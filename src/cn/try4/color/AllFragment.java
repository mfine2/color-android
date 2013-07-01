package cn.try4.color;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

public class AllFragment extends MyGridViewFrament {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.all_fragment, container,
				false);

		GridView gridView = (GridView) rootView.findViewById(R.id.gridview);

		MyGridViewAdapter gridViewAdapter = new MyGridViewAdapter(activity,
				colorList, bundle);
		gridView.setAdapter(gridViewAdapter);
		gridView.setOnItemClickListener(new MyOnItemClickListener());
		return rootView;
	}
}
