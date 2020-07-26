package com.example.mvp.base;

import com.example.mvp.IBasePresenter;
import com.example.mvp.IBaseView;
import com.example.mvp.IModel;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.List;

public class BasePresenter<V extends IBaseView, M extends IModel> {

    private WeakReference<V> mWeakView;

    private V mProxyView;

    public M model;


    public void attach(V view){
        this.mWeakView = new WeakReference<V>(view);

        mProxyView = (V) Proxy.newProxyInstance(mWeakView.get().getClass().getClassLoader(), view.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (mWeakView == null || mWeakView.get() == null) {
                    return null;
                }
                return method.invoke(mWeakView.get(), args);
            }
        });

        Type type=this.getClass().getGenericSuperclass();
        Type[] params= ((ParameterizedType)type).getActualTypeArguments();
        try {
            model= (M) ((Class)params[1]).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public void detach() {
        mWeakView.clear();
        mWeakView = null;
    }


    public V getView() {
        return this.mProxyView;
    }
}
