package com.example.physics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.view.View;

import java.util.ArrayList;

public class Physics extends View {
    ArrayList <Ball> bs = new ArrayList<>();

    int viewWidth, viewHeight;

    public Physics(Context context) {
        super(context);
        MyT t = new MyT(3456789,6);
        t.start();
        bs.add(new Ball(220,220,200,Color.BLUE,Color.YELLOW, 6,6));
        bs.add(new Ball(456,220, 150, Color.GREEN, Color.YELLOW, 3,3));
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
                    b.crush(b2);
                    b.stop(b2);
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
