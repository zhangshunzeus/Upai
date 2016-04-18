package com.zhangwen.customization;

import java.util.ArrayList;
import java.util.List;

import com.ushooting.activity.R;
import com.zhangwen.adapter.OrderPhotographerDataFansAdapter;
import com.zhangwen.demo.OrderPhotographerDataFansDemo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
		//粉絲詳情頁面
public class OrderPhotographerDataFans extends Fragment {
	List<OrderPhotographerDataFansDemo> data = new ArrayList<OrderPhotographerDataFansDemo>();
	ListView listView;
	OrderPhotographerDataFansAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.order_photographer_data_fans, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		//listview显示粉丝数据
		listView = (ListView) getView().findViewById(R.id.fans_list);
		getData();
		adapter = new OrderPhotographerDataFansAdapter(data, getActivity());
		listView.setAdapter(adapter);
	}

	public void getData() {
		for (int i = 0; i < 10; i++) {
			//粉丝数据设置
			OrderPhotographerDataFansDemo demo = new OrderPhotographerDataFansDemo();
			//demo.setFansImages(R.drawable.hun_sha_kai_pai_head);
			demo.setFansName("小小桥");
			data.add(demo);

		}
	}
}
