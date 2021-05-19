package com.example.changeit.ui.home;

import com.example.changeit.model.Advertisement;

/**
 * @author Marcus Randevik
 * @since 2021-05-10
 */
@FunctionalInterface
public interface AdvertisementFavouriteClickCallback {

    void onClick(Advertisement advertisement);
}
