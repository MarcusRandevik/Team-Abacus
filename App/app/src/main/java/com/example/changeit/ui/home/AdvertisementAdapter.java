package com.example.changeit.ui.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.changeit.R;
import com.example.changeit.databinding.AdvertisementItemBinding;
import com.example.changeit.model.Advertisement;

import java.util.List;

/**
 * class for the logic connected to the advertisement list in the home page
 * has a list of all saved advertisements
 * @author Marcus Randevik
 * @since 2021-04-12
 */
public class AdvertisementAdapter extends RecyclerView.Adapter<AdvertisementAdapter.AdvertisementViewHolder> {

    List<Advertisement> advertisements;

    private final AdvertisementClickCallback clickCallback;
    private final AdvertisementFavouriteClickCallback favouriteClickCallback;

    public AdvertisementAdapter(AdvertisementClickCallback clickCallback, AdvertisementFavouriteClickCallback favouriteClickCallback) {
        this.clickCallback = clickCallback;
        this.favouriteClickCallback = favouriteClickCallback;
    }

    /**
     * updates the list of advertisements
     * @param newAdvertisements the new accurate list of advertisements
     */
    public void setAdvertisements(List<Advertisement> newAdvertisements) {
        if (this.advertisements == null) {
            this.advertisements = newAdvertisements;
            notifyItemRangeInserted(0, newAdvertisements.size());
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return advertisements.size();
                }

                @Override
                public int getNewListSize() {
                    return newAdvertisements.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return advertisements.get(oldItemPosition).getId() == newAdvertisements.get(newItemPosition).getId();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    return advertisements.get(oldItemPosition).equals(newAdvertisements.get(newItemPosition));
                }
            });
            this.advertisements = newAdvertisements;
            result.dispatchUpdatesTo(this);
        }
    }
    @NonNull
    @Override
    public AdvertisementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AdvertisementItemBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()), R.layout.advertisement_item, parent, false);
        binding.setCallback(clickCallback);
        binding.setFavouriteCallBack(favouriteClickCallback);
        return new AdvertisementViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AdvertisementViewHolder holder, int position) {
        Advertisement advertisement = advertisements.get(position);
        holder.binding.setAdvertisement(advertisement);
        holder.binding.apartmentImage.setImageURI(advertisement.getPictures().get(0));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return advertisements == null ? 0 : advertisements.size();
    }

    static class AdvertisementViewHolder extends RecyclerView.ViewHolder {
        final AdvertisementItemBinding binding;

        public AdvertisementViewHolder(AdvertisementItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
