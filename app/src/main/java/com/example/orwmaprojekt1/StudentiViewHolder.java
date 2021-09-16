package com.example.orwmaprojekt1;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentiViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView eStudent;
    private NameClickListener clickListener;

    public StudentiViewHolder(@NonNull View itemView, NameClickListener clickListener) {
        super(itemView);
        eStudent = itemView.findViewById(R.id.tvName1);
        this.clickListener = clickListener;
        itemView.setOnClickListener(this);
    }


    public void setStudent(student student) {
        eStudent.setText(student.ime + " " + student.prezime);
    }

    @Override
    public void onClick(View v) {
        clickListener.onNameClick(getAdapterPosition());
    }
}

