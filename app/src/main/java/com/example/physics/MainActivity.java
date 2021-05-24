package com.example.physics;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.physics.Physics.bs;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<Ball> bl;
    static Button stop;
    EditText massa, massa2, V, V2, gr, gr2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fnarchism);
        massa = findViewById(R.id.massa);
        V = findViewById(R.id.V);
        V2 = findViewById(R.id.V2);
        gr = findViewById(R.id.gr);
        gr2 = findViewById(R.id.gr2);
        massa2 = findViewById(R.id.massa2);
        stop = findViewById(R.id.stop);
    }

    public void add(View view){
        try {
            float m = Float.parseFloat(massa.getText().toString());
            float v = Float.parseFloat(V.getText().toString());
            float v2 = Float.parseFloat(V2.getText().toString());
            float grad = Float.parseFloat(gr.getText().toString());
            float grad2 = Float.parseFloat(gr2.getText().toString());
            float m2 = Float.parseFloat(massa2.getText().toString());
            bl = new ArrayList<>();
            bl.add(new Ball(200f, 234f, Color.YELLOW,Color.BLACK, v, grad, m));
            bl.add(new Ball(600f, 234f, Color.BLUE,Color.BLACK, v2, grad2, m2));
            bs.addAll(bl);

            setContentView(new Physics(this));
            stop.setVisibility(View.VISIBLE);

        } catch (NumberFormatException e) {
            Toast toast = Toast.makeText(this,"Недостачно данных или они неправильно введены",Toast.LENGTH_SHORT);
            ViewGroup group = (ViewGroup) toast.getView();
            TextView messageTextView = (TextView) group.getChildAt(0);
            messageTextView.setTextSize(25);
            toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0,0);
            toast.show();
            e.printStackTrace();
        }
    }

    public void stop(View view) {
        setContentView(R.layout.fnarchism);

        bs.clear();

    }

}