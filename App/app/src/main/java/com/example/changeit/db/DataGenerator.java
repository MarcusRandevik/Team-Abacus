package com.example.changeit.db;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;

import com.example.changeit.R;
import com.example.changeit.model.Advertisement;
import com.example.changeit.model.Apartment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
/**
 * @author Marcus Randevik
 * @since 2021-04-04
 */
public class DataGenerator {

    /**
     * Method that generates apartments that are used to create the initial list of advertisements.
     * @return A list of advertisements with random values.
     */
    public static List<Advertisement> generateApartments(Context context) {
        int size = 10;
        ArrayList<Advertisement> advertisements = new ArrayList<>(10);

        Random random = new Random();

        List<Uri> pictures = convertResourcePictures(context);

        for (int i = 0; i < size; i++) {
            int picturesSize = pictures.size();
            List<Uri> picturesInDifferentOrder = Arrays.asList(pictures.get((0 + i) % picturesSize), pictures.get((1 + i) % picturesSize), pictures.get((2 + i) % picturesSize));

            advertisements.add(new Advertisement(i, new Apartment(4000 + i,
                    1 + random.nextInt(5), 15 + random.nextInt(90), random.nextBoolean(), random.nextBoolean(), random.nextBoolean(), random.nextBoolean(), "Apartment Description"), 4000 + i, 3, 40));
        }

        return advertisements;
    }

    private static List<Uri> convertResourcePictures(Context context) {
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
    private static Uri uriFromResourceId(Resources resources, int id) {
        return new Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .authority(resources.getResourcePackageName(id))
                .appendPath(resources.getResourceTypeName(id))
                .appendPath(resources.getResourceEntryName(id))
                .build();
    }
}
