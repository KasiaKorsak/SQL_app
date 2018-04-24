package com.example.katarzynaa.p2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    Intent intent;
    double volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        volume = 0;
    }

    public void onClickbtnChoroby(View v) {
        intent = new Intent(MainActivity.this, ChorobyActivity.class);
        startActivity(intent);
    }

    public void onClickPlyny(View v) {
        intent = new Intent(MainActivity.this, PlynyActivity.class);
       intent.putExtra("volume", volume);
        startActivity(intent);
    }

    public void onClickDieta(View v) {
        intent = new Intent(MainActivity.this, DietaActivity.class);
        startActivity(intent);
    }
}
