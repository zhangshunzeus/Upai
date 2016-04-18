package com.zhangwen.customization;

import java.util.Date;
import com.ushooting.activity.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * 重寫listView用於下拉刷新
 * 
 */

public class MyListview extends ListView implements OnScrollListener {
	private final static int RELEASE_TO_REFRESH = 0;// 下拉过程的状态值
	private final static int PULL_TO_REFRESH = 1;// 从下拉返回到不刷新的状态值
	private final static int REFRESHING = 2;// 正在刷新的状态值
	private final static int DONE = 3;
	private final static int LOADING = 4;
	private final static int RATIO = 3;// 实际的padding的距离与界面上偏移距离的比例
	private LayoutInflater inflater;
	private LinearLayout headerView;// listView头部下拉刷新的布局

	private ImageView lvheaderArrowIv;

	private TextView lvHeaderTipsTv;
	private TextView lvHeaderLastUpdatedTv;
	private ProgressBar lvheaderProgressBar;

	private int headerContentHeight;// 定义头部下拉刷新的布局的高度
	private int startY;
	private int state;
	private boolean isBack;
	private boolean isRecored;
	private boolean isRefreshable;
	private OnRefreshListener refreshListener;
	private RotateAnimation animation;
	private RotateAnimation reverseAnimation;

	public MyListview(Context context) {
		super(context);
		init(context);
		// TODO Auto-generated constructor stub
	}

	public MyListview(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	@SuppressLint("InflateParams")
	private void init(Context context) {
		// TODO Auto-generated method stub
		setCacheColorHint(context.getResources().getColor(R.color.black));
		inflater = LayoutInflater.from(context);

		headerView = (LinearLayout) inflater.inflate(R.layout.liste_header, null);

		lvHeaderTipsTv = (TextView) headerView.findViewById(R.id.lvHeaderTipsTv);
		lvHeaderLastUpdatedTv = (TextView) headerView.findViewById(R.id.lvHeaderLastUpdatedTv);

		lvheaderArrowIv = (ImageView) headerView.findViewById(R.id.lvHeaderArrowIv);
		lvheaderProgressBar = (ProgressBar) headerView.findViewById(R.id.lvHeaderProgressBar);

		measureView(headerView);
		headerContentHeight = headerView.getMeasuredHeight();

		// 设置内边距，正好距离顶部为一个负的整个布局的高度，正好把头部隐藏
		headerView.setPadding(0, -1 * headerContentHeight, 0, 0);
		headerView.invalidate();

		addHeaderView(headerView, null, false);// 将下拉刷新的布局加入的顶部
		setOnScrollListener(this);// 设置滚动监听事件
		// 设置旋转动画事件
		animation = new RotateAnimation(0, -180, RotateAnimation.RELATIVE_TO_SELF, 0.5f,
				RotateAnimation.RELATIVE_TO_SELF, 0.5f);
		animation.setInterpolator(new LinearInterpolator());
		animation.setDuration(250);
		animation.setFillAfter(true);

		reverseAnimation = new RotateAnimation(-180, 0, RotateAnimation.RELATIVE_TO_SELF, 0.5f,
				RotateAnimation.RELATIVE_TO_SELF, 0.5f);
		reverseAnimation.setInterpolator(new LinearInterpolator());
		reverseAnimation.setDuration(200);
		reverseAnimation.setFillAfter(true);

		state = DONE;// 一开始的状态就是下拉刷新完的状态，所以为DONE
		// 是否正在刷新
		isRefreshable = false;
	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
		// TODO Auto-generated method stub
		if (firstVisibleItem == 0) {
			isRefreshable = true;
		} else {
			isRefreshable = false;
		}
	}

	@SuppressLint("ClickableViewAccessibility")
	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		// TODO Auto-generated method stub

	}

	@SuppressLint("ClickableViewAccessibility")
	public boolean onTouchEvent(MotionEvent ev) {
		if (isRefreshable) {
			switch (ev.getAction()) {
			case MotionEvent.ACTION_DOWN:
				if (!isRecored) {
					isRecored = true;
					startY = (int) ev.getY();// 手指按下时记录当前位置
					Log.i("11111111111", "ACTION_DOWN");
				}
				break;
			case MotionEvent.ACTION_UP:
				if (state != REFRESHING && state != LOADING) {
					if (state == PULL_TO_REFRESH) {
						state = DONE;
						changeHeaderViewByState();
						Log.i("222222222", "ACTION_UP");
					}
					if (state == RELEASE_TO_REFRESH) {
						state = REFRESHING;
						changeHeaderViewByState();
						onLvRefresh();

					}
				}
				isRecored = false;
				isBack = false;
				break;
			case MotionEvent.ACTION_MOVE:
				int tempY = (int) ev.getY();
				if (!isRecored) {
					isRecored = true;
					startY = tempY;
					Log.i("333333333", "ACTION_MOVE");
				}
				if (state != REFRESHING && isRecored && state != LOADING) {
					// 保证在设置padding的过程，当前的位置一直是在head，否则如果当列表超出屏幕的，当在上推的时候，列表同时进行滚动可以松手去刷新了
					if (state == RELEASE_TO_REFRESH) {
						setSelection(0);
						// 往上推了，推到了屏幕足够掩盖head的程度，但是还没有推到全部掩盖的地步
						if (((tempY - startY) / RATIO < headerContentHeight) && (tempY - startY > 0)) {
							state = PULL_TO_REFRESH;
							changeHeaderViewByState();
						} else if (tempY - startY <= 0) {
							state = DONE;
							changeHeaderViewByState();
						}
					}
					// 还没有到达显示松开刷新的时候，，DONE或者是PULL_TO_REFRESH状态
					if (state == PULL_TO_REFRESH) {
						setSelection(0);
						// 下拉到可以进入RELEASE_TO_REFRESH的状态
						if ((tempY - startY) / RATIO >= headerContentHeight) {
							state = RELEASE_TO_REFRESH;
							isBack = true;
							changeHeaderViewByState();
							// 上推到顶了
						} else if (tempY - startY <= 0) {// 由deone或者下拉刷新状态变到done状态
							state = DONE;
							changeHeaderViewByState();
						}
					}
					// done状态
					if (state == DONE) {
						if (tempY - startY > 0) {
							state = PULL_TO_REFRESH;
							changeHeaderViewByState();
						}
					}
					// 跟新headerView的size
					if (state == PULL_TO_REFRESH) {
						headerView.setPadding(0, -1 * headerContentHeight + (tempY - startY) / RATIO, 0, 0);
					}
					// 跟新headView的paddingTop
					if (state == RELEASE_TO_REFRESH) {
						headerView.setPadding(0, (tempY - startY) / RATIO - headerContentHeight, 0, 0);

					}

				}
				break;
			default:
				break;

			}
		}
		return super.onTouchEvent(ev);

	}

