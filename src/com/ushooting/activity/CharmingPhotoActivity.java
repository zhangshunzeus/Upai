package com.ushooting.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class CharmingPhotoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_charming_photo);
	}
	
}
