package com.jiangkiaquan.message.activity;

import android.app.Activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.ushooting.activity.FragmentMainActivity;
import com.ushooting.activity.R;

import com.jiangkaiquan.massge.fragment.Chat;
import com.jiangkaiquan.massge.fragment.Coment;
import com.jiangkaiquan.massge.fragment.Competition;
import com.jiangkaiquan.massge.fragment.HotRecomend;
import com.jiangkaiquan.massge.fragment.MessagePage;
import com.jiangkaiquan.massge.fragment.More;
import com.jiangkaiquan.massge.fragment.Sample;
import com.jiangkaiquan.massge.fragment.SendMessae;

/**
 * 消息的类,结构为activity 包含大的frament
 * 
 * @author jkqme ismessage
 */
public class Message extends FragmentMainActivity {
	private ImageView back;
	public TextView more;// 热门推荐。更多按钮
	private TextView title;
	private LinearLayout layout;

	private FragmentManager manager = getSupportFragmentManager();
	private FragmentTransaction transaction = manager.beginTransaction();

	private Sample sample;// 作品集的frament
	private MessagePage mPage;// 消息首页的fragemtn
	private SendMessae sendMessae;// 私信的fragemtn;
	private Coment coment;// 评论的frament
	private Chat chat;// 聊天的frament;

	private HotRecomend recomend;// 推荐的fragment
	private More moreframent;// 跟多的framgment
	private Competition competition;// 热门赛事
	private Intent intent;
	// 判断当前显示是否为消息也
	private boolean isMessage;
	private Fragment courrentFragment;// 当前显示的frament

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.message);

		back = (ImageView) findViewById(R.id.message_back_bt);
		title = (TextView) findViewById(R.id.message_title_tx);
		layout = (LinearLayout) findViewById(R.id.message_liner);
		more = (TextView) findViewById(R.id.message_more_tx);

		back.setOnClickListener(listener);
		more.setOnClickListener(listener);

		intent = getIntent();
		loadFrament();
		courrentFragment = chat;
		// 设置要显示的frament为首页

		register();
		// ViewFlipper flipper=
	}

	/**
	 * 加载frament
	 */
	private void loadFrament() {
		sample = new Sample();

		mPage = new MessagePage();
		sendMessae = new SendMessae();
		coment = new Coment();
		chat = new Chat();
		recomend = new HotRecomend();
		moreframent = new More();
		competition = new Competition();

		transaction.add(R.id.message_liner, sample);
		transaction.add(R.id.message_liner, mPage);
		transaction.add(R.id.message_liner, sendMessae);
		transaction.add(R.id.message_liner, coment);
		transaction.add(R.id.message_liner, chat);
		transaction.add(R.id.message_liner, recomend);
		transaction.add(R.id.message_liner, moreframent);
		transaction.add(R.id.message_liner, competition);

	}

	public OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.message_back_bt:
				onBackDown();
				break;
			case R.id.message_more_tx:
				showFrament(moreframent);
				break;

			default:
				break;

			}
		}
	};
	/**
	 * 底部btton 的监听
	 */
	public OnCheckedChangeListener listeners = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			// TODO Auto-generated method stub

			switch (checkedId) {
			case R.id.tv_home_page:
				finishToHompage(0);
				break;
			case R.id.tv_custom:
				finishToHompage(2);
				break;
			case R.id.tv_my:
				finishToHompage(4);
				break;
			// 跳转到message页面
			case R.id.tv_dynamic:
				if (isMessage) {
					showFrament(recomend);
					isMessage = false;
				}
				break;
			case R.id.tv_message:
				if (!isMessage) {
					showFrament(mPage);
					isMessage = true;
				}

			default:
				break;

			}
		}
	};

	/**
	 * 设置标题 frament调用
	 */
	public void setTitle(String a) {
		title.setText(a);
	}

	// 显示fragment
	private void showFrament(Fragment fragment) {

		Log.i("ShowFrament", "进入方法");
		// 如果当前显示的和需要显示的一样
		if (courrentFragment.hashCode() == fragment.hashCode()) {
			return;
		}
		transaction = manager.beginTransaction();

		transaction.hide(courrentFragment);
		transaction.add(R.id.message_liner, fragment);
		transaction.show(fragment);
		transaction.commit();
		courrentFragment = fragment;
	}

	public void showFragmentByName(String name) {
		switch (name) {
		case "sameple":
			showFrament(sample);
			break;
		case "mPage":
			showFrament(mPage);
			break;
		case "sendMessage":
			showFrament(sendMessae);
			break;
		case "comment":
			showFrament(coment);
			break;
		case "chat":
			showFrament(chat);
			break;
		case "recomed":
			showFrament(recomend);
			break;
		case "morframent":
			showFrament(moreframent);
			break;
		case "comptition":
			showFrament(competition);
			break;

		default:
			Toast.makeText(this, "页面不存在", 1000).show();
			break;
		}
	}

	/**
	 * 接收带有页面跳转的broadcast
	 */
	private BroadcastReceiver receiver = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			if (intent.getAction().equals("sss")) {
				String string = intent.getExtras().getString("fragment");
				Log.i("Broadcast", string);
				showFragmentByName(string);
			}
		}
	};

	// 注册广播
	private void register() {
		IntentFilter filter = new IntentFilter("sss");
		registerReceiver(receiver, filter);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		try {
			unregisterReceiver(receiver);
		} catch (Exception e) {
		}
		super.onPause();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		try {
			unregisterReceiver(receiver);
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

	// 返回张顺主页 a=0,2,4
	public void finishToHompage(int a) {
		Bundle bundle = new Bundle();
		bundle.putInt("home", a);
		intent.putExtra("home", bundle);
		setResult(2, intent);
		finish();
	}

	// back键拦截
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == event.KEYCODE_BACK) {
			onBackDown();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	/*
	 * 当按back键时的响应
	 */
	private void onBackDown() {
		int i = courrentFragment.hashCode();
		if (i == sample.hashCode()) {
			showFrament(mPage);
		} else if (i == mPage.hashCode()) {
			if (!isMessage) {
				showFrament(recomend);
			} else {
				finish();
			}
		} else if (i == sendMessae.hashCode()) {
			showFrament(mPage);
		} else if (i == coment.hashCode()) {
			showFrament(mPage);
		} else if (i == chat.hashCode()) {
			showFrament(sendMessae);
		} else if (i == recomend.hashCode()) {
			if (isMessage) {
				showFrament(mPage);
			} else {
				finish();
			}
		} else if (i == competition.hashCode()) {
			showFrament(recomend);
		} else if (i == moreframent.hashCode()) {
			showFrament(recomend);
		}
	}
}
