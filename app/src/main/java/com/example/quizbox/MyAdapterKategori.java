package com.example.quizbox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MyAdapterKategori extends ArrayAdapter<Kategori> {

    Context context1;
    List<Kategori> arrayListKategori;



    public MyAdapterKategori(@NonNull Context context, List<Kategori> arrayListKategori) {
        super(context, R.layout.custom_list_item, arrayListKategori);

        this.context1 = context;
        this.arrayListKategori = arrayListKategori;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item, null, true);
        TextView tvID = view.findViewById(R.id.txt_id_kategori);
        TextView tvKategori = view.findViewById(R.id.txt_kategori);

        tvID.setText(arrayListKategori.get(position).getId_kategori());
        tvKategori.setText(arrayListKategori.get(position).getKategori());

        return view;
    }
}
