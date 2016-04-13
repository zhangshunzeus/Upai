package com.zhangwen.customization;

import com.ushooting.activity.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class UPCustomizationWeddingKaiPaiPay extends Activity {
	RadioGroup checked;
	RadioButton all;
	RadioButton first;
	LinearLayout allShow;
	LinearLayout firstShow;
	ImageView returns;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.up_customization_wedding_kaipai_payfor);
		checked = (RadioGroup) findViewById(R.id.radio_kaipai);
		checked.setOnCheckedChangeListener(listener);
		all = (RadioButton) findViewById(R.id.all_money_checked);
		first = (RadioButton) findViewById(R.id.first_money_checked);
		allShow = (LinearLayout) findViewById(R.id.all_money);
		firstShow = (LinearLayout) findViewById(R.id.first_paymoney);
		returns = (ImageView) findViewById(R.id.return_finish);
		returns.setOnClickListener(fish);

	}

	OnClickListener fish = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			finish();
		}
	};

	OnCheckedChangeListener listener = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(RadioGroup arg0, int arg1) {
			// TODO Auto-generated method stub
			switch (arg1) {
			case R.id.all_money_checked:
				allShow.setVisibility(View.VISIBLE);
				firstShow.setVisibility(View.GONE);
				break;
			case R.id.first_money_checked:
				allShow.setVisibility(View.GONE);
				firstShow.setVisibility(View.VISIBLE);
				break;

			default:
				break;
			}
		}
	};

}
