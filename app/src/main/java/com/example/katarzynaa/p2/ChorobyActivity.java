package com.example.katarzynaa.p2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;

import java.nio.channels.Selector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChorobyActivity extends Activity {

    Mydatabase mdb;
    List<Objaw> objawy;
    List<ChorobyObjawy> chorobyZobjawami;
    List<Choroba> choroby;
    static List<String> chorobyDlaWybranychObjawow;

    List<String> objawyNazwy;
    List<String> wybraneobjawy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choroby);

        mdb = new Mydatabase(this);
        objawyNazwy = new ArrayList<>();
        for (Objaw o : mdb.objawy()) {
            objawyNazwy.add(o.getNazwa());
        }

        Collections.sort(objawyNazwy);
        final ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, objawyNazwy);
        final ListView listobjawy = (ListView) findViewById(R.id.list_objawy);
        listobjawy.setAdapter(listAdapter);
        wybraneobjawy = new ArrayList<>();
        listobjawy.setSelector(R.color.jasny);
        listobjawy.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listobjawy.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                wybraneobjawy.add(objawyNazwy.get(i));
            }
        });
    }

    public void onClickBtnSprawdz(View v) {
        result();
        Intent intetnt = new Intent(ChorobyActivity.this, ResultActivity.class);
        startActivity(intetnt);

    }

    private void result() {
        Log.d("wybrane objawy:", String.valueOf(wybraneobjawy));
        objawy = mdb.objawy();
        List<Integer> id_ob = new ArrayList<>();
        for (int j = 0; j < wybraneobjawy.size(); j++)
            for (int i = 0; i < objawy.size(); i++) {
                if (objawy.get(i).getNazwa().equals(wybraneobjawy.get(j)))
                    id_ob.add(objawy.get(i).getId());
            }

        //  Log.d("Id_objawy:", String.valueOf(id_ob));

        chorobyZobjawami = mdb.chorobyIobjawy();
        List<Integer> id_chor = new ArrayList<>();
        for (int j = 0; j < id_ob.size(); j++)
            for (int i = 0; i < chorobyZobjawami.size(); i++) {
                if (id_ob.get(j) == chorobyZobjawami.get(i).getId_objawy()) {
                    id_chor.add(chorobyZobjawami.get(i).getId_choroby());
                }
            }

        //  Log.d("Id_choroby:", String.valueOf(id_chor));

        List<Integer> id_chor2 = new ArrayList<>();
        for (int j = 0; j < id_chor.size(); j++) {
            int i = id_chor.get(j);
            int licznik = 0;
            for (int k = 0; k < id_chor.size(); k++) {
                if (i == id_chor.get(k))
                    licznik++;
            }
            System.out.println("element: " + i + " ,ilosc wystapien: " + licznik);
            if (licznik == id_ob.size())
                id_chor2.add(i);
        }

        //  Log.d("Id_chor2: ", String.valueOf(id_chor2));

        choroby = mdb.choroby();
        chorobyDlaWybranychObjawow = new ArrayList<>();
        for (int j = 0; j < id_chor2.size(); j++)
            for (int i = 0; i < choroby.size(); i++) {
                if (id_chor2.get(j) == choroby.get(i).getId())
                    if (chorobyDlaWybranychObjawow.contains(choroby.get(i).getNazwa()))
                        continue;
                    else
                        chorobyDlaWybranychObjawow.add(choroby.get(i).getNazwa());
            }
        //  Log.d("choroby: ", String.valueOf(chorobyDlaWybranychObjawow));
        wybraneobjawy.clear();

    }

    public static List<String> getChorobyDlaWybranychObjawow() {
        return chorobyDlaWybranychObjawow;
    }
}
