package com.jiangkaiquan.massge.fragment;

import com.example.ushooting.R;
import com.jiangkaiquan.adpter.ChatAdpter;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class Chat extends Fragment {
	private ListView listView;
	private ChatAdpter adpter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.jiang_chat, null);
		loadView(view);
		return view;

	}

	private void loadView(View v) {
		listView = (ListView) v.findViewById(R.id.chat_lv);
		adpter = new ChatAdpter(null, getActivity());
		listView.setAdapter(adpter);
	}
}
