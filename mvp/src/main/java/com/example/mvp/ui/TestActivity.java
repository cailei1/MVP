package com.example.mvp.ui;

import com.example.mvp.annocation.InjectPresenter;
import com.example.mvp.base.BaseActivity;
import com.example.mvp.contract.TestActivityContract;
import com.example.mvp.presenter.TestPresenter;
import com.example.mvp.presenter.TestPresenter1;

public class TestActivity extends BaseActivity<TestPresenter> implements TestActivityContract.View {
    @InjectPresenter
    TestPresenter1 presenter1;


    @Override
    protected TestPresenter createPresenter() {
        return new TestPresenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void initView() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
