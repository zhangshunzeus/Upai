package com.zhangwen.customization;

import com.ushooting.activity.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

//开拍预付页面
public class UPCustomizationWeddingKaiPaiPay extends Activity {
	RadioGroup checked;
	RadioButton all;// 全部付款按钮
	RadioButton first;// 首款支付按钮
	LinearLayout allShow;// 显示全部付款数据
	LinearLayout firstShow;// 显示首款支付数据
	ImageView returns;// 返回按钮

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
			Intent intent_wedding = new Intent(UPCustomizationWeddingKaiPaiPay.this, UPCustomizationWedding.class);
			startActivity(intent_wedding);
		}
	};

	OnCheckedChangeListener listener = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(RadioGroup arg0, int arg1) {
			// TODO Auto-generated method stub
			boolean check = true;
			switch (arg1) {
			case R.id.all_money_checked:
				if (check) {
					allShow.setVisibility(View.VISIBLE);
					firstShow.setVisibility(View.GONE);
				} else {

				}

				break;
			case R.id.first_money_checked:
				if (check) {
					firstShow.setVisibility(View.VISIBLE);
					allShow.setVisibility(View.GONE);
				} else {

				}

				break;

			default:
				break;
			}
		}
	};

}
