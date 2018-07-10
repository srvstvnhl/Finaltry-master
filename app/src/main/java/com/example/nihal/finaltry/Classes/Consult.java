package com.example.nihal.finaltry.Classes;

public class Consult {


    private String Name;
    private int Photo;


    public Consult() {
    }

    public Consult(String name, int photo) {
        Name = name;
        Photo = photo;
    }

    //getter

    public String getName() {
        return Name;
    }

    public int getPhoto() {
        return Photo;
    }

    //setter


    public void setName(String name) {
        Name = name;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }
}

