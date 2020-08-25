package com.jivbase.adapter.viewholder;

import android.view.View;

import com.jibase.iflexible.adapter.FlexibleAdapter;
import com.jibase.iflexible.viewholder.FlexibleExpandableViewHolder;

import org.jetbrains.annotations.NotNull;

import butterknife.ButterKnife;

public class BindFlexibleExpandableViewHolder extends FlexibleExpandableViewHolder {
    public BindFlexibleExpandableViewHolder(@NotNull View view, @NotNull FlexibleAdapter<?> adapter, boolean isStickyHeader) {
        super(view, adapter, isStickyHeader);
        ButterKnife.bind(this, view);
    }
}
