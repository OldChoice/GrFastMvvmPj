package com.free.grfastmvvm.utils;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.annotation.NonNull;

/**
 * Created by goldze on 2017/5/14.
 * 常用工具类
 */
public final class UtilsInstance {

    @SuppressLint("StaticFieldLeak")
    private static Context context;

    private UtilsInstance() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 初始化工具类反之内存泄露
     *
     * @param context 上下文
     */
    public static void init(@NonNull final Context context) {
        UtilsInstance.context = context.getApplicationContext();
    }

    /**
     * 获取ApplicationContext
     *
     * @return ApplicationContext
     */
    public static Context getContext() {
        if (context != null) {
            return context;
        }
        throw new NullPointerException("should be initialized in application");
    }
}