package com.example.mvp.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mvp.Activity;
import com.example.mvp.IBasePresenter;
import com.example.mvp.IBaseView;
import com.example.mvp.annocation.InjectPresenter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {

    P presenter;

    List<BasePresenter> presenters;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        presenter = createPresenter();
        presenter.attach(this);



        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            InjectPresenter presenter = field.getAnnotation(InjectPresenter.class);

            if (presenter != null) {
                BasePresenter basePresenter;
                Class<? extends BasePresenter> pClass = (Class<? extends BasePresenter>) field.getType();

                try {
                    basePresenter = pClass.newInstance();
                    basePresenter.attach(this);
                    presenters.add(basePresenter);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }


        initView();
        initListener();
        initData();
    }

    protected abstract P createPresenter();

    protected abstract void initData();

    protected abstract void initListener();

    protected abstract int getLayoutId();

    protected abstract void initView();


    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    protected void onPause() {
        super.onPause();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        for (BasePresenter basePresenter : presenters) {
            basePresenter.detach();
        }
    }
}
