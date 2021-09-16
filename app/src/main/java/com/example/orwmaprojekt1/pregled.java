package com.example.orwmaprojekt1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import static com.example.orwmaprojekt1.dodajpredmet.listaa;

public class pregled extends AppCompatActivity implements NameClickListener, AdapterView.OnItemSelectedListener, View.OnClickListener {
    static ArrayList<String> lista = new ArrayList<String>();
    static ArrayList<String> listaaa = new ArrayList<String>();

    TextView tvUpis, tvStudenti;
    Spinner spin1, spin2;
    ListView listView1;
    Button btnPregled, btnBack;
    ArrayAdapter<String> arrayAdapter1;
    ArrayAdapter<String> arrayAdapter;
    List<String> odabrani;
    private ArrayAdapter aAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pregled);
        tvUpis = (TextView) findViewById(R.id.textW10);
        tvStudenti = (TextView) findViewById(R.id.textW8);
        btnBack = (Button) findViewById(R.id.back3);
        btnPregled = (Button) findViewById(R.id.pregledd);
        listView1 = (ListView) findViewById(R.id.ListView2);
        spin1 = (Spinner) findViewById(R.id.spinnerOdaberiPredmet);
        spin2 = (Spinner) findViewById(R.id.spinnerOdaberiPredavanje);
        btnBack.setOnClickListener(this);
        btnPregled.setOnClickListener(this);

        arrayAdapter = new ArrayAdapter<>(pregled.this, android.R.layout.simple_spinner_item, dodavanjestudenta.listItems);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(arrayAdapter);
        spin1.setOnItemSelectedListener(this);
        arrayAdapter1 = new ArrayAdapter<>(pregled.this, android.R.layout.simple_spinner_item, lista);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(arrayAdapter1);
        spin2.setOnItemSelectedListener(this);


        listView1.setAdapter(aAdapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pregledd:
                listaaa.clear();
                for (int i = 0; i < prisutnost.listaaaa.size(); i++) {
                    if ((prisutnost.listaaaa.get(i).predavanje == spin2.getSelectedItem().toString()) && (prisutnost.listaaaa.get(i).predmet == spin1.getSelectedItem().toString())) {
                        listaaa.add(prisutnost.listaaaa.get(i).ime.toString());
                        arrayAdapter1.notifyDataSetChanged();
                        aAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaaa) {
                            public View getView(int position, View convertView, ViewGroup parent) {
                                // Get the Item from ListView
                                View view = super.getView(position, convertView, parent);

                                // Initialize a TextView for ListView each Item
                                TextView tv = (TextView) view.findViewById(android.R.id.text1);

                                // Set the text color of TextView (ListView Item)
                                tv.setTextColor(Color.WHITE);
                                tv.setTextSize(16);

                                // Generate ListView Item using TextView
                                return view;
                            }
                        };
                    }
                }
                listView1.setAdapter(aAdapter);

                break;
            case R.id.back3:
                startActivity(new Intent(this, pocetna.class));
                finish();
                break;
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Spinner spin = (Spinner) parent;
        Spinner spin2 = (Spinner) parent;
        listaaa.clear();
        if (spin.getId() == R.id.spinnerOdaberiPredmet) {
            String item1 = parent.getItemAtPosition(position).toString();
            //Toast.makeText(this, "Odabran predmet: " + item1, Toast.LENGTH_SHORT).show();
            if (dodajpredmet.list.isEmpty() || dodajpredmet.lista.isEmpty()) {
                Toast.makeText(this, "NISTA NIJE UNESENO", Toast.LENGTH_SHORT).show();
            } else {
                lista.clear();
                for (int i = 0; i < listaa.size(); i++) {
                    if (listaa.get(i).predmet == item1) {
                        lista.add(listaa.get(i).predavanje);
                        arrayAdapter.notifyDataSetChanged();
                        arrayAdapter1.notifyDataSetChanged();
                        ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                        ((TextView) parent.getChildAt(0)).setTextSize(16);

                        //   Toast.makeText(this, "predavanje : " + lista.get(i), Toast.LENGTH_SHORT).show();
                    }
                }
                //       if (dodajpredmet.list.get(i).toString() == item1) {
                //         lista.add(dodajpredmet.lista.get(i));
            }
            ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
            ((TextView) parent.getChildAt(0)).setTextSize(16);

        }
        ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
        ((TextView) parent.getChildAt(0)).setTextSize(16);

        if (spin2.getId() == R.id.spinnerOdaberiPredavanje) {
            String item = parent.getItemAtPosition(position).toString();

            // Toast.makeText(this, "Your choose :" + item, Toast.LENGTH_SHORT).show();
            ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
            ((TextView) parent.getChildAt(0)).setTextSize(16);
        }
        ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
        ((TextView) parent.getChildAt(0)).setTextSize(16);
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onNameClick(int position) {

    }
}