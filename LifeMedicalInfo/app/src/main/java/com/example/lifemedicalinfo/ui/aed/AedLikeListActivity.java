package com.example.lifemedicalinfo.ui.aed;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.lifemedicalinfo.R;
import com.example.lifemedicalinfo.databinding.ActivityAedListBinding;
import com.example.lifemedicalinfo.domain.repository.AED;

import java.util.ArrayList;

import io.realm.Realm;

public class AedLikeListActivity extends AppCompatActivity {

    ActivityAedListBinding binding;
    ArrayList<AED> aedList = new ArrayList<AED>();
    AedAdapter adapter;
    Realm realm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_aed_list);

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        realm = Realm.getDefaultInstance();

        adapter = new AedAdapter(aedList);
        binding.aedList.setAdapter(adapter);
        binding.aedList.setLayoutManager(new LinearLayoutManager(this));
        binding.executePendingBindings();
    }

    @Override
    protected void onResume() {
        super.onResume();

        aedList.clear();
        aedList.addAll(realm.where(AED.class).findAll());
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(realm != null) {
            realm.close();
            realm = null;
        }
    }
}
