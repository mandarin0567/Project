package com.example.lifemedicalinfo.ui.aed;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lifemedicalinfo.R;
import com.example.lifemedicalinfo.databinding.ItemAedBinding;
import com.example.lifemedicalinfo.domain.repository.AED;

import java.util.ArrayList;

public class AedAdapter extends RecyclerView.Adapter<AedViewHolder> {

    ArrayList<AED> aedList;

    public AedAdapter(ArrayList<AED> aedList) {
        this.aedList = aedList;
    }

    @NonNull
    @Override
    public AedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemAedBinding binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.getContext()),
            R.layout.item_aed,
            parent,
            false
            );

        return new AedViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AedViewHolder holder, int position) {
        holder.bind(aedList.get(position));
    }

    @Override
    public int getItemCount() {
        return aedList.size();
    }
}
