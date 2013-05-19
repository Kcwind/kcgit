package com.kc.dangao.adapter;

import com.kc.dangao.R;
import com.kc.dangao.pojo.MenuGridItem;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author kc
 * @time 2013-4-27 10:36:37
 * @describe
 */
public class Menu1GridAdapter extends BaseAdapter {
	private Activity activity;
	
	public Menu1GridAdapter(Activity activity) {
		this.activity = activity;
	}
	
	private MenuGridItem[] items = null;
	
	@Override
	public int getCount() {
		return items.length;
	}

	@Override
	public Object getItem(int position) {
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
			convertView = activity.getLayoutInflater().inflate(R.layout.menu1_grid_item, null);
			viewHold = new ViewHold();
			viewHold.imageView = (ImageView) convertView.findViewById(R.id.menu1_griditem_image);
			viewHold.textView = (TextView) convertView.findViewById(R.id.menu1_griditem_text);
			convertView.setTag(viewHold);
		}else {
			viewHold = (ViewHold) convertView.getTag();
		}
		
		viewHold.imageView.setImageResource(items[position].getImageId());
		viewHold.textView.setText(items[position].getItemName());
		return convertView;
	}

	public void setItems(MenuGridItem[] items) {
		this.items = items;
	}
	
	private class ViewHold {
		ImageView imageView;
		TextView textView;
	}
}
