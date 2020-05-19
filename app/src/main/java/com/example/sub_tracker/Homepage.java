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
    final Fragment frag1=new HomeFrag();
    final Fragment frag2=new SearchFrag();
    final Fragment frag3=new SubsFrag();
    final Fragment frag4=new SettingsFrag();
    Fragment active = frag1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage2);

        getSupportFragmentManager().beginTransaction().add(R.id.frag_contain,frag4,"4").hide(frag4).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frag_contain,frag3,"3").hide(frag3).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frag_contain,frag2,"2").hide(frag2).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frag_contain,frag1,"1").commit();
        BottomNavigationView bottom_nav =findViewById(R.id.bottom_nav_bar);
        bottom_nav.setOnNavigationItemSelectedListener(nav_listener);



    }

    private BottomNavigationView.OnNavigationItemSelectedListener nav_listener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    if(menuItem.getItemId()==R.id.nav_home){
                        getSupportFragmentManager().beginTransaction().hide(active).show(frag1).commit();
                        active=frag1;
                        return true;
                    }else if (menuItem.getItemId()==R.id.nav_search){
                        getSupportFragmentManager().beginTransaction().hide(active).show(frag2).commit();
                        active=frag2;
                        return true;
                    }else if (menuItem.getItemId()==R.id.nav_sub){
                        getSupportFragmentManager().beginTransaction().hide(active).show(frag3).commit();
                        active=frag3;
                        return true;
                    }else if (menuItem.getItemId()==R.id.nav_settings){
                        getSupportFragmentManager().beginTransaction().hide(active).show(frag4).commit();
                        active=frag4;
                        return true;
                    }



                    return false;
                }
            };

}
