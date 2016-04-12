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
		Holder holder;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.jiang_smple_item, null);
			holder=new Holder();
			holder.headimg=(ImageView)convertView.findViewById(R.id.sample_item_headimg_img);
			holder.attention=(TextView)convertView.findViewById(R.id.attention_tx);
			holder.gruphername=(TextView)convertView.findViewById(R.id.smple_gruphername_tx);
			holder.time=(TextView)convertView.findViewById(R.id.sample_time_tx);
			holder.context=(TextView)convertView.findViewById(R.id.sample_context_tx);
		
			holder.sample_img1=(ImageView)convertView.findViewById(R.id.sample_img1);
			holder.sample_img2=(ImageView)convertView.findViewById(R.id.sample_img2);
			holder.sample_img3=(ImageView)convertView.findViewById(R.id.sample_img3);
			holder.sample_img4=(ImageView)convertView.findViewById(R.id.sample_img4);
			holder.sample_img5=(ImageView)convertView.findViewById(R.id.sample_img5);
			holder.sample_img6=(ImageView)convertView.findViewById(R.id.sample_img6);
		
			holder.sample_item_shar_img=(ImageView)convertView.findViewById(R.id.sample_item_shar_img);
			holder.shar_num_tx=(TextView)convertView.findViewById(R.id.sample_shar_num_tx);
		
			holder.evaluate_img=(ImageView)convertView.findViewById(R.id.sample_item_evaluate_img);
			holder.shar_num_tx=(TextView)convertView.findViewById(R.id.sample_evaluate_num_tx);
			
			holder.love_img=(ImageView)convertView.findViewById(R.id.sample_item_love_img);
			holder.love_num_tx=(TextView)convertView.findViewById(R.id.sample_love_num_tx);
			
			holder.coment_img=(ImageView)convertView.findViewById(R.id.sample_item_coment_img);
			holder.coment_num_tx=(TextView)convertView.findViewById(R.id.sample_coment_num_tx);
			
			convertView.setTag(holder);
		}
		return convertView;
	}
	class Holder{
		ImageView headimg;
		TextView attention;
		TextView gruphername;
		TextView time;
		TextView context;
		
		ImageView sample_img1;
		ImageView sample_img2;
		ImageView sample_img3;
		ImageView sample_img4;
		ImageView sample_img5;
		ImageView sample_img6;
		
		ImageView sample_item_shar_img;
		TextView shar_num_tx;
		ImageView evaluate_img;
		TextView evaluate_num_tx;
		
		ImageView love_img;
		TextView love_num_tx;
		ImageView coment_img;
		TextView coment_num_tx;
	}
}
