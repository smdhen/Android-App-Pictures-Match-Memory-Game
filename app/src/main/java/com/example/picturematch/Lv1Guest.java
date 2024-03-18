package com.example.picturematch;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Lv1Guest extends AppCompatActivity {
    public static final String DATABASE_NAME = "mydb";

    SQLiteDatabase mDatabase;
    ImageView imageView=null;
    private int cuerentPair=0;
    int [] drawanle = new int[]{R.drawable.tree1, R.drawable.dog2};
    ArrayList<Integer> pos = new  ArrayList<Integer>(Arrays.asList(0,1,0,1));
    int cuerentpos =-1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        new CountDownTimer(10000, 1000) {


            public void onTick(long millisUntilFinished) {
                TextView txt111 = (TextView) findViewById(R.id.mTextField1);
                txt111.setText(""+millisUntilFinished / 1000);
                //here you can have your logic to set text to edittext
            }
            public void onFinish() {
               // if(txt111!=null) // darori hit gbila b9it kantester, mlli kansali niveau 9bl matsali lw9t kaytra mochkil, dakchi 3lach darori tdir hadi
                TextView txt111 = (TextView) findViewById(R.id.mTextField1);

                txt111.setText("done!");
                finish();
               // this.finishAffinity();
                //System.exit(0);
            }

        }.start();
        super.onCreate(savedInstanceState);


        Collections.shuffle(pos);
        setContentView(R.layout.activity_lv1_guest);

        GridView gridView=(GridView) findViewById(R.id.grlv1);
        imdAdapter imdAdapter=new imdAdapter(this,drawanle);

        gridView.setAdapter(imdAdapter);
        mDatabase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (cuerentpos<0){
                    cuerentpos=position;
                    imageView=(ImageView)view;
                    ((ImageView)view).setImageResource(drawanle[pos.get(position)]);
                }

                else{
                    if(cuerentpos==position){

                        ((ImageView)view).setImageResource(R.drawable.im0);
                    }
                    else if(pos.get(cuerentpos)!=pos.get(position)){
                        imageView.setImageResource(R.drawable.im0);
                        Toast.makeText(getApplicationContext(),"not match", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        ((ImageView)view).setImageResource(drawanle[pos.get(position)]);
                        cuerentPair++;
                        if(cuerentPair==2){
                            Toast.makeText(getApplicationContext(),"you win\n you can move to the  level 2", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getApplicationContext(), LevlsGuest.class);
                            finish();
                            startActivity(i);
                            finish();
                        }
                    }

                    cuerentpos=-1;

                }
            }
        });
    }


}