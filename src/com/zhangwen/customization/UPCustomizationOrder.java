package com.zhangwen.customization;

import com.ushooting.activity.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class UPCustomizationOrder extends Activity {
	RelativeLayout jiYi;
	RelativeLayout jiYiX;
	RelativeLayout wanMei;
	RelativeLayout wanMeiX;
	RelativeLayout wenXin;
	RelativeLayout wenXinX;
	RelativeLayout hunSha;
	RelativeLayout hunShaX;
	ImageView returns;
	Spinner spinners;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.up_customization_order);
		// 记忆时光
		jiYi = (RelativeLayout) findViewById(R.id.ji_yi);
		jiYi.setOnClickListener(l);
		jiYiX = (RelativeLayout) findViewById(R.id.ji_yi_cang);
		jiYiX.setOnClickListener(l);
		// 完美写真
		wanMei = (RelativeLayout) findViewById(R.id.wan_mei);
		wanMei.setOnClickListener(l);
		wanMeiX = (RelativeLayout) findViewById(R.id.wan_mei_cang);
		wanMeiX.setOnClickListener(l);
		// 温馨全家福
		wenXin = (RelativeLayout) findViewById(R.id.wen_xin);
		wenXin.setOnClickListener(l);
		wenXinX = (RelativeLayout) findViewById(R.id.wen_xin_cang);
		wenXinX.setOnClickListener(l);
		// 婚纱摄影
		hunSha = (RelativeLayout) findViewById(R.id.hun_sha);
		hunSha.setOnClickListener(l);
		hunShaX = (RelativeLayout) findViewById(R.id.hun_sha_cang);
		hunShaX.setOnClickListener(l);
		returns = (ImageView) findViewById(R.id.return_finish);
		returns.setOnClickListener(l);
		// 地点城市选择
		spinners = (Spinner) findViewById(R.id.order_chongqing);
		spinners.setOnItemSelectedListener(listener);
	}

	OnItemSelectedListener listener = new OnItemSelectedListener() {
		// 监听地点选择spinner
		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
			// TODO Auto-generated method stub
			// 设置显示地点的字体的颜色
			TextView view = (TextView) arg1;
			view.setTextColor(Color.WHITE);
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub

		}

	};

	OnClickListener l = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
			case R.id.ji_yi:// 记忆时光的隐藏显示
				jiYi.setVisibility(View.GONE);
				jiYiX.setVisibility(View.VISIBLE);
				break;
			case R.id.wan_mei:// 完美写真的隐藏显示界面
				wanMei.setVisibility(View.GONE);
				wanMeiX.setVisibility(View.VISIBLE);
				break;
			case R.id.wen_xin:// 温馨全家福隐藏显示页面
				wenXin.setVisibility(View.GONE);
				wenXinX.setVisibility(View.VISIBLE);
				break;
			case R.id.hun_sha:// 显示隐藏并跳转到婚纱详情开拍页面
				hunSha.setVisibility(View.GONE);
				hunShaX.setVisibility(View.VISIBLE);
				Intent intent = new Intent(UPCustomizationOrder.this, UPCustomizationWedding.class);
				startActivity(intent);
				UPCustomizationOrder.this.finish();
				break;
			case R.id.return_finish:// 返回并跳转到定制页面
				finish();
				/*
				 * Intent intent_main = new Intent(UPCustomizationOrder.this,
				 * UPCustomizationMain.class); startActivity(intent_main);
				 */
				break;
			default:
				break;
			}
		}
	};

}
