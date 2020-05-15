package com.example.sub_tracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.navigation.NavigationView;

public class Homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage2);
        BottomNavigationView bottom_nav =findViewById(R.id.bottom_nav_bar);
        bottom_nav.setOnNavigationItemSelectedListener(nav_listener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener nav_listener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selected_frag=null;

                    switch (menuItem.getItemId()){
                        case R.id.nav_home:
                            selected_frag=new HomeFrag();
                            break;
                        case R.id.nav_search:
                            selected_frag=new SearchFrag();
                            break;
                        case R.id.nav_sub:
                            selected_frag=new SubsFrag();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.frag_contain,selected_frag).commit();
                    return true;
                }
            };
}
