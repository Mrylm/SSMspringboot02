package com.henu.ssm.vo;/**
 * Created by Administrator on 2019/9/24 0024.
 */

/**
 * @author Administrator
 * @date 2019/9/24 0024 17:14
 * @description
 */
public class ResultVO {
    public Integer code;
    public String msg;
    public Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
