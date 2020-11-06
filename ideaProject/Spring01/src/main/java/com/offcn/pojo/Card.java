package com.offcn.pojo;

import java.io.Serializable;

public class Card implements Serializable {
    private Integer id;
    private String name;
    private String num;

    public Card(String name, String num) {
        System.out.println("这是构造器依赖注入");
        this.name = name;
        this.num = num;
    }

    public void init(){
        System.out.println("这是初始化方法");
    }
    public void destroy(){
        System.out.println("这是销毁方法");
    }

    public Card() {
        System.out.println("这是无参构造");
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", num='" + num + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
