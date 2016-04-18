package com.ushooting.activity;

import com.jiangkiaquan.message.activity.Message;

import java.util.ArrayList;

import com.example.ruanjiawei.adapter.ViewPagerAdapter;
import com.ushooting.fragment.CompetitionFragment;
import com.ushooting.fragment.HomePageFragment;
import com.ushooting.fragment.LoginFragment;
import com.ushooting.fragment.MessagePageFragment;
import com.ushooting.fragment.UPCustomizationMainFragment;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
@SuppressLint("NewApi")
public class FragmentMainActivity extends FragmentActivity {

	RadioGroup radioGroup;
	RadioButton tv_home_page, tv_dynamic, tv_custom, tv_message, tv_my;
	ArrayList<Fragment> fragmentList;
	ViewPager viewPager;
	ViewPagerAdapter adapter;
	private Object transaction;
	private FragmentManager manager;
	private Fragment[] myfragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_fagment_main);

		myfragment = new Fragment[5];
		manager = getSupportFragmentManager();
		/*
		 * myfragment[0] = manager
		 * .findFragmentById(R.id.fragment_HomePageFragment); // myfragment[1] =
		 * // manager.findFragmentById(R.id.fragment_CompetitionFragment);
		 * myfragment[2] =
		 * manager.findFragmentById(R.id.fragment_LoginFragment); //
		 * myfragment[3] = //
		 * manager.findFragmentById(R.id.fragment_MessagePageFragment);
		 * myfragment[4] = manager
		 * .findFragmentById(R.id.fragment_UPCustomizationMainFragment);
		 * 
		 * transaction = manager.beginTransaction().hide(myfragment[0])
		 * .hide(myfragment[1]).hide(myfragment[2]).hide(myfragment[3])
		 * .hide(myfragment[4]); myfragment[0] = manager
		 * .findFragmentById(R.id.fragment_HomePageFragment);
		 * 
		 * myfragment[2] =
		 * manager.findFragmentById(R.id.fragment_LoginFragment);
		 * 
		 * myfragment[4] = manager
		 * .findFragmentById(R.id.fragment_UPCustomizationMainFragment);
		 * 
		 * transaction = manager.beginTransaction().hide(myfragment[0])
		 * .hide(myfragment[2]).hide(myfragment[4]);
		 * transaction.show(myfragment[0]).commit();
		 */

		setFragmentIndicator();
	}

	private void setFragmentIndicator() {
		// TODO Auto-generated method stub
		radioGroup = (RadioGroup) findViewById(R.id.radio_group);
		tv_home_page = (RadioButton) findViewById(R.id.tv_home_page);
		tv_dynamic = (RadioButton) findViewById(R.id.tv_dynamic);
		tv_custom = (RadioButton) findViewById(R.id.tv_custom);
		tv_message = (RadioButton) findViewById(R.id.tv_message);
		tv_my = (RadioButton) findViewById(R.id.tv_my);
		viewPager = (ViewPager) findViewById(R.id.fragment_activity_viewpager);

		CompetitionFragment competitionFragment = new CompetitionFragment();
		HomePageFragment homePageFragment = new HomePageFragment();
		LoginFragment loginFragment = new LoginFragment();
		MessagePageFragment messagePageFragment = new MessagePageFragment();
		UPCustomizationMainFragment customizationMainFragment = new UPCustomizationMainFragment();
		fragmentList = new ArrayList<Fragment>();
		fragmentList.add(homePageFragment);
		fragmentList.add(competitionFragment);
		fragmentList.add(customizationMainFragment);
		fragmentList.add(messagePageFragment);
		fragmentList.add(loginFragment);
		adapter = new ViewPagerAdapter(getSupportFragmentManager(),
				fragmentList);
		viewPager.setAdapter(adapter);
		viewPager.setOnPageChangeListener(changeListener);// 滑动改变底部菜单变化
		radioGroup.setOnCheckedChangeListener(listener);
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
				/*
				 * tv_home_page.setCompoundDrawablesRelativeWithIntrinsicBounds(
				 * null, getResources().getDrawable(R.drawable.home_page_btn),
				 * null, null);
				 * tv_dynamic.setCompoundDrawablesRelativeWithIntrinsicBounds(
				 * null, getResources().getDrawable(R.drawable.dynamic_change),
				 * null, null);
				 * tv_custom.setCompoundDrawablesRelativeWithIntrinsicBounds
				 * (null, getResources().getDrawable(R.drawable.custom), null,
				 * null);
				 * tv_message.setCompoundDrawablesRelativeWithIntrinsicBounds(
				 * null, getResources().getDrawable(R.drawable.message), null,
				 * null);
				 * tv_my.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
				 * getResources().getDrawable(R.drawable.my), null, null);
				 */
				Intent intent = new Intent(FragmentMainActivity.this,
						Message.class);
				intent.putExtra("ismessage", false);
				startActivityForResult(intent, 1);
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
				/*
				 * tv_home_page.setCompoundDrawablesRelativeWithIntrinsicBounds(
				 * null, getResources().getDrawable(R.drawable.home_page_btn),
				 * null, null);
				 * tv_dynamic.setCompoundDrawablesRelativeWithIntrinsicBounds(
				 * null, getResources().getDrawable(R.drawable.dynamic), null,
				 * null);
				 * tv_custom.setCompoundDrawablesRelativeWithIntrinsicBounds
				 * (null, getResources().getDrawable(R.drawable.custom), null,
				 * null);
				 * tv_message.setCompoundDrawablesRelativeWithIntrinsicBounds(
				 * null, getResources().getDrawable(R.drawable.message_change),
				 * null, null);
				 * tv_my.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
				 * getResources().getDrawable(R.drawable.my), null, null);
				 */
				Intent intent2 = new Intent(FragmentMainActivity.this,
						Message.class);
				intent2.putExtra("ismessage", true);
				startActivityForResult(intent2, 1);
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
				Intent intent = new Intent(FragmentMainActivity.this,
						Message.class);
				intent.putExtra("ismessage", false);
				startActivityForResult(intent, 1);
				break;
			case R.id.tv_custom:
				viewPager.setCurrentItem(2);
				break;
			case R.id.tv_message:
				Intent intent2 = new Intent(FragmentMainActivity.this,
						Message.class);
				intent2.putExtra("ismessage", true);
				startActivityForResult(intent2, 1);
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

}
