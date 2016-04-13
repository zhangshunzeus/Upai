package com.zhangwen.customization;

import java.util.ArrayList;
import java.util.List;

import com.ushooting.activity.R;
import com.zhangwen.adapter.MorePhotographerAdapter;
import com.zhangwen.demo.MorePhotographerDamo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class MorePhotographer extends Activity {
	List<MorePhotographerDamo> data=new ArrayList<MorePhotographerDamo>();
	ListView listView;
	MorePhotographerAdapter morePhoto;
	RelativeLayout add;
	RelativeLayout addl;
	ImageView returns;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.up_customization_more_photographer);
		listView = (ListView) findViewById(R.id.more_photo_list);
		getData();
		morePhoto = new MorePhotographerAdapter(data, MorePhotographer.this);
		listView.setAdapter(morePhoto);
		returns=(ImageView)findViewById(R.id.return_finish);
		returns.setOnClickListener(l);

	}
	
	OnClickListener l=new OnClickListener(){

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
			case R.id.return_finish:
				finish();
				break;

			default:
				break;
			}
		}
		
		
	};

	public void getData() {
		for (int i = 0; i < 5; i++) {
			MorePhotographerDamo damo = new MorePhotographerDamo();
			damo.setImageHead(R.drawable.hun_sha_kai_pai_head);
			damo.setPhotographerName("Steven  Pan");
			damo.setPopularity("人气  99K+");
			damo.setFans("粉丝 1356");
			damo.setPhotoContext(
					"摄影师Stevin Tuchiwsky单身上路，寻找那些宁静致远或者大气磅礴的风景，将自己融入\n风景中，营造出天涯浪子的不羁感。希望这些照片能给你的下次出行带来一些灵感.");
			data.add(damo);

		}
	}
}
