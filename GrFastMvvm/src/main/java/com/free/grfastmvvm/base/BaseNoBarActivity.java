package com.free.grfastmvvm.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.afollestad.materialdialogs.MaterialDialog;
import com.free.grfastmvvm.R;
import com.free.grfastmvvm.base.BaseViewModel.ParameterField;
import com.free.grfastmvvm.bus.Messenger;
import com.free.grfastmvvm.utils.MaterialDialogUtils;
import com.free.grfastmvvm.utils.StatusBarUtils;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * Create by guorui on 2021/7/7
 * Last update 2021/7/7
 * Description:无顶部bar的
 **/
public abstract class BaseNoBarActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        去掉顶部并修改头部颜色
        getSupportActionBar().hide();
        StatusBarUtils.setWindowStatusBarColor(this, R.color.white, R.color.white);
//        StatusBarUtils.setNoTitleView(this);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        super.onCreate(savedInstanceState);
    }

}
