package com.example.katarzynaa.p2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PlynyActivity extends Activity {

    double volume;
    TextView tvvolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plyny);
        Bundle b = getIntent().getExtras();
        volume = b.getDouble("volume");
        wyswietl();
    }

    public void onClick1(View v) {
        volume += 100;
        wyswietl();
    }

    public void onClick2(View v) {
        volume += 150;
        wyswietl();
    }

    public void onClick3(View v) {
        volume += 300;
        wyswietl();
    }

    public void onClick4(View v) {
        volume += 400;
        wyswietl();
    }

    public void onClick5(View v) {
        volume += 500;
        wyswietl();
    }

    public void onClick6(View v) {
        volume += 600;
        wyswietl();
    }

    public void onClick7(View v) {
        volume += 700;
        wyswietl();
    }

    public void onClick8(View v) {
        volume += 800;
        wyswietl();
    }
    public void onClickCzysc(View v){
        volume=0;
        wyswietl();
    }

    private void wyswietl() {
        tvvolume = (TextView) findViewById(R.id.tvVolume);
        double total = volume;
        if (total > 1000) {
            total /= 1000;
            tvvolume.setText(total + " l");
        } else
            tvvolume.setText(total + " ml");
    }
}
