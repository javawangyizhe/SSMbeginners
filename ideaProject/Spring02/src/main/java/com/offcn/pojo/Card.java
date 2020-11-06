package com.offcn.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
public class Card implements Serializable {
    private Integer id;
    private String name;
    private String num;

    public Card(String name, String num) {
        this.name = name;
        this.num = num;
    }


    public Card() {

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
