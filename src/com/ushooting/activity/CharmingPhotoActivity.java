package com.ushooting.activity;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

public class CharmingPhotoActivity extends Activity {

	ImageView iv_back;
	ImageView iv_add;
	LinearLayout checkOne;
	LinearLayout checkTwo;
	LinearLayout checkThree;
	LinearLayout checkFour;
	LinearLayout checkFive;
	

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_charming_photo);

		iv_back = (ImageView) findViewById(R.id.iv_back);
		iv_back.setOnClickListener(l);
		iv_add = (ImageView) findViewById(R.id.iv_add);
		iv_add.setOnClickListener(l);

		LinearLayout layout = new LinearLayout(getApplication());
		layout.setLayoutParams(new LayoutParams(-1, -1));
		// 使用popupwindow弹出共享界面
		LayoutInflater inflater = LayoutInflater.from(this);
		// 引入窗口配置文件
		View view = inflater.inflate(R.layout.mei_li_xie_zhen_add, layout);
		checkOne = (LinearLayout)view.findViewById(R.id.check_one);
		checkOne.setOnClickListener(l);
		checkTwo = (LinearLayout)view.findViewById(R.id.check_two);
		checkTwo.setOnClickListener(l);
		checkThree = (LinearLayout)view.findViewById(R.id.check_three);
		checkThree.setOnClickListener(l);
		checkFour = (LinearLayout)view.findViewById(R.id.check_four);
		checkFour.setOnClickListener(l);
		checkFive = (LinearLayout)view.findViewById(R.id.check_five);
		checkFive.setOnClickListener(l);
		iv_add = (ImageView) findViewById(R.id.iv_add);
		// 创建popup对象
		final PopupWindow popupWindow = new PopupWindow(view,-1,-1,false);
		// 设置参数，点击外部可消失
		popupWindow.setBackgroundDrawable(new BitmapDrawable());
		// 设置点击窗口外边消失
		popupWindow.setOutsideTouchable(true);
		// 设置参数获得焦点，否则无法点击
		popupWindow.setFocusable(true);
		// getLayoutInflater();
		// 设置点击事件
		iv_add.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (popupWindow.isShowing()) {
					// 隐藏窗口，如果设置了点击窗口外小时即不需要此方式隐藏
					popupWindow.dismiss();

				} else {
					// 显示窗口
					popupWindow.showAsDropDown(arg0);
				}
			}
		});
	}

	OnClickListener l = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.iv_back:
				finish();
				break;
			case R.id.check_one:
				Intent intent_meili_xiezhen=new Intent(CharmingPhotoActivity.this,CharmingPhotoActivity.class);
				startActivity(intent_meili_xiezhen);
				break;
			case R.id.check_two:
				Intent intent_dongwu_mengchong=new Intent(CharmingPhotoActivity.this,PetActivity.class);
				startActivity(intent_dongwu_mengchong);
				break;
			case R.id.check_three:
				Intent intent_fengjing_jianzhu=new Intent(CharmingPhotoActivity.this,LandscapeArchitectureActivity.class);
				startActivity(intent_fengjing_jianzhu);
				break;
			case R.id.check_four:
				Intent intent_chuangyi_sheji=new Intent(CharmingPhotoActivity.this,CreativeDesignActivity.class);
				startActivity(intent_chuangyi_sheji);
				break;
			case R.id.check_five:
				Intent intent_qita_zhuti=new Intent(CharmingPhotoActivity.this,OtherTopicsActivity.class);
				startActivity(intent_qita_zhuti);
				break;
		
			default:
				break;
			}
		}
	};

}
