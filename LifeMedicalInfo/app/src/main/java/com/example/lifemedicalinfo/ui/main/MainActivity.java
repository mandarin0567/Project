package com.example.lifemedicalinfo.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.lifemedicalinfo.R;
import com.example.lifemedicalinfo.domain.repository.AED;
import com.example.lifemedicalinfo.domain.repository.AEDRepository;
import com.example.lifemedicalinfo.domain.repository.GpsTracker;
import com.example.lifemedicalinfo.ui.aed.AedDetailActivity;
import com.example.lifemedicalinfo.ui.aed.AedLikeListActivity;
import com.google.android.material.navigation.NavigationView;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MapView.POIItemEventListener {

    private DrawerLayout mDrawerLayout;
    private Context context = this;
    MapView mapView;
    ViewGroup mapViewContainer;
    private GpsTracker gpsTracker;
    private AEDRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false); // 기존 title 지우기
        actionBar.setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼 만들기
        actionBar.setHomeAsUpIndicator(R.drawable.line); //뒤로가기 버튼 이미지 지정

        this.mapView = new MapView(this);
        this.mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                mDrawerLayout.closeDrawers();

                int id = menuItem.getItemId();
                String title = menuItem.getTitle().toString();

                if(id == R.id.hospital){
                    Toast.makeText(context, title + ": 병원 정보를 불러옵니다.", Toast.LENGTH_SHORT).show();
                } else if(id == R.id.emergency){
                    Toast.makeText(context, title + ": 응급 AED 정보를 확인합니다.", Toast.LENGTH_SHORT).show();
                    displayAEDList();
                } else if(id == R.id.drug){
                    Toast.makeText(context, title + ": 약국 정보를 불러옵니다.", Toast.LENGTH_SHORT).show();
                } else if(id == R.id.favor) {
                    Toast.makeText(context, title + ": 즐겨찾기를 불러옵니다.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, AedLikeListActivity.class);
                    startActivity(intent);
                }

                return true;
            }
        });

        repository = new AEDRepository();
        gpsTracker = new GpsTracker(MainActivity.this);

        double latitude = gpsTracker.getLatitude();
        double longitude = gpsTracker.getLongitude();
        String address = gpsTracker.getCurrentAddress(latitude, longitude);

        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(latitude, longitude), true);
        mapView.setZoomLevel(3, true);
        mapView.setPOIItemEventListener(this);

        MapPOIItem marker = new MapPOIItem();
        marker.setItemName("현재 위치");
        marker.setTag(0);
        marker.setMapPoint(MapPoint.mapPointWithGeoCoord(
                latitude,
                longitude   )
        );
        marker.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        mapView.addPOIItem(marker);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ // 왼쪽 상단 버튼 눌렀을 때
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }


    private void displayAEDList() {
        double latitude = gpsTracker.getLatitude();
        double longitude = gpsTracker.getLongitude();

        repository.findAEDList(1, 100, latitude, longitude, new AEDRepository.AedCallback() {
            @Override
            public void onSuccess(ArrayList<AED> aedList) {
                setMarkers(aedList);
            }

            @Override
            public void onFailure(Exception e) {
                e.printStackTrace();

                Toast.makeText(MainActivity.this, "정보를 가져오지 못했습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setMarkers(ArrayList<AED> aedList) {
        System.out.println(aedList);

        mapView.removeAllPOIItems();

        for (AED aed : aedList) {
            MapPOIItem marker = new MapPOIItem();
            marker.setItemName(aed.getBuildAddress() + " " + aed.getBuildPlace());
            marker.setTag(0);
            marker.setUserObject(aed);
            marker.setMapPoint(MapPoint.mapPointWithGeoCoord(
                Double.parseDouble(aed.getWgs84Lat()),
                Double.parseDouble(aed.getWgs84Lon()))
            );
            marker.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
            marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

            mapView.addPOIItem(marker);
        }
    }

    @Override
    public void onPOIItemSelected(MapView mapView, MapPOIItem mapPOIItem) { }

    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem) {
        AED aed = (AED)mapPOIItem.getUserObject();
        Intent intent = new Intent(this, AedDetailActivity.class);
        intent.putExtra("aed", aed);
        startActivity(intent);
    }
    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem, MapPOIItem.CalloutBalloonButtonType calloutBalloonButtonType) { }
    @Override
    public void onDraggablePOIItemMoved(MapView mapView, MapPOIItem mapPOIItem, MapPoint mapPoint) { }
}