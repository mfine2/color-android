package cn.try4.color;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;

public class LoadingActivity extends Activity {

	private static final String IS_FIRST_COME = "isFirstCome";
	private static final String FILE_NAME = "cn.try4.color";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loading);

		boolean isFirstCome = isFirstCome();
		Intent intent;

		if (isFirstCome) {
			intent = new Intent(LoadingActivity.this, GuideActivity.class);
		} else {
			intent = new Intent(LoadingActivity.this, StartupActivity.class);
		}

		startActivity(intent);
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.startup, menu);
		return true;
	}

	private boolean isFirstCome() {
		SharedPreferences sp = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
		return sp.getBoolean(IS_FIRST_COME, true);
	}

}
