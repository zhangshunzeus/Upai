package com.jiangkaiquan.massge.fragment;

import com.jiangkaiquan.adpter.HotRecoendAdpter;

import com.ushooting.activity.FragmentMainActivity;
import com.ushooting.activity.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * 热门推荐的frament
 * 
 * @author jkqme
 * 
 */
public class HotRecomend extends Fragment {
	private FragmentMainActivity message;
	private ListView listView;
	private HotRecoendAdpter adpter;

	RadioGroup radioGroup;
	RadioButton tv_home_page, tv_dynamic, tv_custom, tv_message, tv_my;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.jiang_hot_recomend,null);
		loadView(view);
		loadTitle(view);
		return view;
	}

	/**
	 * 加载试图
	 * 
	 * @param v
	 */
	private void loadView(View v) {
		listView = (ListView) v.findViewById(R.id.hot_recoment_lv);
		adpter = new HotRecoendAdpter(null,getActivity());
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
		title.setText("热门推荐");
		TextView more = (TextView) view.findViewById(R.id.message_more_tx);
		more.setVisibility(View.VISIBLE);
		ImageView back = (ImageView) view.findViewById(R.id.message_back_bt);
		back.setOnClickListener(dynamic.listener);
		more.setOnClickListener(dynamic.listener);

	}

}
