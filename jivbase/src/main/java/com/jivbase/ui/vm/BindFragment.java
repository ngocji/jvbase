package com.jivbase.ui.vm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.jibase.ui.BaseViewModel;
import com.jibase.ui.base.BaseFragment;

import butterknife.ButterKnife;

public abstract class BindFragment<V extends BaseViewModel> extends BaseFragment<V> {
    @Nullable
    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        View view = super.initView(inflater, container);
        if (view != null) {
            ButterKnife.bind(this, view);
        }
        return view;
    }
}
