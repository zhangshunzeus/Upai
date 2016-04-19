package com.jiangkaiquan.massge.fragment;

import com.jiangkaiquan.adpter.MoreAdpter;

import com.ushooting.activity.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * 更多的frament
 * 
 * @author jkqme
 * 
 */
public class More extends Fragment {
	private ListView listView;
	private MoreAdpter adpter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.jiang_more, null);
		loadView(view);
		loadTitle(view);
		return view;
	}

	private void loadView(View v) {
		listView = (ListView) v.findViewById(R.id.more_lv);
		adpter = new MoreAdpter(null, getActivity());
		listView.setAdapter(adpter);
	}

	/**
	 * 顶部加载
	 * 
	 * @param view
	 */
	private void loadTitle(View view) {
		Dynamic dynamic = (Dynamic) getParentFragment();
		TextView title = (TextView) view.findViewById(R.id.message_title_tx);
		title.setText("更多");
		ImageView back = (ImageView) view.findViewById(R.id.message_back_bt);
		back.setOnClickListener(dynamic.listener);

	}
}
