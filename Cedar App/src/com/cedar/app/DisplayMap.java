package com.cedar.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

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
	public static ArrayList<IntermediateMapNode> pathMapNodes; //Arraylist for path nodes
	public static ArrayList<MapEdge> pathMapEdges;
	private ArrayList<MapNode> fullMap;	
	
	private ArrayList<Point> locations;
	
	private MapCanvas map;
	
	private Path pa;
	
	int screenwidth;
	int screenheight;
	
	LinkedList<MapNode> ridesInOrder = new LinkedList<MapNode>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Get height and width of screen
        
        Display display = getWindowManager().getDefaultDisplay();
        screenwidth = display.getWidth();
        screenheight = display.getHeight();
        
        
        pa = new Path();
        ridesForUser = new ArrayList<MapNode>();
        pathMapNodes = new ArrayList<IntermediateMapNode>();
        pathMapEdges = new ArrayList<MapEdge>();
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

		
		
		createPathNodes(screenwidth, screenheight);
//		
//		createPathFromEdges();

        updateMapRoute();

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
    
    public void updateMapRoute()
    {
    	ridesInOrder = RidePath.GetOptimalPathNodes(ListofRides.ridesList, pathMapNodes);
    	map.drawUserRoute(ridesInOrder);
    }
    
    //This method creates the path nodes which will be connected for the shortest path algorithm
    public void CreatePathNodes()
    {
    	pathMapNodes.add(new IntermediateMapNode(1015,2314, ListofRides.getRide("Ocean Motion")));
    	pathMapNodes.add(new IntermediateMapNode(1000,1899, ListofRides.getRide("Raptor"), ListofRides.getRide("Witches' Wheel"),  ListofRides.getRide("Blue Streak"),  ListofRides.getRide("Cedar Racing Derby")));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(0), pathMapNodes.get(1)));
    	pathMapNodes.add(new IntermediateMapNode(1000,1692, ListofRides.getRide("Troika")));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(1), pathMapNodes.get(2)));
    	pathMapNodes.add(new IntermediateMapNode(987,1519,  ListofRides.getRide("Dodgem"), ListofRides.getRide("Corkscrew")));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(2), pathMapNodes.get(3)));
    	pathMapNodes.add(new IntermediateMapNode(770,1324,  ListofRides.getRide("Iron Dragon"),  ListofRides.getRide("Millenium Force"), ListofRides.getRide("Mantis")));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(3), pathMapNodes.get(4)));
    	pathMapNodes.add(new IntermediateMapNode(600,1091));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(4), pathMapNodes.get(5)));
    	pathMapNodes.add(new IntermediateMapNode(506,893, ListofRides.getRide("Cedar Creek Mine Ride")));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(5), pathMapNodes.get(6)));
    	pathMapNodes.add(new IntermediateMapNode(456,751, ListofRides.getRide("Skyhawk"), ListofRides.getRide("Wave Swinger")));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(6), pathMapNodes.get(7)));
    	pathMapNodes.add(new IntermediateMapNode(641,629, ListofRides.getRide("Maverick")));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(7), pathMapNodes.get(8)));
    	pathMapNodes.add(new IntermediateMapNode(802,569, ListofRides.getRide("Mean Streak"), ListofRides.getRide("Super Himalaya")));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(8), pathMapNodes.get(9)));
    	pathMapNodes.add(new IntermediateMapNode(912,742, ListofRides.getRide("Scrambler"), ListofRides.getRide("Junior Gemini"), ListofRides.getRide("Monster"), ListofRides.getRide("Gemini")));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(9), pathMapNodes.get(10)));
    	pathMapNodes.add(new IntermediateMapNode(1028,949, ListofRides.getRide("Matterhorn"), ListofRides.getRide("Magnum XL-200")));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(10), pathMapNodes.get(11)));
    	pathMapNodes.add(new IntermediateMapNode(1009,1107, ListofRides.getRide("Top Thrill Dragster")));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(11), pathMapNodes.get(12)));
    	pathMapNodes.add(new IntermediateMapNode(993,1245, ListofRides.getRide("Power Tower")));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(12), pathMapNodes.get(13)));
    	pathMapNodes.add(new IntermediateMapNode(1000,1399));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(13), pathMapNodes.get(14)));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(3), pathMapNodes.get(14)));    	
    	pathMapNodes.add(new IntermediateMapNode(1276,1604, ListofRides.getRide("WindSeeker"),  ListofRides.getRide("Calypso")));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(3), pathMapNodes.get(15)));
    	pathMapNodes.add(new IntermediateMapNode(1280,1761, ListofRides.getRide("Woodstock Express")));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(15), pathMapNodes.get(16)));
    	pathMapNodes.add(new IntermediateMapNode(1280,1902, ListofRides.getRide("Wicked Twister")));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(16), pathMapNodes.get(17)));
    	pathMapNodes.add(new IntermediateMapNode(1141,1902, ListofRides.getRide("MaXair")));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(17), pathMapNodes.get(18)));
    	pathMapEdges.add(new MapEdge(pathMapNodes.get(18), pathMapNodes.get(1)));
    	
    }
    
    
    
    public void createPathNodes(int width, int height)
    {
    	map.drawPathNode(pathMapNodes);
    }

    
    public void createPathFromEdges()
    {
    	
    	map.DrawEdges(pathMapEdges);
    	
    }
    

}
