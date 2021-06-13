package com.jivbase.ui;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.jibase.anotation.ViewInflate;
import com.jibase.ui.DialogStore;
import com.jivbase.R;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.content.res.Resources.ID_NULL;

public abstract class BindBottomDialog extends BottomSheetDialogFragment {
    private ViewInflate viewInflate = getClass().getAnnotation(ViewInflate.class);
    private Map<String, Object> tempProperties = new HashMap<>();

    DialogStore dialogStore;
    Unbinder unbinder;

    @Override
    public void onCreate(@androidx.annotation.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initStyle();
        dialogStore = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(DialogStore.class);
        dialogStore.addAll(tempProperties);
    }

    @Nullable
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView(inflater, container);
    }

    @Override
    public void onViewCreated(@NonNull View view, @androidx.annotation.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onViewReady(savedInstanceState);
        onViewListener();
    }

    @Nullable
    protected View initView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container) {
        if (viewInflate.layout() != ID_NULL) {
            View view = inflater.inflate(viewInflate.layout(), container, false);
            unbinder = ButterKnife.bind(this, view);
            return view;
        } else {
            return null;
        }
    }

    @NonNull
    @NotNull
    @Override
    public Dialog onCreateDialog(@androidx.annotation.Nullable @Nullable Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        if (dialog != null) {
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        return dialog;
    }

    public abstract void onViewReady(Bundle savedInstanceState);

    public void onViewListener() {

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

    protected void initStyle() {
        setStyle(STYLE_NO_TITLE, R.style.style_dialog_90);
    }

    public void show(FragmentManager fragmentManager) {
        if (fragmentManager.findFragmentByTag(getClass().getName()) != null) return;
        show(fragmentManager, getClass().getName());
    }

    public <T> void addProperty(String key, T data) {
        if (dialogStore != null) {
            dialogStore.add(key, data);
        } else {
            if (data != null) {
                tempProperties.put(key, data);
            } else {
                tempProperties.remove(key);
            }
        }
    }

    public <T> T getProperty(String key) {
        return dialogStore.get(key);
    }
}
