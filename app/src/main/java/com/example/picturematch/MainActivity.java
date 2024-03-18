package com.example.picturematch;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    public static final String DATABASE_NAME = "mydb";
    SQLiteDatabase mDatabase;
    // EditText editTextName, editTextecole,ediage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // ActionBar().hide();
        getSupportActionBar().hide();


        TextView txt2=(TextView) findViewById(R.id.textView);
        TextView txt1=(TextView) findViewById(R.id.textView2);
        TextView txt3=(TextView) findViewById(R.id.textView3);
        txt1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {



                                        try{

                                            Uri myUri = Uri.parse("android.resource://" + v.getContext().getPackageName() + "/" + R.raw.classicclik);
                                            System.out.println(myUri);
                                            MediaPlayer playerM=new MediaPlayer();
                                            playerM.setDataSource(v.getContext(), myUri);
                                            playerM.prepare();
                                            playerM.setOnPreparedListener(new MediaPlayer.OnPreparedListener(){
                                                @Override
                                                public void onPrepared(MediaPlayer playerM){
                                                    playerM.start();
                                                }
                                            });
                                        }catch(IOException e){
                                            e.printStackTrace();
                                        }

                                        Intent intent = new Intent(getApplicationContext(), loging.class);
                                        startActivity(intent);
                                    }
                                }
        );
        txt2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        try{

                                            Uri myUri = Uri.parse("android.resource://" + v.getContext().getPackageName() + "/" + R.raw.classicclik);
                                            System.out.println(myUri);
                                            MediaPlayer playerM=new MediaPlayer();
                                            playerM.setDataSource(v.getContext(), myUri);
                                            playerM.prepare();
                                            playerM.setOnPreparedListener(new MediaPlayer.OnPreparedListener(){
                                                @Override
                                                public void onPrepared(MediaPlayer playerM){
                                                    playerM.start();
                                                }
                                            });
                                        }catch(IOException e){
                                            e.printStackTrace();
                                        }
                                        Intent intent1 = new Intent(getApplicationContext(), creat.class);
                                        startActivity(intent1);
                                    }
                                }
        );
        txt3.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        try{

                                            Uri myUri = Uri.parse("android.resource://" + v.getContext().getPackageName() + "/" + R.raw.classicclik);
                                            System.out.println(myUri);
                                            MediaPlayer playerM=new MediaPlayer();
                                            playerM.setDataSource(v.getContext(), myUri);
                                            playerM.prepare();
                                            playerM.setOnPreparedListener(new MediaPlayer.OnPreparedListener(){
                                                @Override
                                                public void onPrepared(MediaPlayer playerM){
                                                    playerM.start();
                                                }
                                            });
                                        }catch(IOException e){
                                            e.printStackTrace();
                                        }

                                        Intent intent = new Intent(getApplicationContext(), LevlsGuest.class);
                                        startActivity(intent);
                                    }
                                }
        );

        mDatabase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        CreateJoueurTable();
    }
    private void CreateJoueurTable() {
        mDatabase.execSQL(
                "CREATE TABLE IF NOT EXISTS joueur (\n" +
                        "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                        "    name varchar(200) NOT NULL,\n" +
                        "    prenom varchar(200) NOT NULL,\n" +
                        "    mail varchar(400) NOT NULL,\n" +
                        "    login varchar(400) NOT NULL,\n" +
                        "    password varchar(400) NOT NULL,\n" +
                        "    scor int NOT NULL DEFAULT 0,\n" +
                        "    niveau int NOT NULL DEFAULT 0,\n" +
                        "    theme int NOT NULL DEFAULT 1\n" +
                        ");"
        );
    }


}
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Context;
//import android.content.Intent;
//import android.database.sqlite.SQLiteDatabase;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.TextView;
//
//public class MainActivity extends AppCompatActivity {
//    public static final String DATABASE_NAME = "mydb";
//    SQLiteDatabase mDatabase;
//   // EditText editTextName, editTextecole,ediage;
//
//
//
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        //getActionBar().hide();
//
//
//        TextView txt2=(TextView) findViewById(R.id.textView);
//        TextView txt1=(TextView) findViewById(R.id.textView2);
//        txt1.setOnClickListener(new View.OnClickListener() {
//                                  @Override
//                                  public void onClick(View v) {
//                                      Intent intent = new Intent(MainActivity.this, loging.class);
//                                      startActivity(intent);
//
//                                  }
//                              }
//        );
//        txt2.setOnClickListener(new View.OnClickListener() {
//                                    @Override
//                                    public void onClick(View v) {
//                                        Intent intent1 = new Intent(MainActivity.this, creat.class);
//                                        startActivity(intent1);
//
//                                    }
//                                }
//        );
//
//
//        mDatabase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
//        CreateJoueurTable();
//
//    }
//    private void CreateJoueurTable() {
//
//
//
//        mDatabase.execSQL(
//                "CREATE TABLE IF NOT EXISTS joueur (\n" +
//                        "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
//                        "    name varchar(200) NOT NULL,\n" +
//                        "    prenom varchar(200) NOT NULL,\n" +
//                        "    mail varchar(400) NOT NULL,\n" +
//                        "    login varchar(400) NOT NULL,\n" +
//                        "    password varchar(400) NOT NULL,\n" +
//                        "    scor int NOT NULL DEFAULT 0,\n" +
//                        "    niveau int NOT NULL DEFAULT 0,\n" +
//                        "    theme int NOT NULL DEFAULT 1\n" +
//                        ");"
//        );
//
//    }
//
//
//
//
//
//
//}