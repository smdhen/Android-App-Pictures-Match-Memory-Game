package com.example.picturematch;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class Levls extends AppCompatActivity {

    String niveau, cle;
    TextView txt1,txt2,txt3,txt4,txt5;
    public static final String DATABASE_NAME = "mydb";
    SQLiteDatabase mDatabase;
//    final MediaPlayer md;
//    {
//        md = new MediaPlayer();
//        md.create(this, R.raw.classicclick);
//
//    }
//


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

       // this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_levls);





        SharedPreferences preferences = getSharedPreferences("Coordonnées",Context.MODE_PRIVATE);
        niveau = preferences.getString("niveau","niveau Khawii");
        cle = preferences.getString("cle","Cle Khawya");


       // mDatabase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
       // Cursor cursorJoueur = mDatabase.rawQuery("SELECT * FROM joueur where id = "+Integer.parseInt(cle)+" ;", null);
       // if (cursorJoueur.moveToFirst()) {
          //  @SuppressLint("Range") String niveau = cursorJoueur.getString(cursorJoueur.getColumnIndex("niveau"));


            //  Toast.makeText(this, niveau, Toast.LENGTH_SHORT).show();
            //Toast.makeText(this, cle, Toast.LENGTH_SHORT).show();

            SharedPreferences preferences1 = getSharedPreferences("theme", Context.MODE_PRIVATE);
            // Toast.makeText(this, preferences1.getString("ChoixImages","Mafiha Waloo"), Toast.LENGTH_SHORT).show();

            txt1 = (TextView) findViewById(R.id.levl1);
            txt2 = (TextView) findViewById(R.id.levl2);
            txt3 = (TextView) findViewById(R.id.levl3);
            txt4 = (TextView) findViewById(R.id.levl4);
            txt5 = (TextView) findViewById(R.id.levl5);


            switch (niveau) {
                case "1":
                    txt1.setClickable(true);
//                    txt1.setTextColor(Color.parseColor("#FF0000"));

                    break;
                case "2":
                    txt1.setClickable(true);
                    txt2.setClickable(true);
//
//                    txt1.setTextColor(Color.parseColor("#FF0000"));
//                    txt2.setTextColor(Color.parseColor("#FF0000"));
                    break;
                case "3":
                    txt1.setClickable(true);
                    txt2.setClickable(true);
                    txt3.setClickable(true);
//
//                    txt1.setTextColor(Color.parseColor("#FF0000"));
//                    txt2.setTextColor(Color.parseColor("#FF0000"));
//                    txt3.setTextColor(Color.parseColor("#FF0000"));
                    break;
                case "4":
                    txt1.setClickable(true);
                    txt2.setClickable(true);
                    txt3.setClickable(true);
                    txt4.setClickable(true);
//                    txt1.setTextColor(Color.parseColor("#FF0000"));
//                    txt2.setTextColor(Color.parseColor("#FF0000"));
//                    txt3.setTextColor(Color.parseColor("#FF0000"));
//                    txt4.setTextColor(Color.parseColor("#FF0000"));
//                    txt5.setTextColor(Color.parseColor("#FF0000"));
                    break;
                case "5":
                    txt1.setClickable(true);
                    txt2.setClickable(true);
                    txt3.setClickable(true);
                    txt4.setClickable(true);
                    txt5.setClickable(true);
//                    txt1.setTextColor(Color.parseColor("#FF0000"));
//                    txt2.setTextColor(Color.parseColor("#FF0000"));
//                    txt1.setTextColor(Color.parseColor("#FF0000"));
//                    txt2.setTextColor(Color.parseColor("#FF0000"));


                    break;
            }
       // }





        txt1.setOnClickListener(new View.OnClickListener() {

                                    @Override
                                    public void onClick(View v) {
/*                                        Context context=getApplicationContext();
                                        Intent intent = getIntent();
                                        String   str=niveau;
                                        String   str2=cle;
*/
//                                        str = intent.getStringExtra("id");
//                                        str2 = intent.getStringExtra("cle");

                                        //Toast.makeText(context,str2+"====2222222", Toast.LENGTH_SHORT).show();
                                        //int int1=Integer.valueOf(str);
                                        //Toast.makeText(context,str, Toast.LENGTH_SHORT).show();

/*
                                        int foo;
                                        try {
                                            foo = Integer.parseInt(str);
                                        }
                                        catch (NumberFormatException e) {
                                            foo = 1000;
                                        }
                                        //Toast.makeText(context,foo+"foo", Toast.LENGTH_SHORT).show();
                                        if (foo>=0)
                                        {
                                            Intent intent1 = new Intent(Levls.this, Lv1.class);
                                            // intent1.putExtra("cle1", 4);
                                            intent1.putExtra("idd", str2.toString());
                                            //Toast.makeText(context,foo, Toast.LENGTH_SHORT).show();
                                            startActivity(intent1);
                                        }
                                        else
                                            Toast.makeText(context,"noo", Toast.LENGTH_SHORT).show();
*/
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








////
//                                        MediaPlayer md = new MediaPlayer();
//                                          md.create(Levls.this, R.raw.gameclick);
//                                          md.start();
                                        Intent i = new Intent(getApplicationContext(),Lv1.class);
                                       // md.start();
                                        startActivity(i);
                                      //  md.start();

                                    }
                                }


        );

        Intent i = getIntent();
        if(i.getExtras() != null)
        {
//            if(i.getExtras().getBoolean("passToLevel2"))
//            {
                txt2.setClickable(true);
                txt2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try{

                            Uri myUri = Uri.parse("android.resource://" + view.getContext().getPackageName() + "/" + R.raw.classicclik);
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


                        Intent i2 = new Intent(getApplicationContext(),Lv2.class);
                        //i2.putExtra("idd",i.getExtras().getString("idd"));
                        startActivity(i2);


                    }

                });
           // }

