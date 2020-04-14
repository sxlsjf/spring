package com.mygroup.sxl.scheduler;

import java.util.concurrent.ScheduledFuture;

/**
 * @author shenxl
 * @date 2020/4/14 11:55
 * @description 添加ScheduledFuture的包装类。ScheduledFuture是ScheduledExecutorService定时任务线程池的执行结果。
 */
public final class ScheduledTask {

    volatile ScheduledFuture<?> future;

    /**
     * 取消定时任务
     */
    public void cancel() {
        ScheduledFuture<?> future = this.future;
        if (future != null) {
            future.cancel(true);
        }
    }
}
