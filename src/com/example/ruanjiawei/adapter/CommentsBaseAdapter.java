package com.example.ruanjiawei.adapter;

import java.util.ArrayList;

import com.example.ushooting.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CommentsBaseAdapter extends BaseAdapter {
	ArrayList<CommentsInfo> list;
	Context context;
	LayoutInflater inflater;

	public CommentsBaseAdapter(ArrayList<CommentsInfo> list, Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.list = list;
		inflater = LayoutInflater.from(context);
	}

	public void setData(ArrayList<CommentsInfo> list) {
		this.list = list;
		this.notifyDataSetChanged();
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
		ViewHolder holder;
		if (convertView == null) {

			convertView = inflater.inflate(R.layout.comment_listview, null);
			holder = new ViewHolder();
			holder.portrait = (ImageView) convertView
					.findViewById(R.id.portrait);
			holder.comment_id = (TextView) convertView
					.findViewById(R.id.comment_id);
			holder.text = (TextView) convertView.findViewById(R.id.text);
			holder.min = (TextView) convertView.findViewById(R.id.min);
			// 你下边getTag 这里没setTag

			convertView.setTag(holder);
		}
		holder = (ViewHolder) convertView.getTag();
		CommentsInfo info = (CommentsInfo) getItem(position);
		holder.portrait.setImageResource(info.getPortrait());
		holder.comment_id.setText(info.getComment_id());
		holder.text.setText(info.getText());
		holder.min.setText(info.getMin());
		return convertView;
	}

	class ViewHolder {
		public ImageView portrait;
		public TextView comment_id;
		public TextView text;
		public TextView min;

	}

}
