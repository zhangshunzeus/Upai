package com.jiangkaiquan.adpter;

import java.util.ArrayList;
import java.util.HashMap;

import com.ushooting.activity.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class MoreAdpter extends BaseAdapter {
	private ArrayList<HashMap<String, Object>> list;
	private Context context;
	private LayoutInflater inflater;

	private MoreAdpter() {
	}

	public MoreAdpter(ArrayList<HashMap<String, Object>> list, Context context) {
		this.list = list;
		this.context = context;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 10;
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
		if(convertView==null){
			convertView=inflater.inflate(R.layout.jiang_lv_more,null);
		}
		return convertView;
	}

}
