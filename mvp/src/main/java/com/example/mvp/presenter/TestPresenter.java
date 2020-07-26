package com.example.mvp.presenter;

import com.example.mvp.base.BasePresenter;
import com.example.mvp.contract.TestActivityContract;
import com.example.mvp.model.TestModel;
import com.example.mvp.ui.TestActivity;

public class TestPresenter extends BasePresenter<TestActivity, TestModel> implements TestActivityContract.Presenter {


    public TestPresenter() {
        //放在base中 用反射获取？
        model = new TestModel();
    }


    @Override
    public void getHttpData() {
        model.getHttpData();

    }
}
