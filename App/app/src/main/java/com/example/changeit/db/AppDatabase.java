package com.example.changeit.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.changeit.AppExecutors;
import com.example.changeit.db.dao.ApartmentDao;
import com.example.changeit.model.Apartment;

import java.util.List;

@Database(entities = Apartment.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase appDatabase;

    private static final String DATABASE_NAME = "change-it-db";

    public abstract ApartmentDao apartmentDao();

    public static AppDatabase getInstance(final Context context, final AppExecutors executors) {
        if (appDatabase == null) {
            synchronized (AppDatabase.class) {
                if (appDatabase == null) {
                    appDatabase = buildDatabase(context.getApplicationContext(), executors);
                }
            }
        }
        return appDatabase;
    }

    private static AppDatabase buildDatabase(Context applicationContext, AppExecutors executors) {
        return Room.databaseBuilder(applicationContext, AppDatabase.class, DATABASE_NAME)
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        executors.diskIO().execute(() -> {
                            AppDatabase appDatabase = AppDatabase.getInstance(applicationContext, executors);

                            List<Apartment> apartments = DataGenerator.generateApartments();

                            appDatabase.runInTransaction(() -> {
                                appDatabase.apartmentDao().insertAll(apartments);
                            });
                        });
                    }
                })
                .build();
    }
}