//            if(i.getExtras().getBoolean("passToLevel3"))
//            {
                txt3.setClickable(true);
                txt3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try{

                            Uri myUri = Uri.parse("android.resource://" + view.getContext().getPackageName() + "/" + R.raw.classicclik);
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
                        Intent i3 = new Intent(getApplicationContext(),Lv3.class);
                        //i3.putExtra("idd",i.getExtras().getString("idd"));
                        startActivity(i3);
                    }
                });
         //   }

//            if(i.getExtras().getBoolean("passToLevel4"))
//            {
                txt4.setClickable(true);
                txt4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try{

                            Uri myUri = Uri.parse("android.resource://" + view.getContext().getPackageName() + "/" + R.raw.classicclik);
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
                        Intent i4 = new Intent(getApplicationContext(),Lv4.class);
                        //i4.putExtra("idd",i.getExtras().getString("idd"));
                        startActivity(i4);
                    }
                });
          //  }


//            if(i.getExtras().getBoolean("passToLevel5"))
//            {
                txt5.setClickable(true);
                txt5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try{

                            Uri myUri = Uri.parse("android.resource://" + view.getContext().getPackageName() + "/" + R.raw.classicclik);
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
                        Intent i5 = new Intent(getApplicationContext(),Lv5.class);
                        //i5.putExtra("idd",i.getExtras().getString("idd"));
                        startActivity(i5);
                    }
                });
            }
       // }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuoptions,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.theme:
                Intent i = new Intent(getApplicationContext(), themes.class);
                try{

                    View view = new View(getApplicationContext());
                    Uri myUri = Uri.parse("android.resource://" + view.getContext().getPackageName() + "/" + R.raw.classicclik);
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
                startActivity(i);
                Toast.makeText(this, "Themes", Toast.LENGTH_SHORT).show();
                break;

            case R.id.prof:
                //Toast.makeText(this, "Profiles", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, cle, Toast.LENGTH_SHORT).show();
                Intent i1 = new Intent(getApplicationContext(), modifyProfile.class);
                try{

                    View view = new View(getApplicationContext());
                    Uri myUri = Uri.parse("android.resource://" + view.getContext().getPackageName() + "/" + R.raw.classicclik);
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
                startActivity(i1);

                break;

            case R.id.scores:

                Toast.makeText(this, "Scores", Toast.LENGTH_SHORT).show();
                try{

                    View view = new View(getApplicationContext());
                    Uri myUri = Uri.parse("android.resource://" + view.getContext().getPackageName() + "/" + R.raw.classicclik);
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
                startActivity(new Intent(this, Scor.class));
                break;

            case R.id.quit:
                SharedPreferences myPrefs = getApplicationContext().getSharedPreferences("Coordonnées", Context.MODE_PRIVATE);
                myPrefs.edit().remove("niveau").apply();
                SharedPreferences myPrefs1 = getApplicationContext().getSharedPreferences("Coordonnées", Context.MODE_PRIVATE);
                SharedPreferences myPrefs2 = getApplicationContext().getSharedPreferences("Coordonnées", Context.MODE_PRIVATE);
                myPrefs.edit().remove("niveau").apply();
                myPrefs1.edit().remove("cle").apply();
                myPrefs1.edit().remove("ChoixImages").apply();
                //finish();
                this.finishAffinity();
                //System.exit(0);
                //break;

        }
        return super.onOptionsItemSelected(item);
    }
}
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.TextView;
//import android.widget.Toast;
//
//public class Levls extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_levls);
//
//        TextView txt1=(TextView) findViewById(R.id.levl1);
//        txt1.setOnClickListener(new View.OnClickListener() {
//
//                @Override
//                public void onClick(View v) {
//                    Context context=getApplicationContext();
//
//
//                    Intent intent = getIntent();
//                    String   str="";
//                    String   str2="";
//
//                    str = intent.getStringExtra("id");
//                    str2 = intent.getStringExtra("cle");
//                    //Toast.makeText(context,str2+"====2222222", Toast.LENGTH_SHORT).show();
//                    //int int1=Integer.valueOf(str);
//                    //Toast.makeText(context,str, Toast.LENGTH_SHORT).show();
//
//
//                    int foo;
//                    try {
//                        foo = Integer.parseInt(str);
//                    }
//                    catch (NumberFormatException e) {
//                        foo = 1000;
//                    }
//                    //Toast.makeText(context,foo+"foo", Toast.LENGTH_SHORT).show();
//
//
//                                            if (    foo>=0)
//                                            {
//
//
//                                            Intent intent1 = new Intent(Levls.this, Lv1.class);
//                                           // intent1.putExtra("cle1", 4);
//                                            intent1.putExtra("idd", str2.toString());
//                                               //Toast.makeText(context,foo, Toast.LENGTH_SHORT).show();
//                                            startActivity(intent1);
//                                        }
//                                        else
//                                            Toast.makeText(context,"noo", Toast.LENGTH_SHORT).show();
//                                }
//
//    }
//        );
//}
//}