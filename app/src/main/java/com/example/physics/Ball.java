package com.example.physics;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

public class Ball {
    float x;
    float y;
    float r;
    float dx;
    float dy;
    float V;
    float grad;
    int bc;
    int str;
    float gx,gy;
    float viewWidth, viewHeight;
    float l;
    public static float m;
    boolean touch = false;
    public Ball(float x, float y, int bc, int str, float V, float grad, float m) {
        this.x = x;
        this.y = y;
        this.bc = bc;
        this.str = str;
        this.V = V;
        this.grad = grad;
        this.m = m;
        r = (float) (m*3);
        l = r/4;
        dx = (float) (V*Math.cos(Math.toRadians(grad)));
        dy = (float) (V*Math.sin( (grad) ));
        gx = (float) (x + dx*l);
        gy = (float) (y + dy*l);
    }

    protected void draw(Canvas canvas) {
        viewHeight= canvas.getHeight();
        viewWidth = canvas.getWidth();
        Paint p = new Paint();
        p.setColor(bc);
        canvas.drawCircle(x, y, r, p);
        p.setColor(str);

        canvas.drawLine(x,y,gx,gy,p);

        if(x>viewWidth-r/1.3) {
            dx = -dx;
            gx=-gx;
        }
        else if(x<r/1.3){
            dx=-dx;
            gx=-gx;
        }
        if(y>viewHeight-r/1.3) {
            dy = -dy;
            gy=-gy;
        }
        else if(y <r/1.3) {
            dy = -dy;
            gy=-gy;
        }
        move();

    }
    public void move(){
        x+=dx;
        y+=dy;
        gx = (float) (x+dx*l);
        gy = (float) (y + dy*l);
    }

    public void distance(Ball b){
        int ras = (int)Math.sqrt((x-b.x)*(x-b.x) + (y - b.y)*(y-b.y));
        if(ras<r+b.r){
           touch = true;
        }
        else touch = false;
    }

    public void bounced(Ball b) {
        if (touch == true) {
            double vx1 = ((m - b.m) * dx + 2 * b.m * b.dx) / (m + b.m);
            double vx2 = ((b.m - m) * b.dx + 2 * m * dx) / (m + b.m);
            dx = (float) vx1;
            b.dx = (float) vx2;
            double vy1 = ((m - b.m) * dy + 2 * b.m * b.dy) / (m + b.m);
            double vy2 = ((b.m - m) * b.dy + 2 * m * dy) / (m + b.m);
            dy = (float) vy1;
            b.dy = (float) vy2;
        }
    }
}