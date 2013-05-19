package com.kc.beautifulgirl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.app.WallpaperManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.kc.beautifulgirl.adapter.ImageViewPagerAdapter;
import com.kc.beautifulgirl.resources.Resource;

public class ImageViewActivity extends BaseActivity {
	private ViewPager viewPager;
	private WallpaperManager wallpaperManager;
	private ImageViewPagerAdapter pagerAdapter;
	private int[] ids;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ids = getItems();
		wallpaperManager = WallpaperManager.getInstance(this);
		pagerAdapter = new ImageViewPagerAdapter(getViews());
		viewPager.setAdapter(pagerAdapter);
		
	}
	
	@Override
	public void initViews() {
		setContentView(R.layout.imageview_layout);
		viewPager = (ViewPager)findViewById(R.id.imageview_viewpager);
		
	}

	@Override
	public void setListeners() {
		
		// TODO Auto-generated method stub
		
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
