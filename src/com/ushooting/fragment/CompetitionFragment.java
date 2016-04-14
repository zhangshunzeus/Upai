package com.ushooting.fragment;

import com.jiangkaiquan.adpter.CompetitionAdpter;
import com.jiangkiaquan.message.activity.Message;
import com.ushooting.activity.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class CompetitionFragment extends Fragment {

	private ListView listView;
	private CompetitionAdpter adpter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.jiang_competition, null);
		loadView(view);
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
		Message message;
		message = (Message) getActivity();
		message.setTitle("摄集");
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Message message;
		message = (Message) getActivity();

		message.setTitle("热门推荐");
	}
}
