package com.zhangwen.adapter;

import java.util.List;

import com.ushooting.activity.R;
import com.zhangwen.demo.MorePhotographerDamo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MorePhotographerAdapter extends BaseAdapter {
	List<MorePhotographerDamo> data;
	Context context;
	LayoutInflater inflater;
	CheckBox selector;

	public MorePhotographerAdapter() {
		// TODO Auto-generated constructor stub
	}

	public MorePhotographerAdapter(List<MorePhotographerDamo> data, Context context) {
		this.context = context;
		this.data = data;
		inflater = LayoutInflater.from(context);

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

	@SuppressLint("InflateParams")
	@Override
	public View getView(final int position, View view, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolderPhotographer holderPh;
		if (view == null) {
			view = inflater.inflate(R.layout.more_photographer_listview, null);
			holderPh = new ViewHolderPhotographer();
			holderPh.imageViewHead = (ImageView) view.findViewById(R.id.photo_head);
			holderPh.photoName = (TextView) view.findViewById(R.id.photoer_name);
			holderPh.popularity = (TextView) view.findViewById(R.id.popularity_number);
			holderPh.fans = (TextView) view.findViewById(R.id.fans_number);
			holderPh.contextpaoto = (TextView) view.findViewById(R.id.photo_content);
			// 关注点击事件
			selector = (CheckBox) view.findViewById(R.id.selector_check);
			selector.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Toast.makeText(context, "点击了关注", Toast.LENGTH_SHORT).show();
					CheckBox checkBox = (CheckBox) arg0;
					data.get(position).checked = checkBox.isChecked();
				}
			});
			view.setTag(holderPh);
		}

		holderPh = (ViewHolderPhotographer) view.getTag();
		MorePhotographerDamo mDamo = data.get(position);
		// holderPh.imageViewHead.set(mDamo.getImageHead());
		holderPh.photoName.setText(mDamo.getPhotographerName());
		holderPh.popularity.setText(mDamo.getPopularity());
		holderPh.fans.setText(mDamo.getFans());
		holderPh.contextpaoto.setText(mDamo.getPhotoContext());

		return view;
	}

	class ViewHolderPhotographer {
		ImageView imageViewHead;
		TextView photoName;
		TextView popularity;
		TextView fans;
		TextView contextpaoto;

	}

}
