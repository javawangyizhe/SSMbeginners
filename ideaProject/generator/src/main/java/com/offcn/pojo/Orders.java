package com.offcn.pojo;

public class Orders {
    @Override
    public String toString() {
        return "Orders{" +
                "oid='" + oid + '\'' +
                ", odis='" + odis + '\'' +
                ", onum='" + onum + '\'' +
                ", cusFk=" + cusFk +
                '}';
    }

    private String oid;

    private String odis;

    private String onum;

    private Integer cusFk;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid == null ? null : oid.trim();
    }

    public String getOdis() {
        return odis;
    }

    public void setOdis(String odis) {
        this.odis = odis == null ? null : odis.trim();
    }

    public String getOnum() {
        return onum;
    }

    public void setOnum(String onum) {
        this.onum = onum == null ? null : onum.trim();
    }

    public Integer getCusFk() {
        return cusFk;
    }

    public void setCusFk(Integer cusFk) {
        this.cusFk = cusFk;
    }
}