package com.example.changeit.ui.profile;

import com.example.changeit.model.Advertisement;

/**
 * @author
 * @since 2021-05-13
 */
@FunctionalInterface
public interface ProfileClickCallback {

    void onClick(Advertisement advertisement);
}
