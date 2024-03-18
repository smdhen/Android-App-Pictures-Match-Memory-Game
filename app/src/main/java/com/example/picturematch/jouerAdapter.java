package com.example.picturematch;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class jouerAdapter extends ArrayAdapter<JouerScors> {
    Context mCtx;
    int listLayoutRes;
    List<JouerScors> jouersList;
    SQLiteDatabase mDatabase;

    public jouerAdapter(Context mCtx, int listLayoutRes, List<JouerScors> jouersList) {
        super(mCtx, listLayoutRes, jouersList);

        this.mCtx = mCtx;
        this.listLayoutRes = listLayoutRes;
        this.jouersList = jouersList;
        this.mDatabase = mDatabase;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(listLayoutRes, null);

        //getting employee of the specified position
        JouerScors jouers = jouersList.get(position);


        //getting views
        //TextView textViewId = view.findViewById(R.id.textViewid);
        TextView textViewName = view.findViewById(R.id.inn1);
        TextView textViewprenom = view.findViewById(R.id.inn2);
        TextView textViewSc = view.findViewById(R.id.inn3);
        TextView textViewnv = view.findViewById(R.id.inn4);

        //adding data to views
        //textViewId.setText(etudiens.getId());
        textViewName.setText(jouers.getName());
        //Toast.makeText(mCtx, "111111111111111111111111111111111111111111111", Toast.LENGTH_SHORT).show();
        textViewprenom.setText(jouers.getPrenom());
        textViewSc.setText(String.valueOf(jouers.getScor()));
        textViewnv.setText(String.valueOf(jouers.getNiveau()));
        return view;

    }








}
