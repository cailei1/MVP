package com.example.mvp.contract;

import com.example.mvp.IBaseView;

public class TestActivityContract {

    public interface View extends IBaseView {

    }

    public interface Presenter {
        void getHttpData();
    }


    public interface Model {
        void getHttpData();
    }
}
