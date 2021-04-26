package com.example.changeit.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.changeit.R;

public class ApartmentImageViewAdapter extends RecyclerView.Adapter<ApartmentImageViewAdapter.ApartmentImageViewHolder> {

    @NonNull
    @Override
    public ApartmentImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ApartmentImageViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ApartmentImageViewHolder extends RecyclerView.ViewHolder {

        public ApartmentImageViewHolder(ApartmentImageView view) {
            super(view.view);
        }
    }

    private class ApartmentImageView {
        protected View view;
        private ImageView imageView;

        ApartmentImageView(LayoutInflater inflater, ViewGroup viewGroup) {
            view = inflater.inflate(R.layout.apartment_image_layout, viewGroup, false);
            imageView = view.findViewById(R.id.apartment_image_view);
        }

        protected void bind(int number) {

        }
    }

}
