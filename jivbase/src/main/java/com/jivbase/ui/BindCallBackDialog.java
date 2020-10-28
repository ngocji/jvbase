package com.jivbase.ui;

public abstract class BindCallBackDialog<CallBack> extends BindDialog {
    public void setCallBack(CallBack callback) {
        addProperty("callback", callback);
    }

    public CallBack getCallBack() {
        return getProperty("callback");
    }
}
