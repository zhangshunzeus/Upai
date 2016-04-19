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
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 消息框架，含标题
 * 
 * @author jkqme
 * 
 */
public class Messages extends Fragment {
	private ImageView back;
	private TextView title;
	private FragmentMainActivity activity;
	// private LinearLayout layout;
	private FragmentManager manager;
	private FragmentTransaction transaction;

	private Chat chat;// 聊天
	private Coment coment;// 评论
	private MessagePage mPage;// 消息首页
	private Sample sample;// 作品集
	private SendMessae sMessae;// 发消息
	private Fragment crrentDisplay;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.message, container, false);
		loadView(view);
		return view;
	}

	private void loadView(View view) {
		back = (ImageView) view.findViewById(R.id.message_back_bt);
		back.setOnClickListener(listener);
		title = (TextView) view.findViewById(R.id.message_title_tx);
		if (manager == null) {
			manager = getChildFragmentManager();
			transaction = manager.beginTransaction();
			transaction.add(R.id.message_liner, mPage);
			transaction.add(R.id.message_liner, chat);
			transaction.add(R.id.message_liner, coment);
			transaction.add(R.id.message_liner, sample);
			transaction.add(R.id.message_liner, sMessae);

			transaction.show(mPage);
			title.setText("消息");
			transaction.commit();
			crrentDisplay = mPage;
		}

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		activity = (FragmentMainActivity) getActivity();
		chat = new Chat();
		coment = new Coment();
		mPage = new MessagePage();
		sample = new Sample();
		sMessae = new SendMessae();

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
	 *            显示的fragment 0 mpage 1 sample 2coment 3sMessage 4chat
	 */
	public void showFragment(int a) {
		switch (a) {
		case 0:
			showFragment(mPage);
			title.setText("消息");
			activity.setSlip(false);

			break;
		case 1:
			showFragment(sample);
			title.setText("作品集");
			activity.setSlip(true);

			break;
		case 2:
			showFragment(coment);
			title.setText("评论");
			activity.setSlip(true);
			break;
		case 3:
			showFragment(sMessae);
			title.setText("私信");
			activity.setSlip(true);
			break;
		case 4:
			showFragment(chat);
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
			transaction.hide(chat).hide(mPage).hide(coment).hide(sMessae)
					.hide(sample);
			// transaction.hide(crrentDisplay);
			transaction.show(fragment);
			transaction.commit();
			crrentDisplay = fragment;

		}
		if (crrentDisplay.hashCode() == mPage.hashCode()) {
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
			case R.id.message_back_bt:
				onBack();
				break;

			default:
				break;
			}
		}
	};

	/**
	 * 后退方法
	 */
	public void onBack() {
		int i = crrentDisplay.hashCode();
		// 是消息首页不动作
		if (i == chat.hashCode()) {
			showFragment(coment);
		} else if (i != mPage.hashCode()) {
			showFragment(mPage);
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
			if (intent.getAction().equals("ss")) {
				int a = intent.getExtras().getInt("fragments");
				Log.i("Broadcast", "" + a);
				showFragment(a);
			}
		}
	};
}
