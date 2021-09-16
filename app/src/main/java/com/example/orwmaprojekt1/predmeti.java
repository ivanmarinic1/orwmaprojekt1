package com.example.orwmaprojekt1;

public class predmeti extends student {

    public String predmet;
    public String predavanje;

    public predmeti(String predmet, String ime, String prezime, String broj) {
        this.predmet = predmet;
        this.ime = ime;
        this.prezime = prezime;
        this.broj = broj;
    }

    public predmeti(String predmet, String predavanje) {
        this.predmet = predmet;
        this.predavanje = predavanje;
    }


    public String imepredmeta() {
        return this.ime;
    }
}

