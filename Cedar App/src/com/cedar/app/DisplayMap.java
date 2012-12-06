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
	public static ArrayList<MapNode> pathMapNodes; //Arraylist for path nodes
	public static ArrayList<MapEdge> pathMapEdges;
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
        pathMapNodes = new ArrayList<MapNode>();
        locations = new ArrayList<Point>();
        CreatePathNodes();
        fullMap = new ArrayList<MapNode>(pathMapNodes);
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
    	pathMapNodes.add(new IntermediateMapNode(1015,2399));
    	pathMapNodes.add(new IntermediateMapNode(1000,2072));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(0), pathMapNodes.get(1)));
    	pathMapNodes.add(new IntermediateMapNode(1000,1777));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(1), pathMapNodes.get(2)));
    	pathMapNodes.add(new IntermediateMapNode(987,1604));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(2), pathMapNodes.get(3)));
    	pathMapNodes.add(new IntermediateMapNode(770,1324));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(3), pathMapNodes.get(4)));
    	pathMapNodes.add(new IntermediateMapNode(600,1091));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(4), pathMapNodes.get(5)));
    	pathMapNodes.add(new IntermediateMapNode(506,893));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(5), pathMapNodes.get(6)));
    	pathMapNodes.add(new IntermediateMapNode(456,751));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(6), pathMapNodes.get(7)));
    	pathMapNodes.add(new IntermediateMapNode(641,629));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(7), pathMapNodes.get(8)));
    	pathMapNodes.add(new IntermediateMapNode(802,569));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(8), pathMapNodes.get(9)));
    	pathMapNodes.add(new IntermediateMapNode(912,742));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(9), pathMapNodes.get(10)));
    	pathMapNodes.add(new IntermediateMapNode(1028,949));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(10), pathMapNodes.get(11)));
    	pathMapNodes.add(new IntermediateMapNode(1009,1107));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(11), pathMapNodes.get(12)));
    	pathMapNodes.add(new IntermediateMapNode(993,1245));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(12), pathMapNodes.get(13)));
    	pathMapNodes.add(new IntermediateMapNode(1000,1399));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(13), pathMapNodes.get(14)));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(3), pathMapNodes.get(14)));    	
    	pathMapNodes.add(new IntermediateMapNode(1289,1701));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(3), pathMapNodes.get(15)));
    	pathMapNodes.add(new IntermediateMapNode(1273,1846));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(15), pathMapNodes.get(16)));
    	pathMapNodes.add(new IntermediateMapNode(1280,2012));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(16), pathMapNodes.get(17)));
    	pathMapNodes.add(new IntermediateMapNode(1192,2003));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(17), pathMapNodes.get(18)));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(1), pathMapNodes.get(18)));
    	
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
