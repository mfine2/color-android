package cn.try4.color;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class MyGridViewFrament extends Fragment {
	public FragmentActivity activity;
	public Bundle bundle;
	public List<Bundle> colorList = ColorModel.colorList;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			bundle = getArguments();
		}
		activity = getActivity();
	}

	public void setList(List<Bundle> list) {
		this.colorList = list;
	}
	
	public class MyOnItemClickListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(activity, DetailActivity.class);
			intent.putExtras(colorList.get(position));
			startActivity(intent);
		}

	}
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		activity.findViewById(R.id.loading).setVisibility(View.INVISIBLE);
	}
}