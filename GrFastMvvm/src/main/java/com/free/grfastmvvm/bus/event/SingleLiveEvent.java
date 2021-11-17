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
 * viewModel中在viewModel层初始化处理数据，然后在activity或fragment中执行一些UI操作等
 * 这个是view层，这里绑定一些数据，例如BindingCommand或其它的点击等触发事件，但是界面上要实时变化操作等，在xml里处理不了，
 * 这里直接在viewModel中初始化，然后根据点击或触发事件的变化赋值到这里，最后到activity或其他里响应（这里类似于MVP中接口处理UI在view层展示一个意思，只不过这里用到了观察者模式一样的）
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
