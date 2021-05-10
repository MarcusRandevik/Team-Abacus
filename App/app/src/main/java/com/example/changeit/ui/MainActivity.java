package com.example.changeit.ui;

import android.os.Bundle;
import android.os.UserHandle;
import android.view.MenuItem;

import com.example.changeit.R;
import com.example.changeit.model.StartUpService;
import com.example.changeit.model.User;
import com.example.changeit.model.UserHandler;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

/**
 * Start of the application
 * @author Marcus Randevik, Izabell Arvidsson, Moa Berglund
 * @since 2021-04-04
 */
public class MainActivity extends AppCompatActivity {
    /**
     * Sets up the application, with a menu and a user that is logged in
     * If you have ran the application before, the data is saved and shows next time again
     * @param savedInstanceState last runs settings/data
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_favorites, R.id.navigation_messages, R.id.navigation_profile)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        StartUpService startup = StartUpService.getInstance();
        startup.loadPackage();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // API 5+ solution
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


}