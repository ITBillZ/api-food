package cn.itbill.Util;

import java.io.Serializable;

public class Result implements Serializable {
    private Integer status;
    private Object message;

    public Result(Integer status, Object message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }
}
