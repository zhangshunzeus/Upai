package com.jiangkaiquan.massge.fragment;

import java.lang.reflect.Field;

import com.ushooting.activity.FragmentMainActivity;
import com.ushooting.activity.R;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.accessibility.AccessibilityEvent;

/**
 * 动态框架 ,不包含标题栏
 * 
 * @author jkqme
 * 
 */
public class Dynamic extends Fragment {
	private FragmentMainActivity activity;
	// private LinearLayout layout;
	private FragmentManager manager;
	private FragmentTransaction transaction;

	private HotRecomend recomend;// 推荐
	private More more;// 跟多
	private Competition competition;// 比赛
	private Fragment crrentDisplay;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.jiang_daynamic, container, false);
		loadView(view);
		return view;
	}

	private void loadView(View view) {
		if (manager == null) {
			manager = getChildFragmentManager();
			transaction = manager.beginTransaction();
			transaction.add(R.id.daynamic_linear, recomend);
			transaction.add(R.id.daynamic_linear, more);
			transaction.add(R.id.daynamic_linear, competition);

			transaction.show(recomend);
			transaction.commit();
			crrentDisplay = recomend;
		}

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		activity = (FragmentMainActivity) getActivity();
		recomend = new HotRecomend();
		more = new More();
		competition = new Competition();
	}

	@Override
	// 重置fragmentChrild
	public void onDetach() {
		super.onDetach();
		try {
			// 参数是固定写法
			Field childFragmentManager = Fragment.class
					.getDeclaredField("mChildFragmentManager");
			childFragmentManager.setAccessible(true);
			childFragmentManager.set(this, null);
		} catch (NoSuchFieldException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 
	 * @param a
	 *            显示的fragment 0 recomend 1 more 2competition
	 */
	public void showFragment(int a) {
		switch (a) {
		case 0:
			showFragment(recomend);
			activity.setSlip(false);
			break;
		case 1:
			showFragment(more);
			activity.setSlip(false);
			break;
		case 2:
			showFragment(competition);
			activity.setSlip(true);
			break;

		default:
			break;
		}
	}

	/**
	 * 显示fragment
	 * 
	 * @param fragment
	 */
	private void showFragment(Fragment fragment) {

		if (crrentDisplay.hashCode() != fragment.hashCode()) {
			transaction = manager.beginTransaction();
			transaction.hide(recomend).hide(competition).hide(more);
			// transaction.hide(crrentDisplay);
			transaction.show(fragment);
			transaction.commit();
			crrentDisplay = fragment;
		}
		// 切换底部
		if (crrentDisplay.hashCode() != competition.hashCode()) {
			activity.swichBttom(true);
		} else {
			activity.swichBttom(false);
		}
	}

	/**
	 * 公共监听
	 */
	public OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.message_more_tx:
				showFragment(more);
				break;
			case R.id.message_back_bt:
				onBack();
				break;

			default:
				break;
			}
		}
	};

	/**
	 * 
	 */
	public void onBack() {
		int i = crrentDisplay.hashCode();
		if (i != recomend.hashCode()) {
			showFragment(recomend);
			activity.setSlip(false);
		}
	}

	/**
	 * 接收带有页面跳转的broadcast
	 */
	public BroadcastReceiver receiver = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			if (intent.getAction().equals("sss")) {
				int a = intent.getExtras().getInt("fragment");
				Log.i("Broadcast", "   " + a);
				showFragment(a);
			}
		}
	};

}
