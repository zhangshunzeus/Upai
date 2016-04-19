package com.ushooting.activity;

import java.io.File;

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
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;

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
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.iv_back:
				finish();
				break;
			case R.id.iv_add:
				Dialog();
				break;

			default:
				break;
			}
		}
	};
	private int items;
	
	private void Dialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		
		builder.setItems(items,new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();

				Intent intent = new Intent(CharmingPhotoActivity.this,CreativeDesignActivity.class);
				startActivity(intent);
				
			}
		}).show();
		
		builder.setPositiveButton("动物萌宠", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();

				Intent intent = new Intent(CharmingPhotoActivity.this,PetActivity.class);
				startActivity(intent);
				
			}
		}).show();
		
		builder.setPositiveButton("风景建筑", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();

				Intent intent = new Intent(CharmingPhotoActivity.this,LandscapeArchitectureActivity.class);
				startActivity(intent);
				
			}
		}).show();
		
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
