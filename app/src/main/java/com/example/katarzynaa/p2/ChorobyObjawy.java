package com.example.katarzynaa.p2;

/**
 * Created by Katarzynaa on 2018-01-30.
 */

public class ChorobyObjawy {

    private int id_choroby;
    private int id_objawy;

    public ChorobyObjawy(int id_choroby, int id_objawy) {
        this.id_choroby = id_choroby;
        this.id_objawy = id_objawy;
    }

    public int getId_choroby() {
        return id_choroby;
    }

    public int getId_objawy() {
        return id_objawy;
    }
}
