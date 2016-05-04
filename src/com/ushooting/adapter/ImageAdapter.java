package com.ushooting.adapter;

import java.net.ContentHandler;

import com.ushooting.activity.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

	int[] picIds = {
			R.drawable.hot_img_one,
            R.drawable.hot_img_two,
            R.drawable.hot_img_one,
            R.drawable.hot_img_two,
            R.drawable.hot_img_one,
            R.drawable.hot_img_two
	};
	
	Context context;
	int galleryItemBackground;
	
	public ImageAdapter(Context context) {
		// TODO Auto-generated constructor stub
		this.context=context;
		TypedArray typedArray=context.obtainStyledAttributes(R.styleable.CircleImageView);
		galleryItemBackground=typedArray.getResourceId(R.styleable.CircleImageView_android_galleryItemBackground,0);
		typedArray.recycle();
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return Integer.MAX_VALUE;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return picIds[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ImageView imageView = new ImageView(context);
		imageView.setImageResource(picIds[position%picIds.length]);
		imageView.setLayoutParams(new Gallery.LayoutParams(160,240));
		imageView.setScaleType(ImageView.ScaleType.FIT_XY);
		imageView.setBackgroundResource(galleryItemBackground);
		return imageView;
	}

}
