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

/**
 * 聊天的adpter
 * 
 * @author jkqme
 * 
 */
public class ChatAdpter extends BaseAdapter {
	private ArrayList<HashMap<String, Object>> list;
	private Context context;
	private LayoutInflater inflater;

	private ChatAdpter() {
	}

	public ChatAdpter(ArrayList<HashMap<String, Object>> list, Context context) {
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
			// 判断发表的人是否是自己
			if (position % 2 == 0) {
				convertView = inflater.inflate(R.layout.jiang_chat2_lv, null);
				Holder2 holder2 = new Holder2();
				holder2.img = (ImageView) convertView
						.findViewById(R.id.chat_2_img);
				holder2.textView = (TextView) convertView
						.findViewById(R.id.chat_2_tx);
				convertView.setTag(holder2);
			} else {
				convertView = inflater.inflate(R.layout.jiang_lv_chat_1, null);
				Holder1 holder1 = new Holder1();
				holder1.img = (ImageView) convertView
						.findViewById(R.id.chat_1_img);
				holder1.textView = (TextView) convertView
						.findViewById(R.id.chat_1_tx);
				convertView.setTag(holder1);
			}
		}
		return convertView;
	}

	class Holder1 {
		ImageView img;
		TextView textView;
	}

	/**
	 * 我
	 * 
	 * @author jkqme
	 * 
	 */
	class Holder2 {
		ImageView img;
		TextView textView;
	}

}
