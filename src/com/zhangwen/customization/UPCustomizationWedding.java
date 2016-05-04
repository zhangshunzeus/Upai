package com.zhangwen.customization;

import org.json.JSONObject;

import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import com.ushooting.activity.R;

import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
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
	ImageView shared;
	LinearLayout popup;
	ImageView sharedQQ;
	private Handler handler;
	private Tencent tencent;
	Bundle shareParams = null;
	private static final String APP_ID = "222222";
	View view;

	@SuppressLint("InflateParams")
	@SuppressWarnings("deprecation")
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
		//查看资料
		lookData = (TextView) findViewById(R.id.look_data);
		lookData.setOnClickListener(l);
		//返回
		returns = (ImageView) findViewById(R.id.return_finish);
		returns.setOnClickListener(l);
		
		LinearLayout layout=new LinearLayout(getApplication());
		layout.setLayoutParams(new LayoutParams(-1, -1));
		//使用popupwindow弹出共享界面
		LayoutInflater inflater=LayoutInflater.from(this);
		//引入窗口配置文件
		view=inflater.inflate(R.layout.up_customization_wedding_shared, layout);
		shared=(ImageView)findViewById(R.id.share_check);
		sharedQQ=(ImageView)view.findViewById(R.id.qq_shared);
		final Context myContext = this.getApplicationContext();
		tencent = Tencent.createInstance(APP_ID, myContext);
		handler = new Handler();
		popup=(LinearLayout)findViewById(R.id.popup);
		//创建popup对象
		final PopupWindow popupWindow=new PopupWindow(view,-1,-1,false);
		//设置参数，点击外部可消失
		popupWindow.setBackgroundDrawable(new BitmapDrawable());
		//设置点击窗口外边消失
		popupWindow.setOutsideTouchable(true);
		//设置参数获得焦点，否则无法点击 
		popupWindow.setFocusable(true);
		//getLayoutInflater();
		//设置点击事件
		shared.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (popupWindow.isShowing()) {
					// 隐藏窗口，如果设置了点击窗口外小时即不需要此方式隐藏
					popupWindow.dismiss();
					
				}else {
					// 显示窗口 
					popupWindow.showAsDropDown(arg0);
				}	
			}
		});
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		ImageView button = (ImageView) view.findViewById(R.id.qq_shared);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				onClickShareToQQ();
			}
		});
	}

	protected void onClickShareToQQ() {
		Bundle bundle = getShareBundle();
		if (bundle!=null) {
			shareParams = bundle;
			Thread thread = new Thread(shareThread);
			thread.start();
		}
	}

	private Bundle getShareBundle() {
		Bundle bundle = new Bundle();
		bundle.putString("title", "分享好友");
		bundle.putString("imageUrl",
				"http://img.ivsky.com/img/bizhi/img/201206/25/diablo_-019.jpg");
		bundle.putString("targetUrl",
				"http://d3.blizzard.cn/");
		bundle.putString("summary", "把你的u拍美照分享给好友");
		bundle.putString("site", "U拍分享");
		bundle.putString("appName", "U拍");
		return bundle;
	}

	Runnable shareThread = new Runnable() {

		public void run() {
			doShareToQQ(shareParams);
			Message msg = shareHandler.obtainMessage();

			// ��Message������뵽��Ϣ���е���
			shareHandler.sendMessage(msg);

		}
	};

	@SuppressLint("HandlerLeak")
	Handler shareHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
		}
	};
	
	private void doShareToQQ(Bundle params) {
		tencent.shareToQQ(UPCustomizationWedding.this, params, new BaseUiListener() {
			protected void doComplete(JSONObject values) {
				showResult("shareToQQ:", "onComplete");
			} 

			@Override
			public void onError(UiError e) {
				showResult("shareToQQ:", "onError code:" + e.errorCode
						+ ", msg:" + e.errorMessage + ", detail:"
						+ e.errorDetail);
			}

			@Override
			public void onCancel() {
				showResult("shareToQQ", "onCancel");
			}
		});
	} 
	
	private class BaseUiListener implements IUiListener {

		@Override
		public void onComplete(JSONObject response) {
			// mBaseMessageText.setText("onComplete:");
			// mMessageText.setText(response.toString());
			doComplete(response);
		}

		protected void doComplete(JSONObject values) {

		}

		@Override
		public void onError(UiError e) {
			showResult("onError:", "code:" + e.errorCode + ", msg:"
					+ e.errorMessage + ", detail:" + e.errorDetail);
		}

		@Override
		public void onCancel() {
			showResult("onCancel", "");
		}
	}
	
	private void showResult(final String base, final String msg) {
		handler.post(new Runnable() {

			@Override
			public void run() {
			}
		});
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
				Intent intent_payMoney = new Intent(UPCustomizationWedding.this, UPCustomizationWeddingKaiPaiPay.class);
				startActivity(intent_payMoney);
				UPCustomizationWedding.this.finish();
				break;
			case R.id.more_photo:// 更多摄影师
				morePhoto.setVisibility(View.GONE);
				morePhotoCang.setVisibility(View.VISIBLE);
				Intent intent_morePhoto = new Intent(UPCustomizationWedding.this, MorePhotographer.class);
				startActivity(intent_morePhoto);
				UPCustomizationWedding.this.finish();
				break;
			case R.id.look_data://跳转到查看资料
				Intent intent_photodata = new Intent(UPCustomizationWedding.this, OrderPhotographerData.class);
				startActivity(intent_photodata);
				UPCustomizationWedding.this.finish();
				break;
			case R.id.return_finish://返回并跳轉到預定頁面
				finish();
				Intent intent_return = new Intent(UPCustomizationWedding.this, UPCustomizationOrder.class);
				startActivity(intent_return);
				UPCustomizationWedding.this.finish();
				break;
			default:
				break;
			}
		}

	};

}
