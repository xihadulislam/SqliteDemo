package com.cra.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {


    private AdView mAdView;


    private InterstitialAd mInterstitialAd;



    EditText name,addres,phone;
    Button save;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(MainActivity.this);

        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());



        findViewById(R.id.interstal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mInterstitialAd.show();
            }
        });


        name = findViewById(R.id.nameId);
        addres = findViewById(R.id.addressId);
        phone = findViewById(R.id.phoneId);
        save = findViewById(R.id.saveID);



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String nm = name.getText().toString().trim();
                String add = addres.getText().toString().trim();
                String phn = phone.getText().toString().trim();

                DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);


                long value = databaseHelper.insertData(nm,add,phn);

                if (value>0){

                    Toast.makeText(MainActivity.this, "Store ", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();

                }



            }
        });



        findViewById(R.id.showdataId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Main2Activity.class));

            }
        });



    }
}

