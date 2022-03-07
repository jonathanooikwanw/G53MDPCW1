package com.example.cw1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class ColorPicker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker);
    }

    public void GreenSelect(View v) //when green is selected
    {
        Intent green = new Intent();

        Bundle sendgreen = new Bundle(); //creates a new bundle
        sendgreen.putInt("green", 0xFF00FF00); //puts the hexcode of green in the bundle
        green.putExtras(sendgreen);
        setResult(Activity.RESULT_OK, green);

        finish();

    }

    public void RedSelect(View v) //when red is selected
    {
        Intent red = new Intent();

        Bundle sendred = new Bundle(); //creates a new bundle
        sendred.putInt("red", 0xFFFF0000); //puts the hexcode of red in the bundle
        red.putExtras(sendred);
        setResult(Activity.RESULT_OK, red);

        finish();

    }

    public void OrangeSelect(View v) //when orange is selected
    {
        Intent orange = new Intent();

        Bundle sendorange = new Bundle(); //creates a new bundle
        sendorange.putInt("orange", 0xFFFFA500); //puts the hexcode of orange in the bundle
        orange.putExtras(sendorange);
        setResult(Activity.RESULT_OK, orange);

        finish();

    }

    public void BlackSelect(View v) //when black is selected
    {
        Intent black = new Intent();

        Bundle sendblack = new Bundle(); //creates a new bundle
        sendblack.putInt("black", 0xFF000000); //puts the hexcode of black in the bundle
        black.putExtras(sendblack);
        setResult(Activity.RESULT_OK, black);

        finish();

    }

    public void BlueSelect(View v) //when blue is selected
    {
        Intent blue = new Intent();

        Bundle sendblue = new Bundle(); //creates a new bundle
        sendblue.putInt("blue", 0xFF0000FF); //puts the hexcode of blue in the bundle
        blue.putExtras(sendblue);
        setResult(Activity.RESULT_OK, blue);

        finish();

    }


}
