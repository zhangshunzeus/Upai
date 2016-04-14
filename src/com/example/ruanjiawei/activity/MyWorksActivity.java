package com.example.ruanjiawei.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.GridView;

import com.ushooting.activity.R;

public class MyWorksActivity extends Activity {
	
	GridView Scrollgridview;
	Button uploding;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.myworks);
	}
}
