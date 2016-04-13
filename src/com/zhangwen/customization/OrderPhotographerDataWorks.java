package com.zhangwen.customization;

import java.util.ArrayList;
import java.util.List;

import com.ushooting.activity.R;
import com.zhangwen.adapter.OrderPhotographerDataWorksGridListAdapter;
import com.zhangwen.demo.OrderPhotographerDataWorksGridDemo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

public class OrderPhotographerDataWorks extends Fragment {
	List<OrderPhotographerDataWorksGridDemo> data = new ArrayList<OrderPhotographerDataWorksGridDemo>();
	GridView gridView;
	OrderPhotographerDataWorksGridListAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		return inflater.inflate(R.layout.order_photographer_data_works, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);

		gridView = (GridView) getView().findViewById(R.id.works_gridview);
		getData();
		adapter = new OrderPhotographerDataWorksGridListAdapter(data, getActivity());
		gridView.setAdapter(adapter);
	}
	public void getData(){
		for (int i = 0; i < 10; i++) {
			OrderPhotographerDataWorksGridDemo demo=new OrderPhotographerDataWorksGridDemo();
			demo.setWorksImage(R.drawable.works_gridlist);
			demo.setWorksTitle("爱丽丝之恋");
			demo.setWorksText("轮回的路上，有着深邃的记忆，穿越多情河，你我在红尘中相连，刹那芳华，相离天涯与海角。");
			data.add(demo);
		}
		 
		
	}
	
	
	
	
	
	
	

}
