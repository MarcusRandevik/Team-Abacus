package com.example.changeit.db;

import com.example.changeit.model.Advertisement;
import com.example.changeit.model.Apartment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataGenerator {

    public static List<Advertisement> generateApartments() {
        int size = 10;
        ArrayList<Advertisement> advertisements = new ArrayList<>(10);

        Random random = new Random();

        for (int i = 0; i < size; i++) {
            advertisements.add(new Advertisement(i, new Apartment(4000 + i,
                    1 + random.nextInt(5), 15 + random.nextInt(90), random.nextBoolean(), random.nextBoolean(), random.nextBoolean(), random.nextBoolean(), "Apartment Description"), 4000 + i, 3, 40));
        }

        return advertisements;
    }
}
