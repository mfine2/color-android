package cn.try4.color;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class StartupActivity extends Activity {

	TimerTask task = new TimerTask(){  
		public void run() {	    	 
			finish();
			System.exit(0); 
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
			} else if(msg.what == 0x000) {
				Timer timer = new Timer();
				timer.schedule(task, 3000);
				Toast.makeText(StartupActivity.this, "请确认网络已连接再打开此应用", Toast.LENGTH_LONG).show();
			}
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.startup);
		/*
		findViewById(R.id.goMainActivity).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(StartupActivity.this, MainActivity.class);			
				startActivity(intent);
			}
			
		});
		*/
		ColorModel.getColorModel(handler, StartupActivity.this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.startup, menu);
		return true;
	}
}
