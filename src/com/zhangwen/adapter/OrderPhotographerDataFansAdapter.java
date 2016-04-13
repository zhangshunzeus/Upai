package com.zhangwen.adapter;

import java.util.List;

import com.ushooting.activity.R;
import com.zhangwen.demo.OrderPhotographerDataFansDemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class OrderPhotographerDataFansAdapter extends BaseAdapter{
	List<OrderPhotographerDataFansDemo> data;
	Context context;
	LayoutInflater inflater;
	
	public OrderPhotographerDataFansAdapter() {
		// TODO Auto-generated constructor stub
	}
	public OrderPhotographerDataFansAdapter(List<OrderPhotographerDataFansDemo> data,Context context) {
		// TODO Auto-generated constructor stub
		this.context=context;
		this.data=data;
		inflater=LayoutInflater.from(context);
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolderFans holderFans;
		if (view==null) {
			view=inflater.inflate(R.layout.order_photographer_data_fans_listitem, null);
			holderFans=new ViewHolderFans();
			holderFans.imageView=(ImageView)view.findViewById(R.id.fans_head);
			holderFans.textView=(TextView)view.findViewById(R.id.fans_name);
			view.setTag(holderFans);
		}
		holderFans=(ViewHolderFans)view.getTag();
		OrderPhotographerDataFansDemo dataFansDemo=(OrderPhotographerDataFansDemo)getItem(position);
		holderFans.imageView.setBackgroundResource(dataFansDemo.getFansImages());
		holderFans.textView.setText(dataFansDemo.getFansName());
		return view;
	}
	
	class ViewHolderFans{
		ImageView imageView;
		TextView textView;
		
	}
	

}
