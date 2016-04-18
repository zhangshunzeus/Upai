package com.example.ruanjiawei.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import com.ushooting.activity.R;

public class MyWorksActivity extends Activity {
	
	GridView Scrollgridview;
	Button uploding;
	ImageView iv_return;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.myworks);
		
		iv_return = (ImageView) findViewById(R.id.iv_return);
		iv_return.setOnClickListener(l);
		
	}
	
	OnClickListener l = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.iv_return:
				finish();
				break;

			default:
				break;
			}
		}
	};
	
}
