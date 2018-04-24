package com.example.katarzynaa.p2;

public class Przepis {

    private int imageResourceId;
    private int strona;

    public Przepis(int imageResourceId, int strona) {
        this.imageResourceId = imageResourceId;
        this.strona = strona;
    }

    public static final Przepis[] przepisy = {
            new Przepis(R.drawable.podch, R.string.strona1),
            new Przepis(R.drawable.psil, R.string.strona2),
            new Przepis(R.drawable.pwege,R.string.strona3),
    };


    public int getImageResourceId() {
        return imageResourceId;
    }

    public int getStrona() {
        return strona;
    }
}
