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

public class ComentAdpter extends BaseAdapter {
	private ArrayList<HashMap<String, Object>> list;
	private Context context;
	private LayoutInflater inflater;

	private ComentAdpter() {
	}

	public ComentAdpter(ArrayList<HashMap<String, Object>> list, Context context) {
		this.list = list;
		this.context = context;
		this.inflater = LayoutInflater.from(context);
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
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.jiang_lv_coment, null);
		Holder holder=new Holder();
		holder.coment=(ImageView)convertView.findViewById(R.id.lv_coment_img);
		holder.coment_name=(TextView)convertView.findViewById(R.id.lv_coment_name_tx);
		holder.coment_personality=(TextView)convertView.findViewById(R.id.lv_coment_personality_tx);
		
		holder.coment_time=(TextView)convertView.findViewById(R.id.lv_coment_time_tx);
		convertView.setTag(holder);
		}
		return convertView;
	}
  class Holder{
	  ImageView coment;
	  TextView coment_name;
	  TextView coment_personality;
	  TextView coment_time;
  }
}
