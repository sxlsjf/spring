package com.mygroup.sxl.strategy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shenxl
 * @date 2020/3/28 14:53
 * @description
 */
@Service
public class StrategyFactory {

    @Autowired
    private ApplicationContext applicationContext;

    private Map<Class<? extends Strategy>,Strategy> map=new HashMap<>();


    public Strategy getInstance(Class<? extends Strategy> type){

        Strategy instance=map.get(type);

        if(instance==null){
            instance=applicationContext.getBean(type);
            map.put(type,instance);
        }

        return instance;
    }


}
