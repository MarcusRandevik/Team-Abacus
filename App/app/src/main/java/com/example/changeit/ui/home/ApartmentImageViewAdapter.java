package com.example.changeit.ui.home;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import com.example.changeit.R;


/**
 * class to make it possible with several images for an advertisement
 * @author Marcus Randevik
 * @since 2021-04-26
 */


public class ApartmentImageViewAdapter extends RecyclerView.Adapter<ApartmentImageViewAdapter.ApartmentImageViewHolder> {

    private final List<Uri> pictures;

    public ApartmentImageViewAdapter(List<Uri> pictures) {
        this.pictures = pictures;
    }

    @NonNull
    @Override
    public ApartmentImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ApartmentImageViewHolder(new ApartmentImageView(LayoutInflater.from(parent.getContext()), parent));
    }

    @Override
    public void onBindViewHolder(@NonNull ApartmentImageViewHolder holder, int position) {
        holder.bind(pictures.get(position));
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    protected class ApartmentImageViewHolder extends RecyclerView.ViewHolder {

        private ApartmentImageView view;

        public ApartmentImageViewHolder(ApartmentImageView view) {
            super(view.view);
            this.view = view;
        }

        protected void bind(Uri picture) {
            view.bind(picture);
        }

    }

    private class ApartmentImageView {
        protected View view;
        private ImageView imageView;

        ApartmentImageView(LayoutInflater inflater, ViewGroup viewGroup) {
            view = inflater.inflate(R.layout.apartment_image_layout, viewGroup, false);
            imageView = view.findViewById(R.id.apartment_image_view);
        }

        protected void bind(Uri picture) {
            imageView.setImageURI(picture);
        }
    }

}
