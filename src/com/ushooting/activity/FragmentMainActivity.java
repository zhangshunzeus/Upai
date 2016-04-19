package com.ushooting.activity;

import com.jiangkaiquan.massge.fragment.Dynamic;
import com.jiangkaiquan.massge.fragment.HotRecomend;
import com.jiangkaiquan.massge.fragment.Messages;
import com.jiangkaiquan.view.MyViewPager;
import com.jiangkiaquan.message.activity.Message;

import java.util.ArrayList;

import com.example.ruanjiawei.adapter.ViewPagerAdapter;
import com.ushooting.fragment.CompetitionFragment;
import com.ushooting.fragment.HomePageFragment;
import com.ushooting.fragment.LoginFragment;
import com.ushooting.fragment.MessagePageFragment;
import com.ushooting.fragment.UPCustomizationMainFragment;

import android.R.integer;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
@SuppressLint("NewApi")
public class FragmentMainActivity extends FragmentActivity {
	private boolean slip = false;// 消耗事件
	RadioGroup radioGroup;
	RadioButton tv_home_page, tv_dynamic, tv_custom, tv_message, tv_my;
	ArrayList<Fragment> fragmentList;

	ViewPagerAdapter adapter;
	private Object transaction;
	private FragmentManager manager;
	private Fragment[] myfragment;
	private LinearLayout layout;

