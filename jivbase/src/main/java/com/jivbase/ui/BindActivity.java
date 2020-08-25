package com.jivbase.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.jibase.anotation.ViewInflate;

import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.content.res.Resources.ID_NULL;


public abstract class BindActivity<V extends BaseContract.View, P extends BaseContract.Presenter<V>> extends AppCompatActivity implements BaseContract.View {
    private ViewInflate viewInflate = getClass().getAnnotation(ViewInflate.class);

    protected Unbinder unbinder;
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        presenter = createPresenter();
        presenter.attach((V) this);

        onViewReady(savedInstanceState);
        onViewListener();
    }

    protected P createPresenter() {
        return (P) new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(viewInflate.presenter());
    }

    protected abstract void onViewReady(Bundle savedInstanceState);

    protected abstract void onViewListener();
}
