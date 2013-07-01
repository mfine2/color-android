package cn.try4.color;

import java.util.ArrayList;
import java.util.List;

import cn.try4.color.R;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class GuideActivity extends Activity {
	private static final String IS_FIRST_COME = "isFirstCome";
	private static final String FILE_NAME = "cn.try4.color";

	List<TextView> textViews;
	List<View> listViews;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guide);

		initViews();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.startup, menu);
		return true;
	}

	private void initViews() {
		textViews = new ArrayList<TextView>();
		textViews.add((TextView) findViewById(R.id.page01));
		textViews.add((TextView) findViewById(R.id.page02));
		textViews.add((TextView) findViewById(R.id.page03));
		textViews.add((TextView) findViewById(R.id.page04));
		textViews.add((TextView) findViewById(R.id.page05));

		listViews = new ArrayList<View>();
		LayoutInflater layoutInflater = getLayoutInflater();

		listViews.add(layoutInflater.inflate(R.layout.guide01, null));
		listViews.add(layoutInflater.inflate(R.layout.guide02, null));
		listViews.add(layoutInflater.inflate(R.layout.guide03, null));
		listViews.add(layoutInflater.inflate(R.layout.guide04, null));
		listViews.add(layoutInflater.inflate(R.layout.guide05, null));

		ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
		viewPager.setAdapter(new MyViewPagerAdapter(listViews));
		viewPager.setOnPageChangeListener(new MyOnPageChangeListener());

		int index = 0;
		textViews.get(index).setTextColor(
				getResources().getColor(R.color.fifteen6));
		viewPager.setCurrentItem(index);
	}

	public class MyOnPageChangeListener implements OnPageChangeListener {
		private int index = -1;

		public MyOnPageChangeListener() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onPageScrollStateChanged(int state) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageScrolled(int position, float positionOffset,
				int positionOffsetPixels) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageSelected(int position) {
			// TODO Auto-generated method stub
			Resources resources = getResources();

			textViews.get(position).setTextColor(
					resources.getColor(R.color.fifteen6));
			if (position > 0) {
				textViews.get(position - 1).setTextColor(
						resources.getColor(R.color.nine6));
			}
			if (position + 1 < textViews.size()) {
				textViews.get(position + 1).setTextColor(
						resources.getColor(R.color.nine6));
			}
			/*
			 * if(position > index) { System.out.println("next" + index + ":" +
			 * position); } else if(position < index) { System.out.println("pre"
			 * + index + ":" + position); }
			 */
			index = position;

		}
	}

	public void goStartup(View v) {
		setFirstComed(true);
		addShortCut();
		Intent intent = new Intent();
		intent.setClass(GuideActivity.this, StartupActivity.class);
		startActivity(intent);
	}

	private void setFirstComed(boolean flag) {
		SharedPreferences sp = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
		SharedPreferences.Editor spEdit = sp.edit();
		spEdit.putBoolean(IS_FIRST_COME, false);
		spEdit.commit();
	}

	private void addShortCut() {
		Intent shortcut = new Intent(
				"com.android.launcher.action.INSTALL_SHORTCUT");
		Resources resources = getResources();
		String appName = resources.getString(R.string.app_name);
		ShortcutIconResource shortcutIconResource = Intent.ShortcutIconResource
				.fromContext(GuideActivity.this, R.drawable.ic_launcher);
		// Intent myIntent = new Intent(getApplicationContext(),
		// GuideActivity.class);
		String appClass = this.getPackageName() + "." + "LoadingActivity";
		ComponentName comp = new ComponentName(this.getPackageName(), appClass);
		Intent myIntent = new Intent(Intent.ACTION_MAIN).setComponent(comp);
		shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, myIntent);

		shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME, appName);
		shortcut.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,
				shortcutIconResource);
		shortcut.putExtra("duplicate", false);
		shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, myIntent);
		sendBroadcast(shortcut);
	}
}