	// 当状态改变时候，调用该方法，比更新界面
	private void changeHeaderViewByState() {

		switch (state) {
		case RELEASE_TO_REFRESH:
			lvheaderArrowIv.setVisibility(View.VISIBLE);

			lvheaderProgressBar.setVisibility(View.GONE);

			lvHeaderTipsTv.setVisibility(View.VISIBLE);

			lvHeaderLastUpdatedTv.setVisibility(View.VISIBLE);
			lvheaderArrowIv.clearAnimation();
			lvheaderArrowIv.startAnimation(animation);
			lvHeaderTipsTv.setText("松开刷新");
			break;
		case PULL_TO_REFRESH:

			lvheaderProgressBar.setVisibility(View.GONE);
			lvHeaderTipsTv.setVisibility(View.VISIBLE);
			lvHeaderLastUpdatedTv.setVisibility(View.VISIBLE);
			lvheaderArrowIv.clearAnimation();
			lvheaderArrowIv.setVisibility(View.VISIBLE);
			if (isBack) {
				isBack = false;
				lvheaderArrowIv.clearAnimation();
				lvheaderArrowIv.startAnimation(reverseAnimation);

				lvHeaderTipsTv.setText("下拉刷新");
			} else {
				lvHeaderTipsTv.setText("下拉刷新");
			}

			break;
		case REFRESHING:
			headerView.setPadding(0, 0, 0, 0);
			lvheaderProgressBar.setVisibility(View.VISIBLE);

			lvheaderArrowIv.clearAnimation();
			lvheaderArrowIv.setVisibility(View.GONE);
			lvHeaderTipsTv.setText("正在刷新...");
			lvHeaderLastUpdatedTv.setVisibility(View.VISIBLE);
			break;
		case DONE:
			headerView.setPadding(0, -1 * headerContentHeight, 0, 0);
			lvheaderProgressBar.setVisibility(View.GONE);

			lvheaderArrowIv.clearAnimation();
			lvheaderArrowIv.setImageResource(R.drawable.xlistview_arrow);
			lvHeaderTipsTv.setText("下拉刷新");
			lvHeaderLastUpdatedTv.setVisibility(View.VISIBLE);

			break;

		}
	}

	// 下拉刷新的demo
	@SuppressWarnings("deprecation")
	private void measureView(View child) {

		ViewGroup.LayoutParams params = child.getLayoutParams();
		if (params == null) {
			params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,
					ViewGroup.LayoutParams.WRAP_CONTENT);
		}
		int childWidthSpec = ViewGroup.getChildMeasureSpec(0, 0, params.width);
		int lpHeight = params.height;
		int childHeightSpec = 0;
		if (lpHeight > 0) {
			childWidthSpec = MeasureSpec.makeMeasureSpec(lpHeight, MeasureSpec.EXACTLY);
		} else {
			childWidthSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
		}
		child.measure(childWidthSpec, childHeightSpec);
	}

	public void setonRefreshListener(OnRefreshListener refreshListener) {
		this.refreshListener = refreshListener;
		isRefreshable = true;
	}

	public interface OnRefreshListener {
		public void onRefresh();
	}

	@SuppressWarnings("deprecation")
	public void onRefreshComplete() {
		state = DONE;
		// 设置跟新时间利用new date 获取当前时间
		lvHeaderLastUpdatedTv.setText("最近更新:" + new Date().toLocaleString());
		changeHeaderViewByState();

	}

	public void onLvRefresh() {// 回调
		if (refreshListener != null) {
			refreshListener.onRefresh();

		}
	}

	@SuppressWarnings("deprecation")
	public void setAdapter(ListAdapter adapter) {
		lvHeaderLastUpdatedTv.setText("最近更新:" + new Date().toLocaleString());
		super.setAdapter(adapter);
	}

}
