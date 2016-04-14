package com.jiangkiaquan.message.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;

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
public class Message extends Activity {
	private ImageView back;
	public TextView more;// 热门推荐。更多按钮
	private TextView title;
	private LinearLayout layout;

	private FragmentManager manager = getFragmentManager();
	private FragmentTransaction transaction;

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

		// 设置要显示的frament为首页
		if (intent.getBooleanExtra("ismessage", true)) {
			showFrament(mPage);
			isMessage = true;
		} else {
			showFrament(recomend);
			isMessage = false;
		}

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
	}

	public OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.message_back_bt:
				finish();
				break;
			case R.id.message_more_tx:

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
					showFrament(mPage);
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
	 * 设置标题
	 */
	public void setTitle(String a) {
		title.setText(a);
	}

	// 显示fragment
	private void showFrament(Fragment fragment) {
		Log.i("ShowFrament", "进入方法");
		transaction = manager.beginTransaction();
		transaction.add(R.id.message_liner, fragment);
		transaction.show(fragment);
		transaction.commit();
	}

	// 返回张顺主页 a=0,2,4
	public void finishToHompage(int a) {
		Bundle bundle = new Bundle();
		bundle.putInt("home", a);
		intent.putExtra("home", bundle);
		setResult(2, intent);
		finish();
	}
}
