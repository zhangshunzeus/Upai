package com.jiangkaiquan.massge.fragment;

import com.jiangkaiquan.adpter.CompetitionAdpter;
import com.jiangkiaquan.message.activity.Message;
import com.ushooting.activity.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * 热门赛事的fragment
 * 
 * @author jkqme
 * 
 */
public class Competition extends Fragment {
	private ListView listView;
	private CompetitionAdpter adpter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.jiang_competition, null);
		loadView(view);
		loadTitle(view);
		// TODO Auto-generated method stub
		return view;
	}

	private void loadView(View v) {
		listView = (ListView) v.findViewById(R.id.competition_lv);
		adpter = new CompetitionAdpter(null, getActivity());
		listView.setAdapter(adpter);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	/**
	 * 顶部加载
	 * 
	 * @param view
	 */
	private void loadTitle(View view) {
		Dynamic dynamic = (Dynamic) getParentFragment();
		TextView title = (TextView) view.findViewById(R.id.message_title_tx);
		title.setText("摄集");
		ImageView back = (ImageView) view.findViewById(R.id.message_back_bt);
		back.setOnClickListener(dynamic.listener);
	}
}
