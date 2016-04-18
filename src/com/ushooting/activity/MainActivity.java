package com.ushooting.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends FragmentActivity {

	private Fragment[] mFragments;
	RadioGroup bottomRg;
	FragmentManager fragmentManager;
	FragmentTransaction fragmentTransaction;
	RadioButton tv_home_page,tv_dynamic,tv_custom,tv_message,tv_my;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main_activity);
		mFragments = new Fragment[5];
		fragmentManager = getSupportFragmentManager();
		mFragments[0] = fragmentManager.findFragmentById(R.id.fragement_home_page);
		mFragments[1] = fragmentManager.findFragmentById(R.id.fragement_competition_page);
		mFragments[2] = fragmentManager.findFragmentById(R.id.fragement_upcustomizationmain_page);
		mFragments[3] = fragmentManager.findFragmentById(R.id.fragement_message_page);
		mFragments[4] = fragmentManager.findFragmentById(R.id.fragement_login_page);
		
		fragmentTransaction = fragmentManager.beginTransaction()  
                .hide(mFragments[0]).hide(mFragments[1]).hide(mFragments[2]).hide(mFragments[3]).hide(mFragments[4]);  
        fragmentTransaction.show(mFragments[0]).commit();  
        setFragmentIndicator();  
	
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
                        .hide(mFragments[2]).hide(mFragments[3]).hide(mFragments[4]);  
                switch (checkedId) {  
                case R.id.tv_home_page:  
                    fragmentTransaction.show(mFragments[0]).commit();  
                    break;  
  
                case R.id.tv_dynamic:  
                    fragmentTransaction.show(mFragments[1]).commit();  
                    break;  
  
                case R.id.tv_custom:  
                    fragmentTransaction.show(mFragments[2]).commit();  
                    break;  
                    
                case R.id.tv_message:  
                    fragmentTransaction.show(mFragments[3]).commit();  
                    break;  
                    
                case R.id.tv_my:  
                    fragmentTransaction.show(mFragments[4]).commit();  
                    break;  
  
                default:  
                    break;  
                }  
            }  
        });  
		
	}
	
	
	
}
