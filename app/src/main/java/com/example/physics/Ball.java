package com.example.physics;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

public class Ball {
    int x, y, r, dx, dy;
    int bc, str;
    int gx,gy;
    int viewWidth, viewHeight;
    int l;
    int m;
    boolean touch = false;

    public Ball(int x, int y, int r, int bc, int str, int dx, int dy){
        this.x = x;
        this.y = y;
        this.r = r;
        this.bc = bc;
        this.str = str;
        this.dx = dx;
        this.dy = dy;
        l = r/4;
        gx = x + dx*l ;
        gy = y + dy*l;
        m = r/10;
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
        gx =x+dx*l ;
        gy = y + dy*l;
    }

    public void distance(Ball b){
        int ras = (int)Math.sqrt((x-b.x)*(x-b.x) + (y - b.y)*(y-b.y));
        if(ras<r+b.r){
           touch = true;
        }
        else touch = false;
    }

    public void crush(Ball b) {
        //расстояния между центрами
        if (touch == true) {
            b.dx = -b.dx;
            b.dy = -b.dy;
            dx = -dx;
            dy = -dy;
            /*if(b.dx>0 && dx>0 && b.dy>0 && dy>0){
                if(x>b.x){
                    dx += b.dx;
                    b.dx = 0;
                }
                else{
                    b.dx += dx;
                    dx = 0;
                }
                if(y>b.y){
                    dy += b.dy;
                    b.dy = 0;
                }
                else{
                    b.dy += dy;
                    dy = 0;
                }
            }

            if(b.dx>0 && dx>0 ){
                if(x>b.x){
                    dx += b.dx;
                    b.dx = 0;
                }
                else{
                    b.dx += dx;
                    dx = 0;
                }
                if(y<b.y){
                    dy += b.dy;
                    b.dy = 0;
                }
                else{
                    b.dy += dy;
                    dy = 0;
                }
            }

            else if(b.dx<0 && dx<0&& b.dy<0 && dy<0){
                if(x<b.x){
                    dx += b.dx;
                    b.dx = 0;
                }
                else{
                    b.dx += dx;
                    dx = 0;
                }
                if(y<b.y){
                    dy += b.dy;
                    b.dy = 0;
                }
                else{
                    b.dy += dy;
                    dy = 0;
                }
            }
        }
    }*/


        }
    }
    public void stop(Ball b){
        while (touch == true){
            if(dx == 0 && dy ==0){
                dx = b.dx; dy = b.dy;
                gx = b.gx; gy = b.gy;
                b.dx = 0; b.dy = 0;
                break;

            }
            else if(b.dx ==0 && b.dy ==0){
                b.dx = dx; b.dy = dy;
                dx = 0; dy = 0;

            }
        }
    }
}