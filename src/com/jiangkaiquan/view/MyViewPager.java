package com.jiangkaiquan.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class MyViewPager extends ViewPager {
	public MyViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	private boolean slip = false;

	public void setSlip(boolean slip) {
		this.slip = slip;
	}

	public boolean getSlip() {
		return slip;
	}

	@Override
	public boolean onTouchEvent(MotionEvent arg0) {
		// TODO Auto-generated method stub
		if (!slip) {//
			return super.onTouchEvent(arg0);
		} else {//true时拦截
			return false;
		}
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent arg0) {
		// TODO Auto-generated method stub
		if (!slip) {
			return super.onInterceptTouchEvent(arg0);
		} else {
			return false;
		}
	}
}
