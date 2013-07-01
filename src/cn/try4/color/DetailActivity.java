package cn.try4.color;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail);
		Bundle bundle = this.getIntent().getExtras();
		initView(bundle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.startup, menu);
		return true;
	}

	private void initView(Bundle bundle) {
		ImageView imageView = (ImageView) findViewById(R.id.image);
		TextView textView = (TextView) findViewById(R.id.text);
		imageView.setImageDrawable(new ColorDrawable(Color.parseColor(bundle
				.getString("hex").toString())));
		textView.setText("中文名:  " + bundle.getString("zh") + "\n英文名:  " + bundle.getString("en") + "\nHEX     :  " + bundle.getString("hex") + "\nRGB     :  " + bundle.getString("rgb"));
	}
}
