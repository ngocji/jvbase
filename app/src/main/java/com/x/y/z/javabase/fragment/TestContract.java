package com.x.y.z.javabase.fragment;

import com.jivbase.ui.BaseContract;
import com.x.y.z.javabase.data.TestHolder;

import java.util.List;

public class TestContract {
    interface View extends BaseContract.View{
        void updateData(List<TestHolder> data);
    }
    interface Presenter extends BaseContract.Presenter<View>{
        void loadData();
    }
}
