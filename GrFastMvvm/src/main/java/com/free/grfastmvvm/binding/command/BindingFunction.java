package com.free.grfastmvvm.binding.command;

/**
 * Create by guorui on 2021/11/17
 * Last update 2021/11/17
 * Description:单独处理第二触发事件，在BindingCommand中，true则执行,反之不执行
 **/
public interface BindingFunction<T> {
    T call();
}
