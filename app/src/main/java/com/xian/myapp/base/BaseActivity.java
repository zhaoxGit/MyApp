package com.xian.myapp.base;

import android.os.Bundle;

import com.xian.myapp.swipe.SwipeBackActivity;

import butterknife.ButterKnife;

/**
 * Created by LXR-yfb on 2017/11/10.
 */

public abstract class BaseActivity extends SwipeBackActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSwipeBackEnable(false);
        setContentView(getContentView());
        ButterKnife.bind(this);
        initData();
        initView();
    }

    protected abstract void initData();
    protected abstract void initView();

    protected abstract int getContentView();
}
