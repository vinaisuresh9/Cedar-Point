package com.cedar.app;

import java.io.IOException;

import android.app.Activity;
import android.content.*;
import android.media.*;
import android.os.Bundle;

public class YouTubePlaying extends Activity {


	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	
	    Intent intent = getIntent();
	    String url = intent.getStringExtra(RideDetails.Video);
	    try {
			StartVideo(url);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	
	
	public void StartVideo(String url) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException
	{
		MediaPlayer mp = new MediaPlayer();
		System.out.println(url);
		mp.setDataSource(url);
		mp.prepare();
		mp.start();
		
	}

}
