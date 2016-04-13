package com.zhangwen.customization;

import com.ushooting.activity.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;

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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.up_customization_order);
		jiYi = (RelativeLayout) findViewById(R.id.ji_yi);
		jiYi.setOnClickListener(l);
		jiYiX = (RelativeLayout) findViewById(R.id.ji_yi_cang);
		jiYiX.setOnClickListener(l);

		wanMei = (RelativeLayout) findViewById(R.id.wan_mei);
		wanMei.setOnClickListener(l);
		wanMeiX = (RelativeLayout) findViewById(R.id.wan_mei_cang);
		wanMeiX.setOnClickListener(l);

		wenXin = (RelativeLayout) findViewById(R.id.wen_xin);
		wenXin.setOnClickListener(l);
		wenXinX = (RelativeLayout) findViewById(R.id.wen_xin_cang);
		wenXinX.setOnClickListener(l);
    
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		hunSha = (RelativeLayout) findViewById(R.id.hun_sha);
		hunSha.setOnClickListener(l);
		hunShaX = (RelativeLayout) findViewById(R.id.hun_sha_cang);
		hunShaX.setOnClickListener(l);
		returns=(ImageView)findViewById(R.id.return_finish);
		returns.setOnClickListener(l);
	}

	OnClickListener l = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
			case R.id.ji_yi:
				jiYi.setVisibility(View.GONE);
				jiYiX.setVisibility(View.VISIBLE);
				break;
			case R.id.wan_mei:
				wanMei.setVisibility(View.GONE);
				wanMeiX.setVisibility(View.VISIBLE);
				break;
			case R.id.wen_xin:
				wenXin.setVisibility(View.GONE);
				wenXinX.setVisibility(View.VISIBLE);
				break;
			case R.id.hun_sha:
				hunSha.setVisibility(View.GONE);
				hunShaX.setVisibility(View.VISIBLE);
				Intent intent = new Intent(UPCustomizationOrder.this, UPCustomizationWedding.class);
				startActivity(intent);
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
