package com.mygroup.sxl.strategy;

import org.springframework.stereotype.Service;

/**
 * @author shenxl
 * @date 2020/3/28 14:52
 * @description
 */
@Service
public class AsinfoVip implements Strategy {
    @Override
    public int compute(int money) {

        return money*2;
    }
}
