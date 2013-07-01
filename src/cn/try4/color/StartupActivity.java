package cn.try4.color;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;

public class StartupActivity extends Activity {

	TimerTask task = new TimerTask(){  
		public void run() {	    	 
	    	Intent intent = new Intent(StartupActivity.this, MainActivity.class);			
			startActivity(intent);
		};
	};  
	
	Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			//super.handleMessage(msg);
			if(msg.what == 0x123) {
				Intent intent = new Intent(StartupActivity.this, MainActivity.class);			
				startActivity(intent);
				finish();//if not, error occur after restart
			}
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.startup);
		//Timer timer = new Timer();
		//timer.schedule(task, 1000);
		ColorModel.getColorModel(handler);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.startup, menu);
		return true;
	}
}
