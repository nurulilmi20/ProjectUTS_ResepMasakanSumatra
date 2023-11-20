package com.example.projectuts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {
    private ArrayList<Resep> reseps;
    private Context context;

    public Adapter(ArrayList<Resep> reseps, Context context) {
        this.reseps = reseps;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_resep,parent,false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.Holder holder, int position) {
        Resep resep = reseps.get(position);
        holder.judul.setText(resep.getJudul());
        holder.img.setImageResource(resep.getImg());

        holder.btnDetail.setOnClickListener(view -> {
            Intent i = new Intent(context,DetailResep.class);
            i.putExtra("Resep", resep);
            context.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return reseps.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        public TextView judul;
        public ImageView img;
        public Button btnDetail;
        public Holder(@NonNull View itemView) {
            super(itemView);

            judul = itemView.findViewById(R.id.judul);
            img = itemView.findViewById(R.id.imgresep);
            btnDetail = itemView.findViewById(R.id.detail);

        }
    }
}
