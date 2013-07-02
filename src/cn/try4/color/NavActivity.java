package cn.try4.color;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;

public class NavActivity extends FragmentActivity {

	public ProgressBar progressBar;// not in nav.xml
	public Bundle bundle;
	public TextView navList;
	public TextView navRandom;
	public TextView navAll;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MyMetrics myMetrics = new MyMetrics(NavActivity.this);
		bundle = myMetrics.getGridViewItemInfo();

		progressBar = (ProgressBar) findViewById(R.id.loading);

		navList = (TextView) findViewById(R.id.navList);
		navList.setOnClickListener(new MyOnClickListener());
		
		navRandom = (TextView) findViewById(R.id.navRandom);
		navRandom.setOnClickListener(new MyOnClickListener());
		
		navAll = (TextView) findViewById(R.id.navAll);
		navAll.setOnClickListener(new MyOnClickListener());

		loadFragment(R.id.navList);
	}

	@Override
	protected void onResume() {// onCreate 无法获取元素在MainActivity setContentView之后???
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.startup, menu);
		return false;
	}

	public class MyOnClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			int id = v.getId();
			loadFragment(id);
		}

	}

	public void loadFragment(int id) {
		FragmentManager fragmentManager = getSupportFragmentManager();

		progressBar.setVisibility(View.VISIBLE);
		
		Resources resources = getResources();
		navList.setBackgroundColor(resources.getColor(R.color.zero8));
		navRandom.setBackgroundColor(resources.getColor(R.color.zero8));
		navAll.setBackgroundColor(resources.getColor(R.color.zero8));

		switch (id) {
		case R.id.navList: {
			navList.setBackgroundColor(resources.getColor(R.color.curentbg));
			ListFragments listFragments = new ListFragments();
			listFragments.setArguments(bundle);
			fragmentManager.beginTransaction()
					.replace(R.id.fragmentContainer, listFragments).commit();

			break;
		}

		case R.id.navRandom: {
			navRandom.setBackgroundColor(resources.getColor(R.color.curentbg));
			RandomFragment randomFragment = new RandomFragment();
			randomFragment.setArguments(bundle);
			fragmentManager.beginTransaction()
					.replace(R.id.fragmentContainer, randomFragment).commit();
			break;
		}

		case R.id.navAll: {
			navAll.setBackgroundColor(resources.getColor(R.color.curentbg));
			AllFragment allFragment = new AllFragment();
			allFragment.setArguments(bundle);
			fragmentManager.beginTransaction()
					.replace(R.id.fragmentContainer, allFragment).commit();
			break;
		}

		default: {
			break;
		}
		}
		// progressBar.setVisibility(View.INVISIBLE); //not worked, why?
	}

}
