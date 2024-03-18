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
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Lv4 extends AppCompatActivity {
    public static final String DATABASE_NAME = "mydb";

    SQLiteDatabase mDatabase;
    ImageView imageView=null;
    private int cuerentPair=0;
    int [] drawanle;
    ArrayList<Integer> pos = new  ArrayList<Integer>(Arrays.asList(0,1,2,3,4,0,1,2,3,4));
    int cuerentpos =-1;
    ArrayList<Integer> posDeja = new ArrayList();
    long start, end;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        new CountDownTimer(35000, 1000) {


            public void onTick(long millisUntilFinished) {
                TextView txt111 = (TextView) findViewById(R.id.mTextField1);
                txt111.setText(""+millisUntilFinished / 1000);
                //here you can have your logic to set text to edittext
            }
         //   TextView txt111 = (TextView) findViewById(R.id.mTextField1);
            public void onFinish() {
               // if(txt111!=null) // darori hit gbila b9it kantester, mlli kansali niveau 9bl matsali lw9t kaytra mochkil, dakchi 3lach darori tdir hadi
                TextView txt111 = (TextView) findViewById(R.id.mTextField1);
                txt111.setText("done!");
                finish();
                //this.finishAffinity();
                //System.exit(0);
            }

        }.start();
        super.onCreate(savedInstanceState);

        SharedPreferences preferences = getSharedPreferences("theme", Context.MODE_PRIVATE);
        String choix = preferences.getString("ChoixImages","melanger");

        SharedPreferences preferences2 = getSharedPreferences("Coordonnées", Context.MODE_PRIVATE);
        String cle = preferences2.getString("cle","");

        switch(choix)
        {
            case "Birds":
                drawanle = new int[]{R.drawable.bird1, R.drawable.bird2, R.drawable.bird3,R.drawable.bird4,R.drawable.bird5} ;
                break;
            case "Cats":
                drawanle = new int[]{R.drawable.cat1, R.drawable.cat2, R.drawable.cat3, R.drawable.cat4, R.drawable.cat5} ;
                break;
            case "Dogs":
                drawanle = new int[]{R.drawable.dog1, R.drawable.dog2,R.drawable.dog3, R.drawable.dog4, R.drawable.dog5} ;
                break;
            case "Trees":
                drawanle = new int[]{R.drawable.tree1, R.drawable.tree2,R.drawable.tree3, R.drawable.tree4, R.drawable.tree5} ;
                break;
            default:
                drawanle = new int[]{R.drawable.tree1, R.drawable.dog2,R.drawable.cat3, R.drawable.bird4, R.drawable.im1};
                break;
        }

        start = System.currentTimeMillis();
        Collections.shuffle(pos);
        setContentView(R.layout.activity_lv4);
        GridView gridView=(GridView) findViewById(R.id.grlv4);
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
                                                        try{

                                                            Uri myUri = Uri.parse("android.resource://" + view.getContext().getPackageName() + "/" + R.raw.clickerror);
                                                            System.out.println(myUri);
                                                            MediaPlayer playerM=new MediaPlayer();
                                                            playerM.setDataSource(view.getContext(), myUri);
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
                                                        Toast.makeText(getApplicationContext(),"not match", Toast.LENGTH_SHORT).show();
                                                    }
                                                    else
                                                    {
                                                        ((ImageView)view).setImageResource(drawanle[pos.get(position)]);
//                                                        posDeja.add(drawanle[pos.get(position)]);
//                                                        if(Collections.frequency(posDeja,drawanle[pos.get(position)])<1)
                                                        cuerentPair++;
                                                        if(cuerentPair==5){
                                                            // Intent intent = getIntent();
                                                            // String str4 = intent.getStringExtra("idd");
                                                            mDatabase.execSQL("UPDATE joueur SET niveau =4 WHERE id= "+Integer.parseInt(cle)+" ; ");
                                                            mDatabase.close();
                                                            /*  */
                                                            //Toast.makeText(getApplicationContext(), "updating", Toast.LENGTH_SHORT).show();
                                                            Toast.makeText(getApplicationContext(),"you win\n you can move to the  level 4", Toast.LENGTH_SHORT).show();
                                                            Intent i = new Intent(getApplicationContext(), Levls.class);
                                                            i.putExtra("passToLevel5",true);
                                                            i.putExtra("idd",cle);
                                                            end = System.currentTimeMillis();
                                                            mDatabase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
                                                            Cursor cursorJoueur = mDatabase.rawQuery("SELECT * FROM joueur where id = "+Integer.parseInt(cle)+" ;", null);
                                                            if (cursorJoueur.moveToFirst()) {
                                                                @SuppressLint("Range") int oldScore = cursorJoueur.getInt(cursorJoueur.getColumnIndex("scor"));
                                                                mDatabase.execSQL("UPDATE joueur SET scor = " + (oldScore + (end - start)) + " WHERE id= " + Integer.parseInt(cle) + " ; ");
                                                                mDatabase.close();
                                                            }
                                                            try{

                                                                Uri myUri = Uri.parse("android.resource://" + view.getContext().getPackageName() + "/" + R.raw.achievement);
                                                                System.out.println(myUri);
                                                                MediaPlayer playerM=new MediaPlayer();
                                                                playerM.setDataSource(view.getContext(), myUri);
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



















//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//
//public class Lv4 extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_lv4);
//    }
//}