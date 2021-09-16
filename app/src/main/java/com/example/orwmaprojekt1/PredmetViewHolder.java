package com.example.orwmaprojekt1;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PredmetViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView tvName;
    private NameClickListener clickListener;
    private Button btnDodaj;

    public PredmetViewHolder(@NonNull View itemView, NameClickListener clickListener) {
        super(itemView);

        tvName = itemView.findViewById(R.id.tvName);
        btnDodaj = itemView.findViewById(R.id.btnDodaj2);
        itemView.setOnClickListener(this);
        this.clickListener = clickListener;
        itemView.setOnClickListener(this);


    }

    public void setName(String name) {
        tvName.setText(name);
    }

    @Override
    public void onClick(View v) {
        clickListener.onNameClick(getAdapterPosition());
    }
}

