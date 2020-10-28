package com.x.y.z.javabase.fragment;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.jibase.anotation.ViewInflate;
import com.jibase.iflexible.adapter.FlexibleAdapter;
import com.jibase.iflexible.listener.OnItemClickListener;
import com.jivbase.ui.mvp.MVPFragment;
import com.x.y.z.javabase.R;
import com.x.y.z.javabase.data.TestHolder;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import butterknife.BindView;

@ViewInflate(layout = R.layout.fragment_test, presenter = TestPresenter.class)
public class TestFragment extends MVPFragment<TestContract.View, TestContract.Presenter> implements TestContract.View {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private FlexibleAdapter<TestHolder> adapter;

    @Override
    protected void onViewReady() {
        presenter.loadData();
    }

    @Override
    protected void onViewListener() {

    }

    @Override
    public void updateData(List<TestHolder> data) {
        if (adapter != null) {
            adapter.updateDataSet(data, false);
        } else {
            adapter = new FlexibleAdapter<>(data, false)
            .addListener(new OnItemClickListener() {
                @Override
                public boolean onItemClick(@NotNull View view, int i) {
                    return false;
                }
            });
            recyclerView.setAdapter(adapter);

//            adapter.setStickyHeaders(true);
        }
    }
}
