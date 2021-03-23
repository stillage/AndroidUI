package com.example.mantan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class LoginActivity extends AppCompatActivity {

    FloatingActionButton facebook, google, twitter;
    TabLayout tabLayout;
    ViewPager viewPager;
    float v=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        facebook = findViewById(R.id.fab_fb);
        twitter = findViewById(R.id.fab_twitter);
        google = findViewById(R.id.fab_google);
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpagger);

        tabLayout.addTab(tabLayout.newTab().setText("LOGIN"));
        tabLayout.addTab(tabLayout.newTab().setText("DAFTAR"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final LoginAdapter adapter = new LoginAdapter(getSupportFragmentManager(),this,tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setAlpha(v);
        twitter.setAlpha(v);
        google.setAlpha(v);
        facebook.setAlpha(v);

        twitter.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        google.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(600).start();
        facebook.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(800).start();
        tabLayout.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(100).start();

    }
}