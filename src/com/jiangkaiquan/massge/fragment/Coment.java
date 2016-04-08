package com.jiangkaiquan.massge.fragment;

import com.ushooting.activity.R;
import com.jiangkaiquan.adpter.ComentAdpter;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * 评论页面的frament
 * 
 * @author jkqme
 * 
 */
public class Coment extends Fragment {
	private ListView listView;
	private ComentAdpter adpter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.jiang_coment, null);
		loadView(view);
		return view;
	}

	/**
	 * 加载试图
	 * 
	 * @param v
	 */
	private void loadView(View v) {
		listView = (ListView) v.findViewById(R.id.coment_lv);
		adpter = new ComentAdpter(null, getActivity());
		listView.setAdapter(adpter);
	}
}
