package cn.try4.color;

import android.os.Bundle;

public class MainActivity extends NavActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.main);
		super.onCreate(savedInstanceState);
	}

	/*
	 * public void onNavItemClick(int id) {// not used fragment nav, use extends
	 * // NavActivity // TODO Auto-generated method stub //
	 * progressBar.setVisibility(0); loadFragment(id); }
	 */
}