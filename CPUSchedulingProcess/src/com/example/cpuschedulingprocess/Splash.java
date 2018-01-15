package com.example.cpuschedulingprocess;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class Splash extends Activity {

	Intent i;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		Thread bg = new Thread()
		{
			@Override
			public void run()
		{
		
			try {
				
				sleep(3*1000);
				i= new Intent(getBaseContext(),FIRST.class);
					startActivity(i);
					finish();
			}

		
			
			catch(Exception e){}
			}
		};
			
		bg.start();
		
		
		
	}

	

}
