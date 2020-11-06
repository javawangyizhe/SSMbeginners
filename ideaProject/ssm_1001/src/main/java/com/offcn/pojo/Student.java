package com.offcn.pojo;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = -1242493306307174690L;

    public Student() {
    }

    public Student(Integer sid, String sname, Integer ssex, String saddress, Integer sage) {
        this.sid = sid;
        this.sname = sname;
        this.ssex = ssex;
        this.saddress = saddress;
        this.sage = sage;
    }

    private Integer sid;
    private String sname;
    private Integer ssex;
    private String saddress;
    private Integer sage;

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", ssex=" + ssex +
                ", saddress='" + saddress + '\'' +
                ", sage=" + sage +
                '}';
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getSsex() {
        return ssex;
    }

    public void setSsex(Integer ssex) {
        this.ssex = ssex;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }
}
