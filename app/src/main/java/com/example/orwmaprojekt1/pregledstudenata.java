package com.example.orwmaprojekt1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import static com.example.orwmaprojekt1.dodavanjestudenta.list;

public class pregledstudenata extends AppCompatActivity implements NameClickListener, AdapterView.OnItemSelectedListener, View.OnClickListener {
    static ArrayList<String> lista = new ArrayList<String>();
    TextView tvPregled, tvPredmet, tvStudenti, eStudent;
    Button btnBack;
    ListView lvStudenti;
    EditText etPrezime, etBroj;
    ArrayList<student> listaa = new ArrayList<student>();
    Spinner spin;
    private ArrayAdapter aAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pregledstudenata);
        tvPregled = (TextView) findViewById(R.id.textW6);
        tvPredmet = (TextView) findViewById(R.id.textW7);
        tvStudenti = (TextView) findViewById(R.id.textW8);

        btnBack = (Button) findViewById(R.id.btnBack);
        lvStudenti = (ListView) findViewById(R.id.listView1);
        spin = (Spinner) findViewById(R.id.spinnerPredmeti);
        btnBack.setOnClickListener(this);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(pregledstudenata.this, android.R.layout.simple_spinner_item, dodavanjestudenta.listItems);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(arrayAdapter);
        spin.setOnItemSelectedListener(this);
        lvStudenti = (ListView) findViewById(R.id.listView);
        // aAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dodavanjestudenta.lista) {
        //    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the Item from ListView
        //        View view = super.getView(position, convertView, parent);

        // Initialize a TextView for ListView each Item
        //       TextView tv = (TextView) view.findViewById(android.R.id.text1);

        // Set the text color of TextView (ListView Item)
        //      tv.setTextColor(Color.WHITE);
        //     tv.setTextSize(16);

        // Generate ListView Item using TextView
        //     return view;
        //   }
        //};
        lvStudenti.setAdapter(aAdapter);


    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, pocetna.class));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        lista.clear();
        for (int i = 0; i < dodavanjestudenta.list.size(); i++) {
            if (list.get(i).predmet == item) {
                lista.add(dodavanjestudenta.lista.get(i).toString());
                aAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lista) {
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
        lvStudenti.setAdapter(aAdapter);
        Toast.makeText(parent.getContext(), item, Toast.LENGTH_SHORT).show();
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
