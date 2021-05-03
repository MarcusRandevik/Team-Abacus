package com.example.changeit.db;

import android.net.Uri;

import androidx.room.TypeConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverter {

    @TypeConverter
    public String fromUriList(List<Uri> uris) {
        if (uris == null) {
            return null;
        }

        return uris.stream()
                .map(Uri::toString)
                .collect(Collectors.joining(","));
    }

    @TypeConverter List<Uri> toUriList(String urisString) {
        if (urisString == null) {
            return null;
        }

        return Arrays.stream(urisString.split(","))
                .map(Uri::parse)
                .collect(Collectors.toList());
    }


}
