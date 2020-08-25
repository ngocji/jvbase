package com.x.y.z.javabase;

import com.jivbase.ui.BaseContract;

public class MainContract {
    interface View extends BaseContract.View{
        void updateData(String data);
    }
    interface Presenter extends BaseContract.Presenter<View>{
        void loadData();
    }
}
