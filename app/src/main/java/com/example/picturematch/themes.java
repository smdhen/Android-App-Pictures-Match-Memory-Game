package com.example.picturematch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class themes extends AppCompatActivity {

    TextView btnConfirm;
    RadioGroup groupChoix;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themes);

        btnConfirm = findViewById(R.id.btnChoseTheme);
        groupChoix = findViewById(R.id.choices);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            SharedPreferences preferences = getSharedPreferences("theme", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();

            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(),Levls.class);
                switch(groupChoix.getCheckedRadioButtonId())
                {
                    case R.id.Birds:
                        Toast.makeText(getApplicationContext(), "Birds", Toast.LENGTH_SHORT).show();
                        editor.putString("ChoixImages","Birds");
                        editor.commit();
                        break;
                    case R.id.Cats:
                        Toast.makeText(getApplicationContext(), "Cats", Toast.LENGTH_SHORT).show();
                        editor.putString("ChoixImages","Cats");
                        editor.commit();
                        break;
                    case R.id.Trees:
                        Toast.makeText(getApplicationContext(), "Trees", Toast.LENGTH_SHORT).show();
                        editor.putString("ChoixImages","Trees");
                        editor.commit();
                        break;
                    case R.id.Dogs:
                        Toast.makeText(getApplicationContext(), "Dogs", Toast.LENGTH_SHORT).show();
                        editor.putString("ChoixImages","Dogs");
                        editor.commit();
                        break;
                }
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
                startActivity(i);
            }
        });






    }
}











//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//
//public class themes extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_themes);
//    }
//}