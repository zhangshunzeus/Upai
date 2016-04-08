package com.jiangkiaquan.message.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ushooting.activity.R;

import com.jiangkaiquan.massge.fragment.Chat;
import com.jiangkaiquan.massge.fragment.Coment;
import com.jiangkaiquan.massge.fragment.MessagePage;
import com.jiangkaiquan.massge.fragment.Sample;
import com.jiangkaiquan.massge.fragment.SendMessae;

/**
 * 消息的类,结构为activity 包含大的frament
 * 
 * @author jkqme
 * 
 */
public class Message extends Activity {
	private ImageView back;
	private TextView title;
	private LinearLayout layout;

	private FragmentManager manager = getFragmentManager();
	private FragmentTransaction transaction = manager.beginTransaction();

	private Sample sample;// 作品集的frament
	private MessagePage mPage;// 消息首页的fragemtn
	private SendMessae sendMessae;// 私信的fragemtn;
	private Coment coment;// 评论的frament
	private Chat chat;//聊天的frament;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.message);

		back = (ImageView) findViewById(R.id.message_back_bt);
		title = (TextView) findViewById(R.id.message_title_tx);
		layout = (LinearLayout) findViewById(R.id.message_liner);
		back.setOnClickListener(listener);

		loadFrament();
		// 设置要显示的frament为首页
		transaction.add(R.id.message_liner,chat);
		transaction.show(chat);
		transaction.commit();
	}

	/**
	 * 加载frament
	 */
	private void loadFrament() {
		sample = new Sample();
		mPage = new MessagePage();
		sendMessae = new SendMessae();
		coment = new Coment();
		chat=new Chat();
	}

	private OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.message_back_bt:

				break;

			default:
				break;
			}
		}
	};
}
