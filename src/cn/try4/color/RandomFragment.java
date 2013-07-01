package cn.try4.color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

public class RandomFragment extends MyGridViewFrament {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.random_fragment, container,
				false);

		GridView gridView = (GridView) rootView.findViewById(R.id.gridview);

		List<Bundle> randomList = randomList(colorList, bundle);
		setList(randomList);
		MyGridViewAdapter gridViewAdapter = new MyGridViewAdapter(activity,
				randomList, bundle);
		gridView.setAdapter(gridViewAdapter);
		gridView.setOnItemClickListener(new MyOnItemClickListener());
		return rootView;
	}

	private List<Bundle> randomList(List<Bundle> list, Bundle bundle) {
		Random random = new Random();
		int len = list.size();
		int count = bundle.getInt("itemCounts");
		List<Bundle> result = new ArrayList<Bundle>();
		for (int i = 0; i < count; i++) {
			int index = random.nextInt(len);
			result.add(list.get(index));
		}
		return result;
	}
	/*
	 * private void initGridView(GridView gridView) { SimpleAdapter
	 * simpleAdapter = new SimpleAdapter(activity, colorList, R.layout.item, new
	 * String[] { "hex", "name" }, new int[] { R.id.image, R.id.text });
	 * 
	 * simpleAdapter.setViewBinder(new ViewBinder() {
	 * 
	 * @Override public boolean setViewValue(View view, Object data, String
	 * textRepresentation) { // TODO Auto-generated method stub if ((view
	 * instanceof ImageView) & (data instanceof String)) { ImageView imageView =
	 * (ImageView) view; imageView.setImageDrawable(new ColorDrawable(Color
	 * .parseColor(data.toString()))); return true; } return false; } });
	 * 
	 * gridView.setAdapter(simpleAdapter); }
	 */
}
