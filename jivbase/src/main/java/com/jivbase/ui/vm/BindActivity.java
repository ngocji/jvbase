package com.jivbase.ui.vm;

import static android.content.res.Resources.ID_NULL;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.jibase.ui.BaseViewModel;
import com.jibase.ui.base.BaseActivity;

import butterknife.ButterKnife;


public abstract class BindActivity<V extends BaseViewModel> extends BaseActivity<V> {
    @Override
    public void initView(@Nullable Bundle savedInstanceState) {
        if (getViewInflate().layout() != ID_NULL) {
            setContentView(getViewInflate().layout());
            ButterKnife.bind(this);
        }

        onViewReady(savedInstanceState);
        onViewListener();
    }
}
