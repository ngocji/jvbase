package com.jivbase.ui;

public class BaseContract {
    public interface View {
    }

    public interface Presenter<V extends View> {
        void attach(V view);

        void destroy();
    }
}
