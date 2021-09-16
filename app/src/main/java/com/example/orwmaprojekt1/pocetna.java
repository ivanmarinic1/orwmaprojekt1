package com.example.orwmaprojekt1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class pocetna extends AppCompatActivity implements View.OnClickListener {

    Button btnDodaj, btnPregled, btnPrisutnost, btnPredmet, btnLogOut, btnPreg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pocetna);
        btnPreg = (Button) findViewById(R.id.btnPreg);
        btnDodaj = (Button) findViewById(R.id.btnDodaj);
        btnPregled = (Button) findViewById(R.id.btnPregled);
        btnPrisutnost = (Button) findViewById(R.id.btnPrisutnost);
        btnPredmet = (Button) findViewById(R.id.btnPredmet);
        btnLogOut = (Button) findViewById(R.id.btnLogOut);
        btnPreg.setOnClickListener(this);
        btnDodaj.setOnClickListener(this);
        btnPregled.setOnClickListener(this);
        btnPrisutnost.setOnClickListener(this);
        btnPredmet.setOnClickListener(this);
        btnLogOut.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPreg:
                startActivity(new Intent(this, pregled.class));
                finish();
                break;
            case R.id.btnDodaj:
                startActivity(new Intent(this, dodavanjestudenta.class));
                finish();
                break;
            case R.id.btnPregled:
                startActivity(new Intent(this, pregledstudenata.class));
                finish();
                break;
            case R.id.btnPrisutnost:
                startActivity(new Intent(this, prisutnost.class));
                finish();
                break;
            case R.id.btnPredmet:
                startActivity(new Intent(this, dodajpredmet.class));
                finish();
                break;
            case R.id.btnLogOut:
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
        }
    }
}