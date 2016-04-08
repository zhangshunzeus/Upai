package com.example.ruanjiawei.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;

import com.example.ruanjiawei.adapter.CommentsBaseAdapter;
import com.example.ruanjiawei.adapter.CommentsInfo;
import com.example.ushooting.R;

public class CommentsActivity extends Activity {
	ArrayList<CommentsInfo> list = new ArrayList<CommentsInfo>();
	ListView listView;
	CommentsBaseAdapter adapter;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.comments);

		listView = (ListView) findViewById(R.id.comment_listview);
		getData();
		adapter = new CommentsBaseAdapter(list, this);
		listView.setAdapter(adapter);

	}

	public void getData() {
		CommentsInfo info = new CommentsInfo();
		info.setPortrait(R.drawable.myhand);
		info.setComment_id("薄荷凉216");
		info.setText("好美的感觉，喜欢这个调调。");
		info.setMin("37分钟前");
		list.add(info);
		
		CommentsInfo two = new CommentsInfo();
		two.setPortrait(R.drawable.meinv);
		two.setComment_id("魔蝎之随想");
		two.setText("一张照片就是一个故事");
		two.setMin("43分钟");
		list.add(two);
		
		CommentsInfo ok = new CommentsInfo();
		ok.setPortrait(R.drawable.meinv);
		ok.setComment_id("德德ok啊");
		ok.setText("有的时候一个人的眼睛，就足以表达所有的感情。");
		ok.setMin("43分钟");
		list.add(ok);
		
		CommentsInfo yang = new CommentsInfo();
		yang.setPortrait(R.drawable.meinv);
		yang.setComment_id("小青年老张");
		yang.setText("拍的很不错，感觉很美");
		yang.setMin("45分钟");
		list.add(yang);
		
		CommentsInfo big = new CommentsInfo();
		big.setPortrait(R.drawable.meinv);
		big.setComment_id("我叫陈大梦梦");
		big.setText("好的照片，你总是能被它传递出来的感情所感染。");
		big.setMin("50分钟");
		list.add(big);
		
		CommentsInfo mis = new CommentsInfo();
		mis.setPortrait(R.drawable.meinv);
		mis.setComment_id("面条小姐N");
		mis.setText("神秘，宁静！");
		mis.setMin("55分钟");
		list.add(mis);
	}
}
