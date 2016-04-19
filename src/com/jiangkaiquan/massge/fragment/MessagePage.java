package com.jiangkaiquan.massge.fragment;

import com.ushooting.activity.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

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
		// buttomview(view);
		loadBt(view);
		return view;
	}

	/**
	 * 加载frament内的控件
	 * 
	 * @param view
	 */
	private void loadBt(View view) {
		final Messages messages = (Messages) getParentFragment();

		OnClickListener listener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()) {
				case R.id.message_page_care_tx:

					messages.showFragment(1);
					break;
				case R.id.message_page_comment_tx:
					messages.showFragment(2);
					break;
				case R.id.message_page_sendmsg_tx:
					messages.showFragment(3);

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

	/*
	 * 加载底部button
	 */
	private void buttomview(View view) {

		radioGroup = (RadioGroup) view.findViewById(R.id.radio_group);
		tv_home_page = (RadioButton) view.findViewById(R.id.tv_home_page);
		tv_dynamic = (RadioButton) view.findViewById(R.id.tv_dynamic);
		tv_custom = (RadioButton) view.findViewById(R.id.tv_custom);
		tv_message = (RadioButton) view.findViewById(R.id.tv_message);
		tv_my = (RadioButton) view.findViewById(R.id.tv_my);

	}

	private void chageTitle() {
	}
}
