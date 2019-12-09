package com.mygroup.sxl.syszorized;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author: shenxl
 * @Date: 2019/11/14 10:45
 * @Version 1.0
 * @description：${description}
 */
public class TestSysz {


    private static int totalThreads=200;

    private static int totalClient=5000;

    private static long count=0;


    public static void main(String[] args) throws InterruptedException {

        ExecutorService exec= Executors.newCachedThreadPool();

        final Semaphore semaphore=new Semaphore(totalThreads);

        for (int i = 0; i <totalClient ; i++) {
            exec.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        exec.shutdown();

        Thread.sleep(5000);
        System.out.println(count);
    }

    private synchronized static void add(){
        count++;
    }
}
