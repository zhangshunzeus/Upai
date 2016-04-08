package com.zhangwen.customization;

import com.ushooting.activity.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class UPCustomizationMain extends Activity {
	ImageView imageThemeCheck;
	ImageView imageOrderCheck;
	RelativeLayout themeCheck;
	RelativeLayout orderCheck;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.up_customization_main);
		imageThemeCheck = (ImageView) findViewById(R.id.customization_theme_background);
		imageThemeCheck.setOnClickListener(themes);
		imageOrderCheck = (ImageView) findViewById(R.id.customization_order_background);
		imageOrderCheck.setOnClickListener(orders);
		
		themeCheck=(RelativeLayout)findViewById(R.id.selector_theme);
		themeCheck.setOnClickListener(themes);
		orderCheck=(RelativeLayout)findViewById(R.id.selector_order);
		orderCheck.setOnClickListener(orders);
	}

	OnClickListener themes = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			boolean checked = true;

			if (checked) {
				imageThemeCheck.setVisibility(View.VISIBLE);
			} else {
				imageThemeCheck.setVisibility(View.GONE);
			}

		}
	};
	OnClickListener orders = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			boolean checked = true;

			if (checked) {
				imageOrderCheck.setVisibility(View.VISIBLE);
			} else {
				imageOrderCheck.setVisibility(View.GONE);
			}
			Intent intent=new Intent(UPCustomizationMain.this,UPCustomizationOrder.class);
			startActivity(intent);
		}

	};

}
