package com.ushooting.activity;

import com.example.ruanjiawei.activity.AmaterurPhotographyActivity;
import com.example.ruanjiawei.activity.ImageDetailsActivity;
import com.example.ruanjiawei.activity.ProfessionalActivity;
import com.ushooting.activity.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;

import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class HomePageActivity extends Activity {

	ImageView iv_banner_intent;
	TextView tv_hot, tv_amateur_photography, tv_professional_photography, tv_popular_activities;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_home_page);

		iv_banner_intent = (ImageView) findViewById(R.id.iv_banner_intent);
		iv_banner_intent.setOnClickListener(listener);

		tv_hot = (TextView) findViewById(R.id.tv_hot);
		tv_hot.setOnClickListener(listener);

		tv_amateur_photography = (TextView) findViewById(R.id.tv_amateur_photography);
		tv_amateur_photography.setOnClickListener(listener);

		tv_professional_photography = (TextView) findViewById(R.id.tv_professional_photography);
		tv_professional_photography.setOnClickListener(listener);

		tv_popular_activities = (TextView) findViewById(R.id.tv_popular_activities);
		tv_popular_activities.setOnClickListener(listener);

	}

	private OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {

			case R.id.iv_banner_intent:
				Intent intent_banner = new Intent();
				intent_banner.setClass(HomePageActivity.this, ImageDetailsActivity.class);
				startActivity(intent_banner);
				break;
			case R.id.tv_hot:

				break;
			case R.id.tv_amateur_photography:
				Intent intent_amateur = new Intent();
				intent_amateur.setClass(HomePageActivity.this,AmaterurPhotographyActivity.class);
				startActivity(intent_amateur);
				break;
			case R.id.tv_professional_photography:
				Intent intent_professional = new Intent();
				intent_professional.setClass(HomePageActivity.this,ProfessionalActivity.class);
				startActivity(intent_professional);
				break;
			case R.id.tv_popular_activities:

				break;

			default:
				break;
			}
		}
	};
}
