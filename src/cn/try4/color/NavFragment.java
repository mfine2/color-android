package cn.try4.color;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class NavFragment extends Fragment {
	private NavInterface navInterface;

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		navInterface = (NavInterface) activity;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.nav, container,
				false);

		rootView.findViewById(R.id.navList).setOnClickListener(
				new MyOnClickListener());
		rootView.findViewById(R.id.navRandom).setOnClickListener(
				new MyOnClickListener());
		rootView.findViewById(R.id.navAll).setOnClickListener(
				new MyOnClickListener());

		// TODO Auto-generated method stub
		// return super.onCreateView(inflater, container, savedInstanceState);
		return rootView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onDetach() {
		// TODO Auto-generated method stub
		super.onDetach();
		navInterface = null;
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	public class MyOnClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int id = v.getId();
			navInterface.onNavItemClick(id);
		}

	}
}