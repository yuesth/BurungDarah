package com.yuesth.chatkito;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class recyclerContactAdapter extends RecyclerView.Adapter<recyclerContactAdapter.myViewHolder> {
    View v;
    Context context;
    List<contact_model> list_contact = new ArrayList<>();
    Dialog myDialog;



    public recyclerContactAdapter(Context context, List<contact_model> list_contact) {
        this.context = context;
        this.list_contact = list_contact;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        v = LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false);
        final myViewHolder mViewHoder = new myViewHolder(v);

        //Bagian dialog
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.dialog_contact);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        //contactListener
        mViewHoder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView namaDialog = (TextView) myDialog.findViewById(R.id.nama_dialog);
                TextView nomorDialog = (TextView) myDialog.findViewById(R.id.nomor_dialog);
                ImageView avaDialog = (ImageView) myDialog.findViewById(R.id.ava_dialog);
                namaDialog.setText(list_contact.get(mViewHoder.getAdapterPosition()).getNama_contact());
                nomorDialog.setText(list_contact.get(mViewHoder.getAdapterPosition()).getNomor_contact());
                avaDialog.setImageResource(list_contact.get(mViewHoder.getAdapterPosition()).getImg_contact());
                myDialog.show();
            }
        });

        return mViewHoder;

    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        holder.imageView.setImageResource(list_contact.get(position).getImg_contact());
        holder.textViewNama.setText(list_contact.get(position).getNama_contact());
        holder.textViewNomor.setText(list_contact.get(position).getNomor_contact());
    }

    @Override
    public int getItemCount() {
        return list_contact.size();
    }


    class myViewHolder extends RecyclerView.ViewHolder{
        public myViewHolder(View itemView) {
            super(itemView);
        }

        LinearLayout linearLayout = (LinearLayout) itemView.findViewById(R.id.item_linearlayout);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.circle_image);
        TextView textViewNama = (TextView) itemView.findViewById(R.id.nama_contact);
        TextView textViewNomor = (TextView) itemView.findViewById(R.id.nomor_contact);
    }
}
