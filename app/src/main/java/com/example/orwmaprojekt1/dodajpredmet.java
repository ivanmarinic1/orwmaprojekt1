package com.example.orwmaprojekt1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class dodajpredmet extends AppCompatActivity implements NameClickListener, View.OnClickListener, AdapterView.OnItemSelectedListener {
    static List<String> list = new ArrayList<String>();
    static List<String> lista = new ArrayList<String>();
    static List<predmeti> listaa = new ArrayList<predmeti>();
    public RecyclerAdapter adapter;
    TextView tvPredmeti, tvDodajPredmet, tvDodajPredavanja, ispis;
    EditText etIme, etPredavanje;
    Button btnDodajPredmet, btnDodajPredavanje, btnBack;
    Spinner spin;
    String predmeti;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.predmet);
        ispis = (TextView) findViewById(R.id.ispis);
        spin = (Spinner) findViewById(R.id.spinnerOdaberiPredmet);
        tvPredmeti = (TextView) findViewById(R.id.textW13);
        tvDodajPredmet = (TextView) findViewById(R.id.textW14);
        tvDodajPredavanja = (TextView) findViewById(R.id.textW15);
        btnDodajPredavanje = (Button) findViewById(R.id.btnDodaj3);
        btnDodajPredmet = (Button) findViewById(R.id.btnDodaj2);
        btnBack = (Button) findViewById(R.id.btnBack4);
        etIme = findViewById(R.id.eText2);
        adapter = new RecyclerAdapter(this);
        etPredavanje = (EditText) findViewById(R.id.eText3);
        btnDodajPredmet.setOnClickListener(this);
        btnDodajPredavanje.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(dodajpredmet.this, android.R.layout.simple_spinner_item, dodavanjestudenta.listItems);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(arrayAdapter);
        spin.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDodaj2:
                String predmet = etIme.getText().toString();
                startActivity(new Intent(this, dodajpredmet.class));
                if (predmet.matches("")) {
                    Toast.makeText(this, "Niste unjeli ime predmeta", Toast.LENGTH_SHORT).show();
                } else {
                    list.add(predmet);
                    dodavanjestudenta.listItems.add(predmet);
                     Toast.makeText(this, "Unesen predmet: " + predmet, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnDodaj3:
                String predavanje = etPredavanje.getText().toString();
                if (!dodavanjestudenta.listItems.isEmpty())
                    predmeti = spin.getSelectedItem().toString();
                else Toast.makeText(this, "NISTE ODABRALI PREDMET", Toast.LENGTH_SHORT).show();
                if (predavanje.matches("")) {
                    Toast.makeText(this, "Niste unjeli ime predavanja", Toast.LENGTH_SHORT).show();
                } else {
                    lista.add(predavanje);
                    predmeti predmety = new predmeti(predmeti, predavanje);
                    listaa.add(predmety);
                    Toast.makeText(this, "Uneseno predavanje: " + predavanje + "predavanje: " + predmety.predavanje, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnBack4:
                startActivity(new Intent(this, pocetna.class));
                finish();
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),"Odabran predmet "+ item, Toast.LENGTH_SHORT).show();
        ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
        ((TextView) parent.getChildAt(0)).setTextSize(16);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onNameClick(int position) {
        Toast.makeText(this, "ID je : " + adapter.getItemId(position) + "position je : " + position, Toast.LENGTH_SHORT).show();
        int i = position;
    }
}
