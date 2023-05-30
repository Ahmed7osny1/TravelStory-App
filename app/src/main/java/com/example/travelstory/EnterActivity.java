package com.example.travelstory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.travelstory.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class EnterActivity extends AppCompatActivity {

    SharedPreferences prefs;
    SharedPreferences.Editor prefsEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);

        // Create Shared Preferences
        prefs = this.getSharedPreferences("authUser", MODE_PRIVATE);
        prefsEditor = prefs.edit();


        BottomNavigationView navigation = findViewById(R.id.bottomNavigationView);
        NavController navController = Navigation.findNavController(this,
                R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navigation, navController);

        navigation.getMenu().findItem(R.id.logout)
                .setOnMenuItemClickListener(menuItem -> {

                    // remove token from shared prefs
                    prefsEditor.remove("condition");
                    prefsEditor.apply();

                    startActivity(new Intent(this, MainActivity.class));
                    finish();

                    return true;
                });

    }
}