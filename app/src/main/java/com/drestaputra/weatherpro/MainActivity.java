package com.drestaputra.weatherpro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.WindowManager;

import com.drestaputra.weatherpro.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        BottomNavigationView navView = mainBinding.bottomNavigationView;
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        // agar bottom nav tidak ter adjust ketika soft keyboard muncul
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);
        NavigationUI.setupWithNavController(navView, navController);
//        set agar bottom nav index ke 0 (menu home) tidak checkable dan clickable, karena menggunakan fab
        mainBinding.bottomNavigationView.getMenu().getItem(0).setCheckable(false);
        mainBinding.bottomNavigationView.getMenu().getItem(0).setEnabled(false);
        mainBinding.fab.setOnClickListener(v -> {
                navView.setSelectedItemId(R.id.navigation_home);
                navController.navigate(R.id.navigation_home);
            }
        );


    }
}