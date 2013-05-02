package com.kc.dangao.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * @author kcwind
 * @time 2013-4-28 11:02:29
 * @describe  实现自动翻页功能的ViewPager
 */
public class SmartViewPager extends ViewPager {
	public static final int START_TURN = 1;
	public static final int STOP_TURN = 2;

	private long duration = 3000; //默认间隔时间3000毫秒
	private Handler mHandler;
	private boolean isTurnning;
	public SmartViewPager(Context context) {
		super(context);
		init();
	}
	
	public SmartViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public Handler getmHandler() {
		return mHandler;
	}

	/**
	 * 开始自动翻页
	 */
	public void start() {
		isTurnning = true;
		new Thread(){  //新建一个自动翻页的线程
			@Override
			public void run() {
				while (isTurnning) {
					try {
						Thread.sleep(duration);
						mHandler.sendEmptyMessage(START_TURN);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}.start();
	}
	
	/**
	 *停止自动翻页
	 */
	public void stop() {
		isTurnning = false;
	}
	
	public void setDuration(long duration) {
		this.duration = duration;
	}
	
	@SuppressLint("HandlerLeak")
	private void init() {
		
		mHandler = new Handler(){

			@Override
			public void handleMessage(Message msg) {
				switch (msg.what) {
				case START_TURN:
					turnToNextPage();
					break;

				default:
					break;
				}
			}
		};
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
		case MotionEvent.ACTION_MOVE:
			stop();
			break;
		case MotionEvent.ACTION_UP:
			start();
		default:
			break;
		}
		return super.onTouchEvent(event);
	}
	
	private void turnToNextPage() {
		int currentPage = getCurrentItem();
		if (currentPage == getAdapter().getCount()-1) {
			setCurrentItem(0);
		}else {
			setCurrentItem(currentPage+1);
		}
	}
}
