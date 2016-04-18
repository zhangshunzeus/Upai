package com.ushooting.fragment;

import com.jiangkiaquan.message.activity.Message;
import com.ushooting.activity.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MessagePageFragment extends Fragment {
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
		//message = (Message) getActivity();
		//message.setTitle("消息");
	}
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Message message;
		//message = (Message) getActivity();
		//message.setTitle("消息");
	}
}

