package com.example.ruanjiawei.activity;

import com.ushooting.activity.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class ImageDetailsActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		ImageView myrecords_return_btn;
		
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.imagedetails);
		
		myrecords_return_btn = (ImageView) findViewById(R.id.myrecords_return_btn);
		myrecords_return_btn.setOnClickListener(l);
		
	}
	
	OnClickListener l = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.myrecords_return_btn:
				finish();
				break;

			default:
				break;
			}
		}
	};
	
}