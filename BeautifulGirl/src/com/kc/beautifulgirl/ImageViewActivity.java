package com.kc.beautifulgirl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.app.WallpaperManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.kc.beautifulgirl.adapter.ImageViewPagerAdapter;
import com.kc.beautifulgirl.resources.Resource;

public class ImageViewActivity extends BaseActivity {
	private ViewPager viewPager;
	private WallpaperManager wallpaperManager;
	private ImageViewPagerAdapter pagerAdapter;
	private int[] ids;
	private List<View> views;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ids = getItems();
		wallpaperManager = WallpaperManager.getInstance(this);
		views = getViews();
		pagerAdapter = new ImageViewPagerAdapter(this, views);
		viewPager.setAdapter(pagerAdapter);
		
	}
	
	@Override
	public void initViews() {
		setContentView(R.layout.imageview_layout);
		viewPager = (ViewPager)findViewById(R.id.imageview_viewpager);
		
	}

	@Override
	public void setListeners() {
		final Animation inAnimation = AnimationUtils.loadAnimation(this, R.anim.in_anim);
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				views.get(arg0).startAnimation(inAnimation);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
			}
		});
		
	}

	private int[] getItems() {
		Intent intent = getIntent();
		int position = intent.getIntExtra("position", 0);
		return Resource.ImageResource.gridResources[position];
	}
	
	private List<View> getViews() {
		LayoutInflater inflater = getLayoutInflater();
		List<View> views = new ArrayList<View>();
		for (int i = 0; i < ids.length; i++) {
			ImageView view = (ImageView) inflater.inflate(R.layout.imageview_item, null);
			view.setImageResource(ids[i]);
			views.add(view);
		}
		
		return views;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.imageview_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_settings:
			try {
				int resId = ids[viewPager.getCurrentItem()];
				wallpaperManager.setResource(resId);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
