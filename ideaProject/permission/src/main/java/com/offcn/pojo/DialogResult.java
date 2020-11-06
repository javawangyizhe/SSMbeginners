package com.offcn.pojo;

/**
 * 创建了一个bean：
 * 作用： 封装信息：
 * 删除成功：
 * 删除失败：
 */

public class DialogResult {
    private String msg;
    private String error;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
