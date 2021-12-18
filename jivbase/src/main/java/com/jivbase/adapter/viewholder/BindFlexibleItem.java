package com.jivbase.adapter.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jibase.iflexible.adapter.FlexibleAdapter;
import com.jibase.iflexible.items.abstractItems.AbstractFlexibleItem;

import java.util.List;

public abstract class BindFlexibleItem<VH extends RecyclerView.ViewHolder> extends AbstractFlexibleItem<VH> {
    @Override
    public void bindViewHolder(@NonNull FlexibleAdapter<?> flexibleAdapter, @NonNull RecyclerView.ViewHolder viewHolder, int i, @NonNull List<?> list) {

    }

    @NonNull
    @Override
    public VH createViewHolder(@NonNull ViewGroup viewGroup, @NonNull FlexibleAdapter<?> flexibleAdapter) {
        return onCreateViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(getLayoutRes(), viewGroup, false), flexibleAdapter);
    }

    abstract VH onCreateViewHolder(View view, FlexibleAdapter<?> flexibleAdapter);
}
