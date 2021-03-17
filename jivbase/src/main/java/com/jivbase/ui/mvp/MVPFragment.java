package com.jivbase.ui.mvp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.jibase.anotation.ViewInflate;

import butterknife.ButterKnife;
import butterknife.Unbinder;

import static androidx.core.content.res.ResourcesCompat.ID_NULL;

public abstract class MVPFragment<V extends BaseContract.View, P extends BaseContract.Presenter<V>> extends Fragment {
    private ViewInflate viewInflate = getClass().getAnnotation(ViewInflate.class);

    protected Unbinder unbinder;
    protected P presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        presenter.attach((V) this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView(inflater, container);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onViewReady();
        onViewListener();
    }

    @Override
    public void onDestroyView() {
        try {
            unbinder.unbind();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        super.onDestroyView();
    }

    protected P createPresenter() {
        return (P) new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(viewInflate.presenter());
    }


    @org.jetbrains.annotations.Nullable
    protected View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        View view = null;
        if (viewInflate.layout() != ID_NULL) {
            view = inflater.inflate(viewInflate.layout(), container, false);
            unbinder = ButterKnife.bind(this, view);
        }
        return view;
    }

    protected abstract void onViewReady();

    protected void onViewListener() {

    }
}
