package com.jiangkaiquan.massge.fragment;

import com.ushooting.activity.R;
import com.jiangkaiquan.adpter.SendMessageAdpter;
import com.jiangkiaquan.message.activity.Message;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * 私信的frament
 * 
 * @author jkqme
 * 
 */
public class SendMessae extends Fragment {
	private SendMessageAdpter adpter;
	private ListView listView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.jiang_send_message, null);
		// TODO Auto-generated method stub
		loadView(view);
		return view;
	}

	/**
	 * 加载listview 试图
	 * 
	 * @param v
	 */
	private void loadView(View v) {
		listView = (ListView) v.findViewById(R.id.send_message_lv);
		adpter = new SendMessageAdpter(null, getActivity());
		listView.setAdapter(adpter);
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		super.onCreate(savedInstanceState);
		Message message;
		message = (Message) getActivity();
		message.setTitle("私信");
	}
}
