package com.example.katarzynaa.p2;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PrzepisActivity extends Activity {

    public static final String EXTRA_ID = "przepisID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_przepis);

        Bundle b = getIntent().getExtras();
        int id = b.getInt(EXTRA_ID);
        Przepis p=Przepis.przepisy[id];

        TextView tv = (TextView) findViewById(R.id.tvstrona);
        tv.setText(p.getStrona());
        tv.setMovementMethod(LinkMovementMethod.getInstance());

        ImageView imV = (ImageView) findViewById(R.id.ivPrzepis);
        imV.setImageResource(p.getImageResourceId());
    }
}
