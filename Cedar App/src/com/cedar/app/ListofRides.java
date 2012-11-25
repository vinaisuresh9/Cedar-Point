package com.cedar.app;

import java.util.*;
import android.os.Bundle;
import android.app.Activity;
import android.view.*;
import android.widget.*;
import android.content.*;

public class ListofRides extends Activity  {
	
	public List<String> ridesList;
	public final static String RIDE = "com.cedar.ride";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listof_rides);
        
        ridesList = new LinkedList<String>();
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_listof_rides, menu);
        return true;
    }
    
    /*
     * Function to add Rides to list for route information
     * 
     */
    public void AddtoList (View view)
    {
        ridesList = new LinkedList<String>();
    	final CheckBox check = (CheckBox)view;
    	
    	 switch (check.getId())
    	 {
    	 case R.id.blue_streak_button:
    		 if (check.isChecked())
    		 {
    			 ridesList.add(this.getString(R.string.blue_streak));
    		 }
    		 else
    		 {
    			 ridesList.remove(this.getString(R.string.blue_streak));
    		 }
    		 break;
    	 case R.id.calypso_button:
    		 if (check.isChecked())
    		 {
    			 ridesList.add(this.getString(R.string.calypso));
    		 }
    		 else
    		 {
    			 ridesList.remove(this.getString(R.string.calypso));
    		 }
    		 break;
    	 case R.id.cedar_mine_button:
    		 if (check.isChecked())
    		 {
    			 ridesList.add(this.getString(R.string.cedar_creek_mine));
    		 }
    		 else
    		 {
    			 ridesList.remove(this.getString(R.string.cedar_creek_mine));
    		 }
    		 break;
    	 case R.id.cedar_downs_button:
    		 if (check.isChecked())
    		 {
    			 ridesList.add(this.getString(R.string.cedar_downs));
    		 }
    		 else
    		 {
    			 ridesList.remove(this.getString(R.string.cedar_downs));
    		 }
    		 break;
    	 case R.id.corkscrew_button:
    		 if (check.isChecked())
    		 {
    			 ridesList.add(this.getString(R.string.corkscrew));
    		 }
    		 else
    		 {
    			 ridesList.remove(this.getString(R.string.corkscrew));
    		 }
    		 break;
    	 case R.id.dodgem_button:
    		 if (check.isChecked())
    		 {
    			 ridesList.add(this.getString(R.string.dodgem));
    		 }
    		 else
    		 {
    			 ridesList.remove(this.getString(R.string.dodgem));
    		 }
    		 break;
    	 case R.id.gemini_button:
    		 if (check.isChecked())
    		 {
    			 ridesList.add(this.getString(R.string.gemini));
    		 }
    		 else
    		 {
    			 ridesList.remove(this.getString(R.string.gemini));
    		 }
    		 break;
    	 case R.id.iron_dragon_button:
    		 if (check.isChecked())
    		 {
    			 ridesList.add(this.getString(R.string.iron_dragon));
    		 }
    		 else
    		 {
    			 ridesList.remove(this.getString(R.string.iron_dragon));
    		 }
    		 break;
    	 case R.id.junior_gemini_button:
    		 if (check.isChecked())
    		 {
    			 ridesList.add(this.getString(R.string.junior_gemini));
    		 }
    		 else
    		 {
    			 ridesList.remove(this.getString(R.string.junior_gemini));
    		 }
    		 break;
    	 case R.id.magnum_xl200_button:
    		 if (check.isChecked())
    		 {
    			 ridesList.add(this.getString(R.string.magnum_xl200));
    		 }
    		 else
    		 {
    			 ridesList.remove(this.getString(R.string.magnum_xl200));
    		 }
    		 break;
    	 case R.id.mantis_button:
    		 if (check.isChecked())
    		 {
    			 ridesList.add(this.getString(R.string.mantis));
    		 }
    		 else
    		 {
    			 ridesList.remove(this.getString(R.string.mantis));
    		 }
    		 break;
    	 case R.id.matterhorn_button:
    		 if (check.isChecked())
    		 {
    			 ridesList.add(this.getString(R.string.matterhorn));
    		 }
    		 else
    		 {
    			 ridesList.remove(this.getString(R.string.matterhorn));
    		 }
    		 break;
    	 case R.id.maverick_button:
    		 if (check.isChecked())
    		 {
    			 ridesList.add(this.getString(R.string.maverick));
    		 }
    		 else
    		 {
    			 ridesList.remove(this.getString(R.string.maverick));
    		 }
    		 break;
    	 
    	 case R.id.maxair_button:
    		 if (check.isChecked())
    		 {
    			 ridesList.add(this.getString(R.string.maxair));
    		 }
    		 else
    		 {
    			 ridesList.remove(this.getString(R.string.maxair));
    		 }
    		 break;
    	 case R.id.mean_streak_button:
    		 if (check.isChecked())
    		 {
    			 ridesList.add(this.getString(R.string.mean_streak));
    		 }
    		 else
    		 {
    			 ridesList.remove(this.getString(R.string.mean_streak));
    		 }
    		 break;
    	 case R.id.millenium_force_button:
    		 if (check.isChecked())
    		 {
    			 ridesList.add(this.getString(R.string.millenium_force));
    		 }
    		 else
    		 {
    			 ridesList.remove(this.getString(R.string.millenium_force));
    		 }
    		 break;
    	 case R.id.monster_button:
    		 if (check.isChecked())
    		 {
    			 ridesList.add(this.getString(R.string.monster));
    		 }
    		 else
    		 {
    			 ridesList.remove(this.getString(R.string.monster));
    		 }
    		 break;
    	 case R.id.ocean_motion_button:
    		 if (check.isChecked())
    		 {
    			 ridesList.add(this.getString(R.string.ocean_motion));
    		 }
    		 else
    		 {
    			 ridesList.remove(this.getString(R.string.ocean_motion));
    		 }
    		 break;
    	 case R.id.power_tower_button:
    		 if (check.isChecked())
    		 {
    			 ridesList.add(this.getString(R.string.power_tower));
    		 }
    		 else
    		 {
    			 ridesList.remove(this.getString(R.string.power_tower));
    		 }
    		 break;
    	 case R.id.raptor_button:
    		 if (check.isChecked())
    		 {
    			 ridesList.add(this.getString(R.string.raptor));
    		 }
    		 else
    		 {
    			 ridesList.remove(this.getString(R.string.raptor));
    		 }
    		 break;
    	 case R.id.scrambler_button:
    		 if (check.isChecked())
    		 {
    			 ridesList.add(this.getString(R.string.scrambler));
    		 }
    		 else
    		 {
    			 ridesList.remove(this.getString(R.string.scrambler));
    		 }
    		 break;
    	 case R.id.skyhawk_button:
    		 if (check.isChecked())
    		 {
    			 ridesList.add(this.getString(R.string.skyhawk));
    		 }
    		 else
    		 {
    			 ridesList.remove(this.getString(R.string.skyhawk));
    		 }
    		 break;
    	 case R.id.snake_river_falls_button:
    		 if (check.isChecked())
    		 {
    			 ridesList.add(this.getString(R.string.snake_river_falls));
    		 }
    		 else
    		 {
    			 ridesList.remove(this.getString(R.string.snake_river_falls));
    		 }
    		 break;
    	 case R.id.super_himalaya_button:
    		 if (check.isChecked())
    		 {
    			 ridesList.add(this.getString(R.string.super_himalaya));
    		 }
    		 else
    		 {
    			 ridesList.remove(this.getString(R.string.super_himalaya));
    		 }
    		 break;
    	 case R.id.thunder_canyon_button:
    		 if (check.isChecked())
    		 {
    			 ridesList.add(this.getString(R.string.thunder_canyon));
    		 }
    		 else
    		 {
    			 ridesList.remove(this.getString(R.string.thunder_canyon));
    		 }
    		 break;
    	 case R.id.top_thrill_button:
    		 if (check.isChecked())
    		 {
    			 ridesList.add(this.getString(R.string.top_thrill));
    		 }
    		 else
    		 {
    			 ridesList.remove(this.getString(R.string.top_thrill));
    		 }
    		 break;
    	 case R.id.troika_button:
    		 if (check.isChecked())
    		 {
    			 ridesList.add(this.getString(R.string.troika));
    		 }
    		 else
    		 {
    			 ridesList.remove(this.getString(R.string.troika));
    		 }
    		 break;
    	 case R.id.wave_swinger_button:
    		 if (check.isChecked())
    		 {
    			 ridesList.add(this.getString(R.string.wave_swinger));
    		 }
    		 else
    		 {
    			 ridesList.remove(this.getString(R.string.wave_swinger));
    		 }
    		 break;
    	 case R.id.wicked_twister_button:
    		 if (check.isChecked())
    		 {
    			 ridesList.add(this.getString(R.string.wicked_twister));
    		 }
    		 else
    		 {
    			 ridesList.remove(this.getString(R.string.wicked_twister));
    		 }
    		 break;
    	 case R.id.wind_seeker_button:
    		 if (check.isChecked())
    		 {
    			 ridesList.add(this.getString(R.string.wind_seeker));
    		 }
    		 else
    		 {
    			 ridesList.remove(this.getString(R.string.wind_seeker));
    		 }
    		 break;
    	 case R.id.witches_wheel_button:
    		 if (check.isChecked())
    		 {
    			 ridesList.add(this.getString(R.string.witches_wheel));
    		 }
    		 else
    		 {
    			 ridesList.remove(this.getString(R.string.witches_wheel));
    		 }
    		 break;
    	 case R.id.woodstock_express_button:
    		 if (check.isChecked())
    		 {
    			 ridesList.add(this.getString(R.string.woodstock_express));
    		 }
    		 else
    		 {
    			 ridesList.remove(this.getString(R.string.woodstock_express));
    		 }
    		 break;
    	 
    	 }
    	 
    }
    
    public void ViewMap(View view)
    {
    	Intent intent = new Intent(this, DisplayMap.class);
    	startActivity(intent);
    	
    }

    //Function to allow details for each ride to show up when clicked
    public void RideDetails(View view)
    {
    	Intent intent = new Intent(this, RideDetails.class);
    	
   	 switch (view.getId())
   	 {
   	 case R.id.blue_streak:
   		 intent.putExtra(RIDE, R.string.blue_streak);
   		 startActivity(intent);
   		 break;
   	case R.id.calypso:
  		 intent.putExtra(RIDE, R.string.calypso);
  		 startActivity(intent);
  		 break;
   	case R.id.cedar_downs:
  		 intent.putExtra(RIDE, R.string.cedar_downs);
  		 startActivity(intent);
  		 break;
   	case R.id.cedar_mine:
 		 intent.putExtra(RIDE, R.string.cedar_creek_mine);
 		 startActivity(intent);
 		 break;
   	case R.id.corkscrew:
 		 intent.putExtra(RIDE, R.string.corkscrew);
 		 startActivity(intent);
 		 break;
   	case R.id.dodgem:
 		 intent.putExtra(RIDE, R.string.dodgem);
 		 startActivity(intent);
 		 break;
   	case R.id.gemini:
		 intent.putExtra(RIDE, R.string.gemini);
		 startActivity(intent);
		 break;
   	case R.id.iron_dragon:
		 intent.putExtra(RIDE, R.string.iron_dragon);
		 startActivity(intent);
		 break;
   	case R.id.junior_gemini:
		 intent.putExtra(RIDE, R.string.junior_gemini);
		 startActivity(intent);
		 break;
   	case R.id.magnum_xl200:
		 intent.putExtra(RIDE, R.string.magnum_xl200);
		 startActivity(intent);
		 break;
  	case R.id.mantis:
		 intent.putExtra(RIDE, R.string.mantis);
		 startActivity(intent);
		 break;
  	case R.id.matterhorn:
		 intent.putExtra(RIDE, R.string.matterhorn);
		 startActivity(intent);
		 break;
  	case R.id.maverick:
		 intent.putExtra(RIDE, R.string.maverick);
		 startActivity(intent);
		 break;
  	case R.id.maxair:
		 intent.putExtra(RIDE, R.string.maxair);
		 startActivity(intent);
		 break;
  	case R.id.mean_streak:
		 intent.putExtra(RIDE, R.string.mean_streak);
		 startActivity(intent);
		 break;
 	case R.id.millenium_force:
		 intent.putExtra(RIDE, R.string.millenium_force);
		 startActivity(intent);
		 break;
 	case R.id.monster:
		 intent.putExtra(RIDE, R.string.monster);
		 startActivity(intent);
		 break;
 	case R.id.ocean_motion:
		 intent.putExtra(RIDE, R.string.ocean_motion);
		 startActivity(intent);
		 break;
	case R.id.power_tower:
		 intent.putExtra(RIDE, R.string.power_tower);
		 startActivity(intent);
		 break;
	case R.id.raptor:
		 intent.putExtra(RIDE, R.string.raptor);
		 startActivity(intent);
		 break;
	case R.id.scrambler:
		 intent.putExtra(RIDE, R.string.scrambler);
		 startActivity(intent);
		 break;
	case R.id.skyhawk:
		 intent.putExtra(RIDE, R.string.skyhawk);
		 startActivity(intent);
		 break;
	case R.id.snake_river_falls:
		 intent.putExtra(RIDE, R.string.snake_river_falls);
		 startActivity(intent);
		 break;
	case R.id.super_himalaya:
		 intent.putExtra(RIDE, R.string.super_himalaya);
		 startActivity(intent);
		 break;
	case R.id.thunder_canyon:
		 intent.putExtra(RIDE, R.string.thunder_canyon);
		 startActivity(intent);
		 break;
	case R.id.top_thrill:
		 intent.putExtra(RIDE, R.string.top_thrill);
		 startActivity(intent);
		 break;
	case R.id.troika:
		 intent.putExtra(RIDE, R.string.troika);
		 startActivity(intent);
		 break;
	case R.id.wave_swinger:
		 intent.putExtra(RIDE, R.string.wave_swinger);
		 startActivity(intent);
		 break;
	case R.id.wicked_twister:
		 intent.putExtra(RIDE, R.string.wicked_twister);
		 startActivity(intent);
		 break;
	case R.id.wind_seeker:
		 intent.putExtra(RIDE, R.string.wind_seeker);
		 startActivity(intent);
		 break;
	case R.id.witches_wheel:
		 intent.putExtra(RIDE, R.string.witches_wheel);
		 startActivity(intent);
		 break;
	case R.id.woodstock_express:
		 intent.putExtra(RIDE, R.string.woodstock_express);
		 startActivity(intent);
		 break;
		 
    	
   	 }
    }

}
