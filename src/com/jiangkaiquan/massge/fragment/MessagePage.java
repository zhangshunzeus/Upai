package com.jiangkaiquan.massge.fragment;

import com.jiangkiaquan.message.activity.Message;
import com.ushooting.activity.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 消息首页
 * 
 * @author jkqme
 * 
 */
public class MessagePage extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.jiang_message_page, null);
		// TODO Auto-generated method stub
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
}
