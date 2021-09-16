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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class dodavanjestudenta extends AppCompatActivity implements NameClickListener, View.OnClickListener, AdapterView.OnItemSelectedListener {
    static List<student> list = new ArrayList<student>();
    static ArrayList<String> listItems = new ArrayList<String>();
    static List<String> lista = new ArrayList<String>();
    public String ime, prezime;
    public RecyclerAdapter adapter;
    public RecyclerAdapter adapter1;
    TextView tvDodajStudenta;
    Button btnBack, btnDodaj;
    EditText etIme, etPrezime, etBroj, etPredmet;
    Spinner spin;
    private RecyclerView recycler;
    String predmet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dodavanjestudenta);
        tvDodajStudenta = (TextView) findViewById(R.id.textW5);
        btnBack = (Button) findViewById(R.id.buttonBack);
        btnDodaj = (Button) findViewById(R.id.buttonDodaj);
        etIme = (EditText) findViewById(R.id.etIme);
        etPrezime = (EditText) findViewById(R.id.etPrezime);
        etBroj = (EditText) findViewById(R.id.etBrojStudenta);
        recycler = findViewById(R.id.recyclerView);
        recycler.setHasFixedSize(true);
        adapter = new RecyclerAdapter(this);
        btnBack.setOnClickListener(this);
        btnDodaj.setOnClickListener(this);

        setupRecycler();
        setupRecyclerData();

        spin = (Spinner) findViewById(R.id.spin);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(dodavanjestudenta.this, android.R.layout.simple_spinner_item, dodavanjestudenta.listItems);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(arrayAdapter);
        spin.setOnItemSelectedListener(this);
    }

    private void setupRecyclerData() {
        adapter.addData(listItems);
    }

    private void setupRecycler() {
        recycler = findViewById(R.id.recyclerView);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerAdapter(this);
        recycler.setAdapter(adapter);
    }

    public void addCell(View view) {

    }

    public void removeCell(View view) {
        adapter.removeCell(0);
    }


    @Override
    public void onNameClick(int position) {
        Toast.makeText(this, "ID je : " + adapter.getItemId(position) + "position je : " + position, Toast.LENGTH_SHORT).show();
        int i = position;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonDodaj:
                String ime = etIme.getText().toString();
                String prezime = etPrezime.getText().toString();
                String broj = etBroj.getText().toString();
                if (!dodavanjestudenta.listItems.isEmpty())
                    predmet = spin.getSelectedItem().toString();
                else Toast.makeText(this, "NISTE ODABRALI PREDMET", Toast.LENGTH_SHORT).show();

                if (ime.matches("") || prezime.matches("") || broj.matches("") || dodavanjestudenta.listItems.isEmpty()) {
                    Toast.makeText(this, "Niste unjeli ime i/ili prezime i/ili broj", Toast.LENGTH_SHORT).show();
                } else {
                    student student = new student(ime, prezime, broj, predmet);
                    lista.add(ime + " " + prezime);
                    list.add(student);
                    studentirecycler.listItems.add(student);
                    Toast.makeText(this, "Unesen student: " + student.ime + " " + student.prezime, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.buttonBack:
                startActivity(new Intent(this, pocetna.class));
                finish();
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),"Odabran predmet " + item, Toast.LENGTH_SHORT).show();
        ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
        ((TextView) parent.getChildAt(0)).setTextSize(16);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}





