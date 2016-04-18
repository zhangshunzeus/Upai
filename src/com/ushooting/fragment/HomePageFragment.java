package com.ushooting.fragment;

import com.example.ruanjiawei.activity.AmaterurPhotographyActivity;
import com.example.ruanjiawei.activity.ImageDetailsActivity;
import com.example.ruanjiawei.activity.ProfessionalActivity;
import com.ushooting.activity.R;
import com.zhangwen.customization.PopularActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class HomePageFragment extends Fragment {

	ImageView iv_banner_intent;
	TextView tv_hot, tv_amateur_photography, tv_professional_photography, tv_popular_activities;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		View view = inflater.inflate(R.layout.activity_home_page, container, false);
		
		iv_banner_intent = (ImageView) view.findViewById(R.id.iv_banner_intent);
		iv_banner_intent.setOnClickListener(listener);

		tv_hot = (TextView) view.findViewById(R.id.tv_hot);
		tv_hot.setOnClickListener(listener);

		tv_amateur_photography = (TextView) view.findViewById(R.id.tv_amateur_photography);
		tv_amateur_photography.setOnClickListener(listener);

		tv_professional_photography = (TextView) view.findViewById(R.id.tv_professional_photography);
		tv_professional_photography.setOnClickListener(listener);

		tv_popular_activities = (TextView) view.findViewById(R.id.tv_popular_activities);
		tv_popular_activities.setOnClickListener(listener);
		
		return view;
	}
	
	private OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {

			case R.id.iv_banner_intent:
				Intent intent_banner = new Intent();
				intent_banner.setClass(getActivity(), ImageDetailsActivity.class);
				startActivity(intent_banner);
				break;
			case R.id.tv_hot:

				break;
			case R.id.tv_amateur_photography:
				Intent intent_amateur = new Intent();
				intent_amateur.setClass(getActivity(),AmaterurPhotographyActivity.class);
				startActivity(intent_amateur);
				break;
			case R.id.tv_professional_photography:
				Intent intent_professional = new Intent();
				intent_professional.setClass(getActivity(),ProfessionalActivity.class);
				startActivity(intent_professional);
				break;
			case R.id.tv_popular_activities:
				Intent intent_popular_activity = new Intent();
				intent_popular_activity.setClass(getActivity(),PopularActivities.class);
				startActivity(intent_popular_activity);
				break;

			default:
				break;
			}
		}
	};

}
