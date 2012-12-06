package com.cedar.app;

import java.io.IOException;
import java.util.ArrayList;

import android.os.Bundle;
import android.os.Parcelable;
import android.app.Activity;
import android.content.*;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import android.graphics.*;
import android.support.v4.app.NavUtils;

public class DisplayMap extends Activity {
	
	private ScrollView scroller;
	private RelativeLayout layout;
	private ArrayList<MapNode> ridesForUser; //Rides listed by user from ListofRides
	private ArrayList<MapNode> PathMapNodes; //Arraylist for path nodes
	private ArrayList<MapNode> fullMap;	
	
	private ArrayList<Point> locations;
	
	private MapCanvas map;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Get height and width of screen
        
        Display display = getWindowManager().getDefaultDisplay();
        int screenwidth = display.getWidth();
        int screenheight = display.getHeight();
        
        
        
        ridesForUser = new ArrayList<MapNode>();
        PathMapNodes = new ArrayList<MapNode>();
        locations = new ArrayList<Point>();
        CreatePathNodes();
        fullMap = new ArrayList<MapNode>(PathMapNodes);
        for (Ride r : ListofRides.fullListofRides)
        {
        	fullMap.add(new RideMapNode(r));
        }
        for (Ride r : ListofRides.ridesList)
        {
        	ridesForUser.add(new RideMapNode(r));
        }
       

        

		Bitmap b;
		try {
			b = BitmapFactory.decodeStream(getAssets().open("cedarpointmap.png"));
	        map = new MapCanvas (this, b);
			setContentView(map);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		/*for (MapNode n : PathMapNodes)
		{
			AddPoint((int) (screenwidth * n.x), (int) (screenheight * n.y));
		}
       
        CreatePath(locations);*/
		
		CreateRideNodes(screenwidth, screenheight);
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
    
    //This method creates the path nodes which will be connected for the shortest path algorithm
    public void CreatePathNodes()
    {
    	PathMapNodes.add(new IntermediateMapNode(1015,2399));
    	PathMapNodes.add(new IntermediateMapNode(1000,2072));
    	PathMapNodes.add(new IntermediateMapNode(1000,1777));
    	PathMapNodes.add(new IntermediateMapNode(987,1604));
    	PathMapNodes.add(new IntermediateMapNode(770,1324));
    	PathMapNodes.add(new IntermediateMapNode(600,1091));
    	PathMapNodes.add(new IntermediateMapNode(506,893));
    	PathMapNodes.add(new IntermediateMapNode(456,751));
    	PathMapNodes.add(new IntermediateMapNode(641,629));
    	PathMapNodes.add(new IntermediateMapNode(802,569));
    	PathMapNodes.add(new IntermediateMapNode(912,742));
    	PathMapNodes.add(new IntermediateMapNode(1028,949));
    	PathMapNodes.add(new IntermediateMapNode(1009,1107));
    	PathMapNodes.add(new IntermediateMapNode(993,1245));
    	PathMapNodes.add(new IntermediateMapNode(1000,1399));
    	PathMapNodes.add(new IntermediateMapNode(987,1604));
    	
    	
    	PathMapNodes.add(new IntermediateMapNode(1289,1701));
    	PathMapNodes.add(new IntermediateMapNode(1273,1846));
    	PathMapNodes.add(new IntermediateMapNode(1280,2012));
    	PathMapNodes.add(new IntermediateMapNode(1192,2003));
    }
    
    
    public void AddPoint(int x, int y)
    {
    	Point p = new Point(x,y);
    	locations.add(p);

    }
    
    public void CreatePath(ArrayList<Point> l)
    {
    	Path pa = new Path();
    	pa.setLastPoint(l.get(0).x, l.get(0).y);
    	l.remove(0);
    	for (Point p : l)
    	{  
    		pa.lineTo(p.x, p.y);
    		System.out.println("x = " + p.x + "		y = " + p.y);
    	}
    	
    	map.DrawPath(pa);
    	
    }
    
    public void CreateRideNodes(int width, int height)
    {
    	Path pa = new Path();
    	
    	for (Ride r : ListofRides.fullListofRides)
    	{
    		pa.addCircle((width) * r.mapX,height * r.mapY, 3, Path.Direction.CW);
    	}
    	
    	map.DrawRides(pa);
    }
    

}
