package com.mygroup.sxl.scheduler.controller;

import com.mygroup.sxl.scheduler.entity.SysJob;
import com.mygroup.sxl.scheduler.service.SysJobService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 定时任务表(SysJob)表控制层
 *
 * @author makejava
 * @since 2020-04-14 13:52:10
 */
@RestController
@RequestMapping("sysJob")
public class SysJobController {
    /**
     * 服务对象
     */
    @Resource
    private SysJobService sysJobService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SysJob selectOne(Integer id) {
        return this.sysJobService.queryById(id);
    }

    @GetMapping("selectByStatus")
    public List<SysJob> selectByStatus(Integer status){

        return sysJobService.getSysJobListByStatus(status);

    }


    @PostMapping("addNewTask")
    public SysJob addNewTask(SysJob sysJob){

        return sysJobService.insert(sysJob);

    }


}