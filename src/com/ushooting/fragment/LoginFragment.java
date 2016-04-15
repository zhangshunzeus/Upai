package com.ushooting.fragment;

import com.example.ruanjiawei.activity.LoginActicity;
import com.example.ruanjiawei.activity.MyActicity;
import com.example.ruanjiawei.activity.MyLoginActivity;
import com.ushooting.activity.R;
import com.ushooting.activity.RegisteredActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class LoginFragment extends Fragment {

	Button btn_login_registered;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.my, container, false);

		btn_login_registered = (Button) view.findViewById(R.id.btn_login_registered);
		btn_login_registered.setOnClickListener(l);

		return view;
	}

	OnClickListener l = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.btn_login_registered:
				Intent intent_btn_login_registered = new Intent();
				intent_btn_login_registered.setClass(getActivity(), LoginActicity.class);
				startActivity(intent_btn_login_registered);
				break;

			default:
				break;
			}
		}
	};

}
