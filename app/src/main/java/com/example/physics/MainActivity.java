package com.example.physics;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<Ball> bl;
    //Button ball, start;
    EditText massa, Vx, Vy, colr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fnarchism);


        massa = findViewById(R.id.massa);
        Vx = findViewById(R.id.Vx);
        Vy = findViewById(R.id.Vy);
        colr = findViewById(R.id.colr);
    }

    public void add(){
//        int color = Integer.parseInt(colr.getText().toString());
//        float m = Integer.parseInt(massa.getText().toString());
//        float vx = Float.parseFloat(Vx.getText().toString());
//        float vy = Float.parseFloat(Vy.getText().toString());
//        bl = new ArrayList<>();
//        bl.add(new Ball(220f, 220f, color,Color.BLACK, vx, vy, m));
        setContentView(new Physics(this));
    }
}