package com.ushooting.activity;

import java.io.File;

import com.ushooting.activity.R.layout;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

public class CharmingPhotoActivity extends Activity {

	ImageView iv_back;
	ImageView iv_add;
	
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
		
	}
	
	OnClickListener l = new OnClickListener() {
		
		private View imageView;

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.iv_back:
				finish();
				break;
			case R.id.iv_add:
				showPopuwindow(imageView);
				break;

			default:
				break;
			}
		}
	};
	private int items;
	//private LinearLayout layout;
	//private ListView listView;
	
	private void showPopuwindow(View parent){
	//	layout = (LinearLayout) LayoutInflater.from(CharmingPhotoActivity.this).inflate(R.layout.popupwindow, null);
	//	listView  = (ListView) layout.findViewById(R.id.popupwindow_list);
	//	listView.setAdapter(new ArrayAdapter<String>(CharmingPhotoActivity.this,R.layout));
	}
	
	private void Dialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		
		builder.setItems(items,new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();

				Intent intent = new Intent(CharmingPhotoActivity.this,CreativeDesignActivity.class);
				startActivity(intent);
				
			}
		});
		
		builder.setPositiveButton("动物萌宠", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();

				Intent intent = new Intent(CharmingPhotoActivity.this,PetActivity.class);
				startActivity(intent);
				
			}
		});
		
		builder.setPositiveButton("风景建筑", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();

				Intent intent = new Intent(CharmingPhotoActivity.this,LandscapeArchitectureActivity.class);
				startActivity(intent);
				
			}
		});
		
		builder.setNegativeButton("其他主题", new DialogInterface.OnClickListener() {

			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();

				Intent intent = new Intent(CharmingPhotoActivity.this,OtherTopicsActivity.class);
				startActivity(intent);
				
			}
		}).show();
	    }
	
}
