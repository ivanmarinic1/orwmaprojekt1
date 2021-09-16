package com.example.orwmaprojekt1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter1 extends RecyclerView.Adapter<StudentiViewHolder> {

    private List<student> dataList = new ArrayList<student>();
    private NameClickListener clickListener;

    public RecyclerAdapter1(NameClickListener listener) {
        this.clickListener = listener;
    }

    @NonNull
    @Override
    public StudentiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cellView = LayoutInflater.from(parent.getContext()).inflate(R.layout.studenti_name, parent, false);
        return new StudentiViewHolder(cellView, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentiViewHolder studentiViewHolder, int position) {
        studentiViewHolder.setStudent(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void addData(List<student> data) {
        this.dataList.clear();
        this.dataList.addAll(data);
        notifyDataSetChanged();
    }

    public void addNewCell(String name) {
        // dataList.add(name);
        notifyItemInserted(dataList.size());
    }

    public void removeCell(int position) {
        if (dataList.size() > position) {
            dataList.remove(position);
            notifyItemRemoved(position);
        }
    }
}