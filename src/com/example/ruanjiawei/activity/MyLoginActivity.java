package com.example.ruanjiawei.activity;

import com.ushooting.activity.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MyLoginActivity extends Activity {

	TextView tv_my_collection,tv_my_set,tv_my_works;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.my_login);
		
		tv_my_collection = (TextView) findViewById(R.id.tv_my_collection);
		tv_my_collection.setOnClickListener(l);
		
		tv_my_set = (TextView) findViewById(R.id.tv_my_set);
		tv_my_set.setOnClickListener(l);
		
		tv_my_works = (TextView) findViewById(R.id.tv_my_works);
		tv_my_works.setOnClickListener(l);
		
	}
	
	OnClickListener l = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.tv_my_collection:
				//Intent intent_collection = new Intent();
				//intent_collection.setClass(MyLoginActivity.this,)
				break;
			case R.id.tv_my_set:
				Intent intent_set = new Intent();
				intent_set.setClass(MyLoginActivity.this,SetActicity.class);
				startActivity(intent_set);
				break;
			case R.id.tv_my_works:
				Intent intent_my_works = new Intent();
				intent_my_works.setClass(MyLoginActivity.this,MyWorksActivity.class);
				startActivity(intent_my_works);
				break;
			default:
				break;
			}
		}
	};
	
}
