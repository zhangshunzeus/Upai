package com.jiangkaiquan.massge.fragment;

import com.jiangkiaquan.message.activity.Message;
import com.ushooting.activity.FragmentMainActivity;
import com.ushooting.activity.R;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

/**
 * 消息首页
 * 
 * @author jkqme
 * 
 */
public class MessagePage extends Fragment {
	RadioGroup radioGroup;
	RadioButton tv_home_page, tv_dynamic, tv_custom, tv_message, tv_my;
	private TextView care, comment, sendmsg;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.jiang_message_page, null);
		// TODO Auto-generated method stub
		buttomview(view);
		loadBt(view);
		return view;
	}

	/**
	 * 加载frament内的控件
	 * 
	 * @param view
	 */
	private void loadBt(View view) {
		final Message message = (Message) getActivity();
		OnClickListener listener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()) {
				case R.id.message_page_care_tx:
					message.showFragmentByName("sameple");
					break;
				case R.id.message_page_comment_tx:
					message.showFragmentByName("comment");
					break;
				case R.id.message_page_sendmsg_tx:
					message.showFragmentByName("sendMessage");
					break;

				default:
					break;
				}
			}
		};
		care = (TextView) view.findViewById(R.id.message_page_care_tx);
		comment = (TextView) view.findViewById(R.id.message_page_comment_tx);
		sendmsg = (TextView) view.findViewById(R.id.message_page_sendmsg_tx);
		care.setOnClickListener(listener);
		comment.setOnClickListener(listener);
		sendmsg.setOnClickListener(listener);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		super.onCreate(savedInstanceState);
		Message message;
		message = (Message) getActivity();
		message.setTitle("消息");
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		Message message;
		message = (Message) getActivity();
		Log.i("MessagePage", "onResume");
		message.setTitle("消息");
		super.onResume();
		
	}
	
	/*
	 * 加载底部button
	 */
	private void buttomview(View view) {
		Message message = (Message) getActivity();
		radioGroup = (RadioGroup) view.findViewById(R.id.radio_group);
		tv_home_page = (RadioButton) view.findViewById(R.id.tv_home_page);
		tv_dynamic = (RadioButton) view.findViewById(R.id.tv_dynamic);
		tv_custom = (RadioButton) view.findViewById(R.id.tv_custom);
		tv_message = (RadioButton) view.findViewById(R.id.tv_message);
		tv_my = (RadioButton) view.findViewById(R.id.tv_my);
		radioGroup.setOnCheckedChangeListener(message.listeners);
	}
	private void chageTitle(){}
}
