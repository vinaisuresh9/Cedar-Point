package com.cedar.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import android.graphics.*;
import android.support.v4.app.NavUtils;



/**
 * @author Vinai Suresh
 *@param Bundle for Creation of Activity
 *DisplayMap
 *Class displays Map and handles routing of the rides created in ListofRides
 */


public class DisplayMap extends Activity {
	
	private ArrayList<MapNode> ridesForUser; //Rides listed by user from ListofRides
	public static ArrayList<IntermediateMapNode> pathMapNodes; //Arraylist for path nodes
	public static ArrayList<MapEdge> pathMapEdges; //Arraylist for map edges
	private ArrayList<MapNode> fullMap;	 //ArrayList for all nodes in the map including rides and
	//the path
	

	
	private MapCanvas map; //Map creation using custom view class
	

	
	int screenwidth;
	int screenheight;
	
	LinkedList<IntermediateMapNode> ridesInOrder = new LinkedList<IntermediateMapNode>();

	
	/* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Get height and width of screen
        
        //Get screen width and height
        Display display = getWindowManager().getDefaultDisplay();
        screenwidth = display.getWidth();
        screenheight = display.getHeight();
        
        //Initialize arraylists
        ridesForUser = new ArrayList<MapNode>();
        pathMapNodes = new ArrayList<IntermediateMapNode>();
        pathMapEdges = new ArrayList<MapEdge>();
        //Method to create Path Nodes on map by location on screen
        CreatePathNodes();
        
        fullMap = new ArrayList<MapNode>(pathMapNodes);
        for (Ride r : ListofRides.fullListofRides)
        {
        	//Add all of the ridenodes and pathnodes to the full map
        	fullMap.add(new RideMapNode(r));
        }
        for (Ride r : ListofRides.ridesList)
        {
        	//create ride nodes for the user
        	ridesForUser.add(new RideMapNode(r));
        }
       
        
        //Create the custom view using the cedar point map from the assets folder for
        //custom drawing 
		Bitmap b;
		try {
			b = BitmapFactory.decodeStream(getAssets().open("cedarpointmap.png"));
	        map = new MapCanvas (this, b);
			setContentView(map);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		//Method for updating the Map route with the new rides
        updateMapRoute();

    }
   

	//create options menu
    /* (non-Javadoc)
     * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_display_map, menu);
        return true;
    }

    //when items are selected
    /* (non-Javadoc)
     * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    
    /**
     * @author Thomas Li
     *@param None
     *@return Nothing
     *This map calls a new RidePath Object that generates a list of nodes that a user must visit
     *to reach all nodes on their list. It returns nothing but sends the list of nodes to the
     *MapCanvas class to be drawn
     */
    public void updateMapRoute()
    {
    	ridesInOrder = RidePath.GetOptimalPathNodes(ListofRides.ridesList, pathMapNodes);
    	map.drawUserRoute(ridesInOrder);
    }
    
    
    
    /**
     * @author Eric Mellino
     * @param None
     * @return None
     * Creates the Custom Path through the park by adding IntermediateMapNodes and
     * MapEdges between these Nodes to create a graph
     */
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
    	pathMapNodes.add(new IntermediateMapNode(912,742, ListofRides.getRide("Scrambler"), ListofRides.getRide("Jr. Gemini"), ListofRides.getRide("Monster"), ListofRides.getRide("Gemini")));
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
    
    
    

}
