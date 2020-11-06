package com.offcn.pojo;

import java.io.Serializable;

public class Orders  implements Serializable {
    private String oid;
    private String odis;
    private String onum;

    @Override
    public String toString() {
        return "Orders{" +
                "oid='" + oid + '\'' +
                ", odis='" + odis + '\'' +
                ", onum='" + onum + '\'' +
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
}
