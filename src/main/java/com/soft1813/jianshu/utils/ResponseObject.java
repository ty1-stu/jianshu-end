package com.soft1813.jianshu.utils;

 import cn.hutool.db.Entity;
 import lombok.Data;

 import java.util.List;

/**
 * @author ty
 * @ClassName ResponseObject
 * @Description 统一的响应对象
 * @Date 2019/10/10
 * @Version 1.0
 **/
@Data
public class ResponseObject {
    public ResponseObject() {
    }

    public ResponseObject(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private Integer code;
    private String msg;
    private Object data;

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

    @Override
    public String toString() {
        return "ResponseObject{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
