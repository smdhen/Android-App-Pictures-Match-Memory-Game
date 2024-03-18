package com.example.picturematch;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Scor extends AppCompatActivity {
    List<JouerScors> JouerList;
    SQLiteDatabase mDatabase;
    ListView listViewJou;
    jouerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scor);


        listViewJou = (ListView) findViewById(R.id.listViewJouers);
        JouerList = new ArrayList<>();

        //opening the database
        mDatabase = openOrCreateDatabase(MainActivity.DATABASE_NAME, MODE_PRIVATE, null);

        //this method will display the employees in the list
        showEmployeesFromDatabase();
    }

    private void showEmployeesFromDatabase() {
        //Toast.makeText(getApplicationContext(), "yessssssssss", Toast.LENGTH_SHORT).show();


        //we used rawQuery(sql, selectionargs) for fetching all the employees
        Cursor cursorEtudiens = mDatabase.rawQuery("SELECT * FROM joueur where scor>0  ORDER BY niveau desc ,scor  ", null);

        //if the cursor has some data
        if (cursorEtudiens.moveToFirst()) {
            //looping through all the records
            do {
                //pushing each record in the employee list
                JouerList.add(new JouerScors(
                        cursorEtudiens.getString(7),
                        cursorEtudiens.getString(1),
                        cursorEtudiens.getString(2),

                        cursorEtudiens.getString(6)

                ));
//                Toast.makeText(getApplicationContext(), cursorEtudiens.getString(1), Toast.LENGTH_SHORT).show();
//                Toast.makeText(getApplicationContext(), cursorEtudiens.getString(2), Toast.LENGTH_SHORT).show();
//                Toast.makeText(getApplicationContext(), cursorEtudiens.getString(6), Toast.LENGTH_SHORT).show();
//                Toast.makeText(getApplicationContext(), cursorEtudiens.getString(0), Toast.LENGTH_SHORT).show();
//                Toast.makeText(getApplicationContext(), cursorEtudiens.getString(3), Toast.LENGTH_SHORT).show();
//                Toast.makeText(getApplicationContext(), cursorEtudiens.getString(4), Toast.LENGTH_SHORT).show();
//                Toast.makeText(getApplicationContext(), cursorEtudiens.getString(5), Toast.LENGTH_SHORT).show();
               // Toast.makeText(getApplicationContext(), cursorEtudiens.getString(7), Toast.LENGTH_SHORT).show();
            } while (cursorEtudiens.moveToNext());
        }
        //closing the cursor
        cursorEtudiens.close();

        //creating the adapter object
       // Toast.makeText(getApplicationContext(), "cursorEtudiens.getString(1)", Toast.LENGTH_SHORT).show();
        adapter = new jouerAdapter(this, R.layout.lyscors, JouerList);

        //adding the adapter to listview
        //Toast.makeText(getApplicationContext(), "cursorEtkj;asCh;kjhkc;vJ;VUNHFH;bfoSudiens.getString(1)", Toast.LENGTH_SHORT).show();
        listViewJou.setAdapter(adapter);


    }
}