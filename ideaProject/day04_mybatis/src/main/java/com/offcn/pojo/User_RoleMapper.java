package com.offcn.pojo;

public class User_RoleMapper {
    private  Integer uid;
    private  Integer rid;

    @Override
    public String toString() {
        return "User_RoleMapper{" +
                "uid=" + uid +
                ", rid=" + rid +
                '}';
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }
}
