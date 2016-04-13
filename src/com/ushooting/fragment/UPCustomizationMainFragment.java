package com.ushooting.fragment;

import com.ushooting.activity.R;
import com.zhangwen.customization.UPCustomizationOrder;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class UPCustomizationMainFragment extends Fragment {

	ImageView imageThemeCheck;
	ImageView imageOrderCheck;
	RelativeLayout themeCheck;
	RelativeLayout orderCheck;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view=inflater.inflate(R.layout.up_customization_main, container,false);
		imageThemeCheck = (ImageView) view.findViewById(R.id.customization_theme_background);
		imageThemeCheck.setOnClickListener(themes);
		imageOrderCheck = (ImageView) view.findViewById(R.id.customization_order_background);
		imageOrderCheck.setOnClickListener(orders);
		
		themeCheck=(RelativeLayout)view.findViewById(R.id.selector_theme);
		themeCheck.setOnClickListener(themes);
		orderCheck=(RelativeLayout)view.findViewById(R.id.selector_order);
		orderCheck.setOnClickListener(orders);
		return view;
	}
	
	OnClickListener themes = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			boolean checked = true;

			if (checked) {
				imageThemeCheck.setVisibility(View.VISIBLE);
			} else {
				imageThemeCheck.setVisibility(View.GONE);
			}

		}
	};
	OnClickListener orders = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			boolean checked = true;

			if (checked) {
				imageOrderCheck.setVisibility(View.VISIBLE);
			} else {
				imageOrderCheck.setVisibility(View.GONE);
			}
			Intent intent=new Intent(getActivity(),UPCustomizationOrder.class);
			startActivity(intent);
		}

	};
	
}
