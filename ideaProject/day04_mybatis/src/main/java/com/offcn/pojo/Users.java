package com.offcn.pojo;

import java.io.Serializable;
import java.util.List;

public class Users implements Serializable {
    private Integer uid;
    private String username;

    @Override
    public String toString() {
        return "Users{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                '}';
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
