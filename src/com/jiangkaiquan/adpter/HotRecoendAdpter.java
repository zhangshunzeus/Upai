package com.jiangkaiquan.adpter;

import java.util.ArrayList;
import java.util.HashMap;

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
 * 热门推荐adpter
 * 
 * @author jkqme
 * 
 */
public class HotRecoendAdpter extends BaseAdapter {
	private ArrayList<HashMap<String, Object>> list;
	private Context context;
	private LayoutInflater inflater;

	private HotRecoendAdpter() {
		// TODO Auto-generated constructor stub
	}

	public HotRecoendAdpter(ArrayList<HashMap<String, Object>> list,
			Context context) {
		this.context = context;
		this.list = list;
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
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.jiang_lv_hot_recoemd, null);
			holder = new Holder();
			holder.care = (ImageView) convertView
					.findViewById(R.id.lv_hot_recomend_care_img);
			holder.head = (ImageView) convertView
					.findViewById(R.id.lv_hot_recomend_head_img);
			holder.recomend_contextImg = (ImageView) convertView
					.findViewById(R.id.lv_hot_recomend_context_img);

			holder.photographer = (TextView) convertView
					.findViewById(R.id.lv_hot_recomend_photographer_tx);
			holder.recomend_time = (TextView) convertView
					.findViewById(R.id.lv_hot_recoemd_time_tx);
			holder.recomend_context = (TextView) convertView
					.findViewById(R.id.lv_hot_recoemd_context_tx);
			convertView.setTag(holder);
			holder.head.setOnClickListener(listener);
			holder.recomend_contextImg.setOnClickListener(listener);
		}
		return convertView;
	}

	private OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.lv_hot_recomend_head_img:
				sendToMesssage();
				break;
			case R.id.lv_hot_recomend_context_img:
				sendToMesssage();
				break;

			default:
				break;
			}
		}
	};

	private void sendToMesssage() {
		Bundle bundle = new Bundle();
		bundle.putString("fragment", "comptition");
		Intent intent = new Intent("sss");
		intent.putExtras(bundle);
		context.sendBroadcast(intent);
	}

	class Holder {
		// 关注的按钮
		ImageView care;
		ImageView head;
		TextView photographer;
		TextView recomend_time;
		TextView recomend_context;
		ImageView recomend_contextImg;
	}
}
