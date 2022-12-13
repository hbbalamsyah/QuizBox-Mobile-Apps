package com.example.quizbox;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.List;

public class MyAdapter extends ArrayAdapter<Soal> {

    Context context;
    List<Soal> arrayListSoal;

    public MyAdapter(@NonNull Context context, List<Soal> arrayListSoal) {
        super(context, R.layout.custom_list_item1, arrayListSoal);

        this.context = context;
        this.arrayListSoal = arrayListSoal;
    }
}
