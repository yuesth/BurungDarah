package com.yuesth.chatkito;

import android.Manifest;
import android.app.Fragment;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class contactFragment extends android.support.v4.app.Fragment {

    private View view1, view2;
    private List<contact_model> listContact = new ArrayList<>();
    private static final int REQUEST_CALL =1;
    LayoutInflater layoutInflater;

    public contactFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //inisialisasi layout fragment & layout item kontak
        view1 = inflater.inflate(R.layout.fragment_contact, container, false);

        //inisialisasi recycler view & icon call dan nomor kontak
        RecyclerView recyclerViewContact = view1.findViewById(R.id.recycler_contact);

        //inisialisasi adapter
        recyclerContactAdapter rca = new recyclerContactAdapter(getContext(),listContact);
        recyclerViewContact.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewContact.setAdapter(rca);

        return view1;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        listContact.add(new contact_model(R.drawable.ava,"Yues Tadrik","082220825719"));
        listContact.add(new contact_model(R.drawable.ava,"Yues Hafiyan","08153801034"));
        listContact.add(new contact_model(R.drawable.ava,"Tadrik hafiyan","081514303576"));
        listContact.add(new contact_model(R.drawable.ava,"Yues Ganteng","085367773576"));
        listContact.add(new contact_model(R.drawable.ava,"Yues Tadrik","082220825719"));
        listContact.add(new contact_model(R.drawable.ava,"Yues Hafiyan","08153801034"));
        listContact.add(new contact_model(R.drawable.ava,"Tadrik hafiyan","081514303576"));
        listContact.add(new contact_model(R.drawable.ava,"Yues Ganteng","085367773576"));
        listContact.add(new contact_model(R.drawable.ava,"Yues Tadrik","082220825719"));
        listContact.add(new contact_model(R.drawable.ava,"Yues Hafiyan","08153801034"));
        listContact.add(new contact_model(R.drawable.ava,"Tadrik hafiyan","081514303576"));
        listContact.add(new contact_model(R.drawable.ava,"Yues Ganteng","085367773576"));



    }
}
