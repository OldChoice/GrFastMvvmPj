package com.free.grfastmvvmpj.getdata;

import com.free.grfastmvvm.rxhttp.http.HttpManager;
import com.free.grfastmvvm.rxhttp.http.basehttp.RetrofitUtils;
import com.free.grfastmvvmpj.listforjson.ChoosePersonMultiVo;

import java.util.List;

import io.reactivex.Observer;
import okhttp3.MultipartBody;

/**
 * 设置访问根地址，进行网络访问
 * 在OkHttp3Utils中的拦截器中，填入(网络返回数据)就会返回地址和返回数据
 */
public class HttpManagerMeter {
    //    创造访问接口，提供网络访问使用
    protected static final ApiService mApiService = RetrofitUtils.getRetrofit(Constant.BASE_URL_WATER).create(ApiService.class);

    /**
     * 选择人多选列表
     */
    public static void getChoosePersonMuiltiList(List<MultipartBody.Part> list, Observer<ChoosePersonMultiVo> subscriber) {
        HttpManager.getInstance().toSubscribe(mApiService.getChoosePersonMuiltiLists(list), subscriber);
    }


}
