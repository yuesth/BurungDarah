package com.yuesth.chatkito;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class exploreFragment extends android.support.v4.app.Fragment {
    private View view;
    private List<explore_model> listContact = new ArrayList<>();

    public exploreFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_explore, container, false);

        //inisialisasi recycler view & icon call dan nomor kontak
        RecyclerView recyclerViewExplore = view.findViewById(R.id.recycler_explore);

        //inisialisasi adapter
        recyclerExploreAdapter rca = new recyclerExploreAdapter(getContext(),listContact);
        recyclerViewExplore.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewExplore.setAdapter(rca);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listContact.add(new explore_model(R.drawable.dondar1,"Donor darah bersama Paguyuban KSE UI","Senin, 9 Desember 2013"
        ,"11.00 - 14.00 WIB","Aula selatan Masjid Ukhwah Islamiyah UI Depok",R.string.loremIpsum));
        listContact.add(new explore_model(R.drawable.dondar2,"Donor darah INTERIO bersama PMI","Sabtu, 30 Januari 2016"
                ,"09.00 - 12.00 WIB","INTERIO Cengkareng",R.string.loremIpsum));
        listContact.add(new explore_model(R.drawable.dondar3,"Donor darah Mayestik","Selasa, 3 Mei 2016"
                ,"09.00 - 12.00 WIB","Gedung pasar Mayestik",R.string.loremIpsum));
        listContact.add(new explore_model(R.drawable.dondar1,"Donor darah bersama Paguyuban KSE UI","Senin, 9 Desember 2013"
                ,"11.00 - 14.00 WIB","Aula selatan Masjid Ukhwah Islamiyah UI Depok",R.string.loremIpsum));
        listContact.add(new explore_model(R.drawable.dondar2,"Donor darah INTERIO bersama PMI","Sabtu, 30 Januari 2016"
                ,"09.00 - 12.00 WIB","INTERIO Cengkareng",R.string.loremIpsum));
        listContact.add(new explore_model(R.drawable.dondar3,"Donor darah Mayestik","Selasa, 3 Mei 2016"
                ,"09.00 - 12.00 WIB","Gedung pasar Mayestik",R.string.loremIpsum));
    }
}
