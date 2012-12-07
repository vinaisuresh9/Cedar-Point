package com.cedar.app;


import android.app.Activity;
import android.content.*;
import android.graphics.BitmapFactory;
import android.widget.*;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.graphics.*;

import java.io.*;

import com.keyes.youtube.OpenYouTubePlayerActivity;

public class RideDetails extends Activity {
	RelativeLayout layout;
	String duration;
	String heightreq;
	String speed;
	String description;
	
	String[] ride;
	
	//Text View 
	TextView textView;
	ImageView imageView;
	
	public static final String Video = "com.cedar.app.video";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        duration = "";
        heightreq = "";
        speed = "";
        description = "";
        
        //Creating the Layout dynamically
        layout = new RelativeLayout(this);
        RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        layout.setLayoutParams(rlp);
        layout.setBackgroundColor(getResources().getColor(R.color.black));
        setContentView(layout);
        
        Intent intent = getIntent();
    	ride = intent.getStringArrayExtra(ListofRides.RIDE);
        
    	
    	YouTubeButton();
        this.DetailsforRide();
        
        
       
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_ride_details, menu);
        return true;
    }

    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void YouTubeButton()
    {
    	if (!ride[6].isEmpty())
    	{
	    	Button b = new Button(this);
	    	RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
	                RelativeLayout.LayoutParams.MATCH_PARENT,
	                RelativeLayout.LayoutParams.WRAP_CONTENT);
	    	lp.addRule(RelativeLayout.CENTER_HORIZONTAL);
	    	lp.addRule(RelativeLayout.ALIGN_PARENT_TOP);
	    	b.setText("See Video!");
	    	b.setTextSize(20);
	    	b.setId(1);
	    	b.setPadding(0, 50, 0, 0);
	    	b.setBackgroundColor(Color.BLACK);
	    	b.setTextColor(Color.WHITE);
	    	b.setLayoutParams(lp);
	    	b.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View v) {
					
					startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(ride[6])));
				}
			});
	    	
	    	layout.addView(b);
    	}
    }
    
    public void DetailsforRide()
    {
    	
    	RideType r;
    	
    	if (ride[1].equals("Roller Coaster"))
    		r = RideType.RollerCoaster;
    	else
    		r = RideType.ThrillRide;
    	
    	
    	switch(r)
    	{
    	case RollerCoaster:
    		textView = this.CreateTextView(ride[0], ride[2], ride[3], ride[4], ride[5]);
    		layout.addView(textView);
    		
    		try {
				imageView = CreateImageView(ride[0]);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
    		layout.addView(imageView);
    		break;
    	
	    case ThrillRide:
			textView = this.CreateTextView(ride[0], ride[3], ride[5]);
			layout.addView(textView);
			
			try {
				imageView = CreateImageView(ride[0]);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			layout.addView(imageView);
			break;
			
    	}
    }
    
    //TextView creation for roller coasters which have duration and speed statistics
    public TextView CreateTextView(String name, String duration, String heightreq, String speed, String description)

    {
    	TextView tv = new TextView(this);
		RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
		lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		lp.addRule(RelativeLayout.CENTER_HORIZONTAL);
		tv.setLayoutParams(lp);
		tv.setId(2);
		tv.setPadding(0, 0, 0, 20);
		tv.setTextColor(getResources().getColor(R.color.white));
		tv.setText("Name:	" + name + "\nDuration: 	" + duration +
				"\nHeight Requirement:	" + heightreq +
				"\nSpeed:		" + speed + "\n" +
					description);
		return tv;
    }
    
    
 
    //TextView creation for thrillrides, which do not have duration and speed statistics
    public TextView CreateTextView(String name, String heightreq, String description)
    {
    	TextView tv = new TextView(this);
		RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
		//Align the view near the bottom about 20 pixles from the bottom
		lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		lp.addRule(RelativeLayout.CENTER_HORIZONTAL);
		tv.setPadding(0, 0, 0, 20);
		tv.setLayoutParams(lp);
		tv.setId(2);
		tv.setTextColor(getResources().getColor(R.color.white));
		tv.setText("Name:	" + name + "\nHeight Requirement:	" + heightreq + "\n" +
					description);
		return tv;
    }
    
    
    //Create imageview for the picture of each ride dynamically from the Assets Folder
    public ImageView CreateImageView (String name) throws IOException
    {
    	ImageView image = new ImageView(this);
		RelativeLayout.LayoutParams l = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
		l.addRule(RelativeLayout.CENTER_HORIZONTAL);
		if (!ride[6].isEmpty())
		{
			l.addRule(RelativeLayout.BELOW, 1);
			image.setPadding(0, 20, 0, 0);
		}
		else
		{
			l.addRule(RelativeLayout.ALIGN_PARENT_TOP);
			image.setPadding(0, 75, 0, 0);
		}
		
		Display display = getWindowManager().getDefaultDisplay();
        int screenwidth = display.getWidth();
        int screenheight = display.getHeight();
		
        //Make sure image does not scale past the top half of the screen
		image.setLayoutParams(l);
		image.setAdjustViewBounds(true);
		
		
		//image.setMaxHeight(screenheight/2);
		//image.setMaxWidth(screenwidth/2);
		
		//Grab image from the assets folder and load it into an imageview
		InputStream is = getAssets().open("Thumbnails/" + name + ".jpg");
		Bitmap bitmap = BitmapFactory.decodeStream(is);
		image.setImageBitmap(bitmap);

		return image;
    }
    
    public enum RideType
    {
    	RollerCoaster,ThrillRide
    }
    
    

}
