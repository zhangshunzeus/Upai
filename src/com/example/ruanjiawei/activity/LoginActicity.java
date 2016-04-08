package com.example.ruanjiawei.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.example.ushooting.R;

public class LoginActicity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);

	}

}
