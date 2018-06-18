//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.test.dubbo.common;

import com.github.pagehelper.Page;

public class WrapMapper {
    private WrapMapper() {
    }
    public static Wrapper genSuccessResult() {
        return new Wrapper()
                .code(Wrapper.SUCCESS_CODE)
                .message(Wrapper.SUCCESS_MESSAGE);
    }

    public static <E> Wrapper<E> genSuccessResult(E data) {
        return new Wrapper()
                .code(Wrapper.SUCCESS_CODE)
                .message(Wrapper.SUCCESS_MESSAGE)
                .result(data);
    }

    public static <E> Wrapper<E> wrap(int code, String message, E o, Page<E> page) {
        return new Wrapper(code, message, o, page);
    }

    public static <E> Wrapper<E> wrap(int code, String message, E o) {
        return new Wrapper(code, message, o);
    }

    public static <E> Wrapper<E> wrap(int code, String message) {
        return new Wrapper(code, message);
    }

    public static <E> Wrapper<E> wrap(int code) {
        return wrap(code, (String)null);
    }

    public static <E> Wrapper<E> wrap(Exception e) {
        return new Wrapper(500, e.getMessage());
    }

    public static <E> E unWrap(Wrapper<E> wrapper) {
        return wrapper.getResult();
    }

    public static <E> Wrapper<E> illegalArgument() {
        return wrap(100, "参数非法");
    }

    public static <E> Wrapper<E> error() {
        return wrap(500, "内部异常");
    }

    public static <E> Wrapper<E> ok() {
        return new Wrapper();
    }
}
