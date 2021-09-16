package com.example.orwmaprojekt1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class studentirecycler extends AppCompatActivity implements NameClickListener, AdapterView.OnItemSelectedListener {

    static ArrayList<student> listItems = new ArrayList<student>();
    public RecyclerAdapter1 adapter;
    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studentirecycler);
        recycler = findViewById(R.id.recyclerView1);
        recycler.setHasFixedSize(true);
        adapter = new RecyclerAdapter1(this);
        setupRecycler();
        setupRecyclerData();
    }

    private void setupRecyclerData() {
        adapter.addData(listItems);
    }

    private void setupRecycler() {
        recycler = findViewById(R.id.recyclerView1);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerAdapter1(this);
        recycler.setAdapter(adapter);
    }

    public void addCell(View view) {

    }

    public void removeCell(View view) {
        adapter.removeCell(0);
    }


    @Override
    public void onNameClick(int position) {
        Toast.makeText(this, "ID je : " + adapter.getItemId(position) + "positione je : " + position, Toast.LENGTH_SHORT).show();
        int i = position;
    }


    public void onClick(View v) {


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), item, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}




