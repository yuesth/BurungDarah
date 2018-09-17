package com.yuesth.chatkito;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class recyclerExploreAdapter extends RecyclerView.Adapter<recyclerExploreAdapter.myViewHolder> {
    View v;
    Context context;
    List<explore_model> list_contact = new ArrayList<>();

    public recyclerExploreAdapter(Context context, List<explore_model> list_contact) {
        this.v = v;
        this.context = context;
        this.list_contact = list_contact;
    }

    @Override
    public recyclerExploreAdapter.myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        v = LayoutInflater.from(context).inflate(R.layout.item_explore,parent,false);
        final myViewHolder mvHolder = new myViewHolder(v);
        return mvHolder;
    }

    @Override
    public void onBindViewHolder(recyclerExploreAdapter.myViewHolder holder, int position) {
        holder.posterExplore.setImageResource(list_contact.get(position).getPoster());
        holder.judulExplore.setText(list_contact.get(position).getJudul());
        holder.tanggalExplore.setText(list_contact.get(position).getTanggal());
        holder.waktuExplore.setText(list_contact.get(position).getWaktu());
        holder.tempatExplore.setText(list_contact.get(position).getTempat());
        holder.kontenExplore.setText(list_contact.get(position).getKonten());
    }

    @Override
    public int getItemCount() {
        return list_contact.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        public myViewHolder(View itemView) {
            super(itemView);
        }

        CardView cardViewExplore = itemView.findViewById(R.id.cardview_explore);
        ImageView posterExplore = itemView.findViewById(R.id.poster_explore);
        TextView judulExplore = itemView.findViewById(R.id.judul_explore);
        TextView tanggalExplore = itemView.findViewById(R.id.tanggal_explore);
        TextView waktuExplore = itemView.findViewById(R.id.waktu_explore);
        TextView tempatExplore = itemView.findViewById(R.id.tempat_explore);
        TextView kontenExplore = itemView.findViewById(R.id.konten_explore);
    }
}
