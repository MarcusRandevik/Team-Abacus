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
                .map(uri -> uri.toString())
                .collect(Collectors.joining(","));
    }

    @TypeConverter List<Uri> toUriList(String urisString) {
        if (urisString == null) {
            return null;
        }

        return Arrays.asList(urisString.split(",")).stream()
                .map(s -> Uri.parse(s))
                .collect(Collectors.toList());
    }


}
