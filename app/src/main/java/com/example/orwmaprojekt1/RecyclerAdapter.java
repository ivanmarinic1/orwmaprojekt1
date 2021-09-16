package com.example.orwmaprojekt1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<PredmetViewHolder> {

    private List<String> dataList = new ArrayList<>();
    private NameClickListener clickListener;

    public RecyclerAdapter(NameClickListener listener) {
        this.clickListener = listener;
    }

    @NonNull
    @Override
    public PredmetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cellView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_name, parent, false);
        return new PredmetViewHolder(cellView, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PredmetViewHolder predmetViewHolder, int position) {
        predmetViewHolder.setName(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void addData(List<String> data) {
        this.dataList.clear();
        this.dataList.addAll(data);
        notifyDataSetChanged();
    }

    public void addNewCell(String name) {
        dataList.add(name);
        notifyItemInserted(dataList.size());
    }

    public void removeCell(int position) {
        if (dataList.size() > position) {
            dataList.remove(position);
            notifyItemRemoved(position);
        }
    }

}