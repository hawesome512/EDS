package com.hawesome.edsdemo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.Log;
import android.view.View;

/**
 * Created by haisheng on 2016/2/16.
 */
public class CvsView extends View {
    public CvsView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();
        paint.setColor(Color.YELLOW);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
        paint.setAntiAlias(true);
        canvas.drawColor(Color.BLACK);
        canvas.translate(canvas.getWidth()/2,canvas.getHeight()/2);
        canvas.drawCircle(0,0,400,paint);

        canvas.save();
        canvas.translate(-300,-300);
        Path path=new Path();
        path.addArc(new RectF(0,0,600,600),-180,180);
        Paint citePaint=new Paint(paint);
        citePaint.setTextSize(40);
        citePaint.setStrokeWidth(1);
        canvas.drawTextOnPath("www.hawesome.com",path,270,0,citePaint);
        canvas.restore();

        Paint tmpPaint=new Paint(paint);
        tmpPaint.setStrokeWidth(1);
        tmpPaint.setTextSize(36);
        int count=60;
        int y=400;
        for(int i=0;i<count;i++){
            if(i%5==0){
                canvas.drawLine(0,y,0,y+48,paint);
                canvas.drawText(String.valueOf(i/5+1),-10,y+80,tmpPaint);
            }else {
                canvas.drawLine(0,y,0,y+20,tmpPaint);
            }
            canvas.rotate(360/count,0,0);

        }

        tmpPaint.setColor(Color.GRAY);
        tmpPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(0,0,50,tmpPaint);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(3);
        canvas.drawCircle(0,0,30,paint);
        canvas.drawLine(0,75,0,-250,paint);
////        画布背景色
//        canvas.drawColor(Color.WHITE);
////        设置画笔
//        Paint paint=new Paint();
//        paint.setAntiAlias(true);
//        paint.setColor(Color.BLUE);
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(3);
////        画几何图形
//        canvas.drawCircle(40,40,30,paint);
//        canvas.drawRect(10,80,70,140,paint);
//        canvas.drawRect(10,150,70,190,paint);
//        canvas.drawRoundRect(new RectF(10,200,70,230),15,15,paint);
//        canvas.drawOval(new RectF(10,240,70,270),paint);
////        画多边形
//        Path path3=new Path();
//        path3.moveTo(10,340);
//        path3.lineTo(70,340);
//        path3.lineTo(40,290);
//        path3.close();
//        canvas.drawPath(path3,paint);
//
//        Path path5=new Path();
//        path5.moveTo(26,360);
//        path5.lineTo(54,360);
//        path5.lineTo(70,392);
//        path5.lineTo(40,420);
//        path5.lineTo(10,392);
//        path5.close();
//        canvas.drawPath(path5,paint);
//
////        设置填充风格
//        paint.setStyle(Paint.Style.FILL);
//        paint.setColor(Color.RED);
//        canvas.drawCircle(120,40,30,paint);
//        canvas.drawRect(90,80,150,140,paint);
//        canvas.drawRect(80,150,150,190,paint);
//        canvas.drawRoundRect(new RectF(90,200,150,230),15,15,paint);
//        canvas.drawOval(new RectF(90,240,150,270),paint);
//        Path path3_1=new Path();
//        path3_1.moveTo(90,340);
//        path3_1.lineTo(150,340);
//        path3_1.lineTo(120,290);
//        path3_1.close();
//        canvas.drawPath(path3_1,paint);
//        Path path5_1=new Path();
//        path5_1.moveTo(106, 360);
//        path5_1.lineTo(134, 360);
//        path5_1.lineTo(150, 392);
//        path5_1.lineTo(120, 420);
//        path5_1.lineTo(90, 392);
//        path5_1.close();
//        canvas.drawPath(path5_1,paint);
//
////        设置渐变器风格
//        Shader shader=new LinearGradient(0,0,40,60,new int[]{Color.RED,Color.GREEN,Color.BLUE,Color.YELLOW},null,Shader.TileMode.REPEAT);
//        paint.setShader(shader);
////        设置阴影
////        paint.setShadowLayer(45,10,10,Color.GRAY);
//        // 绘制圆形
//        canvas.drawCircle(200, 40, 30, paint);
//        // 绘制正方形
//        canvas.drawRect(170, 80, 230, 140, paint);
//        // 绘制矩形
//        canvas.drawRect(170, 150, 230, 190, paint);
//        RectF re3 = new RectF(170, 200, 230, 230);
//        // 绘制圆角矩形
//        canvas.drawRoundRect(re3, 15, 15, paint);
//        RectF re31 = new RectF(170, 240, 230, 270);
//        // 绘制椭圆
//        canvas.drawOval(re31, paint);
//        Path path3_2 = new Path();
//        path3_2.moveTo(170, 340);
//        path3_2.lineTo(230, 340);
//        path3_2.lineTo(200, 290);
//        path3_2.close();
//        // 根据Path进行绘制，绘制三角形
//        canvas.drawPath(path3_2, paint);
//        Path path5_2 = new Path();
//        path5_2.moveTo(186, 360);
//        path5_2.lineTo(214, 360);
//        path5_2.lineTo(230, 392);
//        path5_2.lineTo(200, 420);
//        path5_2.lineTo(170, 392);
//        path5_2.close();
//        // 根据Path进行绘制，绘制五角形
//        canvas.drawPath(path5_2, paint);
////        文字
//        paint.setTextSize(24);
//        paint.setShader(null);
//
////        String[]shapes=getResources().getStringArray(R.array.array_of_shapes);
//        canvas.drawText(getContext().getString(R.string.circle),240,50,paint);
//        canvas.drawText(getContext().getString(R.string.square),240,120,paint);
//        canvas.drawText(getContext().getString(R.string.rect),240,175,paint);
//        canvas.drawText(getContext().getString(R.string.round_rect),230,220,paint);
//        canvas.drawText(getContext().getString(R.string.oval),240,260,paint);
//        canvas.drawText(getContext().getString(R.string.triangle),240,325,paint);
//        canvas.drawText(getContext().getString(R.string.pentagon),240,390,paint);

/*        canvas.drawText("a", 240, 50,paint);
        canvas.drawText("b", 240, 120,paint);
        canvas.drawText("c", 240, 175,paint);
        canvas.drawText("d", 230,220, paint);
        canvas.drawText("e", 240, 260,paint);
        canvas.drawText("f", 240, 325,paint);
        canvas.drawText("g", 240, 390,paint);*/
    }
}
