package com.example.orwmaprojekt1;

public class student {

    public String ime;
    public String prezime;
    public String broj;
    public String predavanje;
    public String predmet;

    public student(String ime, String prezime, String broj, String predmet) {
        this.ime = ime;
        this.prezime = prezime;
        this.broj = broj;
        this.predmet = predmet;
    }

    public student(String ime, String predmet, String predavanje) {
        this.ime = ime;
        this.predmet = predmet;
        this.predavanje = predavanje;
    }

    public student() {
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String imeprezime(String ime, String prezime) {
        return this.ime + "" + this.prezime;
    }

}

