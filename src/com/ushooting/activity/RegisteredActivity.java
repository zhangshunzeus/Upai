package com.ushooting.activity;

import com.example.ruanjiawei.activity.LoginActicity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class RegisteredActivity extends Activity {

	TextView tv_intent_login;
	ImageView iv_back;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_registered_page);
		
		tv_intent_login = (TextView) findViewById(R.id.tv_intent_login);
		tv_intent_login.setOnClickListener(lick);
		iv_back = (ImageView) findViewById(R.id.iv_back);
		iv_back.setOnClickListener(lick);
		
	}
	
	OnClickListener lick = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.tv_intent_login:
				Intent intent_login = new Intent();
				intent_login.setClass(RegisteredActivity.this,LoginActicity.class);
				startActivity(intent_login);
				break;
			case R.id.iv_back:
				finish();
				break;
			default:
				break;
			}
		}
	};
	
}
