package com.example.katarzynaa.p2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Katarzynaa on 2018-01-30.
 */

public class Mydatabase extends SQLiteAssetHelper {


    private static final String DATABASE_NAME = "MyDatabase.db";
    private static final int DATABASE_VERSION = 1;

    SQLiteDatabase db = getReadableDatabase();

    public Mydatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public List<Objaw> objawy() {
        List<Objaw> objawyList = new ArrayList<Objaw>();
        String[] kolumny = {"ID_OBJAWY", "NAZWA"};
        //SQLiteDatabase db = getReadableDatabase();
        Cursor kursor = db.query("OBJAWY", kolumny, null, null, null, null, null);
        while (kursor.moveToNext()) {
            Objaw objaw = new Objaw(kursor.getInt(0), kursor.getString(1));
            objawyList.add(objaw);
        }
        return objawyList;
    }

    public List<Choroba> choroby() {
        List<Choroba> chorobyList = new ArrayList<Choroba>();
        String[] kolumny = {"ID_CHOROBY", "NAZWA"};
        Cursor kursor = db.query("CHOROBY", kolumny, null, null, null, null, null);
        while (kursor.moveToNext()) {
            Choroba choroba = new Choroba(kursor.getInt(0), kursor.getString(1));
            chorobyList.add(choroba);
        }
        return chorobyList;
    }

    public List<ChorobyObjawy> chorobyIobjawy() {
        List<ChorobyObjawy> ch_o_List = new ArrayList<ChorobyObjawy>();
        String[] kolumny = {"ID_CHOROBY", "ID_OBJAWY"};
        Cursor kursor = db.query("CHOROBY_OBJAWY", kolumny, null, null, null, null, null);
        while (kursor.moveToNext()) {
            ChorobyObjawy ch_o = new ChorobyObjawy(kursor.getInt(0), kursor.getInt(1));
            ch_o_List.add(ch_o);
        }
        return ch_o_List;
    }
}
