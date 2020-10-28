package com.jivbase.ui.vm;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.jibase.anotation.ViewInflate;
import com.jibase.ui.BaseViewModel;

import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.content.res.Resources.ID_NULL;


public abstract class BindActivity<V extends BaseViewModel> extends AppCompatActivity {
    private ViewInflate viewInflate = getClass().getAnnotation(ViewInflate.class);

    protected Unbinder unbinder;
    protected V viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = (V) new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(viewInflate.viewModel());
        initView(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        try {
            unbinder.unbind();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        super.onDestroy();
    }

    protected void initView(Bundle savedInstanceState) {
        if (viewInflate.layout() != ID_NULL) {
            setContentView(viewInflate.layout());
            unbinder = ButterKnife.bind(this);
        }

        onViewReady(savedInstanceState);
        onViewListener();
    }

    protected abstract void onViewReady(Bundle savedInstanceState);

    protected abstract void onViewListener();
}
