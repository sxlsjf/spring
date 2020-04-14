package com.mygroup.sxl.scheduler.service.impl;

import com.mygroup.sxl.scheduler.entity.SysJob;
import com.mygroup.sxl.scheduler.dao.SysJobDao;
import com.mygroup.sxl.scheduler.service.SysJobService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 定时任务表(SysJob)表服务实现类
 *
 * @author makejava
 * @since 2020-04-14 13:52:09
 */
@Service("sysJobService")
public class SysJobServiceImpl implements SysJobService {
    @Resource
    private SysJobDao sysJobDao;

    /**
     * 通过ID查询单条数据
     *
     * @param jobId 主键
     * @return 实例对象
     */
    @Override
    public SysJob queryById(Integer jobId) {
        return this.sysJobDao.queryById(jobId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SysJob> queryAllByLimit(int offset, int limit) {
        return this.sysJobDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysJob 实例对象
     * @return 实例对象
     */
    @Override
    public SysJob insert(SysJob sysJob) {
        this.sysJobDao.insert(sysJob);
        return sysJob;
    }

    /**
     * 修改数据
     *
     * @param sysJob 实例对象
     * @return 实例对象
     */
    @Override
    public SysJob update(SysJob sysJob) {
        this.sysJobDao.update(sysJob);
        return this.queryById(sysJob.getJobId());
    }

    /**
     * 通过主键删除数据
     *
     * @param jobId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer jobId) {
        return this.sysJobDao.deleteById(jobId) > 0;
    }

    @Override
    public List<SysJob> getSysJobListByStatus(Integer status) {
        return sysJobDao.getSysJobListByStatus(status);
    }
}