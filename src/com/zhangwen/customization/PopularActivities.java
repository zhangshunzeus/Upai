package com.zhangwen.customization;

import com.ushooting.activity.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;

public class PopularActivities extends Activity{
	ImageView returns;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//热门活动页面
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.popular_activities);
		returns=(ImageView)findViewById(R.id.return_finish);
		returns.setOnClickListener(l);
	}
	
	OnClickListener l=new OnClickListener(){
		//返回按钮监听
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			finish();
		}
	};

}
