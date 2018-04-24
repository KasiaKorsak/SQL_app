package com.example.katarzynaa.p2;

/**
 * Created by Katarzynaa on 2018-01-30.
 */

public class Choroba {

    private int id;
    private String nazwa;

    public Choroba(int id, String nazwa) {
        this.id = id;
        this.nazwa = nazwa;
    }

    public int getId() {
        return id;
    }

    public String getNazwa() {
        return nazwa;
    }
}
