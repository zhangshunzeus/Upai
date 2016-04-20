package com.example.ruanjiawei.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.ushooting.activity.R;

public class PersonalInformationActivity extends Activity {

	ImageView finishasd;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.personalinformation);
		finishasd = (ImageView) findViewById(R.id.finishasd);
		finishasd.setOnClickListener(l);
	}

	OnClickListener l = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.finishasd:
				finish();
				break;

			default:
				break;
			}
		}
	};
}
