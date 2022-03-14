package com.example.drwtopapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
    }

    public void clickhospital(View view) {
        //gambar Hospital di click
        Intent i  = new Intent(this,hospital.class);
        startActivity(i);
    }
    public void clickpolice(View view) {
        //gambar Polisi di click
        Intent i  = new Intent(this,polisi.class);
        startActivity(i);
    }
    public void clickschooll(View view) {
        //gambar School di click
        Intent i  = new Intent(this,schooll.class);
        startActivity(i);
    }
    public void clicksupermarket(View view) {
        //gambar Supermarket di click
        Intent i  = new Intent(this,supermarkett.class);
        startActivity(i);
    }

}