package com.kc.dangao;

import java.util.ArrayList;
import java.util.List;

import com.kc.dangao.adapter.ViewPaperAdapter;
import com.kc.dangao.view.SmartViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

/**
 * @author kc
 * @time 2013-4-28 1:43:29
 * @describe
 */
@ContentView(R.layout.menu4_company_layout)
public class CompanyInfoActivity extends RoboActivity{
	@InjectView(R.id.menu4_viewpager) SmartViewPager viewPager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initPager();
	}
	
	@Override
	protected void onResume() {
		viewPager.start();
		super.onResume();
	}

	@Override
	protected void onPause() {
		viewPager.stop();
		super.onPause();
	}
	
	private void initPager() {
		List<View> views = new ArrayList<View>();
		for (int i = 0; i < 4; i++) {
			View view = getLayoutInflater().inflate(R.layout.menu4_viewpager_item, null);
			ImageView image = (ImageView) view.findViewById(R.id.menu4_viewpager_imageitem);
			image.setImageResource(R.drawable.guide_01 + i);
			views.add(view);
		}
		ViewPaperAdapter adapter = new ViewPaperAdapter(views);
		viewPager.setAdapter(adapter);
	}
	
}
