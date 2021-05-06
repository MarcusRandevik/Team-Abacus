package com.example.changeit.util;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;

import com.example.changeit.R;

import java.util.Arrays;
import java.util.List;

public class AppUtil {

    public static List<Uri> convertResourcePictures(Context context) {
        Resources resources = context.getResources();
        return Arrays.asList(uriFromResourceId(resources, R.drawable.apartment_example),
                uriFromResourceId(resources, R.drawable.apartment_example_2),
                uriFromResourceId(resources, R.drawable.apartment_example_3));
    }

    /**
     * Converts a resource id to an Uri, method found here https://stackoverflow.com/a/52422171
     * @param resources The android resource object used for fetching Uri parameters
     * @param id The id of the specific resource to convert
     * @return An Uri representation of a project resource
     */
    public static Uri uriFromResourceId(Resources resources, int id) {
        return new Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .authority(resources.getResourcePackageName(id))
                .appendPath(resources.getResourceTypeName(id))
                .appendPath(resources.getResourceEntryName(id))
                .build();
    }
}
