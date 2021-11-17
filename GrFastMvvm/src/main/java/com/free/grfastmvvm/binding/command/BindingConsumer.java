package com.free.grfastmvvm.binding.command;

/**
 * Create by guorui on 2021/11/17
 * Last update 2021/11/17
 * Description:响应带参接口
 **/
public interface BindingConsumer<T> {
    void call(T t);
}
