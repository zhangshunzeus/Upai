package com.ushooting.activity;

import com.jiangkaiquan.massge.fragment.Dynamic;
import com.jiangkaiquan.massge.fragment.Messages;

import android.R.integer;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends FragmentActivity {

	LinearLayout layout;
	int curentDisplay;
	Dynamic dynamic;
	Messages messages;

	private Fragment[] mFragments;
	RadioGroup bottomRg;
	FragmentManager fragmentManager;
	FragmentTransaction fragmentTransaction;
	RadioButton tv_home_page, tv_dynamic, tv_custom, tv_message, tv_my;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main_activity);
		mFragments = new Fragment[5];
		fragmentManager = getSupportFragmentManager();
		mFragments[0] = fragmentManager
				.findFragmentById(R.id.fragement_home_page);
		mFragments[1] = fragmentManager
				.findFragmentById(R.id.fragement_competition_page);
		mFragments[2] = fragmentManager
				.findFragmentById(R.id.fragement_upcustomizationmain_page);
		mFragments[3] = fragmentManager
				.findFragmentById(R.id.fragement_message_page);
		mFragments[4] = fragmentManager
				.findFragmentById(R.id.fragement_login_page);

		fragmentTransaction = fragmentManager.beginTransaction()
				.hide(mFragments[0]).hide(mFragments[1]).hide(mFragments[2])
				.hide(mFragments[3]).hide(mFragments[4]);
		fragmentTransaction.show(mFragments[0]).commit();
		setFragmentIndicator();

		dynamic = (Dynamic) mFragments[1];
		messages = (Messages) mFragments[3];
		curentDisplay = 1;
		layout = (LinearLayout) findViewById(R.id.bottom_of_menue_linear);
	}

	private void setFragmentIndicator() {
		// TODO Auto-generated method stub
		bottomRg = (RadioGroup) findViewById(R.id.radio_group);
		tv_home_page = (RadioButton) findViewById(R.id.tv_home_page);
		tv_dynamic = (RadioButton) findViewById(R.id.tv_dynamic);
		tv_custom = (RadioButton) findViewById(R.id.tv_custom);
		tv_message = (RadioButton) findViewById(R.id.tv_message);
		tv_my = (RadioButton) findViewById(R.id.tv_my);

		bottomRg.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				fragmentTransaction = fragmentManager.beginTransaction()
						.hide(mFragments[0]).hide(mFragments[1])
						.hide(mFragments[2]).hide(mFragments[3])
						.hide(mFragments[4]);
				switch (checkedId) {
				case R.id.tv_home_page:
					fragmentTransaction.show(mFragments[0]).commit();
					curentDisplay=0;
					break;

				case R.id.tv_dynamic:
					fragmentTransaction.show(mFragments[1]).commit();
				curentDisplay=1;
					break;

				case R.id.tv_custom:
					fragmentTransaction.show(mFragments[2]).commit();
					curentDisplay=2;
					break;

				case R.id.tv_message:
					curentDisplay=3;
					fragmentTransaction.show(mFragments[3]).commit();
					break;

				case R.id.tv_my:
					curentDisplay=4;
					fragmentTransaction.show(mFragments[4]).commit();
					break;

				default:
					break;
				}
			}
		});

	}

	/**
	 * 切换底部显示状态
	 */
	public void swichBttom(boolean canDisplay) {
		if (canDisplay) {
			// 显示
			layout.setVisibility(LinearLayout.VERTICAL);
		} else {
			layout.setVisibility(LinearLayout.GONE);
		}
	}

	/*
	 * 切换viewpager可滑动
	 */
	public void setSlip(boolean a) {

	}

	/*
	 * private void setPagerMove() { viewPager.setOnTouchListener(new
	 * OnTouchListener() {
	 * 
	 * public boolean onTouch(View v, MotionEvent event) { // TODO
	 * Auto-generated method stub // falth不消耗，true 消耗 return slip; } }); }
	 */

	// 注册广播
	private void register() {

		IntentFilter filter = new IntentFilter("sss");
		registerReceiver(dynamic.receiver, filter);
		filter = new IntentFilter("ss");
		registerReceiver(messages.receiver, filter);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		try {
			unregisterReceiver(dynamic.receiver);
			unregisterReceiver(messages.receiver);
		} catch (Exception e) {
		}
		super.onPause();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		try {
			unregisterReceiver(dynamic.receiver);
			unregisterReceiver(messages.receiver);

		} catch (Exception e) {
		}
		super.onDestroy();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub

		register();
		super.onResume();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		int i = curentDisplay;
		if (keyCode == event.KEYCODE_BACK) {
			switch (i) {
			case 1:
				if(dynamic.canClose())break;
				dynamic.onBack();
				return true;
			case 3:
				if(messages.canClose())break;
				messages.onBack();
				return true;

			default:

				break;
			}

		}
		return super.onKeyDown(keyCode, event);

	}

}
