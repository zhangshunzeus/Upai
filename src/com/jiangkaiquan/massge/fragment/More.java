package com.jiangkaiquan.massge.fragment;

import com.jiangkaiquan.adpter.MoreAdpter;
import com.jiangkiaquan.message.activity.Message;
import com.ushooting.activity.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class More extends Fragment {
	private ListView listView;
	private MoreAdpter adpter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.jiang_more, null);
		loadView(view);
		return view;
	}

	private void loadView(View v) {
		listView = (ListView) v.findViewById(R.id.more_lv);
		adpter = new MoreAdpter(null,getActivity());
		listView.setAdapter(adpter);
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		super.onCreate(savedInstanceState);
		Message message;
		message = (Message) getActivity();
		message.setTitle("更多");
	}
}
