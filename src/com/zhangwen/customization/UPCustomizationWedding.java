package com.zhangwen.customization;

import com.ushooting.activity.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class UPCustomizationWedding extends Activity {
	com.zhangwen.customization.CircleImageView headAttention;
	TextView attention;
	TextView attentionCang;
	TextView collection;
	TextView collectionCang;
	RelativeLayout prepay;
	RelativeLayout prepayCang;
	LinearLayout morePhoto;
	LinearLayout morePhotoCang;
	TextView lookData;
	ImageView returns;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.up_customization_wedding);
		// 关注点击隐藏
		headAttention = (CircleImageView) findViewById(R.id.head);
		headAttention.setOnClickListener(l);
		attention = (TextView) findViewById(R.id.attention);
		attention.setOnClickListener(l);
		attentionCang = (TextView) findViewById(R.id.attention_cang);
		attentionCang.setOnClickListener(l);
		// 收藏点击隐藏
		collection = (TextView) findViewById(R.id.collection);
		collection.setOnClickListener(l);
		collectionCang = (TextView) findViewById(R.id.collection_cang);
		collectionCang.setOnClickListener(l);
		// 开拍预付点击隐藏
		prepay = (RelativeLayout) findViewById(R.id.prepay);
		prepay.setOnClickListener(l);
		prepayCang = (RelativeLayout) findViewById(R.id.prepay_cang);
		prepayCang.setOnClickListener(l);
		// 更多摄影师
		morePhoto = (LinearLayout) findViewById(R.id.more_photo);
		morePhoto.setOnClickListener(l);
		morePhotoCang = (LinearLayout) findViewById(R.id.more_photo_cang);
		morePhotoCang.setOnClickListener(l);
		
		lookData=(TextView)findViewById(R.id.look_data);
		lookData.setOnClickListener(l);
		returns=(ImageView)findViewById(R.id.return_finish);
		returns.setOnClickListener(l);

	}

	OnClickListener l = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
			case R.id.head:// 关注
				attention.setVisibility(View.GONE);
				attentionCang.setVisibility(View.VISIBLE);
				break;
			case R.id.collection:// 收藏
				collection.setVisibility(View.GONE);
				collectionCang.setVisibility(View.VISIBLE);
				break;
			case R.id.prepay:// 开拍预付
				prepay.setVisibility(View.GONE);
				prepayCang.setVisibility(View.VISIBLE);
				Intent intent_payMoney=new Intent(UPCustomizationWedding.this,UPCustomizationWeddingKaiPaiPay.class);
				startActivity(intent_payMoney);
				break;
			case R.id.more_photo:// 更多摄影师
				morePhoto.setVisibility(View.GONE);
				morePhotoCang.setVisibility(View.VISIBLE);
				Intent intent_morePhoto=new Intent(UPCustomizationWedding.this,MorePhotographer.class);
				startActivity(intent_morePhoto); 
				break;
			case R.id.look_data:
				Intent intent_photodata=new Intent(UPCustomizationWedding.this,OrderPhotographerData.class);
				startActivity(intent_photodata);
				break;
			case R.id.return_finish:
				finish();
				break;
			default:
				break;
			}
		}

	};

}
