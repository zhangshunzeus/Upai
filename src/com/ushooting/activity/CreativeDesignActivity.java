package com.ushooting.activity;

import java.util.ArrayList;
import java.util.List;

import com.ushooting.adapter.CreativeDesignAdapter;
import com.ushooting.demo.CreativeDesignDemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;

public class CreativeDesignActivity extends Activity {

	CreativeDesignAdapter mAdapter;
	ListView mList;
	ArrayList<CreativeDesignDemo> list = new ArrayList<CreativeDesignDemo>();
	ImageView iv_back;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_creative_design);
		mList = (ListView) findViewById(R.id.lv_creative_design);
		//为Adapter准备数据
		getData();
		//实例化自定义的Adapter
		mAdapter = new CreativeDesignAdapter(this, list);
		//绑定Adapter
		mList.setAdapter(mAdapter);
		
		iv_back = (ImageView) findViewById(R.id.iv_back);
		iv_back.setOnClickListener(l);
	
	}

	private void getData() {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < 9 ; i++){
			CreativeDesignDemo buy = new CreativeDesignDemo();
			buy.setIv_img_one(R.drawable.img_one);
			buy.setImg_one_transparent(R.drawable.img_one_transparent);
			buy.setTv_title("");
			buy.setIv_praise(R.drawable.praise);
			buy.setIv_like(R.drawable.like);
			buy.setIv_collection(R.drawable.collection);
			list.add(buy);
		}
		
	}
	
	OnClickListener l = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.iv_back:
				finish();
				break;

			default:
				break;
			}
		}
	};
	
}
