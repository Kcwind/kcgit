package com.kc.dangao.adapter;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author kc
 * @time 2013-4-28 1:21:23
 * @describe
 */
public class ViewPaperAdapter extends PagerAdapter{
	private List<View> views;
	public ViewPaperAdapter(List<View> items) {
		this.views = items;
	}
	
	@Override
	public int getCount() {
		return views.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(views.get(position));
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		container.addView(views.get(position),0);
		return views.get(position);
	}

}
