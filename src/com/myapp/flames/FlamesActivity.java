package com.myapp.flames;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class FlamesActivity extends Activity {
	/** Called when the activity is first created. */
	Thread thr1;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		thr1 = new Thread() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				try {
				//	introMusic.start();
					sleep(3000);
					startActivity(new Intent("com.myapp.flames.SPLASH"));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				} finally {
					finish();
				}

			}

		};
		thr1.start();
		
		
		//final MediaPlayer introMusic = MediaPlayer.create(Splash.this, R.raw.bgm1);
	

	}
	
	
	
	
	

}