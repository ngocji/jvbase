package com.x.y.z.javabase.data;

import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.jibase.extensions.InflateExtensions;
import com.jibase.iflexible.adapter.FlexibleAdapter;
import com.jibase.iflexible.items.abstractItems.AbstractFlexibleItem;
import com.jibase.iflexible.items.interfaceItems.IHeader;
import com.x.y.z.javabase.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Header extends AbstractFlexibleItem<ExpandHolder.ViewHolder> implements IHeader<ExpandHolder.ViewHolder> {

    @Override
    public void bindViewHolder(@NotNull FlexibleAdapter<?> flexibleAdapter, @NotNull RecyclerView.ViewHolder viewHolder, int i, @NotNull List<?> list) {
        ((ExpandHolder.ViewHolder) viewHolder).textView.setText("Header");
    }

    @NotNull
    @Override
    public ExpandHolder.ViewHolder createViewHolder(@NotNull ViewGroup viewGroup, @NotNull FlexibleAdapter<?> flexibleAdapter) {
        return new ExpandHolder.ViewHolder(InflateExtensions.inflate(viewGroup, getLayoutRes(), false), flexibleAdapter, true);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_test_expand;
    }
}
