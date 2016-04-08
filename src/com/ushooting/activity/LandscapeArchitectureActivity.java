package com.ushooting.activity;

import java.util.ArrayList;
import com.ushooting.adapter.LandscapeArchitectureAdapter;
import com.ushooting.demo.LandscapeArchitectureDemo;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;

public class LandscapeArchitectureActivity extends Activity {

	LandscapeArchitectureAdapter mAdapter;
	ListView mList;
	ArrayList<LandscapeArchitectureDemo> list = new ArrayList<LandscapeArchitectureDemo>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.landscape_architecture);
		mList = (ListView) findViewById(R.id.lv_landscape_architecture);
		getData();
		mAdapter = new LandscapeArchitectureAdapter(this, list);
		mList.setAdapter(mAdapter);
	}

	private void getData() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 9 ; i++){
			LandscapeArchitectureDemo buy = new LandscapeArchitectureDemo();
			buy.setIv_bg(R.drawable.landscape_architecture_img_one);
			buy.setIv_bg_transparent(R.drawable.transparent);
			buy.setTv_title("");
			buy.setTv_content("");
			list.add(buy);
		}
	}

}
