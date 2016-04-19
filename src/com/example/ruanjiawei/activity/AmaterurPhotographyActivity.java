package com.example.ruanjiawei.activity;

import com.ushooting.activity.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class AmaterurPhotographyActivity extends Activity {

	ImageView iv_return;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.amateur_photography);

		iv_return = (ImageView) findViewById(R.id.iv_return);
		iv_return.setOnClickListener(l);

	}

	OnClickListener l = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.iv_return:
				finish();
				break;

			default:
				break;
			}
		}
	};

}
