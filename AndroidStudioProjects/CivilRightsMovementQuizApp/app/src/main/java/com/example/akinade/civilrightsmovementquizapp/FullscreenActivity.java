package com.example.akinade.civilrightsmovementquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class FullscreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        }

    //Takes user to the Quiz page
    public void submit(View v){
        Intent quiz= new Intent(FullscreenActivity.this, MainActivity.class);
        startActivity(quiz);
        finish();
    }
}