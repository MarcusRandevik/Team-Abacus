package com.example.changeit;

import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Class maintaining exectuors for different tasks. Ensures diskIO won't prevent UI from loading
 * @since 2021-04-12
 */
public class AppExecutors {

    private final Executor mDiskIO;


    private AppExecutors(Executor diskIO) {
        this.mDiskIO = diskIO;
    }

    public AppExecutors() {
        this(Executors.newSingleThreadExecutor());
    }

    public Executor diskIO() {
        return mDiskIO;
    }

    private static class MainThreadExecutor implements Executor {
        private Handler mainThreadHandler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(@NonNull Runnable command) {
            mainThreadHandler.post(command);
        }
    }
}
