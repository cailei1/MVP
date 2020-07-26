package com.example.mvp;

import com.example.mvp.base.BaseView;

public interface IBasePresenter<V extends IBaseView> {

    void attach(V view);


    void unAttach();
}
