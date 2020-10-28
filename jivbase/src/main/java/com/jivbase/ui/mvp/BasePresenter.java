package com.jivbase.ui.mvp;

import androidx.annotation.CallSuper;

import com.jibase.ui.BaseViewModel;
import io.reactivex.disposables.Disposable;

public abstract class BasePresenter<V extends BaseContract.View> extends BaseViewModel implements BaseContract.Presenter<V> {
    protected V view;

    public BasePresenter() {
    }

    @Override
    public void attach(V view) {
        this.view = view;
    }

    @CallSuper
    @Override
    protected void onCleared() {
        super.onCleared();
        destroy();
    }

    public void attachToComposite(Disposable disposable) {
        getCompositeDisposable().add(disposable);
    }
}
