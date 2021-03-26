package com.example.mantan;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class MainActivityDash extends AppCompatActivity {
    private MeowBottomNavigation meowBottomNavigation;
    private final static int HOME = 1;
    private final static int KERANJANG = 2;
    private final static int PROFIL = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dash);

        meowBottomNavigation = findViewById(R.id.meow_bottom_navigation);
        meowBottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.home));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.keranjang));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.profile));

        getSupportFragmentManager().beginTransaction().replace(R.id.frame, new DashBoardFragment()).commit();

        meowBottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                Fragment selectFragment = null;
                switch (item.getId()){
                    case HOME:
                        selectFragment = new DashBoardFragment();
                        break;
                    case KERANJANG:
                        selectFragment = new KeranjangFragment();
                        break;
                    case PROFIL:
                        selectFragment = new ProfilFragment();
                        break;
                    default:
                        return;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frame, selectFragment).commit();
            }
        });

        meowBottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment selectFragment = null;
                switch (item.getId()){
                    case HOME:
                        selectFragment = new DashBoardFragment();
                        break;
                    case KERANJANG:
                        selectFragment = new KeranjangFragment();
                        break;
                    case PROFIL:
                        selectFragment = new ProfilFragment();
                        break;
                    default:
                        return;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frame, selectFragment).commit();
            }
        });

        meowBottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
                // your codes
            }
        });

    }
}