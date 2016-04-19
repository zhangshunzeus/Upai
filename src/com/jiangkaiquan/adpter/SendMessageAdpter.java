package com.jiangkaiquan.adpter;

import java.util.ArrayList;
import java.util.HashMap;

import com.jiangkiaquan.message.activity.Message;
import com.ushooting.activity.R;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 私信页面的adpter
 * 
 * @author jkqme
 * 
 */
public class SendMessageAdpter extends BaseAdapter {
	private ArrayList<HashMap<String, Object>> list;
	private Context context;
	private LayoutInflater inflater;

	private SendMessageAdpter() {
		// TODO Auto-generated constructor stub
	}

	public SendMessageAdpter(ArrayList<HashMap<String, Object>> list,
			Context context) {
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
		Holder holder;
		if (convertView == null) {
			convertView = inflater
					.inflate(R.layout.jiang_send_message_lv, null);
			holder = new Holder();
			holder.send_message_img = (ImageView) convertView
					.findViewById(R.id.lv_send_message_img);
			holder.send_message_name = (TextView) convertView
					.findViewById(R.id.lv_send_message_name_tx);
			holder.personality_tx = (TextView) convertView
					.findViewById(R.id.lv_send_message_personality_tx);
			holder.time_tx = (TextView) convertView
					.findViewById(R.id.lv_send_message_time_tx);
			convertView.setOnClickListener(listener);
		}

		return convertView;
	}

	private OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			sendBroadcast();

		}
	};

	private void sendBroadcast() {
		Bundle bundle = new Bundle();
		bundle.putInt("fragments", 4);
		Intent intent = new Intent("ss");
		intent.putExtras(bundle);
		context.sendBroadcast(intent);
	}

	class Holder {
		ImageView send_message_img;
		TextView send_message_name;
		TextView personality_tx;
		TextView time_tx;
	}
}
