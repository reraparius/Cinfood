package com.example.cinfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class navbar extends AppCompatActivity {

    //mendeklarasikan buttom navigation
    BottomNavigationView bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navbar);

        //menghubungkan bottom navigation dengan id
        bottomNavigation = findViewById(R.id.bottom_navigation);
        //memberikan aksi ketika button di klick

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new BerandaFragment()).commit();
        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //object fragment
              Fragment selectedFragment = null;

                switch (item.getItemId()){
                    case R.id.nav_home:
                        selectedFragment = new BerandaFragment();
                        break;
                    case R.id.nav_profil:
                        selectedFragment = new ProfileFragment();
           //            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
                        break;



                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
                return true;
            }
        });
            }
        }
