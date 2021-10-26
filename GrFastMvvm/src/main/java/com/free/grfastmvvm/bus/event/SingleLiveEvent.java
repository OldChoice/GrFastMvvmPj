package com.free.grfastmvvm.bus.event;

import android.util.Log;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import java.util.concurrent.atomic.AtomicBoolean;

/**
* Create by guorui on 2021/10/22
* Last update 2021/10/22
* Description:安全线程执行livedata观察者模式传递数据setvalue可以为任何数据
**/
public class SingleLiveEvent<T> extends MutableLiveData<T> {

    private static final String TAG = "SingleLiveEvent";

    private final AtomicBoolean mPending = new AtomicBoolean(false);

    @MainThread
    public void observe(LifecycleOwner owner, final Observer<? super T> observer) {

        if (hasActiveObservers()) {
            Log.w(TAG, "Multiple observers registered but only one will be notified of changes.");
        }

        // Observe the internal MutableLiveData
        super.observe(owner, new Observer<T>() {
            @Override
            public void onChanged(@Nullable T t) {
                // 当前mPending值和expect相等时候，就执行下面并且mPending变为update,当前如果mPending为true就执行并且更新参数
                // 起到了只执行一次里面关闭的作用
                if (mPending.compareAndSet(true, false)) {
                    observer.onChanged(t);
                }
            }
        });
    }

    @MainThread
    public void setValue(@Nullable T t) {
        //这里结合上面观察者，不管t值是什么都执行上面的观察者
        mPending.set(true);
        super.setValue(t);
    }

    /**
     * Used for cases where T is Void, to make calls cleaner.
     */
    @MainThread
    public void call() {
        //被订阅之后就设置为空
        setValue(null);
    }
}
