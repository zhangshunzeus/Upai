package com.example.ruanjiawei.activity;

import com.ushooting.activity.R;
import com.ushooting.activity.RegisteredActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActicity extends Activity {
	
	TextView tv_registered;
	Button btn_login;
	ImageView iv_return;
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);
		
		tv_registered = (TextView) findViewById(R.id.tv_registered);
		tv_registered.setOnClickListener(l);
		
		btn_login= (Button) findViewById(R.id.btn_login);
		btn_login.setOnClickListener(l);
		
		iv_return = (ImageView) findViewById(R.id.iv_return);
		iv_return.setOnClickListener(l);

	}
	
	OnClickListener l = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.tv_registered:
				Intent intent_registered = new Intent();
				intent_registered.setClass(LoginActicity.this,RegisteredActivity.class);
				startActivity(intent_registered);
				break;
			case R.id.btn_login:
				Intent intent_my = new Intent();
				intent_my.setClass(LoginActicity.this,MyLoginActivity.class);
				startActivity(intent_my);
				break;
			case R.id.iv_return:
				finish();
				break;
			default:
				break;
			}
		}
	};

}
