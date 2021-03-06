package com.jivbase.ui.vm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.jibase.anotation.ViewInflate;
import com.jibase.ui.BaseViewModel;

import butterknife.ButterKnife;

import static androidx.core.content.res.ResourcesCompat.ID_NULL;

public abstract class BindFragment<V extends BaseViewModel> extends Fragment {
    private ViewInflate viewInflate = getClass().getAnnotation(ViewInflate.class);
    protected V viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = (V) new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(viewInflate.viewModel());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView(inflater, container);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        registerBackPressed();
        onViewReady();
        onViewListener();
    }

    protected View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        View view = null;
        if (viewInflate.layout() != ID_NULL) {
            view = inflater.inflate(viewInflate.layout(), container, false);
            ButterKnife.bind(this, view);
        }
        return view;
    }

    protected abstract void onViewReady();

    protected void onViewListener() {
    }

    protected void onBackPressed() {
    }

    private void registerBackPressed() {
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(),
                new OnBackPressedCallback(viewInflate.enableBackPressed()) {
                    @Override
                    public void handleOnBackPressed() {
                        onBackPressed();
                    }
                }
        );
    }
}
