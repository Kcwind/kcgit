package com.kc.beautifulgirl;

import android.app.Activity;
import android.os.Bundle;

public abstract class BaseActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initViews();
		setListeners();
	}
	
	public abstract void initViews();
	public abstract void setListeners();
}
