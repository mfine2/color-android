package cn.try4.color;

import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyGridViewAdapter extends BaseAdapter {
	private Context context;
	private List<Bundle> list;
	private Bundle bundle;

	private class ItemContainer {
		ImageView imageView;
		TextView textView;
	}

	public MyGridViewAdapter(Context context, List<Bundle> list, Bundle bundle) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.list = list;
		this.bundle = bundle;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		//return Math.min(list.size(), bundle.getInt("itemCounts"));
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ItemContainer itemContainer;
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(R.layout.item,
					null);
			itemContainer = new ItemContainer();
			itemContainer.imageView = (ImageView) convertView
					.findViewById(R.id.image);
			itemContainer.textView = (TextView) convertView
					.findViewById(R.id.text);
			convertView.setTag(itemContainer);
		} else {
			itemContainer = (ItemContainer) convertView.getTag();
		}
		
		Bundle map = list.get(position);
		itemContainer.imageView.setImageDrawable(new ColorDrawable(Color
				.parseColor(map.getString("hex").toString())));
		itemContainer.textView.setText(map.getString("zh"));
		
		//int w  = itemContainer.imageView.getMeasuredWidth();//can not get width each time
		
		LayoutParams layoutParams = itemContainer.imageView.getLayoutParams();
		layoutParams.height = bundle.getInt("itemHeight");
		layoutParams.width = bundle.getInt("itemWidth");
		itemContainer.imageView.setLayoutParams(layoutParams);
		return convertView;
	}

}
