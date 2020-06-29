package com.example.lifemedicalinfo.ui.aed;

import androidx.recyclerview.widget.RecyclerView;

import com.example.lifemedicalinfo.databinding.ItemAedBinding;
import com.example.lifemedicalinfo.domain.repository.AED;

public class AedViewHolder extends RecyclerView.ViewHolder {
    ItemAedBinding binding;

    public AedViewHolder(ItemAedBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(AED aed) {
        binding.setViewModel(new AEDViewModel(aed));
        binding.executePendingBindings();
    }
}
