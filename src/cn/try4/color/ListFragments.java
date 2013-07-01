package cn.try4.color;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ListFragments extends MyGridViewFrament {
	List<Fragment> listViews;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.list_fragments, container,
				false);

		initListViews(colorList, bundle);

		ViewPager viewPager = (ViewPager) rootView
				.findViewById(R.id.fragmentViewPager);
		// viewPager.setAdapter(new
		// MyFragmentPagerAdapter(activity.getSupportFragmentManager(),
		// listViews));
		viewPager.setAdapter(new MyFragmentStatePagerAdapter(activity
				.getSupportFragmentManager(), listViews));
		viewPager.setOnPageChangeListener(new MyOnPageChangeListener());

		return rootView;
	}

	private void initListViews(List<Bundle> colorList, Bundle bundle) {
		double size = colorList.size();
		int itemCount = bundle.getInt("itemCounts");
		int pageCount = (int) Math.ceil(size / itemCount);// fk 除法这么大的坑都能忘记

		listViews = new ArrayList<Fragment>();
		for (int i = 0; i < pageCount; i++) {
			int start = i * itemCount;
			int end = Math.min((i + 1) * itemCount, (int) size);
			ListFragment listFragment = new ListFragment();
			listFragment.setList(colorList.subList(start, end));
			listFragment.setArguments(bundle);
			listViews.add(listFragment);
		}
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

			if (position > index) {
				System.out.println("next" + index + ":" + position);
			} else if (position < index) {
				System.out.println("pre" + index + ":" + position);
			}
			index = position;

		}
	}
}