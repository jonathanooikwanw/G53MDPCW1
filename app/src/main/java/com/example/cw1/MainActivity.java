    package com.example.cw1;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    // variables
    private TextView shape;
    private TextView size;
    private FingerPainterView fingerpainter;
    static final int BRUSH_COLOR_SELECT = 1;
    static final int BRUSH_CHANGE_SELECT = 2;
    int color;
    Button colorbutton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        colorbutton = findViewById(R.id.colorbutton); //makes an object of colorbutton so we can change the buttons colour
        fingerpainter = findViewById(R.id.view); //makes an object of fingerpainter so we can access the method references view so we can edit
        shape = findViewById(R.id.textshape); //makes an object of the shape text box so we can display the current shape
        size = findViewById(R.id.textsize); //makes an object of the size text box so we can display the current size
//        fingerpainter.load(getIntent().getData()); //loads an image from downloads

        //these are to set the default colour,shape and size of the brush
        color = fingerpainter.getColour();
        String brushSize = String.valueOf(fingerpainter.getBrushWidth());
        String brushShape = fingerpainter.getBrush().toString();
        shape.setText("Shape of brush :" + brushShape);
        size.setText("Size of brush :" + brushSize);
        colorbutton.setBackgroundColor(color);

            if (color == 0xFF000000)
        {
            colorbutton.setTextColor(Color.WHITE);
        }


    }

    //if the user clicks on the colour button, they will be taken to the colour menu
    public void onColorClick(View v)
    {
        Intent intent = new Intent(MainActivity.this, ColorPicker.class); //starts the color picker activity
        startActivityForResult(intent, BRUSH_COLOR_SELECT); //return the result for color picker

    }

    //if the user clicks on the brush button, they will be taken to the brush menu
    public void onBrushClick(View v)
    {
        Intent intent = new Intent(MainActivity.this, BrushSetter.class); //starts the brush setter activity
        startActivityForResult(intent, BRUSH_CHANGE_SELECT);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        //if the brush color button is pressed
        if (requestCode == BRUSH_COLOR_SELECT)
        {
            if (resultCode == RESULT_OK)
            {
                //gets the data
                Bundle bundlecolor = data.getExtras(); //retrieves the data from the intent
                if (bundlecolor.containsKey("green")) //sets the colour green
                {
                    color = bundlecolor.getInt("green"); //if the bundle contains the key green
                    fingerpainter.setColour(color); //set color green
                }

                else if (bundlecolor.containsKey("blue")) //sets the colour blue
                {
                    color = bundlecolor.getInt("blue");
                    fingerpainter.setColour(color);
                }

                else if (bundlecolor.containsKey("black")) //sets the colour black
                {
                    color = bundlecolor.getInt("black");
                    fingerpainter.setColour(color);
                }

                else if (bundlecolor.containsKey("orange")) //sets the colour orange
                {
                    color = bundlecolor.getInt("orange");
                    fingerpainter.setColour(color);
                }

                if (bundlecolor.containsKey("red")) //sets the colour red
                {
                    color = bundlecolor.getInt("red");
                    fingerpainter.setColour(color);
                }

                colorbutton.setBackgroundColor(color); //shows the current colour on the colour button

                if (bundlecolor.containsKey("black")) //if the current colour is black it changes the colour of the text to white
                {
                    colorbutton.setTextColor(Color.WHITE); //this is for the user experience
                }

            }
        }

        if (requestCode == BRUSH_CHANGE_SELECT)//if the user selects the brush option
        {
            if (resultCode == RESULT_OK) {
                Bundle bundlebrush = data.getExtras(); //get data from bundle

                if (bundlebrush.containsKey("brushsize10")) //sets brush size to 10
                {
                    int size = bundlebrush.getInt("brushsize10");
                    fingerpainter.setBrushWidth(size);
                }

                if (bundlebrush.containsKey("brushsize5"))//sets brush size to 5
                {
                    int size = bundlebrush.getInt("brushsize5");
                    fingerpainter.setBrushWidth(size);
                }

                if (bundlebrush.containsKey("brushsize20")) //sets brush size to 20
                {
                    int size = bundlebrush.getInt("brushsize20");
                    fingerpainter.setBrushWidth(size);
                }

                if (bundlebrush.containsKey("brushsize50"))//sets brush size to 50
                {
                    int size = bundlebrush.getInt("brushsize50");
                    fingerpainter.setBrushWidth(size);
                }

                if (bundlebrush.containsKey("brushsize100")) //sets brush size to 100
                {
                    int size = bundlebrush.getInt("brushsize100");
                    fingerpainter.setBrushWidth(size);
                }

                if(bundlebrush.containsKey("brushsquare")) //sets brush shape to square
                {
                    fingerpainter.setBrush(Paint.Cap.SQUARE);
                }

                if(bundlebrush.containsKey("brushround"))  //sets brush shape to circle
                {
                    fingerpainter.setBrush(Paint.Cap.ROUND);
                }

                String brushSize = String.valueOf(fingerpainter.getBrushWidth()); //gets the current brush size
                size.setText("Size of brush :" + brushSize);// displays the current brush size

                String brushShape = fingerpainter.getBrush().toString(); //gets the current brush shape
                shape.setText("Shape of brush :" + brushShape); //displays the current brush shape

            }
        }
    }

    //persistence
    protected void onSaveInstanceState(Bundle outState) { //saves the current brush colour,shape and size
        int colour = fingerpainter.getColour();
        int size = fingerpainter.getBrushWidth();
        String shape = fingerpainter.getBrush().toString();
        super.onSaveInstanceState(outState);
        outState.putInt("brush color", colour);
        outState.putInt("brush size", size);
        outState.putString("brush shape", shape);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) { //restores the current brush colour,shape and size
        super.onRestoreInstanceState(savedInstanceState);
        fingerpainter.setColour(savedInstanceState.getInt("brush color"));
        fingerpainter.setBrushWidth(savedInstanceState.getInt("brush size"));
        color = savedInstanceState.getInt("brush color");

        colorbutton.setBackgroundColor(color);
        if (color == 0xFF000000)
        {
            colorbutton.setTextColor(Color.WHITE);
        }

        size.setText("Size of brush:" + fingerpainter.getBrushWidth());

        if (savedInstanceState.getString("brush shape").equals("ROUND"))
        {
            fingerpainter.setBrush(Paint.Cap.ROUND);
            shape.setText("Shape of brush :" + fingerpainter.getBrush().toString());
        }
        if (savedInstanceState.getString("brush shape").equals("SQUARE")) {
            fingerpainter.setBrush(Paint.Cap.SQUARE);
            shape.setText("Shape of brush :" + fingerpainter.getBrush().toString());
        }
    }
}


