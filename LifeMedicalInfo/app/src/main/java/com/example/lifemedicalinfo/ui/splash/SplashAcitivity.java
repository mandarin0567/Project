package com.example.lifemedicalinfo.ui.splash;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lifemedicalinfo.R;
import com.example.lifemedicalinfo.ui.sign.LoginAcitivity;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class SplashAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TedPermission.with(this)
            .setPermissions(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
                )
            .setPermissionListener(new PermissionListener() {
                @Override
                public void onPermissionGranted() {
                    startSplash();
                }

                @Override
                public void onPermissionDenied(List<String> deniedPermissions) {
                    Toast.makeText(
                        SplashAcitivity.this,
                        "권한을 허용해주셔야 사용 가능합니다.",
                        Toast.LENGTH_SHORT
                    ).show();
                }
            })
            .check();
    }

    private void startSplash() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask(){

            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), LoginAcitivity.class);
                startActivity(intent);
                finish();
            }
        };

        timer.schedule(timerTask, 3000);
    }
}
