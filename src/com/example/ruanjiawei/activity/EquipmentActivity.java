package com.example.ruanjiawei.activity;

import com.ushooting.activity.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class EquipmentActivity extends Activity {
	ImageView finish;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.equipment);
		
		finish=(ImageView) findViewById(R.id.finish);
		finish.setOnClickListener(l);

	}
	
	OnClickListener l=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.finish:
				finish();
				break;

			default:
				break;
			}
		}
	};
}
