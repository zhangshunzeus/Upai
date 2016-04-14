package com.ushooting.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class FragmentMainActivity extends Activity  {

	RadioGroup radioGroup;
	RadioButton tv_home_page,tv_dynamic,tv_custom,tv_message,tv_my;
	Fragment[] myfragment;
	FragmentTransaction transaction;
	FragmentManager manager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_fagment_main);
		
		myfragment = new Fragment[5];
		manager = getFragmentManager();
		myfragment[0] = manager.findFragmentById(R.id.fragment_HomePageFragment);
		myfragment[1] = manager.findFragmentById(R.id.fragment_CompetitionFragment);
		myfragment[2] = manager.findFragmentById(R.id.fragment_LoginFragment);
		myfragment[3] = manager.findFragmentById(R.id.fragment_MessagePageFragment);
		myfragment[4] = manager.findFragmentById(R.id.fragment_UPCustomizationMainFragment);
		
		transaction = manager.beginTransaction().hide(myfragment[0]).hide(myfragment[1]).hide(myfragment[2]).hide(myfragment[3]).hide(myfragment[4]);
		transaction.show(myfragment[0]).commit();
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
		radioGroup.setOnCheckedChangeListener(listener);
	}
	
	OnCheckedChangeListener listener = new OnCheckedChangeListener() {
		
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			// TODO Auto-generated method stub
			transaction = manager.beginTransaction().hide(myfragment[0]).hide(myfragment[1]).hide(myfragment[2]).hide(myfragment[3]).hide(myfragment[4]);
			switch (checkedId) {

			case R.id.tv_home_page:
				transaction.show(myfragment[0]).commit();
				break;
			case R.id.tv_dynamic:
				transaction.show(myfragment[1]).commit();
				break;
			case R.id.tv_custom:
				transaction.show(myfragment[2]).commit();
				break;
			case R.id.tv_message:
				transaction.show(myfragment[3]).commit();
				break;
			case R.id.tv_my:
				transaction.show(myfragment[4]).commit();
				break;
			default:
				break;
			}
		}
	};
	
}
