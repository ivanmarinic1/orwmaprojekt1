package com.example.orwmaprojekt1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.SparseBooleanArray;
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
import static com.example.orwmaprojekt1.dodavanjestudenta.list;

public class prisutnost extends AppCompatActivity implements NameClickListener, AdapterView.OnItemSelectedListener, View.OnClickListener {
    static ArrayList<String> lista = new ArrayList<String>();
    static ArrayList<String> listaaa = new ArrayList<String>();
    static ArrayList<student> listaaaa = new ArrayList<student>();
    static List<String> odabrani;
    TextView tvUpis, tvStudenti;
    Spinner spin1, spin2;
    ListView listView1;
    Button btnDodaj, btnBack;
    ArrayAdapter<String> arrayAdapter1;
    private ArrayAdapter aAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prisutnost);
        tvUpis = (TextView) findViewById(R.id.textW10);
        tvStudenti = (TextView) findViewById(R.id.textW8);
        btnBack = (Button) findViewById(R.id.back3);
        btnDodaj = (Button) findViewById(R.id.btnDodaj1);
        listView1 = (ListView) findViewById(R.id.ListView2);
        spin1 = (Spinner) findViewById(R.id.spinnerOdaberiPredmet);
        spin2 = (Spinner) findViewById(R.id.spinnerOdaberiPredavanje);
        btnBack.setOnClickListener(this);
        btnDodaj.setOnClickListener(this);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(prisutnost.this, android.R.layout.simple_spinner_item, dodavanjestudenta.listItems);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(arrayAdapter);
        spin1.setOnItemSelectedListener(this);
        arrayAdapter1 = new ArrayAdapter<>(prisutnost.this, android.R.layout.simple_spinner_item, lista);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(arrayAdapter1);
        spin2.setOnItemSelectedListener(this);
        listView1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        //


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back3:
                startActivity(new Intent(this, pocetna.class));
                finish();
                break;
            case R.id.btnDodaj1:
                boolean check = false;
                SparseBooleanArray checked = listView1.getCheckedItemPositions();
                for (int i = 0; i < checked.size(); i++) {
                    if (checked.valueAt(i))
                        check = true;
                }
                odabrani = new ArrayList<String>();
                odabrani.clear();
                if (check) {
                    for (int i = 0; i < checked.size(); i++) {
                        int position = checked.keyAt(i);
                        if (checked.valueAt(i)) {
                            odabrani.add(listView1.getAdapter().getItem(position).toString());
                            student novi = new student(listView1.getAdapter().getItem(position).toString(), spin1.getSelectedItem().toString(), spin2.getSelectedItem().toString());
                            listaaaa.add(novi);
                            Toast.makeText(this, "odabrali ste " + listView1.getAdapter().getItem(position) + " " + listaaaa.get(i).ime.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                } else
                    Toast.makeText(this, "nitko nije odabran", Toast.LENGTH_LONG).show();
                break;
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Spinner spin = (Spinner) parent;
        Spinner spin2 = (Spinner) parent;

        if (spin.getId() == R.id.spinnerOdaberiPredmet) {
            String item1 = parent.getItemAtPosition(position).toString();
            listaaa.clear();
            for (int i = 0; i < dodavanjestudenta.list.size(); i++) {
                if (list.get(i).predmet == item1) {
                    listaaa.add(dodavanjestudenta.lista.get(i).toString());
                    aAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, listaaa) {
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
            ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
            ((TextView) parent.getChildAt(0)).setTextSize(16);
            //Toast.makeText(this, "Odabran predmet: " + item1, Toast.LENGTH_SHORT).show();
            if (dodajpredmet.list.isEmpty() || dodajpredmet.lista.isEmpty()) {
                Toast.makeText(this, "NISTA NIJE UNESENO", Toast.LENGTH_SHORT).show();
            } else {
                lista.clear();
                for (int i = 0; i < listaa.size(); i++) {
                    if (listaa.get(i).predmet == item1) {
                        lista.add(listaa.get(i).predavanje);
                        arrayAdapter1.notifyDataSetChanged();
                        ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                        ((TextView) parent.getChildAt(0)).setTextSize(16);
                        //   Toast.makeText(this, "predavanje : " + lista.get(i), Toast.LENGTH_SHORT).show();
                    }
                }


            }
        }
        ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
        ((TextView) parent.getChildAt(0)).setTextSize(16);

        if (spin2.getId() == R.id.spinnerOdaberiPredavanje) {
            String item = parent.getItemAtPosition(position).toString();
            // Toast.makeText(this, "Your choose :" + item, Toast.LENGTH_SHORT).show();
            ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
            ((TextView) parent.getChildAt(0)).setTextSize(16);
        }

    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onNameClick(int position) {

    }
}