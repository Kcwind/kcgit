package com.kc.beautifulgirl;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.kc.beautifulgirl.adapter.MainGridAdapter;
import com.kc.beautifulgirl.pojo.MainGridItem;
import com.kc.beautifulgirl.resources.Resource;

public class MainActivity extends BaseActivity {
	private GridView grid;
	private MainGridAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		adapter = new MainGridAdapter(this);
		adapter.setItems(getItems());
		grid.setAdapter(adapter);
	}

	@Override
	public void initViews() {
		setContentView(R.layout.main);
		grid = (GridView)findViewById(R.id.main_grid);
		
	}

	@Override
	public void setListeners() {
		
		grid.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				Intent intent = new Intent(MainActivity.this, ImageViewActivity.class);
				intent.putExtra("position", position);
				startActivity(intent);
			}
		});
		
	}
	
	private MainGridItem[] getItems() {
		int[] ids = Resource.ImageResource.gridIds;
		String[] titles = Resource.StringResource.gridTitles;
		MainGridItem[] items = new MainGridItem[ids.length];
		for (int i = 0; i < items.length; i++) {
			MainGridItem item = new MainGridItem();
			item.setImageId(ids[i]);
			item.setItemName(titles[i]);
			items[i] = item;
		}
		return items;
	}
}
