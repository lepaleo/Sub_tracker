package com.example.sub_tracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class Homepage extends AppCompatActivity {
    final Fragment frag1=new HomeFrag();
    final Fragment frag2=new NotificationsFrag();
    final Fragment frag3=new SettingsFrag();
    Fragment active = frag1;
    BottomNavigationView bottom_nav;
    static Homepage obj;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage2);
        obj=this;

        intent = getIntent();

        /*

        getSupportFragmentManager().beginTransaction().add(R.id.frag_contain,frag3,"3").hide(frag3).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frag_contain,frag2,"2").hide(frag2).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frag_contain,frag1,"1").commit();
        bottom_nav =findViewById(R.id.bottom_nav_bar);
        bottom_nav.setOnNavigationItemSelectedListener(nav_listener);

         */

        bottom_nav =findViewById(R.id.bottom_nav_bar);
        bottom_nav.setOnNavigationItemSelectedListener(nav_listener);
        getSupportFragmentManager().beginTransaction().replace(R.id.frag_contain, new HomeFrag()).commit();



        //change notificaton bar color
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.mainApp_color));
        }



    }


    public static Homepage getInstance(){
        return obj;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener nav_listener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment active_frag = null;

                    if(menuItem.getItemId()==R.id.nav_home){
                        active_frag = new HomeFrag();
                        //getSupportFragmentManager().beginTransaction().replace(R.id.frag_contain,homeFrag).commit();
                        // active=frag1;
                    }else if (menuItem.getItemId()==R.id.nav_notifications){
                        //getSupportFragmentManager().beginTransaction().hide(active).show(frag2).commit();
                        //  active=frag2;
                        active_frag = new NotificationsFrag();
                    }else if (menuItem.getItemId()==R.id.nav_settings){
                        // getSupportFragmentManager().beginTransaction().hide(active).show(frag3).commit();
                        // active=frag3;
                        active_frag = new SettingsFrag();
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.frag_contain, active_frag).commit();


                    return true;
                }
            };

//    private boolean isCallable(Intent intent){
//        List<ResolveInfo> list =getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
//        return list.size()>0;
//    }

}
