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
        return new ApartmentImageViewHolder(new ApartmentImageView(LayoutInflater.from(parent.getContext()), parent));
    }

    @Override
    public void onBindViewHolder(@NonNull ApartmentImageViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    protected class ApartmentImageViewHolder extends RecyclerView.ViewHolder {

        private ApartmentImageView view;

        public ApartmentImageViewHolder(ApartmentImageView view) {
            super(view.view);
            this.view = view;
        }

        protected void bind(int position) {
            view.bind(position);
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
            switch (number) {
                case 0:     imageView.setImageResource(R.drawable.apartment_example);
                            break;
                case 1:     imageView.setImageResource(R.drawable.apartment_example_2);
                            break;
                case 2:     imageView.setImageResource(R.drawable.apartment_example_3);
                            break;
                default:    imageView.setImageResource(R.drawable.apartment_example_3);
                            break;
            }
        }
    }

}
