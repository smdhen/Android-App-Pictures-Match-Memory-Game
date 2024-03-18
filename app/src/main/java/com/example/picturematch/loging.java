package com.example.picturematch;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class loging extends AppCompatActivity {
    public static final String DATABASE_NAME = "mydb";
    SQLiteDatabase mDatabase;

    EditText editTextLogin,editTextPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loging);


        mDatabase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);

        TextView login=(TextView) findViewById(R.id.login3);
        login.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         Context context=getApplicationContext();

                                         String login = editTextLogin.getText().toString().trim();
                                         String password = editTextPassword.getText().toString();

                                         if (inputsAreCorrect(login,password)) {
                                             Cursor cursorJoueur = mDatabase.rawQuery("SELECT * FROM joueur where login='" + login + "' and password='" + password + "'", null);
                                             if (cursorJoueur.getCount() > 0) {
                                                 if (cursorJoueur.moveToFirst()) {
                                                     @SuppressLint("Range") String x = cursorJoueur.getString(cursorJoueur.getColumnIndex("niveau"));
                                                     @SuppressLint("Range") String x1 = cursorJoueur.getString(cursorJoueur.getColumnIndex("id"));


                                                     Toast.makeText(context, "login successfully", Toast.LENGTH_SHORT).show();
                                                     Intent intent = new Intent(loging.this, Levls.class);
                                                     SharedPreferences preferences = getSharedPreferences("Coordonnées", Context.MODE_PRIVATE);
                                                     SharedPreferences.Editor editor = preferences.edit();
                                                     editor.putString("niveau",x);
                                                     editor.putString("cle",x1);
                                                     editor.commit();
//                                                     intent.putExtra("id", x);
                                                     //                                                   intent.putExtra("cle", x1);
                                                     //Toast.makeText(context, x, Toast.LENGTH_SHORT).show();
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
                                                     startActivity(intent);
                                                     finish();
                                                 }


                                             }
                                             else
                                                 Toast.makeText(context, "login unsuccessfully", Toast.LENGTH_SHORT).show();
                                         }


                                     }
                                 }
        );





        editTextLogin = (EditText) findViewById(R.id.userlogin);
        editTextPassword = (EditText) findViewById(R.id.passwordlogin);

    }

    private boolean inputsAreCorrect(String login,String password) {

        if (login.isEmpty()) {
            editTextLogin.setError("Please enter login");
            Toast.makeText(this, "entery the login", Toast.LENGTH_SHORT).show();
            editTextLogin.requestFocus();
            return false;
        }
        if (password.isEmpty()) {
            editTextPassword.setError("Please enter password");
            Toast.makeText(this, "enter the password ", Toast.LENGTH_SHORT).show();
            editTextPassword.requestFocus();
            return false;
        }


        return true;
    }



}


//import androidx.appcompat.app.AppCompatActivity;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.content.Intent;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//public class loging extends AppCompatActivity {
//    public static final String DATABASE_NAME = "mydb";
//    SQLiteDatabase mDatabase;
//
//    EditText editTextLogin,editTextPassword;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_loging);
//
//
//        mDatabase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
//
//        TextView login=(TextView) findViewById(R.id.login3);
//        login.setOnClickListener(new View.OnClickListener() {
//                                    @Override
//                                    public void onClick(View v) {
//                                        Context context=getApplicationContext();
//
//                                        String login = editTextLogin.getText().toString().trim();
//                                        String password = editTextPassword.getText().toString();
//
//                                        if (inputsAreCorrect(login,password)) {
//                                            Cursor cursorJoueur = mDatabase.rawQuery("SELECT * FROM joueur where login='" + login + "' and password='" + password + "'", null);
//                                            if (cursorJoueur.getCount() > 0) {
//                                                if (cursorJoueur.moveToFirst()) {
//                                                    @SuppressLint("Range") String x = cursorJoueur.getString(cursorJoueur.getColumnIndex("niveau"));
//                                                    @SuppressLint("Range") String x1 = cursorJoueur.getString(cursorJoueur.getColumnIndex("id"));
//
//
//                                                    Toast.makeText(context, "login successfully", Toast.LENGTH_SHORT).show();
//                                                    Intent intent = new Intent(loging.this, Levls.class);
//                                                    intent.putExtra("id", x);
//                                                    intent.putExtra("cle", x1);
//                                                    //Toast.makeText(context, x, Toast.LENGTH_SHORT).show();
//                                                    startActivity(intent);
//                                                }
//
//
//                                            }
//                                            else
//                                                Toast.makeText(context, "login unsuccessfully", Toast.LENGTH_SHORT).show();
//                                        }
//
//
//                                    }
//                                }
//        );
//
//
//
//
//
//
//
//
//
//
//
//
//        editTextLogin = (EditText) findViewById(R.id.userlogin);
//        editTextPassword = (EditText) findViewById(R.id.passwordlogin);
//
//    }
//
//    private boolean inputsAreCorrect(String login,String password) {
//
//        if (login.isEmpty()) {
//            editTextLogin.setError("Please enter login");
//            Toast.makeText(this, "entery the login", Toast.LENGTH_SHORT).show();
//            editTextLogin.requestFocus();
//            return false;
//        }
//        if (password.isEmpty()) {
//            editTextPassword.setError("Please enter password");
//            Toast.makeText(this, "enter the password ", Toast.LENGTH_SHORT).show();
//            editTextPassword.requestFocus();
//            return false;
//        }
//
//
//        return true;
//    }
//
//
//
//}