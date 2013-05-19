package com.kc.beautifulgirl.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kc.beautifulgirl.R;
import com.kc.beautifulgirl.pojo.MainGridItem;

public class MainGridAdapter extends BaseAdapter {
private Activity activity;
	
	public MainGridAdapter(Activity activity) {
		this.activity = activity;
	}
	
	private MainGridItem[] items = null;
	
	@Override
	public int getCount() {
		return items.length;
	}

	@Override
	public MainGridItem getItem(int position) {
		return items[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHold viewHold = null;
		if (convertView == null) {
			convertView = activity.getLayoutInflater().inflate(R.layout.main_grid_item, null);
			viewHold = new ViewHold();
			viewHold.imageView = (ImageView) convertView.findViewById(R.id.main_griditem_image);
			viewHold.textView = (TextView) convertView.findViewById(R.id.main_griditem_text);
			convertView.setTag(viewHold);
		}else {
			viewHold = (ViewHold) convertView.getTag();
		}
		
		viewHold.imageView.setImageResource(items[position].getImageId());
		viewHold.textView.setText(items[position].getItemName());
		return convertView;
	}

	public void setItems(MainGridItem[] items) {
		this.items = items;
	}
	
	private class ViewHold {
		ImageView imageView;
		TextView textView;
	}
}