	MyViewPager viewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_fagment_main);
		layout = (LinearLayout) findViewById(R.id.bottom_of_menue_linear);

		myfragment = new Fragment[5];
		manager = getSupportFragmentManager();

		viewPager = (MyViewPager) findViewById(R.id.fragment_activity_viewpager);
		setFragmentIndicator();

	}

	Dynamic dynamic;
	Messages messages;

	private void setFragmentIndicator() {
		// TODO Auto-generated method stub
		radioGroup = (RadioGroup) findViewById(R.id.radio_group);
		tv_home_page = (RadioButton) findViewById(R.id.tv_home_page);
		tv_dynamic = (RadioButton) findViewById(R.id.tv_dynamic);
		tv_custom = (RadioButton) findViewById(R.id.tv_custom);
		tv_message = (RadioButton) findViewById(R.id.tv_message);
		tv_my = (RadioButton) findViewById(R.id.tv_my);
		// frament初始化
		dynamic = new Dynamic();
		HomePageFragment homePageFragment = new HomePageFragment();
		LoginFragment loginFragment = new LoginFragment();
		messages = new Messages();
		UPCustomizationMainFragment customizationMainFragment = new UPCustomizationMainFragment();
		// 添加
		fragmentList = new ArrayList<Fragment>();
		fragmentList.add(homePageFragment);
		fragmentList.add(dynamic);
		fragmentList.add(customizationMainFragment);
		fragmentList.add(messages);
		fragmentList.add(loginFragment);
		adapter = new ViewPagerAdapter(getSupportFragmentManager(),
				fragmentList);
		viewPager.setAdapter(adapter);
		viewPager.setOnPageChangeListener(changeListener);// 滑动改变底部菜单变化
		radioGroup.setOnCheckedChangeListener(listener);
		register();
	}

	@SuppressLint("NewApi")
	OnPageChangeListener changeListener = new OnPageChangeListener() {

		@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
		@SuppressLint("NewApi")
		@Override
		public void onPageSelected(int position) {
			// TODO Auto-generated method stub
			switch (position) {
			case 0:
				tv_home_page.setCompoundDrawablesRelativeWithIntrinsicBounds(
						null,
						getResources().getDrawable(
								R.drawable.home_page_btn_change), null, null);
				tv_dynamic.setCompoundDrawablesRelativeWithIntrinsicBounds(
						null, getResources().getDrawable(R.drawable.dynamic),
						null, null);
				tv_custom.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
						getResources().getDrawable(R.drawable.custom), null,
						null);
				tv_message.setCompoundDrawablesRelativeWithIntrinsicBounds(
						null, getResources().getDrawable(R.drawable.message),
						null, null);
				tv_my.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
						getResources().getDrawable(R.drawable.my), null, null);

				break;
			case 1:

				tv_home_page.setCompoundDrawablesRelativeWithIntrinsicBounds(
						null,
						getResources().getDrawable(R.drawable.home_page_btn),
						null, null);
				tv_dynamic.setCompoundDrawablesRelativeWithIntrinsicBounds(
						null,
						getResources().getDrawable(R.drawable.dynamic_change),
						null, null);
				tv_custom.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
						getResources().getDrawable(R.drawable.custom), null,
						null);
				tv_message.setCompoundDrawablesRelativeWithIntrinsicBounds(
						null, getResources().getDrawable(R.drawable.message),
						null, null);
				tv_my.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
						getResources().getDrawable(R.drawable.my), null, null);

				/*
				 * Intent intent = new Intent(FragmentMainActivity.this,
				 * Message.class); intent.putExtra("ismessage", false);
				 * startActivityForResult(intent, 1);
				 */
				break;
			case 2:
				tv_home_page.setCompoundDrawablesRelativeWithIntrinsicBounds(
						null,
						getResources().getDrawable(R.drawable.home_page_btn),
						null, null);
				tv_dynamic.setCompoundDrawablesRelativeWithIntrinsicBounds(
						null, getResources().getDrawable(R.drawable.dynamic),
						null, null);
				tv_custom.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
						getResources().getDrawable(R.drawable.custom_change),
						null, null);
				tv_message.setCompoundDrawablesRelativeWithIntrinsicBounds(
						null, getResources().getDrawable(R.drawable.message),
						null, null);
				tv_my.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
						getResources().getDrawable(R.drawable.my), null, null);
				break;
			case 3:

				tv_home_page.setCompoundDrawablesRelativeWithIntrinsicBounds(
						null,
						getResources().getDrawable(R.drawable.home_page_btn),
						null, null);
				tv_dynamic.setCompoundDrawablesRelativeWithIntrinsicBounds(
						null, getResources().getDrawable(R.drawable.dynamic),
						null, null);
				tv_custom.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
						getResources().getDrawable(R.drawable.custom), null,
						null);
				tv_message.setCompoundDrawablesRelativeWithIntrinsicBounds(
						null,
						getResources().getDrawable(R.drawable.message_change),
						null, null);
				tv_my.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
						getResources().getDrawable(R.drawable.my), null, null);

				/*
				 * Intent intent2 = new Intent(FragmentMainActivity.this,
				 * Message.class); intent2.putExtra("ismessage", true);
				 * startActivityForResult(intent2, 1);
				 */
				break;
			case 4:
				tv_home_page.setCompoundDrawablesRelativeWithIntrinsicBounds(
						null,
						getResources().getDrawable(R.drawable.home_page_btn),
						null, null);
				tv_dynamic.setCompoundDrawablesRelativeWithIntrinsicBounds(
						null, getResources().getDrawable(R.drawable.dynamic),
						null, null);
				tv_custom.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
						getResources().getDrawable(R.drawable.custom), null,
						null);
				tv_message.setCompoundDrawablesRelativeWithIntrinsicBounds(
						null, getResources().getDrawable(R.drawable.message),
						null, null);
				tv_my.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
						getResources().getDrawable(R.drawable.my_change), null,
						null);
				break;

			default:
				break;
			}
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub

		}
	};

	public OnCheckedChangeListener listener = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			// TODO Auto-generated method stub

			/*
			 * transaction = manager.beginTransaction().hide(myfragment[0])
			 * .hide(myfragment[2]).hide(myfragment[4]);
			 */

			switch (checkedId) {

			case R.id.tv_home_page:
				viewPager.setCurrentItem(0);
				break;
			case R.id.tv_dynamic:
				viewPager.setCurrentItem(1);
				break;
			case R.id.tv_custom:
				viewPager.setCurrentItem(2);
				break;
			case R.id.tv_message:
				viewPager.setCurrentItem(3);
				break;
			case R.id.tv_my:
				viewPager.setCurrentItem(4);
				break;
			default:
				break;
			}
		}
	};

	/**
	 * 获取message 页面的返回数据，并决定显示的frament
	 */
	@SuppressWarnings("unused")
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == 2) {
			int a = data.getBundleExtra("home").getInt("home");
			transaction = manager.beginTransaction().hide(myfragment[0])
					.hide(myfragment[2]).hide(myfragment[4]);
			viewPager.setCurrentItem(a);
		}
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

		viewPager.setSlip(a);
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
		int i = viewPager.getCurrentItem();
		if (keyCode == event.KEYCODE_BACK) {
			switch (i) {
			case 1:
				dynamic.onBack();
				break;
			case 3:
				messages.onBack();
				break;

			default:
				break;
			}

			return true;
		}
		return super.onKeyDown(keyCode, event);

	}
}
