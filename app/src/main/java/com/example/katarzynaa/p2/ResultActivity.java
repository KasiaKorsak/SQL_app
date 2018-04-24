package com.example.katarzynaa.p2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //Log.d("Choroba:", String.valueOf(ChorobyActivity.getChorobyDlaWybranychObjawow()));
        List<String> choroby = ChorobyActivity.getChorobyDlaWybranychObjawow();
        TextView tv = (TextView) findViewById(R.id.tvChoroby);
        String c = new String();
        for (String ch : choroby) {
            c = c + ch + "\n";
            tv.setText(c);
        }
    }
}
