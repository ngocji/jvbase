package com.jivbase.ui;

public abstract class BindBottomCallBackDialog<CallBack> extends BindBottomDialog {
    public void setCallBack(CallBack callback) {
        addProperty("callback", callback);
    }

    public CallBack getCallBack() {
        return getProperty("callback");
    }
}
