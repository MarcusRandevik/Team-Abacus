package com.example.changeit.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.changeit.AppExecutors;
import com.example.changeit.db.dao.AdvertisementsDao;
import com.example.changeit.model.Advertisement;
import com.example.changeit.model.Apartment;

import java.util.List;

/**
 * @author Marcus Randevik
 * @since 2021-04-04
 */

    /**
    * This class creates the database itself, where the information is stored
    */
@Database(entities = Advertisement.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {
        /**
         * An instance of the app's database
         */
    private static AppDatabase appDatabase;
        /**
         * The name of the database, called "change it db"
         */
    private static final String DATABASE_NAME = "change-it-db";

        /**
         * Interface used to access the data from the database
         * @return an instance of advertisementsDao
         */
    public abstract AdvertisementsDao advertisementsDao();

        /**
         * getInstance creates the database if there isn't already one
         * @param context
         * @param executors
         * @return the app's database
         */
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

        /**
         * Creates the database and the apartments, and then adds the apartments to the database
         * @param applicationContext
         * @param executors
         * @return a complete database containing all advertisements
         */
    private static AppDatabase buildDatabase(Context applicationContext, AppExecutors executors) {
        return Room.databaseBuilder(applicationContext, AppDatabase.class, DATABASE_NAME)
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        executors.diskIO().execute(() -> {
                            AppDatabase appDatabase = AppDatabase.getInstance(applicationContext, executors);

                            List<Advertisement> advertisements = DataGenerator.generateApartments(applicationContext);

                            appDatabase.runInTransaction(() -> {
                                appDatabase.advertisementsDao().insertAll(advertisements);
                            });
                        });
                    }
                })
                .build();
    }
}
