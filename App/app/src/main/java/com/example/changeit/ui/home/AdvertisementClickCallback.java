package com.example.changeit.ui.home;

import com.example.changeit.model.Advertisement;

/**
 * @author Marcus Randevik
 * @since 2021-04-12
 */
@FunctionalInterface
public interface AdvertisementClickCallback {

    void onClick(Advertisement advertisement);
}
