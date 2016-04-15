package com.jiangkaiquan.massge.fragment;

import com.jiangkaiquan.adpter.HotRecoendAdpter;
import com.jiangkiaquan.message.activity.Message;
import com.ushooting.activity.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * 热门推荐的frament
 * 
 * @author jkqme
 * 
 */
public class HotRecomend extends Fragment {
	private Message message;
	private ListView listView;
	private HotRecoendAdpter adpter;

	RadioGroup radioGroup;
	RadioButton tv_home_page, tv_dynamic, tv_custom, tv_message, tv_my;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.jiang_hot_recomend, null);
		loadView(view);
		buttomview(view);
		return view;
	}

	/**
	 * 加载试图
	 * 
	 * @param v
	 */
	private void loadView(View v) {
		listView = (ListView) v.findViewById(R.id.hot_recoment_lv);
		adpter = new HotRecoendAdpter(null, message);
		listView.setAdapter(adpter);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		message = (Message) getActivity();
		// 显示更多按钮
		message.more.setVisibility(View.VISIBLE);
		message.setTitle("热门推荐");
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub

		message.more.setVisibility(View.INVISIBLE);
		super.onPause();
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub

		message.more.setVisibility(View.VISIBLE);
		message.setTitle("热门推荐");
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

}
