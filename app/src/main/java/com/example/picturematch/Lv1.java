package com.example.picturematch;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Lv1 extends AppCompatActivity {
    public static final String DATABASE_NAME = "mydb";

    SQLiteDatabase mDatabase;
    ImageView imageView=null;
    private int cuerentPair=0;
    int [] drawanle;
    ArrayList<Integer> pos = new  ArrayList<Integer>(Arrays.asList(0,1,0,1));
    int cuerentpos =-1;
    long Start, end;
    ArrayList<Integer> posDeja = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        new CountDownTimer(10000, 1000) {


            public void onTick(long millisUntilFinished) {
                TextView txt111 = (TextView) findViewById(R.id.mTextField1);
                txt111.setText(""+millisUntilFinished / 1000);
                //here you can have your logic to set text to edittext
            }
           // TextView txt111 = (TextView) findViewById(R.id.mTextField1);
            public void onFinish()
            {
                TextView txt111 = (TextView) findViewById(R.id.mTextField1);
                txt111.setText("done!");
                finish();
                //this.finishAffinity();
                //System.exit(0);
            }

        }.start();
        super.onCreate(savedInstanceState);


        SharedPreferences preferences = getSharedPreferences("theme", Context.MODE_PRIVATE);
        String choix = preferences.getString("ChoixImages","Mafiha Walooooo");

        //Toast.makeText(this, choix, Toast.LENGTH_SHORT).show();

        SharedPreferences preferences2 = getSharedPreferences("Coordonnées", Context.MODE_PRIVATE);
        String cle = preferences2.getString("cle","");

        switch(choix)
        {
            case "Birds":

                drawanle = new int[]{R.drawable.bird1, R.drawable.bird2} ;
                break;
            case "Cats":

                drawanle = new int[]{R.drawable.cat1, R.drawable.cat2} ;
                break;
            case "Dogs":

                drawanle = new int[]{R.drawable.dog1, R.drawable.dog2} ;
                break;
            case "Trees":

                drawanle = new int[]{R.drawable.tree1, R.drawable.tree2} ;
                break;
            default:
                drawanle = new int[]{R.drawable.tree1, R.drawable.dog2};
                break;
        }



        Start = System.currentTimeMillis();
        Collections.shuffle(pos);
        setContentView(R.layout.activity_lv1);
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

                                                    }
                                                    else
                                                    {
                                                        ((ImageView)view).setImageResource(drawanle[pos.get(position)]);

                                                            cuerentPair++;
                                                        if(cuerentPair==2){
                                                            //Intent intent = getIntent();
                                                            //String str4 = intent.getStringExtra("idd");

                                                            mDatabase.execSQL("UPDATE joueur SET niveau =1 WHERE id="+Integer.parseInt(cle)+"; ");
                                                            mDatabase.close();
                                                            /*  */
                                                            //Toast.makeText(getApplicationContext(), "updating", Toast.LENGTH_SHORT).show();
                                                            Toast.makeText(getApplicationContext(),"you win\n you can move to the  level 2", Toast.LENGTH_SHORT).show();

                                                            Intent i = new Intent(getApplicationContext(), Levls.class);
                                                            i.putExtra("passToLevel2",true);
                                                            i.putExtra("idd",cle);
                                                            end = System.currentTimeMillis();

                                                            Toast.makeText(getApplicationContext(),String.valueOf(end-Start) , Toast.LENGTH_SHORT).show();
                                                            mDatabase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
                                                            mDatabase.execSQL("UPDATE joueur SET scor = "+ (end-Start) +" WHERE id="+Integer.parseInt(cle)+"; ");
                                                            mDatabase.close();
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
//import android.content.Intent;
//import android.database.sqlite.SQLiteDatabase;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.EditText;
//import android.widget.GridView;
//import android.widget.ImageView;
//import android.widget.Toast;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.Collections;
//
//public class Lv1 extends AppCompatActivity {
//    public static final String DATABASE_NAME = "mydb";
//
//    SQLiteDatabase mDatabase;
//    ImageView imageView=null;
//    private int cuerentPair=0;
//    final int [] drawanle=new int[]{R.drawable.im1,R.drawable.im2};
//    //int [] pos ={0,1,0,1};
//    ArrayList<Integer> pos= new ArrayList<Integer>(Arrays.asList(0,1,0,1));
//    int cuerentpos =-1;
//
//    @Override
//
//    protected void onCreate(Bundle savedInstanceState) {
//        Collections.shuffle(pos);
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_lv1);
//        GridView gridView=(GridView) findViewById(R.id.grlv1);
//        imdAdapter imdAdapter=new imdAdapter(this);
//        gridView.setAdapter(imdAdapter);
//        mDatabase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//
//
//                                        @Override
//                                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                                            if (cuerentpos<0){
//                                                cuerentpos=position;
//                                                imageView=(ImageView)view;
//                                                ((ImageView)view).setImageResource(drawanle[pos.get(position)]);
//
//
//
//                                            }
//
//                                            else{
//                                                if(cuerentpos==position){
//
//                                                    ((ImageView)view).setImageResource(R.drawable.im0);
//                                                }
//                                                else if(pos.get(cuerentpos) !=pos.get(position))
//                                                {
//                                                    imageView.setImageResource(R.drawable.im0);
//                                                    Toast.makeText(getApplicationContext(),"not match", Toast.LENGTH_SHORT).show();
//
//
//                                                }
//                                                else
//                                                {
//                                                    ((ImageView)view).setImageResource(drawanle[pos.get(position)]);
//                                                    cuerentPair++;
//                                                    if(cuerentPair==2){
//                                                        Intent intent = getIntent();
//
//                                                        String str4 = intent.getStringExtra("idd");
//
//                                                        mDatabase.execSQL("UPDATE joueur SET niveau =1 WHERE id='"+str4+"'; ");
//                                                        mDatabase.close();
//                                                        /*  */
//                                                        //Toast.makeText(getApplicationContext(), "updating", Toast.LENGTH_SHORT).show();
//                                                        Toast.makeText(getApplicationContext(),"you win\n you can move to the  level 2", Toast.LENGTH_SHORT).show();
//                                                        startActivity(new Intent(getApplicationContext(), Levls.class));
//
//                                                    }
//
//                                                }
//
//                                                cuerentpos=-1;
//
//
//
//
//
//
//
//                                            }
//
//                                        }
//                                    }
//
//        );
//    }
//
//}