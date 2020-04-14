package com.mygroup.sxl.scheduler.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 定时任务表(SysJob)实体类
 *
 * @author makejava
 * @since 2020-04-14 13:51:54
 */
public class SysJob implements Serializable {
    private static final long serialVersionUID = -26436359455312094L;
    
    private Integer jobId;
    
    private String beanName;
    
    private String methodName;
    
    private String methodParams;
    
    private String cronExpression;
    
    private Integer jobStatus;
    
    private String remark;
    
    private Date createTime;
    
    private Date updateTime;


    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodParams() {
        return methodParams;
    }

    public void setMethodParams(String methodParams) {
        this.methodParams = methodParams;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public Integer getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(Integer jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}