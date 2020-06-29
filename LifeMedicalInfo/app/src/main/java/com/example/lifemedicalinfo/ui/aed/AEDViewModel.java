package com.example.lifemedicalinfo.ui.aed;

import android.content.Context;
import android.content.Intent;

import com.example.lifemedicalinfo.domain.repository.AED;

public class AEDViewModel {
    public AED aed;

    public AEDViewModel(AED aed) {
        this.aed = aed;
    }

    public void onClick(Context context) {
        Intent intent = new Intent(context, AedDetailActivity.class);
        intent.putExtra("aed", new AED(aed));
        context.startActivity(intent);
    }
}
