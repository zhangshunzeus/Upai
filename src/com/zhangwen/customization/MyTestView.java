package com.zhangwen.customization;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class MyTestView extends View{
	 
	 //构造器
	 public MyTestView(Context context, AttributeSet attrs) {
	  super(context, attrs);
	  // TODO Auto-generated constructor stub
	 }

	  
	 @Override
	 protected void onDraw(Canvas canvas) {
	  // TODO Auto-generated method stub
	  super.onDraw(canvas);
	  //绘制黑色背景
	  canvas.drawColor(Color.WHITE);
	  //创建画笔
	  Paint paint = new Paint();
	  //设置画笔颜色为红色
	  paint.setColor(Color.BLACK);
	  /*//绘制矩形
	  canvas.drawRect(110, 10, 110, 110, paint);
	  //字符串 以字符串下面为基准
	  canvas.drawText("这是字符串", 10, 130, paint);
	  */
	  //定义一个矩形
	  RectF rf1 = new RectF(10, 130, 110, 230);
	  //画弧顺时针
	  canvas.drawArc(rf1, 0, 45, true, paint);
	  //画线
	  //canvas.drawLine(150, 10, 250, 110, paint);
	  
	  //定义一个矩形
	  RectF rf2 = new RectF(150, 130, 250, 230);
	  //画圆
	 // canvas.drawOval(rf2, paint);
	  
	 }

	}



