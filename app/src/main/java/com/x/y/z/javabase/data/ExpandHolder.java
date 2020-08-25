package com.x.y.z.javabase.data;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.jibase.extensions.InflateExtensions;
import com.jibase.iflexible.adapter.FlexibleAdapter;
import com.jibase.iflexible.items.abstractItems.AbstractFlexibleExpandItem;
import com.jibase.iflexible.items.interfaceItems.IHeader;
import com.jivbase.adapter.viewholder.BindFlexibleExpandableViewHolder;
import com.x.y.z.javabase.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import butterknife.BindView;

public class ExpandHolder extends AbstractFlexibleExpandItem<ExpandHolder.ViewHolder, TestHolder> implements IHeader<ExpandHolder.ViewHolder> {
    String title;

    public ExpandHolder(@NotNull List<TestHolder> subItems, String title) {
        super(subItems);
        this.title = title;
    }

    @Override
    public void bindViewHolder(@NotNull FlexibleAdapter<?> flexibleAdapter, @NotNull RecyclerView.ViewHolder viewHolder, int i, @NotNull List<?> list) {
        ((ViewHolder) viewHolder).textView.setText(title);
    }

    @NotNull
    @Override
    public ViewHolder createViewHolder(@NotNull ViewGroup viewGroup, @NotNull FlexibleAdapter<?> flexibleAdapter) {
        return new ViewHolder(InflateExtensions.inflate(viewGroup, getLayoutRes(), false), flexibleAdapter, true);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_test_expand;
    }

    static class ViewHolder extends BindFlexibleExpandableViewHolder {
        @BindView(R.id.tv_title)
        TextView textView;

        public ViewHolder(@NotNull View view, @NotNull FlexibleAdapter<?> adapter, boolean stickyHeader) {
            super(view, adapter, stickyHeader);
        }
    }
}
