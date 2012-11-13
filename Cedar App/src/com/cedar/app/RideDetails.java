package com.cedar.app;

import android.app.Activity;
import android.content.*;
import android.widget.*;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

public class RideDetails extends Activity {
	RelativeLayout layout;
	String duration;
	String heightreq;
	String speed;
	String description;
	
	TextView textView;
	ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        //Creating the Layout dynamically
        layout = new RelativeLayout(this);
        RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        layout.setLayoutParams(rlp);
        layout.setBackgroundColor(getResources().getColor(R.color.black));
        setContentView(layout);
        
        
        Intent intent = getIntent();
        int message = intent.getIntExtra(ListofRides.RIDE, 0);
        DetailsforRide(message);
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
    
    
    
    public void DetailsforRide(int ride)
    {
    	switch(ride)
    	{
    	case R.string.blue_streak:
    		duration = "1 min, 45 sec\n";
    		heightreq = "48\"\n";
    		speed = "40 mph\n";
    		description = "Cedar Point\'s classic wooden roller coaster!\n";
    		textView = this.CreateTextView(duration, heightreq, speed, description);
    		layout.addView(textView);
    		
    		imageView = CreateImageView(R.drawable.bluestreak_thumb);
    		layout.addView(imageView);
    		
    		break;
    	
	    case R.string.calypso:
			heightreq = "46\"\n";
			description = "The platform spins one way while the car spins the other way\n";
			textView = this.CreateTextView(heightreq, description);
			layout.addView(textView);
			
			imageView = CreateImageView(R.drawable.calypso_thumb);
			layout.addView(imageView);
			
			break;
			
	    case R.string.cedar_downs:
			heightreq = "48\"\n";
			description = "It’s a carrousel AND a race! One of the only two racing carrousels in the United States, Cedar Downs Racing Derby began its gallop in 1920. You’ll ride in four-across rows, and the horses trade the lead back and forth as you race for the finish!\n";
			textView = this.CreateTextView(heightreq, description);
			layout.addView(textView);
			
			imageView = CreateImageView(R.drawable.cedardowns_thumb);
			layout.addView(imageView);
			
			break;
			
	    case R.string.cedar_creek_mine:
	    	duration = "2 min, 0 sec\n";
    		heightreq = "48\"\n";
    		speed = "40 mph\n";
    		description = "There’s a runaway mine train on the loose and you’re a passenger! The Cedar Creek Mine Ride takes you on a wild journey up hills, through a tunnel and over water, finishing up with a signature helix whirlwind as the ride finishes. When it comes to old-fashioned thrills, the Cedar Creek Mine Ride is gold.\n";
    		textView = this.CreateTextView(duration, heightreq, speed, description);
    		
			layout.addView(textView);
			
			imageView = CreateImageView(R.drawable.mineride_thumb);
			layout.addView(imageView);
			
			break;
			
	    case R.string.corkscrew:
	    	duration = "2 min, 0 sec\n";
    		heightreq = "48\"\n";
    		speed = "48 mph\n";
    		description = "Turning the traditional coaster experience on its head, Corkscrew was the first coaster in history to invert riders three times over the course of its run. It also was the first coaster to span a park midway as it corkscrews, giving riders and park-goers views of each other with an amazingly exciting perspective.\n";
    		textView = this.CreateTextView(duration, heightreq, speed, description);
    		
			layout.addView(textView);
			
			imageView = CreateImageView(R.drawable.corkscrew_thumb);
			layout.addView(imageView);
			
			break;
			
	    case R.string.dodgem:
			heightreq = "36\"\n";
			description = "Just when you think you’ve got a clear path, BAM!--there’s someone you didn’t dodge. Get behind the wheel of this midway classic and take a crash course in family fun!\n";
			textView = this.CreateTextView(heightreq, description);
			layout.addView(textView);
			
			imageView = CreateImageView(R.drawable.dodgem_thumb);
			layout.addView(imageView);
			
			break;
			
	    case R.string.gemini:
	    	duration = "2 min, 20 sec\n";
    		heightreq = "48\"\n";
    		speed = "60 mph\n";
    		description = "What could be more exciting than a wild racing roller coaster that broke height and speed records when it was introduced? How about a second coaster train racing along a parallel track! You’re either Blue or Red, and the race is on, over tracks that promise drops, twists, turns, airtime and a big finish. No matter the result, you’re the winner on Gemini.\n";
    		textView = this.CreateTextView(duration, heightreq, speed, description);
    		
			layout.addView(textView);
			
			imageView = CreateImageView(R.drawable.gemini_thumb);
			layout.addView(imageView);
			
			break;
			
	    case R.string.iron_dragon:
	    	duration = "2 min, 0 sec\n";
    		heightreq = "46\"\n";
    		speed = "40 mph\n";
    		description = "Swoop down toward the Cedar Point Lagoon and sweep away at the last moment, all with no tracks underneath you! The Iron Dragon suspended coaster moves like no other, swinging and swaying as it makes its way around a track that takes you in and around the woods and over the lagoon itself.\n";
    		textView = this.CreateTextView(duration, heightreq, speed, description);
    		
			layout.addView(textView);
			
			imageView = CreateImageView(R.drawable.iron_thumb);
			layout.addView(imageView);
			
			break;
			
	    case R.string.junior_gemini:
	    	duration = "0 min, 50 sec\n";
    		heightreq = "36\"\n";
    		speed = "6 mph\n";
    		description = "Okay, you’re a coaster lover in training. It’s time to get started by stepping on to the Jr. Gemini. Inspired by its famous older sibling, Gemini, the Jr. Gemini gives youngsters a taste of the thrills to come just across the Midway. They can take a wild ride over the kid-sized hills and turns, and anticipate the excitement of a real grown-up coaster!\n";
    		textView = this.CreateTextView(duration, heightreq, speed, description);
    		
			layout.addView(textView);
			
			imageView = CreateImageView(R.drawable.jrgem_thumb);
			layout.addView(imageView);
			
			break;
			
	    case R.string.magnum_xl200:
	    	duration = "2 min, 0 sec\n";
    		heightreq = "48\"\n";
    		speed = "72 mph\n";
    		description = "For coaster enthusiasts around the world, the Magnum XL-200 is the ultimate ride. Situated right on the Lake Erie shore, Magnum was the first coaster ever to top 200 feet – you can see Canada on a clear day. Accelerating down its incredible first hill, Magnum reaches a top speed of 72 MPH, while rocketing you over multiple hills, 3 tunnels, and a signature “pretzel” turnaround.\n";
    		textView = this.CreateTextView(duration, heightreq, speed, description);
    		
			layout.addView(textView);
			
			imageView = CreateImageView(R.drawable.magnum_thumb);
			layout.addView(imageView);
			
			break;
			
	    case R.string.mantis:
	    	duration = "2 min, 40 sec\n";
    		heightreq = "54\"\n";
    		speed = "60 mph\n";
    		description = "What’s the best seat on Mantis? There isn’t one, because this is the coaster you ride STANDING UP! Step up and challenge yourself with a 145-foot climb, followed by a dive into a 119-foot giant loop, then a 103-foot tall dive loop, then an inclined loop and a flat spin maneuver. Did we mention you’ll do all this standing up?\n";
    		textView = this.CreateTextView(duration, heightreq, speed, description);
    		
			layout.addView(textView);
			
			imageView = CreateImageView(R.drawable.mantis_thumb);
			layout.addView(imageView);
			
			break;
			
	    case R.string.matterhorn:
			heightreq = "42\"\n";
			description = "For a rush of Alpine excitement, you can’t beat the Matterhorn. The cars rock and roll up, down and around as you fly to the summit!\n";
			textView = this.CreateTextView(heightreq, description);
			layout.addView(textView);
			
			imageView = CreateImageView(R.drawable.matterhorn_thumb);
			layout.addView(imageView);
			
			break;
			
	    case R.string.maverick:
	    	duration = "2 min, 30 sec\n";
    		heightreq = "52\"\n";
    		speed = "70 mph\n";
    		description = "You’ve heard of the Wild West--now you can ride it! Maverick is the coaster for riders who want one-of-a-kind thrills beyond the big hills. Saddle up and get ready for more twists, turns and airtime than a rodeo. Plus you’ll go through a “twisted horseshoe roll” and 400-foot-long speed launch through a pitch black tunnel. How about that, Pardner!\n";
    		textView = this.CreateTextView(duration, heightreq, speed, description);
    		
			layout.addView(textView);
			
			imageView = CreateImageView(R.drawable.maverick_thumb);
			layout.addView(imageView);
			
			break;
			
	    case R.string.maxair:
			heightreq = "52\"\n";
			description = "A blast of blue sky, then something flashes by, where exactly am I? For maximum air and delightful disorientation, maXair is your destination. You and 49 other riders are seated around a giant ring that starts to spin, then starts to swing, then before you know it you’re getting swirling views of the park from 140 feet in the air!\n";
			textView = this.CreateTextView(heightreq, description);
			layout.addView(textView);
			
			imageView = CreateImageView(R.drawable.maxair_thumb);
			layout.addView(imageView);
			
			break;
			
			
			
			
			
    	}
    }
    
