package com.ushooting.adapter;

import java.util.ArrayList;

import com.ushooting.activity.R;
import com.ushooting.demo.LandscapeArchitectureDemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LandscapeArchitectureAdapter extends BaseAdapter {

	Context context;
	ArrayList<LandscapeArchitectureDemo> list;
	LayoutInflater mInflater;
	LandscapeArchitectureAdapter mAdapter;
	
	public LandscapeArchitectureAdapter(Context context,ArrayList<LandscapeArchitectureDemo>list) {
		// TODO Auto-generated constructor stub
		this.context=context;
		this.list=list;
		mInflater=LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder viewHolder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_landscape_architecture, null);
			viewHolder = new ViewHolder();
			viewHolder.iv_bg = (ImageView) convertView.findViewById(R.id.iv_bg);
			viewHolder.iv_bg_transparent = (ImageView) convertView.findViewById(R.id.iv_bg_transparent);
			viewHolder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
			viewHolder.tv_content = (TextView) convertView.findViewById(R.id.tv_content);
			convertView.setTag(viewHolder);
		}
		viewHolder = (ViewHolder) convertView.getTag();
		LandscapeArchitectureDemo landscapeArchitectureDemo = (LandscapeArchitectureDemo) getItem(position);
		landscapeArchitectureDemo.setIv_bg(landscapeArchitectureDemo.getIv_bg());
		landscapeArchitectureDemo.setIv_bg_transparent(landscapeArchitectureDemo.getIv_bg_transparent());
		landscapeArchitectureDemo.setTv_title(landscapeArchitectureDemo.getTv_title());
		landscapeArchitectureDemo.setTv_content(landscapeArchitectureDemo.getTv_content());
		return convertView;
	}
	
	public class ViewHolder{

		public TextView tv_content;
		public TextView tv_title;
		public ImageView iv_bg_transparent;
		public ImageView iv_bg;
		
	}

}
