package org.com.pojo;

import java.io.Serializable;

public class Student implements Serializable {
    private String sname;
    private String saddress;

    @Override
    public String toString() {
        return "Student{" +
                "sname='" + sname + '\'' +
                ", saddress='" + saddress + '\'' +
                '}';
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }
}
