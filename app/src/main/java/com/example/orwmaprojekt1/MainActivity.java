package com.example.orwmaprojekt1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvDobrodosli, tvBiljezenje;
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDobrodosli = (TextView) findViewById(R.id.textW1);
        tvBiljezenje = (TextView) findViewById(R.id.textW2);
        btnStart = (Button) findViewById(R.id.buttonStart);
        btnStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, login.class));
        finish();
    }
}