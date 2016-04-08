package com.example.ruanjiawei.activity;

import com.ushooting.activity.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class EquipmentActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.equipment);
		
	}
}
