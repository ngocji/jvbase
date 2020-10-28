package com.x.y.z.javabase;

import com.jivbase.ui.mvp.BasePresenter;

import java.util.Random;

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {
    private String data;

    public MainPresenter() {
    }

    @Override
    public void loadData() {
        if (data == null) {
            data = "PResenter" + new Random().nextInt(10000);
        }
        view.updateData(data);
    }

    @Override
    public void destroy() {

    }
}
