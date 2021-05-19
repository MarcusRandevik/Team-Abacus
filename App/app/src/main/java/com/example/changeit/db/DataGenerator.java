package com.example.changeit.db;

import android.content.Context;
import android.net.Uri;

import com.example.changeit.model.Advertisement;
import com.example.changeit.model.Apartment;
import com.example.changeit.model.UserHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.example.changeit.util.AppUtil.convertResourcePictures;

/**
 * Class that generates advertisements for the initial start up
 * @author Marcus Randevik. Also edited by Lisa Samuelsson, Amanda Styff, Moa Berglund, Izabell Arvidsson and Noa Tholén
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

                    1 + random.nextInt(5), 15 + random.nextInt(90), random.nextBoolean(), random.nextBoolean(), random.nextBoolean(),
                                                                  random.nextBoolean(), "Apartment Description", "Gibraltargatan "+(random.nextInt(96)+1)), picturesInDifferentOrder,
                    4000 + i, 3, 40, UserHandler.getInstance().getAllUsers().get(i), random.nextBoolean(), random.nextBoolean(), random.nextBoolean(),
                    random.nextBoolean(), false));
        }

        return advertisements;
    }
}
