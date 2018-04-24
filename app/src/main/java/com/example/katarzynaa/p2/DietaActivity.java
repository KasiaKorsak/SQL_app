package com.example.katarzynaa.p2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DietaActivity extends Activity {

    Intent intent;// = new Intent(DietaActivity.this, PrzepisActivity.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dieta);
    }

    public void onClickOdch(View v) {
        intent = new Intent(DietaActivity.this, PrzepisActivity.class);
        intent.putExtra(PrzepisActivity.EXTRA_ID,0);
        startActivity(intent);
    }

    public void onClickSil(View v) {
        intent = new Intent(DietaActivity.this, PrzepisActivity.class);
        intent.putExtra(PrzepisActivity.EXTRA_ID,1);
        startActivity(intent);
    }
    public void onClickWege(View v) {
        intent = new Intent(DietaActivity.this, PrzepisActivity.class);
        intent.putExtra(PrzepisActivity.EXTRA_ID,2);
        startActivity(intent);
    }



}
