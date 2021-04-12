package com.example.changeit.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.changeit.R;
import com.example.changeit.databinding.ApartmentItemBinding;
import com.example.changeit.model.Apartment;

import java.util.List;

public class ApartmentAdapter extends RecyclerView.Adapter<ApartmentAdapter.ApartmentViewHolder> {

    List<Apartment> apartments;

    private final ApartmentClickCallback clickCallback;

    public ApartmentAdapter(ApartmentClickCallback clickCallback) {
        this.clickCallback = clickCallback;
    }

    public void setApartments(List<Apartment> apartmentList) {
        if (this.apartments == null) {
            this.apartments = apartmentList;
            notifyItemRangeInserted(0, apartmentList.size());
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return apartments.size();
                }

                @Override
                public int getNewListSize() {
                    return apartmentList.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return apartments.get(oldItemPosition).getId() == apartmentList.get(newItemPosition).getId();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    return apartments.get(oldItemPosition).equals(apartmentList.get(newItemPosition));
                }
            });
            this.apartments = apartmentList;
            result.dispatchUpdatesTo(this);
        }
    }
    @NonNull
    @Override
    public ApartmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ApartmentItemBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()), R.layout.apartment_item, parent, false);
        binding.setCallback(clickCallback);
        return new ApartmentViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ApartmentViewHolder holder, int position) {
        holder.binding.setApartment(apartments.get(position));
        holder.binding.apartmentImage.setImageResource(R.drawable.apartment_example);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return apartments == null ? 0 : apartments.size();
    }

    static class ApartmentViewHolder extends RecyclerView.ViewHolder {
        final ApartmentItemBinding binding;

        public ApartmentViewHolder(ApartmentItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
