/*package com.ushooting.activity;

import java.util.ArrayList;

import com.ushooting.fragment.CompetitionFragment;
import com.ushooting.fragment.HomePageFragment;
import com.ushooting.fragment.LoginFragment;
import com.ushooting.fragment.MessagePageFragment;
import com.ushooting.fragment.UPCustomizationMainFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class FragmentMainActivity extends FragmentActivity  {

	private RadioGroup group; //这界面的radiogroup
	private FragmentManager fragmentManager; //fragment的管理者
	private android.support.v4.app.FragmentTransaction transaction; //fragment的处理者
	private ArrayList<Fragment> fragments = new ArrayList<Fragment>();
	private HomePageFragment homeFragment=new HomePageFragment(); //加载的首页板块的Fragment
	private CompetitionFragment competitionFragment=new CompetitionFragment(); //加载的热门赛事板块的Fragment
	private LoginFragment loginFragment=new LoginFragment(); //加载的登陆板块的Fragment
	private MessagePageFragment messagePageFragment=new MessagePageFragment(); //加载的消息板块的Fragment
	private UPCustomizationMainFragment uPCustomizationMainFragment=new UPCustomizationMainFragment(); //加载的定制板块的Fragment
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_fagment_main);
		
		loadFragmentIniv();
		
	}

	private void loadFragmentIniv() {
		// TODO Auto-generated method stub
		group = (RadioGroup) findViewById(R.id.radio_group);
		group.setOnCheckedChangeListener(listener);
		fragmentManager = getSupportFragmentManager();
		transaction = fragmentManager.beginTransaction();
		homeFragment = new HomePageFragment();
		
		transaction.add(R.id.fragment_main_line, homeFragment,"homeFragment");
		transaction.add(R.id.fragment_main_line, competitionFragment,"competitionFragment");
		transaction.add(R.id.fragment_main_line, loginFragment,"loginFragment");
		transaction.add(R.id.fragment_main_line, messagePageFragment,"messagePageFragment");
		transaction.add(R.id.fragment_main_line, uPCustomizationMainFragment,"uPCustomizationMainFragment");
		
		transaction.commitAllowingStateLoss();
		
	}
	
	OnCheckedChangeListener listener = new OnCheckedChangeListener() {
		
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			// TODO Auto-generated method stub
			fragmentManager = getSupportFragmentManager();
			transaction = fragmentManager.beginTransaction();
			
			if(homeFragment!=null){
				transaction.hide(homeFragment);
			}
			if(competitionFragment!=null){
				transaction.hide(competitionFragment);
			}
			if(loginFragment!=null){
				transaction.hide(loginFragment);
			}
			if(messagePageFragment!=null){
				transaction.hide(messagePageFragment);
			}
			if(uPCustomizationMainFragment!=null){
				transaction.hide(uPCustomizationMainFragment);
			}
			
			switch (checkedId) {
			case R.id.tv_home_page: //点击首页切换的Fragment
				if(homeFragment==null){
					homeFragment=new HomePageFragment();
					transaction.add(R.id.fragment_main_line, homeFragment,"homeFragment");
					
				}else{
					transaction.show(homeFragment);
				}
				break;
			}
			
		}
	};
	
}
*/