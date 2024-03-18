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

public class modifyProfile extends AppCompatActivity {
    String niveau, cle;
    public static final String DATABASE_NAME = "mydb";
    SQLiteDatabase mDatabase;

    EditText editTextName,editTextName2, editTextMail,editTextLogin,editTextPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_profile);


        SharedPreferences preferences = getSharedPreferences("Coordonnées", Context.MODE_PRIVATE);
        //niveau = preferences.getString("niveau","niveau Khawii");
        cle = preferences.getString("cle","Cle Khawya");

        mDatabase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        Cursor cursorJoueur = mDatabase.rawQuery("SELECT * FROM joueur where id = "+Integer.parseInt(cle)+" ;", null);
        if (cursorJoueur.moveToFirst()) {
            @SuppressLint("Range") String oldScorename = cursorJoueur.getString(cursorJoueur.getColumnIndex("name"));
            @SuppressLint("Range") String oldScoreprenom = cursorJoueur.getString(cursorJoueur.getColumnIndex("prenom"));
            @SuppressLint("Range") String oldScoremail = cursorJoueur.getString(cursorJoueur.getColumnIndex("mail"));
            @SuppressLint("Range") String oldScorelogin = cursorJoueur.getString(cursorJoueur.getColumnIndex("login"));
            @SuppressLint("Range") String oldScorepassword = cursorJoueur.getString(cursorJoueur.getColumnIndex("password"));


        editTextName = (EditText) findViewById(R.id.nam);
        editTextName2 = (EditText) findViewById(R.id.nam1);
        editTextMail = (EditText) findViewById(R.id.email1);
        editTextLogin = (EditText) findViewById(R.id.login1);
        editTextPassword = (EditText) findViewById(R.id.password1);

            editTextName.setText(oldScorename);
            editTextName2.setText(oldScoreprenom);
            editTextMail.setText(oldScoremail);
            editTextLogin.setText(oldScorelogin);
            editTextPassword.setText(oldScorepassword);
            mDatabase.close();
    }
        TextView modify=(TextView) findViewById(R.id.modifjy);
        modify.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         Context context=getApplicationContext();

                                         String name = editTextName.getText().toString().trim();
                                         String name2 = editTextName2.getText().toString().trim();
                                         String mail = editTextMail.getText().toString().trim();
                                         String login = editTextLogin.getText().toString().trim();
                                         String password = editTextPassword.getText().toString();
                                         //Toast.makeText(context, "yessssssssss", Toast.LENGTH_SHORT).show();

                                         if (inputsAreCorrect(name, name2,mail,login,password)) {
                                             Toast.makeText(context, mail, Toast.LENGTH_SHORT).show();
                                             Toast.makeText(context,login , Toast.LENGTH_SHORT).show();
                                             Toast.makeText(context, password, Toast.LENGTH_SHORT).show();

//
//                                             mDatabase.execSQL("INSERT INTO joueur \n" +
//                                                     "(name, prenom,mail,login,password)\n" +
//                                                     "VALUES \n" +
//                                                     "(?, ?, ?,?,?);", new String[]{name, name2, mail,login,password});
                                             mDatabase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);

                                             mDatabase.execSQL("UPDATE joueur SET name = '"+name+"', prenom ='"+name2+"' , mail = '"+mail+"' , login = '"+login+"',password = '"+password+"' WHERE id="+Integer.parseInt(cle)+" ;");


                                             mDatabase.close();

                                             Toast.makeText(context, "modifyed successfully", Toast.LENGTH_SHORT).show();



                                             Intent intent = new Intent(modifyProfile.this, Levls.class);
                                            // Toast.makeText(context, "Get started with your account", Toast.LENGTH_SHORT).show();
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

                                         }


                                     }

                                 }
        );








    }

    private boolean inputsAreCorrect(String name, String name1,String mail,String login,String password) {
        if (name.isEmpty()) {
            editTextName.setError("Please enter a name");
            editTextName.requestFocus();
            return false;
        }
        if (name1.isEmpty()) {
            editTextName2.setError("Please enter prenom");
            editTextName2.requestFocus();
            return false;
        }
        if (mail.isEmpty()) {
            editTextMail.setError("Please enter mail");
            editTextMail.requestFocus();
            return false;
        }
        if (login.isEmpty()) {
            editTextLogin.setError("Please enter login");
            editTextLogin.requestFocus();
            return false;
        }
        if (password.isEmpty()) {
            editTextPassword.setError("Please enter password");
            editTextPassword.requestFocus();
            return false;
        }


        return true;
    }

}