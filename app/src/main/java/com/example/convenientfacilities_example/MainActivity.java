package com.example.convenientfacilities_example;
// 편의시설 네비 드로워 어플
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.convenientfacilities_example.ui.home.FoodFragment;
import com.example.convenientfacilities_example.ui.home.HomeFragment;
import com.example.convenientfacilities_example.ui.home.PublicartFragment;
import com.example.convenientfacilities_example.ui.home.StorytellingFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeFragment()).commit();
                break;
            case R.id.nav_hospital:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HospitalFragment()).commit();
                break;
            case R.id.nav_parking:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ParkingFragment()).commit();
                break;
            case R.id.nav_bus:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new BusFragment()).commit();
                break;
            case R.id.nav_food:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FoodFragment()).commit();
                break;
            case R.id.nav_storytelling:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new StorytellingFragment()).commit();
                break;
            case R.id.nav_publicart:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new PublicartFragment()).commit();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}