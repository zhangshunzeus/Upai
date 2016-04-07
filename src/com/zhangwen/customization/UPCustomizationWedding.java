package com.zhangwen.customization;

import com.example.ushooting.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class UPCustomizationWedding extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.up_customization_wedding);
	}

}
