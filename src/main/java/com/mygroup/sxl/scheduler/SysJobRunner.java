package com.mygroup.sxl.scheduler;

import com.mygroup.sxl.scheduler.dao.SysJobDao;
import com.mygroup.sxl.scheduler.entity.SysJob;
import com.mygroup.sxl.scheduler.service.SysJobService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shenxl
 * @date 2020/4/14 17:03
 * @description
 */
@Service
public class SysJobRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(SysJobRunner.class);

    @Autowired
    private SysJobService sysJobService;

    @Autowired
    private CronTaskRegistrar cronTaskRegistrar;

    @Override
    public void run(String... args) {
        // 初始加载数据库里状态为正常的定时任务
        List<SysJob> jobList = sysJobService.getSysJobListByStatus(1);
        if (CollectionUtils.isNotEmpty(jobList)) {
            for (SysJob job : jobList) {
                SchedulingRunnable task = new SchedulingRunnable(job.getBeanName(), job.getMethodName(), job.getMethodParams());
                cronTaskRegistrar.addCronTask(task, job.getCronExpression());
            }

            logger.info("定时任务已加载完毕...");
        }
    }
}