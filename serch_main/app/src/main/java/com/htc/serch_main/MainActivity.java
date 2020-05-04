package com.htc.serch_main;

import android.support.annotation.NonNull;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    View drawView;
    Button Menub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout=(DrawerLayout)findViewById(R.id.draw);
        drawView=(View)findViewById(R.id.drawView);
        drawerLayout.setDrawerListener(listener);

        Menub=(Button)findViewById(R.id.menuB);
        Menub.setOnClickListener(slide);
    }

    Button.OnClickListener slide = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            drawerLayout.openDrawer(drawView);
        }
    };

    DrawerLayout.DrawerListener listener = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(@NonNull View drawView, float slideOffset) {

        }
        @Override
        public void onDrawerOpened(@NonNull View drawView) {

        }

        @Override
        public void onDrawerClosed(@NonNull View drawView) {

        }

        @Override
        public void onDrawerStateChanged(int newState) {

        }
    };
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawers();
        }
        else {
            super.onBackPressed();
        }
    }
}
