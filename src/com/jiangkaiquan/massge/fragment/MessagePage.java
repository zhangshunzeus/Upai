package com.jiangkaiquan.massge.fragment;

import com.jiangkiaquan.message.activity.Message;
import com.ushooting.activity.FragmentMainActivity;
import com.ushooting.activity.R;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

/**
 * 消息首页
 * 
 * @author jkqme
 * 
 */
public class MessagePage extends Fragment {
	RadioGroup radioGroup;
	RadioButton tv_home_page, tv_dynamic, tv_custom, tv_message, tv_my;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.jiang_message_page, null);
		// TODO Auto-generated method stub
		buttomview(view);
		return view;
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
		super.onResume();
		Message message;
		message = (Message) getActivity();
		message.setTitle("消息");
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

}
