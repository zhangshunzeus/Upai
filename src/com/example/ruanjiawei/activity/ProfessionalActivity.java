package com.example.ruanjiawei.activity;

import com.ushooting.activity.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class ProfessionalActivity extends Activity {

	ImageView iv_return;
	RelativeLayout equipment;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.professional);

		iv_return = (ImageView) findViewById(R.id.iv_return);
		iv_return.setOnClickListener(l);
		equipment = (RelativeLayout) findViewById(R.id.equipment);
		equipment.setOnClickListener(l);

	}

	OnClickListener l = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.iv_return:
				finish();
				break;

			case R.id.equipment:
				Intent intenet = new Intent(ProfessionalActivity.this,
						EquipmentActivity.class);
				startActivity(intenet);
				break;

			default:
				break;
			}
		}
	};

}
