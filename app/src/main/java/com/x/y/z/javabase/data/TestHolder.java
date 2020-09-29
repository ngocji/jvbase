package com.x.y.z.javabase.data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.jibase.extensions.InflateExtensions;
import com.jibase.iflexible.adapter.FlexibleAdapter;
import com.jibase.iflexible.items.abstractItems.AbstractFlexibleItem;
import com.jibase.iflexible.viewholder.FlexibleViewHolder;
import com.jivbase.adapter.viewholder.BindFlexibleViewHolder;
import com.x.y.z.javabase.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import butterknife.BindView;

public class TestHolder extends AbstractFlexibleItem<TestHolder.ViewHolder> {
    String data;

    public TestHolder(String data) {
        this.data = data;
        setDraggable(true);
    }

    @Override
    public void bindViewHolder(@NotNull FlexibleAdapter<?> flexibleAdapter, @NotNull RecyclerView.ViewHolder viewHolder, int i, @NotNull List<?> list) {
        ((ViewHolder) viewHolder).textView.setText(data);
    }

    @NotNull
    @Override
    public ViewHolder createViewHolder(@NotNull ViewGroup viewGroup, @NotNull FlexibleAdapter<?> flexibleAdapter) {
        return new ViewHolder(InflateExtensions.inflate(viewGroup, getLayoutRes(), false), flexibleAdapter, false);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_test;
    }

    static class ViewHolder extends BindFlexibleViewHolder {
        @BindView(R.id.tv_title)
        TextView textView;

        public ViewHolder(@NotNull View preItemView, @NotNull FlexibleAdapter<?> adapter, boolean isStickyHeader) {
            super(preItemView, adapter, isStickyHeader);
        }
    }
}
