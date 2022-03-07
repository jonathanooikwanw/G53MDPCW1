package com.example.cw1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class BrushSetter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brush_setter);
    }

    //if the user selects a brush size of 10
    public void BrushSize10(View v){
        Intent size10 = new Intent(); //makes an intent

        Bundle send10 = new Bundle(); //creates a new bundle
        send10.putInt("brushsize10", 10); //puts the key and the size of brush in the bundle
        size10.putExtras(send10); //includes bundle in intent
        setResult(Activity.RESULT_OK, size10); //returns result ok to show activity was successful in obtaining data

        finish();
    }

    //if the user selects a brush size of 5
    public void BrushSize5(View v){
        Intent size5 = new Intent();

        Bundle send5 = new Bundle();
        send5.putInt("brushsize5", 5);
        size5.putExtras(send5);
        setResult(Activity.RESULT_OK, size5);

        finish();
    }

    //if the user selects a brush size of 20
    public void BrushSize20(View v){
        Intent size20 = new Intent();

        Bundle send20 = new Bundle();
        send20.putInt("brushsize20", 20);
        size20.putExtras(send20);
        setResult(Activity.RESULT_OK, size20);

        finish();
    }

    //if the user selects a brush size of 50
    public void BrushSize50(View v){
        Intent size50 = new Intent();

        Bundle send50 = new Bundle();
        send50.putInt("brushsize50", 50);
        size50.putExtras(send50);
        setResult(Activity.RESULT_OK, size50);

        finish();
    }

    //if the user selects a brush size of 100
    public void BrushSize100(View v){
        Intent size100 = new Intent();

        Bundle send100 = new Bundle();
        send100.putInt("brushsize100", 100);

        size100.putExtras(send100);
        setResult(Activity.RESULT_OK, size100);

        finish();
    }

    //if the user selects a square brush shape
    public void BrushSquare(View v){
        Intent brushSquare = new Intent();

        Bundle sendSquare = new Bundle();
        sendSquare.putString("brushsquare", "Square");


        brushSquare.putExtras(sendSquare);
        setResult(Activity.RESULT_OK, brushSquare);
        finish();
    }

    //if the user selects a round brush shape
    public void BrushRound(View v){
        Intent brushRound = new Intent();

        Bundle sendRound = new Bundle();
        sendRound.putString("brushround", "Circle"); //places the key and the shape of the brush in the bundle

        brushRound.putExtras(sendRound);
        setResult(Activity.RESULT_OK, brushRound);
        finish();
    }
}
