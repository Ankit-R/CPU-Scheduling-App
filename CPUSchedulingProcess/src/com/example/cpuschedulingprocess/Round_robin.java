package com.example.cpuschedulingprocess;

import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputType;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class Round_robin extends Activity {

	Button btn_main;
	EditText et_main, et_tq;
	int n,tq;
	String str;
	String title = "ROUND ROBIN SCHEDULING";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle(title);
		setContentView(R.layout.activity_round_robin);
		
		
		
		btn_main = (Button) findViewById (R.id.btn_main);
		et_main = (EditText) findViewById (R.id.et_main);
		et_tq = (EditText) findViewById (R.id.et_tq);
		
		btn_main.setOnClickListener(new OnClickListener() {
			int cn = 0;
			
			@Override
			public void onClick(View arg0) {
				
				
				String str = et_main.getText().toString();
				String str1 = et_tq.getText().toString();

				 if(TextUtils.isEmpty(str)) {
				    et_main.setError("Enter Number Of Processes");
				    return;
				 }
				 else if(TextUtils.isEmpty(str1)) {
					    et_main.setError("Enter Time Quantum");
					    return;
					 }
				 
				
				
				else{
				
					if(Double.parseDouble(et_main.getText().toString()) < 10000)
					{
					
					n = Integer.parseInt(et_main.getText().toString());
					tq = Integer.parseInt(et_tq.getText().toString());
					if(n!=0 && tq!=0 ){
					
					 if(cn == 0){
							cn++;
					
					
				
					 
				/*Toast.makeText(getBaseContext(),""+n, Toast.LENGTH_LONG).show();*/
				//et_main.getText().clear();
				
				final TextView[] process_no = new TextView[n];
				final TextView[] process_no1 = new TextView[n];
				final TextView[] process_no2 = new TextView[n];
				final EditText[] at_value = new EditText[n];
				final EditText[] et_value = new EditText[n];
				//final EditText[] p_value = new EditText[n];
				
				TableLayout process_table = (TableLayout) findViewById(R.id.table_main);
				/*TextView t = new TextView(getBaseContext());*/
	            TableRow tbrow0 = new TableRow(getBaseContext());
	            TextView tv0 = new TextView(getBaseContext());
	            tv0.setText(" Process No. ");
	            tv0.setTextColor(Color.BLACK);
	            tv0.setTextSize(25);
	            tbrow0.addView(tv0);
	            TextView tv1 = new TextView(getBaseContext());
	            tv1.setText(" AT ");
	            tv1.setTextColor(Color.BLACK);
	            tv1.setTextSize(25);
	            tbrow0.addView(tv1);
	            TextView tv2 = new TextView(getBaseContext());
	            tv2.setText(" ET ");
	            tv2.setTextColor(Color.BLACK);
	            tv2.setTextSize(25);
	            tbrow0.addView(tv2);
	            process_table.addView(tbrow0);
	            
	            TableRow tbrowbtn = new TableRow(getBaseContext());
	            
	            for (int i = 0; i < n; i++) {
	            	
	                TableRow tbrow = new TableRow(getBaseContext());
	                	                
	                process_no[i] = new TextView(getBaseContext());
	                process_no[i].setText("P" + (i+1));
	                process_no[i].setTextColor(Color.BLACK);
	                process_no[i].setGravity(Gravity.CENTER);
	                tbrow.addView(process_no[i]);
	                
	                at_value[i] = new EditText(getBaseContext());
	                at_value[i].setGravity(Gravity.CENTER);
	                at_value[i].setTextColor(Color.BLACK);  
	                at_value[i].setInputType(InputType.TYPE_CLASS_NUMBER);
	                int color = Color.parseColor("#000000");
            	    Drawable drawable = at_value[i].getBackground();
            	    drawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
            	    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            	        at_value[i].setBackground(drawable);
            	    } 
            	    else {
            	        at_value[i].setCompoundDrawables(null, null, drawable, null);
            	    }
	                tbrow.addView(at_value[i]);
	                
	                et_value[i] = new EditText(getBaseContext());
	                et_value[i].setGravity(Gravity.CENTER);
	                et_value[i].setTextColor(Color.BLACK);
	                et_value[i].setInputType(InputType.TYPE_CLASS_NUMBER);
	                color = Color.parseColor("#000000");
            	    drawable = et_value[i].getBackground();
            	    drawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
            	    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            	        et_value[i].setBackground(drawable);
            	    } 
            	    else {
            	        et_value[i].setCompoundDrawables(null, null, drawable, null);
            	    }
	                tbrow.addView(et_value[i]);
	                
	                
	                process_table.addView(tbrow);
	                	               
	            }
	            	LinearLayout ll = (LinearLayout)findViewById(R.id.ll);
	            	
	            	TextView sn = new TextView(getBaseContext());
	            	sn.setText("(ET and AT to be added in 'ms' unit)");
	            	sn.setTextSize(10);
	            	sn.setTextColor(Color.RED);
	            	ll.addView(sn);
	            	
		            Button compute = new Button(getBaseContext());
					compute.setText("  Show Gantt Chart  ");
					compute.setTextSize(25);
					compute.setTextColor(Color.WHITE);
					compute.setBackgroundColor(Color.BLUE);
					ll.addView(compute);
					
					compute.setOnClickListener(new OnClickListener() {
						int cnt = 0;
						@Override
						public void onClick(View arg0) {
							
							for(int i=0; i<n; i++){
							String str = at_value[i].getText().toString();
							
							 if(TextUtils.isEmpty(str)) {
							    at_value[i].setError("Fill this field");
							    return;
							 } 
							}
							
							for(int i=0; i<n; i++){
								String str = et_value[i].getText().toString();
								
								 if(TextUtils.isEmpty(str)) {
								    et_value[i].setError("Fill this field");
								    return;
								 } 
								}
								
							
							if(cnt == 0){
								cnt++;
					
							LinearLayout Gantt = (LinearLayout) findViewById(R.id.Gantt);
			            	TextView title = new TextView(getBaseContext());
			 	            title.setText(" Gantt Chart: ");
			 	            title.setTextColor(Color.MAGENTA);
			 	            title.setTextSize(20);
			 	            Gantt.addView(title);
			 	            
			 	           LinearLayout rl = (LinearLayout) findViewById(R.id.rl);
			 	            
			 	          int i,j,temp,time,time1,a=0,b,T=0,w=0,c=0;
			 	          
			 	          
			                int x=0,y=0,z=0,m;
			                
			                double AVG_WT=0,AVG_TAT=0;
							final double avg_wt;
							final double avg_tat;
							
							int ET[]=new int[20];
							int ET1[]=new int[20];
							int f[]=new int[20];
							int AT[]=new int[20];
							int PRIORITY[]=new int[20];
							final int process[]=new int[n];
							final int WT[]=new int[n];
							final int TAT[]=new int[n];
							
							for(i=0;i<n;i++){
								ET[i] = Integer.parseInt(et_value[i].getText().toString());
								AT[i] = Integer.parseInt(at_value[i].getText().toString()); 
								
								process[i]=i+1;
								if(ET[i]==0)f[i]=1;
								else
								f[i]=0;
								ET1[i]=ET[i];
								/*Toast.makeText(getBaseContext(),""+PRIORITY[i], Toast.LENGTH_SHORT).show();*/
							}
							
							/*for(i=0;i<n;i++){
								et_value[i].getText().clear();
								at_value[i].getText().clear();
								p_value[i].getText().clear();
							}*/
							
							//Arranging AT
							for(i=0;i<n-1;i++)
					        {
								for(j=i+1;j<n;j++)
								{
									if(AT[i]>AT[j])
									{
									temp=AT[i];
					                                AT[i]=AT[j];
					                                AT[j]=temp;	

									temp=ET[i];
					                                ET[i]=ET[j];
					                                ET[j]=temp;		

									temp=process[i];
					                                process[i]=process[j];
					                                process[j]=temp;	
									
									}	
								}	
							}
							for(i=0;i<n;i++){PRIORITY[i]=n-i-1;}
							time1=AT[0];
							for(i=0;i<n;i++)
							{          
					                        time1+=ET[i];
					                        if(i+1!=n){if(time1<AT[i+1]){ time1+=AT[i+1]-time1;}}
							        WT[i]=0;
							}	
					          
							time=0;                  //DECLARATIONS
							int x1[]=new int[time1];        
							int y1[]=new int[time1];
							int z1[]=new int[time1];    
							int x2[]=new int[time1];
							int y2[]=new int[time1];
							int z2[]=new int[time1];
							int tp,tp1=-1;      
							
							
							
							while (time!=time1)  
							{
								a=0;
								
								
								
								//System.out.println(" outer   w= "+w+ " =a"+a);
								

						//System.out.println(" UPPER   pro "+process[i]+" at "+AT[i]+" et "+ET[i]+" prio "+PRIORITY[i]+" w "+w+" flag "+f[i]);

																										
								for(i=0;i<n;i++)
								{
									if(AT[i]<=time)
										if(f[i]==0)
											a++;
								}
								
																							
								if(tp1!=-1)
								if(w==0)
									{
									                                      
									         for(i=0;i<a;i++)
									         {
												 if(f[i]==0)
												{
									         	PRIORITY[i]=PRIORITY[i]+1;
									         	PRIORITY[i]=PRIORITY[i]%n;
								        		if(PRIORITY[i]==0)
								     			PRIORITY[i]=n-a;
								            	}
												else
												{
													for(j=0;j<a;j++)
													{
														if(j!=i)
														{
													    if(PRIORITY[j]<PRIORITY[i])									
															PRIORITY[j]=PRIORITY[j]+1;
														}
													}
													PRIORITY[i]=0;
												}
											 }
					                }
								else tp1=0;
								
								
								if(a!=0)
								{a=0;
									
									
								for(i=0;i<n;i++)
								{
									if(AT[i]<=time)
										
											a++;
								}
								
									
									
									c=0;
									for(i=0;i<n;i++)
								    {
									if(AT[i]<=time)
											c++;
								    }
									
									if(c!=0)
									{
									if(w==0)
									{
								        b=-1;
								        for(i=0;i<a;i++)
								        {
									        if(PRIORITY[i]>b)
										    if(f[i]==0)
										{
											T=process[i];
											b=PRIORITY[i];
										}
									    }
									}
									if(w==0)
										w=tq;
									System.out.println(" inner    w= "+w+ " =a"+a);
									for(i=0;i<a;i++)
									{
										if(f[i]==0)
										{
											
											if(process[i]==T)
											{
												
												ET[i]=ET[i]-1;
												w=w-1;
												
												 x=process[i];
					                             y=time;
					                             z=time+1;
												 
												if(ET[i]==0)
												{
													f[i]=1;
													w=0;
												}
											}
											else
											{
												
												WT[i]=WT[i]+1;
											}
										}
									}
									}
									
								
								
								
								if(w==0)
									{
									                                      
									         for(i=0;i<a;i++)
									         {
												 if(f[i]==0)
												{
									         	PRIORITY[i]=PRIORITY[i]+1;
									         	PRIORITY[i]=PRIORITY[i]%n;
								        		if(PRIORITY[i]==0)
								     			PRIORITY[i]=n-a;
								            	}/*
												else
												{
													for(j=0;j<a;j++)
													{
														if(j!=i)
														{
													    if(PRIORITY[j]<PRIORITY[i])									
															PRIORITY[j]=PRIORITY[j]+1;
														}
													}
													PRIORITY[i]=0;
												}*/
											 }
					                }

								
								
								
								
								
								
								}
								
					            else{x=0;y=time;z=time+1;}
								
								
					                  System.out.println(y+" P"+x+" "+z);
									   x1[time]=x;                 
							           y1[time]=y;                
							           z1[time]=z; 


					/*for(i=0;i<n;i++)
					{
						System.out.println("pro "+process[i]+" at "+AT[i]+" et "+ET[i]+" prio "+PRIORITY[i]+" w "+w+" flag "+f[i] +" time "+time+" wt "+WT[i]);
					}*/
												   
											  
							time++;
							}
							
					        
							tp=-1; tp1=0;
							for(i=0;i<time1;i++)
							{
							
							if(tp1==0)
							{
							
							tp++;
							x2[tp]=x1[i];
						    y2[tp]=y1[i];
							z2[tp]=z1[i];
							tp1=1;
							
							continue;
							}
							if(x2[tp]==x1[i])
							{    
							z2[tp]=z1[i];
							}
							else{
							tp1=0; i=i-1;
							}
						    }
							tp++;           //ANKIT THIS ENDS SIMPLYFY CHART
							
							/*System.out.println("last ans jhnsdjjhfjkkjglkklhjkjgkhjkfgjkj :");*/
							
							TextView show_gantt1 = new TextView(getBaseContext());
					           // show_gantt.setText(Html.fromHtml("______<br>|&nbsp;&nbsp;P"+x+"&nbsp;&nbsp;&nbsp;&nbsp;|"+"<br>"+"______"+""));
				                show_gantt1.setText("-\n|\n0");
					            show_gantt1.setTextColor(Color.MAGENTA);
					            show_gantt1.setTextSize(25);
					            show_gantt1.setGravity(Gravity.CENTER);
					            rl.addView(show_gantt1);
							
							for(i=0;i<tp;i++)         // ANKIT THIS IS FOR CHART
							{
							
								
									if(x2[i]==0){
					                
					                TextView show_gantt = new TextView(getBaseContext());
							           // show_gantt.setText(Html.fromHtml("______<br>|&nbsp;&nbsp;P"+x+"&nbsp;&nbsp;&nbsp;&nbsp;|"+"<br>"+"______"+""));
						                show_gantt.setText("-------"+"\n       "+"    |"+"\n"+"------"+z2[i]+"");
							            show_gantt.setTextColor(Color.MAGENTA);
							            show_gantt.setTextSize(25);
							            show_gantt.setGravity(Gravity.CENTER);
							            rl.addView(show_gantt);
					                
					                
					                
					                }
					                else{
					                
					                	if(y2[i]>9 && z2[i]>9){
					                TextView show_gantt = new TextView(getBaseContext());
						           // show_gantt.setText(Html.fromHtml("______<br>|&nbsp;&nbsp;P"+x+"&nbsp;&nbsp;&nbsp;&nbsp;|"+"<br>"+"______"+""));
					                show_gantt.setText("--------"+"\n    P"+x2[i]+"   |"+"\n"+"------"+z2[i]+"");
						            show_gantt.setTextColor(Color.MAGENTA);
						            show_gantt.setTextSize(25);
						            show_gantt.setGravity(Gravity.CENTER);
						            rl.addView(show_gantt);
					                	}
					                	
					                	else if(y2[i]<=9 && z2[i]>=10){
					                		
					                		 TextView show_gantt = new TextView(getBaseContext());
									           // show_gantt.setText(Html.fromHtml("______<br>|&nbsp;&nbsp;P"+x+"&nbsp;&nbsp;&nbsp;&nbsp;|"+"<br>"+"______"+""));
								                show_gantt.setText("--------"+"\n    P"+x2[i]+"    |"+"\n"+"------"+z2[i]+"");
									            show_gantt.setTextColor(Color.MAGENTA);
									            show_gantt.setTextSize(25);
									            show_gantt.setGravity(Gravity.CENTER);
									            rl.addView(show_gantt);
					                		
					                	}
					                	else{
					                		
					                		TextView show_gantt = new TextView(getBaseContext());
									           // show_gantt.setText(Html.fromHtml("______<br>|&nbsp;&nbsp;P"+x+"&nbsp;&nbsp;&nbsp;&nbsp;|"+"<br>"+"______"+""));
								                show_gantt.setText("--------"+"\n   P"+x2[i]+"    |"+"\n"+"-------"+z2[i]+"");
									            show_gantt.setTextColor(Color.MAGENTA);
									            show_gantt.setTextSize(25);
									            show_gantt.setGravity(Gravity.CENTER);
									            rl.addView(show_gantt);
					                		
					                	}
					                	
					                	}
									
									
								
								
							}
							
					
			   
					            
							for(i=0;i<n-1;i++)
					        {
								for(j=i+1;j<n;j++)
								{
									if(process[i]>process[j])
									{
									temp=AT[i];
					                AT[i]=AT[j];
					                AT[j]=temp;	

									temp=ET[i];
					                ET[i]=ET[j];
					                ET[j]=temp;		

									temp=process[i];
					                process[i]=process[j];
					                process[j]=temp;	
									
									temp=PRIORITY[i];
					                PRIORITY[i]=PRIORITY[j];
					                PRIORITY[j]=temp;	

					                temp=WT[i];
					                WT[i]=WT[j];
					                WT[j]=temp;				
									}	
								}	
							}
							
					       for(i=0;i<n;i++)
						   {
							   TAT[i]=WT[i]+ET1[i];
						   }
					       
					       for(i=0;i<n;i++)
				            {
								/*System.out.printf("\nP["+(process[i])+"]\t\t"+AT[i]+"\t"+ET1[i]+"\t"+PRIORITY[i]+"\t\t"+(WT[i])+"\t"+TAT[i]);*/
								AVG_WT+=WT[i];
								AVG_TAT+=TAT[i];
							}
							
					       avg_wt = (AVG_WT*1.0)/n;
					       avg_tat = (AVG_TAT*1.0)/n;
					
					       LinearLayout NoticeGantt = (LinearLayout) findViewById(R.id.NoticeGantt);
					       	TextView notice = new TextView(getBaseContext());
			 	            notice.setText("Blank Box indicates that in that time span no Process is running");
			 	            notice.setTextColor(Color.MAGENTA);
			 	            notice.setTextSize(10);
			 	            NoticeGantt.addView(notice);
							
							
			 	            LinearLayout show_output = (LinearLayout)findViewById(R.id.show_output);
				            Button final_table = new Button(getBaseContext());
				            final_table.setText("  Show Execution Table  ");
				            final_table.setTextSize(25);
				            final_table.setTextColor(Color.WHITE);
				            final_table.setBackgroundColor(Color.BLUE);
							show_output.addView(final_table);
							
							
							/*TextView t = new TextView(getBaseContext());*/
				           
							
							
							final_table.setOnClickListener(new OnClickListener() {
								 
								int count = 0;
								
								@Override
								public void onClick(View arg0) {
									
									if(count == 0){
										count++;
									final TableLayout table_output = (TableLayout) findViewById(R.id.table_output);
									final TableRow tbrow0 = new TableRow(getBaseContext());
						            final TextView tv0 = new TextView(getBaseContext());
						            tv0.setText(" Process No. ");
						            tv0.setTextColor(Color.RED);
						            tv0.setTextSize(15);
						            
						            final TextView tv1 = new TextView(getBaseContext());
						            tv1.setText(" Waiting Time ");
						            tv1.setTextColor(Color.RED);
						            tv1.setTextSize(15);
						            
						            final TextView tv2 = new TextView(getBaseContext());
						            tv2.setText(" Turn Around Time ");
						            tv2.setTextColor(Color.RED);
						            tv2.setTextSize(15);
									
						            tbrow0.addView(tv0);
						            
						            tbrow0.addView(tv1);
						            
						            tbrow0.addView(tv2);
						         						
						            table_output.addView(tbrow0);
						            
						            
						            for (int i = 0; i < n; i++) {
						            	
						            	/*Toast.makeText(getBaseContext(),""+TAT[i], Toast.LENGTH_LONG).show();*/
						            	
						                TableRow tbrow = new TableRow(getBaseContext());
						                	                
						                process_no[i] = new TextView(getBaseContext());
						                process_no[i].setText("P" + process[i]);
						                process_no[i].setTextColor(Color.RED);
						                process_no[i].setGravity(Gravity.CENTER);
						                tbrow.addView(process_no[i]);
						                						            
						                process_no1[i] = new TextView(getBaseContext());
						                process_no1[i].setText("" + WT[i]);
						                process_no1[i].setTextColor(Color.RED);
						                process_no1[i].setGravity(Gravity.CENTER);
						                tbrow.addView(process_no1[i]);
						                
						                process_no2[i] = new TextView(getBaseContext());
						                process_no2[i].setText("" + TAT[i]);
						                process_no2[i].setTextColor(Color.RED);
						                process_no2[i].setGravity(Gravity.CENTER);
						                tbrow.addView(process_no2[i]);
						                
						                table_output.addView(tbrow);
						               
						            }
						            
						            LinearLayout final_ans = (LinearLayout)findViewById(R.id.final_ans);
						            TextView answer = new TextView(getBaseContext());
						            answer.setText("The Average Waiting Time is: "+avg_wt+"ms\n"+"The Average Turn Around Time is: "+avg_tat+"ms");
						            answer.setTextSize(15);
						            answer.setTextColor(Color.RED);							           
									final_ans.addView(answer);
									
									LinearLayout clear = (LinearLayout)findViewById(R.id.clear);
						            Button clear_whole = new Button(getBaseContext());
						            clear_whole.setText("  CLEAR  ");
						            clear_whole.setTextSize(25);
						            clear_whole.setTextColor(Color.WHITE);
						            clear_whole.setBackgroundColor(Color.BLUE);
									clear.addView(clear_whole);
									
									clear_whole.setOnClickListener(new OnClickListener() {
										
										@Override
										public void onClick(View arg0) {
											Intent i = new Intent(Round_robin.this, Round_robin.class);
						                    startActivity(i);
						                    finish();
											
										}
									});
									LinearLayout allclear = (LinearLayout)findViewById(R.id.allclear);
						            Button back = new Button(getBaseContext());
						            back.setText("  BACK  ");
						            back.setTextSize(25);
						            back.setTextColor(Color.WHITE);
						            back.setBackgroundColor(Color.BLUE);
									allclear.addView(back);
									
									back.setOnClickListener(new OnClickListener() {
										
										@Override
										public void onClick(View arg0) {
											Intent i = new Intent(Round_robin.this, FIRST.class);
						                    startActivity(i);
						                    finish();
											
										}
									});
									
									
						            
									}
									else{
										Toast.makeText(getBaseContext(),"You have already clicked this Button once", Toast.LENGTH_LONG).show();
									}
									
									
									
								}
							});
					       
							}
							
							
							else{
								Toast.makeText(getBaseContext(),"You have already clicked this Button once", Toast.LENGTH_LONG).show();
								
							}
							
							
							
							
						}
					
					});
				
				
				
				
				 	/*LinearLayout clear = (LinearLayout)findViewById(R.id.clear);
		            Button clear_whole = new Button(getBaseContext());
		            clear_whole.setText("  Show Execution Table  ");
		            clear_whole.setTextSize(25);
		            clear_whole.setTextColor(Color.WHITE);
		            clear_whole.setBackgroundColor(Color.BLUE);
					clear.addView(clear_whole);
					
					clear_whole.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							Intent i = new Intent(MainActivity.this, MainActivity.class);
		                    startActivity(i);
		                    finish();
							
						}
					});*/
				
				}
					 else{
							Toast.makeText(getBaseContext(),"You have already clicked this Button once", Toast.LENGTH_LONG).show();
							
						}
					
					 
					 
					}
					else{
						Toast.makeText(getBaseContext(),"Enter Valid Number of Processes", Toast.LENGTH_LONG).show();
					}
					}
					else{
						
						Toast.makeText(getBaseContext(),"Enter Valid Number of Processes", Toast.LENGTH_LONG).show();
						
					}
					 
				}
				
				
				
				
			}
		});

		
		
		
	}

	

}
