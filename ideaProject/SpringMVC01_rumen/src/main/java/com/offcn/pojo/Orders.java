package com.offcn.pojo;

import java.io.Serializable;
import java.util.Date;

public class Orders  implements Serializable {
    private String oid;
    private String odis;
    private String onum;
    private Date brithday;

    @Override
    public String toString() {
        return "Orders{" +
                "oid='" + oid + '\'' +
                ", odis='" + odis + '\'' +
                ", onum='" + onum + '\'' +
                ", brithday=" + brithday +
                '}';
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getOdis() {
        return odis;
    }

    public void setOdis(String odis) {
        this.odis = odis;
    }

    public String getOnum() {
        return onum;
    }

    public void setOnum(String onum) {
        this.onum = onum;
    }

    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }
}
