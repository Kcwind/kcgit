package com.kc.dangao;

import roboguice.activity.RoboTabActivity;
import roboguice.inject.ContentView;

import com.google.inject.Inject;

import android.os.Bundle;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.TabHost;

@ContentView(R.layout.main_tab_layout)
public class MainTabActivity extends RoboTabActivity {
	private TabHost tabHost;
	@Inject private Resources res;
	private LayoutInflater inflater;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		inflater = getLayoutInflater();
		initTab();
	}
	
	private void initTab() {
		tabHost = getTabHost();
		Intent intent = new Intent(this, MenuActivity.class);
		
		tabHost.addTab(tabHost.newTabSpec("菜单").setIndicator(getMenuBox("菜单", R.drawable.menu_t01)).setContent(intent));
		tabHost.addTab(tabHost.newTabSpec("首页").setIndicator(getMenuBox("首页", R.drawable.menu_t02)).setContent(intent));
		tabHost.addTab(tabHost.newTabSpec("呼叫").setIndicator(getMenuBox("呼叫", R.drawable.menu_t03)).setContent(intent));
		tabHost.addTab(tabHost.newTabSpec("企业信息").setIndicator(getMenuBox("企业信息", R.drawable.menu_t04)).setContent(intent));
		tabHost.addTab(tabHost.newTabSpec("更多").setIndicator(getMenuBox("更多", R.drawable.menu_t05)).setContent(intent));
		tabHost.setCurrentTab(1);
		
	}
	
	private CheckBox getMenuBox(String tag, int resId) {
		CheckBox menuBox = (CheckBox) inflater.inflate(R.layout.menu_item, null);
		menuBox.setText(tag);
		Drawable drawable= res.getDrawable(resId);
		/// 这一步必须要做,否则不会显示.
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight()); 
		menuBox.setCompoundDrawables(null, drawable, null, null);
		return menuBox;
	}

}
