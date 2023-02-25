package cn.itbill.utils;

public enum ResultCode {
    SUCCESS(200, "成功"),
    FAIL(500, "失败");

    private final Integer status;
    private final String msg;

    ResultCode(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }


}
