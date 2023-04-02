package cn.wddxhz.util;

import lombok.Data;

@Data
public class ResultJson {

    private static final Integer SUCCESS_CODE = 200;

    /**
     * 状态码 正确为0000
     */
    private Integer code;

    /**
     * 返回提示信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private Object data;

    public ResultJson() {
        this.code = SUCCESS_CODE;
        this.msg = "";
    }

    public ResultJson(Object data) {
        this.code = SUCCESS_CODE;
        this.msg = "";
        this.data = data;
    }

    public ResultJson(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 如果返回状态码非0000，且接口状态为成功，请使用这个
     * @param code 返回code值
     * @param msg 返回消息
     * @param data 返回数据
     */
    public ResultJson(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

}
