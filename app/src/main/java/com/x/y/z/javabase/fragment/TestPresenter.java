package com.x.y.z.javabase.fragment;

import com.jivbase.ui.BasePresenter;
import com.x.y.z.javabase.data.TestHolder;

import java.util.ArrayList;
import java.util.List;

public class TestPresenter extends BasePresenter<TestContract.View> implements TestContract.Presenter {
    private List<TestHolder> data;

    public TestPresenter() {
    }

    @Override
    public void loadData() {
        if (data == null) {
            data = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
//                List<TestHolder> items = new ArrayList<>();
//                for (int j = 0; j < 5; j++) {
                data.add(new TestHolder("item: " + i));
//                }
//                data.add(new ExpandHolder(items, "data: " + i));
            }
        }
        view.updateData(data);
    }

    @Override
    public void destroy() {

    }
}
