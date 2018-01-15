package com.example.cpuschedulingprocess;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FIRST extends Activity {

	String title = "CPU SCHEDULING PROCESS";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle(title);
		setContentView(R.layout.activity_first);
		
		Button process_priority = (Button) findViewById (R.id.process_priority);
		Button process_sjf = (Button) findViewById (R.id.process_sjf);
		Button process_fcfs = (Button) findViewById (R.id.process_fcfs);
		Button process_rr = (Button) findViewById (R.id.process_rr);		
		
		process_priority.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(FIRST.this, MainActivity.class);
				startActivity(i);
				
				
			}
		});
		
		
		process_sjf.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(FIRST.this, SJF.class);
				startActivity(i);
				
				
			}
		});
		
		
		process_fcfs.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(FIRST.this, FCFS.class);
				startActivity(i);
				
				
			}
		});
		
		process_rr.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(FIRST.this, Round_robin.class);
				startActivity(i);
				
				
			}
		});
		
		
		
		
		
		
	}


}
