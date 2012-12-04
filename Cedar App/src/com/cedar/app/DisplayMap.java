package com.cedar.app;

import java.io.IOException;
import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import android.graphics.*;
import android.support.v4.app.NavUtils;

public class DisplayMap extends Activity {
	
	private ScrollView scroller;
	private RelativeLayout layout;
	public ArrayList<MapNode> nodes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        scroller = new ScrollView(this);
        layout = new RelativeLayout(this);
        RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        layout.setLayoutParams(rlp);
        layout.setBackgroundColor(getResources().getColor(R.color.black));
        
        try {
			CreateMap();
		} catch (IOException e) {
			System.out.println( "Error while trying to create Map: " + e.getMessage());
		}
        
        

    }
    
    //create options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_display_map, menu);
        return true;
    }

    //when items are selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void CreateMap() throws IOException
    {
    	Bitmap b = BitmapFactory.decodeStream(getAssets().open("cedarpointmap.bmp"));
    	Canvas im = new Canvas(b);
    	RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
    	
    	
    	
    	
    }

}
