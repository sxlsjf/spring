package com.mygroup.sxl.future;

import org.junit.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @Author: shenxl
 * @Date: 2019/11/16 11:20
 * @Version 1.0
 * @description：${description}
 */


public class TestCompletableFuture {

    @Test
    public void test() throws Exception {
        // 创建一个带result的CompletableFuture
        CompletableFuture<String> future = CompletableFuture.completedFuture("result");
        future.get();

        // 默认创建的CompletableFuture是没有result的，这时调用future.get()会一直阻塞下去知道有result或者出现异常
        future = new CompletableFuture<>();
        try {
            future.get(1, TimeUnit.SECONDS);
        } catch (Exception e) {
            // no care
        }

// 给future填充一个result
        future.complete("result");
        assert "result".equals(future.get());

// 给future填充一个异常
        future = new CompletableFuture<>();
        future.completeExceptionally(new RuntimeException("exception"));
        try {
            future.get();
        } catch (Exception e) {
            assert "exception".equals(e.getCause().getMessage());
        }
    }


    /**
     * 上面的示例是自己设置future的result，一般情况下我们都是让其他线程或者线程池来执行future这些异步任务。
     * 除了直接创建CompletableFuture 对象外（不推荐这样使用），还可以使用如下4个方法创建CompletableFuture 对象：
     */
    @Test
    public void test2() {
// 使用示例
        CompletableFuture.runAsync(() -> {
            System.out.println("hello world");
        });
        CompletableFuture.supplyAsync(() -> {
            System.out.println("hello world");
            return "result";
        });
    }

    @Test
    public void test3() throws InterruptedException {
        // 使用示例
        CompletableFuture.supplyAsync(() -> {
            System.out.println("hello world");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //  int i=10/0;
            return "result";
        }).whenComplete((result, e) -> {

            System.out.println(result + " " + e);
        }).exceptionally((e) -> {
            System.out.println("exception " + e);
            return "exception";
        });

        System.out.println(Thread.currentThread().getName()+"end");

     //   Thread.sleep(10000);
    }



    /**
     * 除了用上面的whenComplete来执行完成动作之外，
     * 还可以使用handle方法，该方法可以返回一个新的CompletableFuture的返回类型。
     * */
    @Test
    public void test4() throws InterruptedException {

        // handle方法示例：
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello world");
            return "result";
        });

        CompletableFuture<Integer> f3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello world");
            return 6;
        });


        CompletableFuture<Integer> f2 = f1.handle((r, e) -> {
            System.out.println("handle");
            return 1;
        });

        f2.handle((r, e) -> {
            System.out.println("handle2");
            return 2;
        });



        System.out.println((f1.equals(f2)) ?"dengyu":"budengyu");
    }

    /**
     *  除了使用handle方法来执行CompletableFuture返回类型转换之外，
     *  还可以使用thenApply方法，二者不同的是前者会处理正常返回值和异常，
     *  因此可以屏蔽异常，避免继续抛出；而后者只能处理正常返回值，一旦有异常就会抛出。
     * */
    @Test
    public void test5() throws InterruptedException {

        // thenApply方法示例：
        CompletableFuture.supplyAsync(() -> {
            System.out.println("hello world");
            return "result";
        }).thenApply((r) -> {
            System.out.println(r);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "aaa";
        }).thenApply((r) -> {
            System.out.println(r);
            return 1;
        });
    }


    /**
     * 注意，上面的handle、thenApply都是返回新的CompletableFuture类型，
     * 如果只是为了在CompletableFuture完成之后执行某些消费动作，
     * 而不返回新的CompletableFuture类型，则可以使用thenAccept方法。
     * */
    @Test
    public void test6() throws InterruptedException {

        // thenAccept方法示例：
        CompletableFuture.supplyAsync(() -> {
            System.out.println("hello world");
            return "result";
        }).thenAccept(r -> {
            System.out.println(r);
        }).thenAccept(r -> {
            // 这里的r为Void（null）了
            System.out.println(r);
        });
    }
}