    //TextView creation for roller coasters which have duration and speed statistics
    public TextView CreateTextView(String duration, String heightreq, String speed, String description)

    {
    	TextView tv = new TextView(this);
		RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
		lp.addRule(RelativeLayout.CENTER_IN_PARENT);
		lp.addRule(RelativeLayout.CENTER_HORIZONTAL);
		tv.setLayoutParams(lp);
		tv.setTextColor(getResources().getColor(R.color.white));
		tv.setText("Duration: 	" + duration +
				"Height Requirement:	" + heightreq +
				"Speed:		" + speed +
					description);
		return tv;
    }
    
    
    //TextView creation for thrillrides, which do not have duration and speed statistics
    public TextView CreateTextView(String heightreq, String description)
    {
    	TextView tv = new TextView(this);
		RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
		lp.addRule(RelativeLayout.CENTER_IN_PARENT);
		lp.addRule(RelativeLayout.CENTER_HORIZONTAL);
		tv.setLayoutParams(lp);
		tv.setTextColor(getResources().getColor(R.color.white));
		tv.setText("Height Requirement:	" + heightreq +
					description);
		return tv;
    }
    
    public ImageView CreateImageView (int imageResource)
    {
    	ImageView image = new ImageView(this);
		RelativeLayout.LayoutParams l = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
		l.addRule(RelativeLayout.CENTER_HORIZONTAL);
		image.setLayoutParams(l);
		image.setImageResource(imageResource);
		return image;
    }
    
    

}
