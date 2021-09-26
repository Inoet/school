package com.example.physics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

import static com.example.physics.MainActivity.stop;

public class Physics extends View {
    static ArrayList <Ball> bs = new ArrayList<>();
    public static MyT t;
    int viewWidth, viewHeight;
    boolean touch = false;

    public Physics(Context context) {
        super(context);
        t = new MyT(3456789,6);
        t.start();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        viewWidth = w;
        viewHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.RED);
        for(Ball b : bs){
                b.draw(canvas);
                for(Ball b2 : bs){
                    b.distance(b2);
                    b.bounced(b2);
                }
            }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(touch == false) {
            t.cancel();
            touch = true;
            stop.setVisibility(View.VISIBLE);
        }
        else if(touch == true){
            t.start();
            touch = false;
            stop.setVisibility(View.INVISIBLE);
        }
        return super.onTouchEvent(event);
    }

    class MyT extends CountDownTimer{
        public MyT(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
        invalidate();
        }

        @Override
        public void onFinish() {

        }
    }
}
