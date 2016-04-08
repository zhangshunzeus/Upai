package com.jiangkaiquan.massge.fragment;

import com.ushooting.activity.R;
import com.jiangkaiquan.adpter.SampleAdpter;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * 作品集的fragment,主要元素listView
 * 
 * @author jkqme
 * 
 */
public class Sample extends Fragment {
	private ListView lView;
	private SampleAdpter adpter;

	public Sample() {
		super();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view;
		view = inflater.inflate(R.layout.sample, null);
		loadVary();
		lView = (ListView) view.findViewById(R.id.sample_lv);
		lView.setAdapter(adpter);
		return view;
	}
	
	private void loadVary() {
		adpter = new SampleAdpter(null, getActivity());
	}
}
