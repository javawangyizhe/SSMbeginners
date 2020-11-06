package com.offcn.dao.impl;

import com.offcn.dao.HumanDao;

public class HumanDaoImpl implements HumanDao {

    @Override
    public void sing(Double money) {
        System.out.println(money+"唱歌");
    }

    @Override
    public void dance(Double money) {
        System.out.println(money+"跳舞");
    }
}
