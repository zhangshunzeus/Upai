package com.example.ruanjiawei.activity;

import com.ushooting.activity.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class SetActicity extends Activity {
	
	ImageView iv_return;
	Button btn_exit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.set);
		
		iv_return = (ImageView) findViewById(R.id.iv_return);
		iv_return.setOnClickListener(l);
		
		btn_exit = (Button) findViewById(R.id.btn_exit);
		btn_exit.setOnClickListener(l);
		
	}
	
	OnClickListener l = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.iv_return:
				finish();
				break;
			case R.id.btn_exit:
				finish();
				break;
			default:
				break;
			}
		}
	};
	
}
