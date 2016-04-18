package com.example.ruanjiawei.activity;

import com.ushooting.activity.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MyActicity extends Activity {
	
	Button btn_login_registered;
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.my);
		
		btn_login_registered = (Button) findViewById(R.id.btn_login_registered);
		btn_login_registered.setOnClickListener(l);
		
	}
	
	OnClickListener l = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.btn_login_registered:
				Intent intent_btn_login_registered = new Intent();
				intent_btn_login_registered.setClass(MyActicity.this, LoginActicity.class);
				startActivity(intent_btn_login_registered);
				break;

			default:
				break;
			}
		}
	};
	
}
