package cn.try4.color;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {//会发生第二次点击出现blank页面的bug
	public List<Fragment> fragments;

	public MyFragmentPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
		super(fm);
		this.fragments = fragments;
	}
	

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		return fragments.get(arg0);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return fragments.size();
	}

}