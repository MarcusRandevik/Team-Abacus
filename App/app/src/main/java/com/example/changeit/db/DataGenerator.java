package com.example.changeit.db;

import com.example.changeit.model.Apartment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataGenerator {

    public static List<Apartment> generateApartments() {
        int size = 10;
        ArrayList<Apartment> apartments = new ArrayList<>(10);

        Random random = new Random();

        for (int i = 0; i < size; i++) {
            apartments.add(new Apartment(i, 4000 + i, 1 + random.nextInt(5), 5000));
        }

        return apartments;
    }
}
