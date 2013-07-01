package cn.try4.color;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class MyMetrics {
	private int width = 0;
	private int height = 0;
	private float density = 0;

	private float horizontalSpacing = 0;
	private float verticalSpacing = 0;

	private float itemWidth = 0;// height = width
	private float itemHeight = 0;

	private int numColumns = 3;
	private int numRows = 3;
	private int itemCounts = 0;

	public MyMetrics(Context context) {
		// TODO Auto-generated constructor stub
		Activity activity = (Activity) context;
		DisplayMetrics displayMetrics = new DisplayMetrics();
		activity.getWindowManager().getDefaultDisplay()
				.getMetrics(displayMetrics);

		this.width = displayMetrics.widthPixels;
		this.height = displayMetrics.heightPixels;
		this.density = displayMetrics.density;
		// int densityDpi = displayMetrics.densityDpi

		// this.widthDp = (int) (this.width / this.density);
		// this.heightDp = (int) (this.height / this.density);

		this.horizontalSpacing = activity.getResources().getDimension(
				R.dimen.gridview_horizontalSpacing);
		this.verticalSpacing = activity.getResources().getDimension(
				R.dimen.gridview_verticalSpacing);
	}

	public Bundle getGridViewItemInfo() {
		float totalHS = (numColumns + 1) * horizontalSpacing;
		itemWidth = (width - totalHS) / numColumns;
		itemHeight = itemWidth;
		// heightDp = (numRows + 1) * verticalSpacing + itemHeight * numRows;
		double tempRows = (height - verticalSpacing)
				/ (verticalSpacing + itemHeight);
		numRows = (int) Math.ceil(tempRows);
		itemCounts = numRows * numColumns;

		Bundle bundle = new Bundle();
		bundle.putInt("itemWidth", (int) itemWidth);
		bundle.putInt("itemHeight", (int) itemHeight);
		bundle.putInt("numRows", numRows);
		bundle.putInt("numColumns", numColumns);
		bundle.putInt("itemCounts", itemCounts);
		return bundle;
	}
}