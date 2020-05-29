package com.htc.serch_main;

import android.content.Intent;
import android.media.session.PlaybackState;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;


import java.util.Map;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    View drawView;
    Button Menub; // 메뉴 버튼
    TextView Hospi; // 병원 버튼
    TextView Emer; // 응급실 버튼
    TextView Phar; // 약국 버튼
    TextView Star; // 즐겨찾기 버튼
    TextView Place; // 자주가는곳 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this,Loading.class);
        startActivity(intent);

        //드로어 네비게이션 변수 선언
        drawerLayout=(DrawerLayout)findViewById(R.id.draw);
        drawView=(View)findViewById(R.id.drawView);
        drawerLayout.setDrawerListener(listener);

        // 메뉴 버튼 변수 선언
        Menub=(Button)findViewById(R.id.menuB);
        Menub.setOnClickListener(slide);

        // 병원 텍스트 변수 선언
        Hospi=(TextView)findViewById(R.id.hos);
        Hospi.setOnClickListener(hosp);

        // 응급실 텍스트 변수 선언
        Emer=(TextView)findViewById(R.id.emer);
        Emer.setOnClickListener(emerg);

        // 약국 텍스트 변수 선언
        Phar=(TextView)findViewById(R.id.par);
        Phar.setOnClickListener(parm);

        // 즐겨탖기 텍스트 변수 선언
        Star=(TextView)findViewById(R.id.star);
        Star.setOnClickListener(stars);

        //  자주가는곳 텍스트 변수 선언
        Place=(TextView)findViewById(R.id.place);
        Place.setOnClickListener(places);

    }

    //병원 탭을 누를때 지도에 마커 찍히는 기능
    TextView.OnClickListener hosp = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    // 응급실 탭 누를때 지도에 마커 찍히는 기능
    TextView.OnClickListener emerg = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    //약국 탭 누를때 지도에 마커 찍힘
    TextView.OnClickListener parm = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    // 즐겨찾기 탭 누르면 즐겨찾기 화면 on
    TextView.OnClickListener stars = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    // 자주가는곳 탭 누르면 자주가는곳 화면 on
    TextView.OnClickListener places = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    // 메뉴 버튼 누르면 드로어 네비게이션 활성화
    Button.OnClickListener slide = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            drawerLayout.openDrawer(drawView);
        }
    };

    //화면 슬라이드시 드로어 활성화
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

    //뒤로가기 버튼 누를시 드로어 비활성화
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

}
