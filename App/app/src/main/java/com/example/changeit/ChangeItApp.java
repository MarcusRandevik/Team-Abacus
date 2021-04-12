package com.example.changeit;

import android.app.Application;

import com.example.changeit.db.AppDatabase;

public class ChangeItApp extends Application {

    private AppExecutors appExecutors;

    @Override
    public void onCreate() {
        super.onCreate();

        appExecutors = new AppExecutors();
    }

    public AppDatabase getDatabase() {
        return AppDatabase.getInstance(this, appExecutors);
    }

    public AppRepository getRepository() {
        return AppRepository.getInstance(getDatabase());
    }
}
