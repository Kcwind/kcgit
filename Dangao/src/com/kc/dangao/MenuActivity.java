package com.kc.dangao;

import com.kc.dangao.adapter.Menu1GridAdapter;
import com.kc.dangao.pojo.MenuGridItem;

import android.os.Bundle;
import android.widget.GridView;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

@ContentView(R.layout.menu1_layout)
public class MenuActivity extends RoboActivity{
	@InjectView(R.id.menu1_grid) GridView menuGrid;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Menu1GridAdapter adapter = new Menu1GridAdapter(this);
		adapter.setItems(getItems());
		menuGrid.setAdapter(adapter);
	}
	
	private MenuGridItem[] getItems() {
		
		MenuGridItem[] items = new MenuGridItem[9];
		for (int i = 0; i < items.length; i++) {
			items[i] = new MenuGridItem();
			items[i].setImageId(R.drawable.caidan1 + i);
			items[i].setItemName("菜单" + i);
		}
		return items;
	}
}
