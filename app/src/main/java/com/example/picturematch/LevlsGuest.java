package com.example.picturematch;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import static java.lang.System.exit;

public class LevlsGuest extends AppCompatActivity {

    String niveau, cle;
    TextView txt1,txt2,txt3,txt4,txt5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levls_guest);
        LevlsGuest selfintent = this;



        txt1 = (TextView) findViewById(R.id.levl1);
        txt2 = (TextView) findViewById(R.id.levl2);
        txt3 = (TextView) findViewById(R.id.levl3);
        txt4 = (TextView) findViewById(R.id.levl4);
        txt5 = (TextView) findViewById(R.id.levl5);


        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Lv1Guest.class);


                startActivity(i);

            }
        });
        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(getApplicationContext(), Lv2Guest.class);
                //i2.putExtra("idd",i.getExtras().getString("idd"));

             //   selfintent.finish();
                startActivity(i2);


            }
        });
        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(getApplicationContext(), Lv3Guest.class);
                //i3.putExtra("idd",i.getExtras().getString("idd"));


                startActivity(i3);
            }
        });
        txt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i4 = new Intent(getApplicationContext(),Lv4Guest.class);
                //i4.putExtra("idd",i.getExtras().getString("idd"));

               // selfintent.finish();
                startActivity(i4);


            }
        });
        txt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i5 = new Intent(getApplicationContext(),Lv5Guest.class);
                //i5.putExtra("idd",i.getExtras().getString("idd"));

                startActivity(i5);



            }
        });
    }
}
