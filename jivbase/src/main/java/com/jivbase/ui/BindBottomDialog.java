package com.jivbase.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jibase.ui.dialog.BaseBottomDialog;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class BindBottomDialog extends BaseBottomDialog {
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getViewInflate().layout(), container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        try {
            unbinder.unbind();
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onDestroyView();
    }
}
