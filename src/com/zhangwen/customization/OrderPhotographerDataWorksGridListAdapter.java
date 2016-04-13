package com.zhangwen.customization;

import java.util.List;

import com.ushooting.activity.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class OrderPhotographerDataWorksGridListAdapter extends BaseAdapter {
	List<OrderPhotographerDataWorksGridDemo> data;
	Context context;
	LayoutInflater inflater;

	public OrderPhotographerDataWorksGridListAdapter() {
		// TODO Auto-generated constructor stub
	}

	public OrderPhotographerDataWorksGridListAdapter(List<OrderPhotographerDataWorksGridDemo> data, Context context) {
		// TODO Auto-generated constructor stub
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
	public View getView(int position, View view, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolderWorks holderWorks;
		if (view == null) {
			view = inflater.inflate(R.layout.order_photographer_data_works_grid_list, null);
			holderWorks = new ViewHolderWorks();
			holderWorks.backImage = (ImageView) view.findViewById(R.id.works_image);
			holderWorks.workstitle = (TextView) view.findViewById(R.id.works_title);
			holderWorks.workstext = (TextView) view.findViewById(R.id.works_content);
			view.setTag(holderWorks);

		}
		holderWorks = (ViewHolderWorks) view.getTag();
		OrderPhotographerDataWorksGridDemo dataWorksGridDemo =(OrderPhotographerDataWorksGridDemo)getItem(position);
		holderWorks.backImage.setBackgroundResource(dataWorksGridDemo.getWorksImage());
		holderWorks.workstitle.setText(dataWorksGridDemo.getWorksTitle());
		holderWorks.workstext.setText(dataWorksGridDemo.getWorksText());

		return view;
	}
	class ViewHolderWorks {
		ImageView backImage;
		TextView workstitle;
		TextView workstext;

	}
	
	int a;
	String aString;
	

}
