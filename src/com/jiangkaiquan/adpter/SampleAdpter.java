package com.jiangkaiquan.adpter;

import java.util.ArrayList;
import java.util.HashMap;

import com.ushooting.activity.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * 处理SampleFramgent的adpter
 * 
 * @author jkqme
 * 
 */
public class SampleAdpter extends BaseAdapter {
	private ArrayList<HashMap<String, Object>> list;
	private LayoutInflater inflater;
	private Context context;

	public SampleAdpter() {
	}

	public SampleAdpter(ArrayList<HashMap<String, Object>> list,

	Context context) {
		this.list = list;
		this.context = context;
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View view = null;
		if (convertView == null) {
			view = inflater.inflate(R.layout.jiang_smple_item, null);
			return view;
		}
		return convertView;
	}

}
