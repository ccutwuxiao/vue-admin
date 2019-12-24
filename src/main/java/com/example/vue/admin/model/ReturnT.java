package com.example.vue.admin.model;

import lombok.Data;

@Data
public class ReturnT<T> {

    private int code;

    private String message;

    private T data;

    public static <K> ReturnT<K> success(K data) {
        return make(200, "成功", data);
    }

    public static <K> ReturnT<K> faild(K data) {
        return make(800, "失败", data);
    }

    public static <K> ReturnT<K> make(int code, String message, K data) {
        ReturnT<K> returnT = new ReturnT<>();
        returnT.code = code;
        returnT.message = message;
        returnT.data = data;
        return returnT;
    }
}
