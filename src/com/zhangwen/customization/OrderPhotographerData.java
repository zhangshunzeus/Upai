package com.zhangwen.customization;

import com.ushooting.activity.R;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class OrderPhotographerData extends Activity {
	RadioGroup group;
	RadioButton personalData;
	RadioButton works;
	RadioButton fans;
	ImageView returns;

	Fragment[] myfragment;
	FragmentTransaction transaction;
	FragmentManager manager;
	RadioGroup radioGroup;
	RadioButton btnPersonal, btnWorks, btnFans;// 5个链接fragment按钮

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.order_photographer_data);
		returns=(ImageView)findViewById(R.id.return_finish);
		returns.setOnClickListener(listener);

		// 设置需要切换的相对应fragment页面
		myfragment = new Fragment[3];
		manager = getFragmentManager();
		myfragment[0] = manager.findFragmentById(R.id.personal_data_fragment);
		myfragment[1] = manager.findFragmentById(R.id.works_data_fragment);
		myfragment[2] = manager.findFragmentById(R.id.fans_data_fragment);

		transaction = manager.beginTransaction().hide(myfragment[0]).hide(myfragment[1]).hide(myfragment[2]);
		transaction.show(myfragment[0]).commit();
		setFragmentIndicator();
	}

	public void setFragmentIndicator() {
		// 设置切换按钮的监听，对应相对的页面
		radioGroup = (RadioGroup) findViewById(R.id.data_radiogroup);
		btnPersonal = (RadioButton) findViewById(R.id.data_personal);
		btnWorks = (RadioButton) findViewById(R.id.data_works);
		btnFans = (RadioButton) findViewById(R.id.data_fans);
		radioGroup.setOnCheckedChangeListener(l);

	}
	
	OnClickListener listener=new OnClickListener(){

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
			case R.id.return_finish:
				finish();
				Intent intent_wedding = new Intent(OrderPhotographerData.this, UPCustomizationWedding.class);
				startActivity(intent_wedding);
				break;

			default:
				break;
			}
		}
	};

	OnCheckedChangeListener l = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(RadioGroup arg0, int arg1) {
			// TODO Auto-generated method stub
			transaction = manager.beginTransaction().hide(myfragment[0]).hide(myfragment[1]).hide(myfragment[2]);
			switch (arg1) {
			case R.id.data_personal:
				transaction.show(myfragment[0]).commit();
				break;
			case R.id.data_works:
				transaction.show(myfragment[1]).commit();
				break;
			case R.id.data_fans:
				transaction.show(myfragment[2]).commit();
				break;

			default:
				break;
			}
		}

	};

}
