package com.example.lifemedicalinfo.ui.aed;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.lifemedicalinfo.R;
import com.example.lifemedicalinfo.databinding.ActivityAedDetailBinding;
import com.example.lifemedicalinfo.domain.repository.AED;

import io.realm.Realm;

public class AedDetailActivity extends AppCompatActivity {

    ActivityAedDetailBinding binding;
    boolean isLiked = false;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AED aed = (AED) getIntent().getSerializableExtra("aed");

        binding = DataBindingUtil.setContentView(this, R.layout.activity_aed_detail);
        binding.setAed(aed);

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        realm = Realm.getDefaultInstance();
        isLiked = realm.where(AED.class)
            .equalTo("id", aed.hashCode())
            .findAll()
            .size() > 0;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (realm != null) {
            realm.close();
            realm = null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.aed_detail, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        int tintColor = Color.YELLOW;
        if (!isLiked)
            tintColor = Color.GRAY;

        menu.findItem(R.id.action_like).getIcon().setColorFilter(tintColor, PorterDuff.Mode.SRC_IN);

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                finish();
                return true;
            }
            case R.id.action_like: {
                if (isLiked)
                    unlike();
                else
                    like();

                isLiked = !isLiked;
                invalidateOptionsMenu();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public void like() {
        final AED aed = (AED) getIntent().getSerializableExtra("aed");

        aed.setId(aed.hashCode());

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(aed);
            }
        });
    }

    public void unlike() {
        final AED aed = (AED) getIntent().getSerializableExtra("aed");

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.where(AED.class)
                    .equalTo("id", aed.hashCode())
                    .findAll().deleteAllFromRealm();
            }
        });
    }
}
