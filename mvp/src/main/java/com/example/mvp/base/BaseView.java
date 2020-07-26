package com.example.mvp.base;

import com.example.mvp.IBasePresenter;
import com.example.mvp.IBaseView;

public abstract class BaseView<P extends IBasePresenter> implements IBaseView {



    @Override
    public void showLoading() {

    }


    @Override
    public void hideLoading() {

    }
}
