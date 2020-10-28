package com.x.y.z.javabase;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.jibase.anotation.ViewInflate;
import com.jibase.iflexible.adapter.FlexibleAdapter;
import com.jibase.iflexible.items.abstractItems.AbstractFlexibleItem;
import com.jibase.iflexible.listener.OnItemClickListener;
import com.jivbase.ui.mvp.MVPActivity;
import com.x.y.z.javabase.data.Header;
import com.x.y.z.javabase.data.TestHolder;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

@ViewInflate(layout = R.layout.activity_main, presenter = MainPresenter.class)
public class MainActivity extends MVPActivity<MainContract.View, MainContract.Presenter> implements MainContract.View {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    public void onViewReady(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            List<AbstractFlexibleItem> data = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                List<TestHolder> items = new ArrayList<>();
                for (int j = 0; j < 5; j++) {
                    items.add(new TestHolder("item: " + i));
                }
                data.add(new Header());
                data.addAll(items);
//                data.add(new ExpandHolder(items, "data: " + i));
            }

            FlexibleAdapter adapter = new FlexibleAdapter<>(data, false)
                    .addListener(new OnItemClickListener() {
                        @Override
                        public boolean onItemClick(@NotNull View view, int i) {
                            return false;
                        }
                    })
                    .setDisplayHeadersAtStartUp(true);
            recyclerView.setAdapter(adapter);
            adapter.setStickyHeaders(true)
            .setLongPressDragEnabled(true)
            .setHandleDragEnabled(true);
        }
    }

    @Override
    protected void onViewListener() {

    }

    @Override
    public void updateData(String data) {

    }
}