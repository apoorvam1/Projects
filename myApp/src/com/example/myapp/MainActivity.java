package com.example.myapp;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.support.v7.internal.widget.AdapterViewCompat.OnItemSelectedListener;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private TextView hdr;
	private TextView content;
	private TextView addn_content; 
	private ImageView img;
	private ImageView fb_icon;
	private ImageView li_icon;
	
    @SuppressLint("NewApi") @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        li_icon = (ImageView)findViewById(R.id.li);
        li_icon.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.linkedin.com/pub/apoorva-mahabaleshwara/a4/78/4a/"));
                startActivity(intent);	
			}
		});

        fb_icon = (ImageView) findViewById(R.id.fb);
        fb_icon.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.facebook.com/apoorvambhat"));
                startActivity(intent);
            }
        });
        
        /*Spinner spinner = (Spinner) findViewById(R.id.menu_spinner);
    	ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
    	        R.array.menu_spinner, android.R.layout.simple_spinner_item);
    	adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	spinner.setAdapter(adapter);*/
    
    	

    }


    @SuppressLint("NewApi") @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	
    	
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_actions, menu);
 
        return super.onCreateOptionsMenu(menu);
        
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	
    	content = (TextView) findViewById(R.id.content);
    	addn_content = (TextView) findViewById(R.id.addncontent);
    	img = (ImageView) findViewById(R.id.icon);
    	
    	
       
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
        	case R.id.about :	li_icon.getLayoutParams().height = 55;
								li_icon.setVisibility(View.VISIBLE);
								
        						fb_icon.getLayoutParams().height = 55;
        						fb_icon.setVisibility(View.VISIBLE);
        						
        						img.getLayoutParams().height = 600;
        						img.setVisibility(View.VISIBLE);
        						
        						hdr = (TextView) findViewById(R.id.hdr);
        						hdr.setText(getString(R.string.hdr1));
        						
        						content.setText(getString(R.string.section1a));
        						addn_content.setText(getString(R.string.section1b));	
        						return true;
        	case R.id.edu :		
								li_icon.setVisibility(View.INVISIBLE);
								li_icon.getLayoutParams().height = 0;
								
				        		fb_icon.setVisibility(View.INVISIBLE);
								fb_icon.getLayoutParams().height = 0;
								
        						img.setVisibility(View.INVISIBLE);
        						img.getLayoutParams().height = 0;
        						
        						hdr = (TextView) findViewById(R.id.hdr);
        						hdr.setText(getString(R.string.hdr2));
        						
        						content.setText(getString(R.string.section2a));
        						addn_content.setText(getString(R.string.section2b));
        						return true;
        	case R.id.work :	li_icon.setVisibility(View.INVISIBLE);
								li_icon.getLayoutParams().height = 0;
								
        						fb_icon.setVisibility(View.INVISIBLE);
								fb_icon.getLayoutParams().height = 0;
								
        						img.getLayoutParams().height = 0;
        						img.setVisibility(View.INVISIBLE);
        						
        						hdr = (TextView) findViewById(R.id.hdr);
        						hdr.setText(getString(R.string.hdr3));
        						
        						content.setText(getString(R.string.section3a));
        						addn_content.setText("");
        						return true;
        	default : return super.onOptionsItemSelected(item); 				
        }
        
    }
}


