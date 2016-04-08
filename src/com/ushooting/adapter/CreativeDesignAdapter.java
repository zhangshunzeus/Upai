package com.ushooting.adapter;

import java.util.ArrayList;

import com.ushooting.activity.R;
import com.ushooting.demo.CreativeDesignDemo;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CreativeDesignAdapter extends BaseAdapter {

	CreativeDesignAdapter mAdapter;
	Context context;
	LayoutInflater mInflater;
	ArrayList<CreativeDesignDemo> list;
	
	public CreativeDesignAdapter(Context context,ArrayList<CreativeDesignDemo>list) {
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
		
		ViewHoder viewHoder;
		if(convertView == null){
			//导入布局并赋值给convertView
			convertView = mInflater.inflate(R.layout.item_creative_design, null);
			//获得ViewHolder对象
			viewHoder = new ViewHoder();
			viewHoder.iv_img_one = (ImageView) convertView.findViewById(R.id.iv_img_one);
			viewHoder.img_one_transparent = (ImageView) convertView.findViewById(R.id.img_one_transparent);
			viewHoder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
			viewHoder.iv_praise = (ImageView) convertView.findViewById(R.id.iv_praise);
			viewHoder.iv_like = (ImageView) convertView.findViewById(R.id.iv_like);
			viewHoder.iv_collection = (ImageView) convertView.findViewById(R.id.iv_collection);
			convertView.setTag(viewHoder);
		}
		
		viewHoder = (ViewHoder) convertView.getTag();
		CreativeDesignDemo creativeDesignDemo = (CreativeDesignDemo) getItem(position);
		creativeDesignDemo.setIv_img_one(creativeDesignDemo.getIv_img_one());
		creativeDesignDemo.setImg_one_transparent(creativeDesignDemo.getImg_one_transparent());
		creativeDesignDemo.setTv_title(creativeDesignDemo.getTv_title());
		creativeDesignDemo.setIv_praise(creativeDesignDemo.getIv_praise());
		creativeDesignDemo.setIv_like(creativeDesignDemo.getIv_like());
		creativeDesignDemo.setIv_collection(creativeDesignDemo.getIv_collection());
		
		return convertView;
	}
	
	public class ViewHoder{

		public ImageView iv_collection;
		public ImageView iv_like;
		public ImageView iv_praise;
		public TextView tv_title;
		public ImageView img_one_transparent;
		public ImageView iv_img_one;
		
	}

}
