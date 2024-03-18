package com.example.picturematch;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class creat extends AppCompatActivity {
    public static final String DATABASE_NAME = "mydb";
    SQLiteDatabase mDatabase;

    EditText editTextName,editTextName2, editTextMail,editTextLogin,editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat);
        mDatabase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);



        TextView Creat=(TextView) findViewById(R.id.creataccount);
        Creat.setOnClickListener(new View.OnClickListener() {
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


                                             mDatabase.execSQL("INSERT INTO joueur \n" +
                                                     "(name, prenom,mail,login,password)\n" +
                                                     "VALUES \n" +
                                                     "(?, ?, ?,?,?);", new String[]{name, name2, mail,login,password});
                                             mDatabase.close();

                                             Toast.makeText(context, "The Account created successfully", Toast.LENGTH_SHORT).show();



                                             Intent intent = new Intent(creat.this, loging.class);
                                             Toast.makeText(context, "Get started with your account", Toast.LENGTH_SHORT).show();
                                             startActivity(intent);

                                         }


                                     }

                                 }
        );


        editTextName = (EditText) findViewById(R.id.name);
        editTextName2 = (EditText) findViewById(R.id.name1);
        editTextMail = (EditText) findViewById(R.id.email);
        editTextLogin = (EditText) findViewById(R.id.login);
        editTextPassword = (EditText) findViewById(R.id.password);
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




















//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Context;
//import android.content.Intent;
//import android.database.sqlite.SQLiteDatabase;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//public class creat extends AppCompatActivity {
//    public static final String DATABASE_NAME = "mydb";
//    SQLiteDatabase mDatabase;
//
//    EditText editTextName,editTextName2, editTextMail,editTextLogin,editTextPassword;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_creat);
//        mDatabase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
//
//
//
//        TextView Creat=(TextView) findViewById(R.id.creataccount);
//        Creat.setOnClickListener(new View.OnClickListener() {
//                                     @Override
//                                     public void onClick(View v) {
//                                         Context context=getApplicationContext();
//
//                                         String name = editTextName.getText().toString().trim();
//                                         String name2 = editTextName2.getText().toString().trim();
//                                         String mail = editTextMail.getText().toString().trim();
//                                         String login = editTextLogin.getText().toString().trim();
//                                         String password = editTextPassword.getText().toString();
//                                         //Toast.makeText(context, "yessssssssss", Toast.LENGTH_SHORT).show();
//
//                                         if (inputsAreCorrect(name, name2,mail,login,password)) {
//
//
//                                             mDatabase.execSQL("INSERT INTO joueur \n" +
//                                                     "(name, prenom,mail,login,password)\n" +
//                                                     "VALUES \n" +
//                                                     "(?, ?, ?,?,?);", new String[]{name, name2, mail,login,password});
//                                             mDatabase.close();
//
//                                            Toast.makeText(context, "The Account created successfully", Toast.LENGTH_SHORT).show();
//
//
//
//                                             Intent intent = new Intent(creat.this, loging.class);
//                                             Toast.makeText(context, "Get started with your account", Toast.LENGTH_SHORT).show();
//                                             startActivity(intent);
//
//                                         }
//
//
//                                     }
//
//        }
//        );
//
//
//                editTextName = (EditText) findViewById(R.id.name);
//        editTextName2 = (EditText) findViewById(R.id.name1);
//        editTextMail = (EditText) findViewById(R.id.email);
//        editTextLogin = (EditText) findViewById(R.id.login);
//        editTextPassword = (EditText) findViewById(R.id.password);
//    }
//
//
//    private boolean inputsAreCorrect(String name, String name1,String mail,String login,String password) {
//        if (name.isEmpty()) {
//            editTextName.setError("Please enter a name");
//            editTextName.requestFocus();
//            return false;
//        }
//        if (name1.isEmpty()) {
//            editTextName2.setError("Please enter prenom");
//            editTextName2.requestFocus();
//            return false;
//        }
//        if (mail.isEmpty()) {
//            editTextMail.setError("Please enter mail");
//            editTextMail.requestFocus();
//            return false;
//        }
//        if (login.isEmpty()) {
//            editTextLogin.setError("Please enter login");
//            editTextLogin.requestFocus();
//            return false;
//        }
//        if (password.isEmpty()) {
//            editTextPassword.setError("Please enter password");
//            editTextPassword.requestFocus();
//            return false;
//        }
//
//
//        return true;
//    }
//}