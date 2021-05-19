package com.example.physics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.view.View;

import java.util.ArrayList;

public class Physics extends View {
    static ArrayList <Ball> bs = new ArrayList<>();

    int viewWidth, viewHeight;

    public Physics(Context context) {
        super(context);
        MyT t = new MyT(3456789,6);
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
