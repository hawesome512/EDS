package com.hawesome.edsdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by haisheng on 2016/2/24.
 */
public class GridView extends View {
    Paint paint,paint1,paint2,paint3,paint4;

    public GridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public GridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    public GridView(Context context) {
        super(context);

        init();
    }

    private void init() {
        paint=new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint1=new Paint(paint);
        paint1.setStrokeWidth(8);
        paint2=new Paint(paint);
        paint2.setStyle(Paint.Style.FILL);
        paint3=new Paint(paint2);
        paint3.setColor(0xff1d953f);
//        paint3.setColor(0xfffcaf17);
//        paint3.setColor(0xfff7acbc);
        paint4=new Paint(paint);
        paint4.setStrokeWidth(10);
        paint4.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int wid=getMeasuredWidth();
        int hei=getMeasuredHeight();
        canvas.drawColor(Color.WHITE);

        RectF rectF=new RectF(0.4f*wid,0.37f*hei,0.6f*wid,0.43f*hei);
        canvas.drawRect(rectF,paint3);
        rectF.offset(0,0.25f*hei);
        canvas.drawRect(rectF,paint3);
        rectF.offset(0,0.25f*hei);
        canvas.drawRect(rectF,paint3);

        canvas.drawLine(0.1f*wid,0.15f*hei,0.42f*wid,0.15f*hei,paint);
        canvas.drawLine(0.58f*wid,0.15f*hei,0.9f*wid,0.15f*hei,paint);
        canvas.drawLine(0.1f*wid,0.4f*hei,0.42f*wid,0.4f*hei,paint);
        canvas.drawLine(0.58f*wid,0.4f*hei,0.9f*wid,0.4f*hei,paint);
        canvas.drawLine(0.1f*wid,0.65f*hei,0.42f*wid,0.65f*hei,paint);
        canvas.drawLine(0.58f*wid,0.65f*hei,0.9f*wid,0.65f*hei,paint);
        canvas.drawLine(0.1f*wid,0.9f*hei,0.42f*wid,0.9f*hei,paint);
        canvas.drawLine(0.58f*wid,0.9f*hei,0.9f*wid,0.9f*hei,paint);
        canvas.drawLine(0.9f*wid,0.15f*hei,0.9f*wid,0.4f*hei,paint);
        canvas.drawLine(0.1f*wid,0.9f*hei,0.9f*wid,0.9f*hei,paint);
        canvas.drawLine(0.1f*wid,0.38f*hei,0.1f*wid,0.92f*hei,paint1);
        canvas.drawCircle(0.47f*wid,0.15f*hei,0.05f*wid,paint);
        canvas.drawCircle(0.53f*wid,0.15f*hei,0.05f*wid,paint);

        Path path=new Path();
        path.moveTo(0.1f*wid,0.13f*hei);
        path.lineTo(0.1f*wid,0.17f*hei);
        path.lineTo(0.14f*wid,0.15f*hei);
        canvas.drawPath(path,paint2);
        path.offset(0.76f*wid,0.5f*hei);
        canvas.drawPath(path,paint2);
        path.offset(0,0.25f*hei);
        canvas.drawPath(path,paint2);

        canvas.drawLine(0.42f*wid,0.4f*hei,0.58f*wid,0.4f*hei,paint4);
        canvas.drawLine(0.42f*wid,0.65f*hei,0.58f*wid,0.65f*hei,paint4);
        canvas.drawLine(0.42f*wid,0.9f*hei,0.58f*wid,0.9f*hei,paint4);

        Paint paint5=new Paint();
        paint5.setColor(Color.GRAY);
        paint5.setTextSize(52);
        canvas.drawText("401",0.46f*wid,0.36f*hei,paint5);
        canvas.drawText("413",0.46f*wid,0.61f*hei,paint5);
        canvas.drawText("415",0.46f*wid,0.86f*hei,paint5);
        canvas.drawText("成宇配电图",0.4f*wid,0.08f*hei,paint5);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x= (int) event.getX();
        int y= (int) event.getY();
        Point point=new Point(x,y);
        int wid=getMeasuredWidth();
        int hei=getMeasuredHeight();
        RectF rectF1=new RectF(0.4f*wid,0.37f*hei,0.6f*wid,0.43f*hei);
        RectF rectF2=new RectF(0.4f*wid,0.62f*hei,0.6f*wid,0.68f*hei);
        RectF rectF3=new RectF(0.4f*wid,0.87f*hei,0.6f*wid,0.93f*hei);
        switch(event.getAction()){
            case MotionEvent.ACTION_UP:
                if(isTouch(rectF1,point)){
                    paint3.setColor(0xff1d953f);
                    invalidate();
                }else if(isTouch(rectF2,point)){
                    paint3.setColor(0xfffcaf17);
                    invalidate();
                }else if(isTouch(rectF3,point)){
                    paint3.setColor(0xfff7acbc);
                    invalidate();
                }
                break;
            default:
                break;
        }
        return true;
    }

    private boolean isTouch(RectF rectF,Point point){
        boolean bX= point.x>rectF.left&&point.x<rectF.right;
        boolean bY=point.y>rectF.top&&point.y<rectF.bottom;
        if(bX&&bY){
            //进入设备详情页面
            Intent intent=new Intent(getContext(),DeviceActivity.class);
            super.getContext().startActivity(intent);
            return true;
        }else {
            return false;
        }
    }
}
