package com.jiangkaiquan.adpter;

import java.util.ArrayList;
import java.util.HashMap;

import com.ushooting.activity.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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
		Holder holder;
		if(convertView==null){
			convertView=inflater.inflate(R.layout.jiang_lv_more,null);
			holder=new Holder();
			holder.moreimg=(ImageView)convertView.findViewById(R.id.lv_more_img);
			holder.carimg=(ImageView)convertView.findViewById(R.id.lv_care_img);
			holder.more_name=(TextView)convertView.findViewById(R.id.lv_more_name_tx);
			holder.more_age=(TextView)convertView.findViewById(R.id.lv_more_age_tx);
			holder.more_upload=(TextView)convertView.findViewById(R.id.lv_more_upload_tx);
			holder.more_care=(TextView)convertView.findViewById(R.id.lv_more_care_tx);
			convertView.setTag(convertView);
		}
		return convertView;
	}
	class Holder{
		ImageView moreimg;
		ImageView carimg;
		TextView more_name;
		TextView more_age;
		TextView more_upload;
		TextView more_care;
		
	}
}
