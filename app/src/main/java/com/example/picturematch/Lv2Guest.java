package com.example.picturematch;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Lv2Guest extends AppCompatActivity {

    ImageView imageView=null;
    private int cuerentPair=0;
    int [] drawanle = new int[]{R.drawable.tree1, R.drawable.dog2,R.drawable.cat3};
    ArrayList<Integer> pos = new  ArrayList<Integer>(Arrays.asList(0,1,2,0,1,2));
    int cuerentpos =-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        new CountDownTimer(20000, 1000) {


            public void onTick(long millisUntilFinished) {
                TextView txt111 = (TextView) findViewById(R.id.mTextField1);
                txt111.setText(""+millisUntilFinished / 1000);
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                TextView txt111 = (TextView) findViewById(R.id.mTextField1);
               // if(txt111!=null) // darori hit gbila b9it kantester, mlli kansali niveau 9bl matsali lw9t kaytra mochkil, dakchi 3lach darori tdir hadi
                    txt111.setText("done!");
                finish();
                //this.finishAffinity();
                //System.exit(0);
            }

        }.start();
        super.onCreate(savedInstanceState);


        Collections.shuffle(pos);
        setContentView(R.layout.activity_lv2_guest);

        GridView gridView=(GridView) findViewById(R.id.grlv2);
        imdAdapter imdAdapter=new imdAdapter(this,drawanle);
        gridView.setAdapter(imdAdapter);
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
                                                        if(cuerentPair==3){
                                                            Toast.makeText(getApplicationContext(),"you win\n you can move to the  level 3", Toast.LENGTH_SHORT).show();
                                                            Intent i = new Intent(getApplicationContext(), LevlsGuest.class);
                                                            finish();
                                                            startActivity(i);
                                                            finish();

                                                        }

                                                    }

                                                    cuerentpos=-1;

                                                }

                                            }
                                        }

        );
    }

}