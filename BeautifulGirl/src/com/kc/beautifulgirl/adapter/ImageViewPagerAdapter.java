package com.kc.beautifulgirl.adapter;

import java.util.List;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class ImageViewPagerAdapter extends PagerAdapter {
	private List<View> views;
	
	public ImageViewPagerAdapter(Activity activity,List<View> views) {
		this.views = views;
	}
	
	@Override
	public int getCount() {
		return views.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0==arg1;
	}
	
	@Override  
    public void destroyItem(ViewGroup container, int position, Object object)   {    
        container.removeView(views.get(position));//删除页卡  
    }
	
	 @Override  
     public Object instantiateItem(ViewGroup container, int position) {  //这个方法用来实例化页卡         
         container.addView(views.get(position), 0);//添加页卡  
         return views.get(position);  
     }

}
