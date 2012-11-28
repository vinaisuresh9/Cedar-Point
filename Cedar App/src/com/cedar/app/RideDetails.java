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
        
        //Get the name of the ride from the Intent
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
			
	    case R.string.mean_streak:
	    	duration = "2 min, 45 sec\n";
    		heightreq = "48\"\n";
    		speed = "65 mph\n";
    		description = "Quite possibly the most wood you’ll ever see in one place, the Mean Streak is 1.7 million board feet of southern yellow pine with an attitude. It’s beautiful to look at, but climb aboard and other words soon come to mind as you rocket through the hills and turns, in and out of the structure itself. This world-record breaker is everything you love about wooden coasters, just a lot more of it.\n";
    		textView = this.CreateTextView(duration, heightreq, speed, description);
    		
			layout.addView(textView);
			
			imageView = CreateImageView(R.drawable.mean_thumb);
			layout.addView(imageView);
			
			break;
			
	    case R.string.millenium_force:
	    	duration = "2 min, 0 sec\n";
    		heightreq = "48\"\n";
    		speed = "93 mph\n";
    		description = "It’s the big star of the show. A true Giant among coasters. So huge, it created a whole new category – the giga-coaster. Welcome to Millennium Force, the 310 foot, 93 MPH record-breaking monster of a thrill ride. The first hill features an elevator cable lift system to get you to the top faster, then it’s an 80-degree drop to start the coaster ride of your life!\n";
    		textView = this.CreateTextView(duration, heightreq, speed, description);
    		
			layout.addView(textView);
			
			imageView = CreateImageView(R.drawable.milli_thumb);
			layout.addView(imageView);
			
			break;
			
	    case R.string.monster:
			heightreq = "46\"\n";
			description = "A many-tentacled creature has you in its grip. Ride the disorienting Monster and you’ll be spun, turned, lifted and lowered – all at the same time! \n";
			textView = this.CreateTextView(heightreq, description);
			layout.addView(textView);
			
			imageView = CreateImageView(R.drawable.monster_thumb);
			layout.addView(imageView);
			
			break;
			
	    case R.string.ocean_motion:
			heightreq = "39\"\n";
			description = "Ships are made to sail, and this one REALLY does its job. The Ocean Motion ship swings back and forth, higher and higher, until it reaches 65 feet.\n";
			textView = this.CreateTextView(heightreq, description);
			layout.addView(textView);
			
			imageView = CreateImageView(R.drawable.oceanmotion_thumb);
			layout.addView(imageView);
			
			break;
			
	    case R.string.power_tower:
			heightreq = "52\"\n";
			description = " It’s 300 feet of steel rising into the sky, and a choice: you can rocket 240 feet up to the top at incredible speed, or you can start at the top and thrust downward faster than a free fall. Two towers rocket up, and two towers thrust down. Well, what’s it gonna be?\n";
			textView = this.CreateTextView(heightreq, description);
			layout.addView(textView);
			
			imageView = CreateImageView(R.drawable.oceanmotion_thumb);
			layout.addView(imageView);
			
			break;
			
	    case R.string.raptor:
	    	duration = "2 min, 0 sec\n";
    		heightreq = "54\"\n";
    		speed = "57 mph\n";
    		description = "Get ready to catch some big air: when you ride Raptor the only thing under your feet is sky. You really will feel snatched up by a bird of prey as the Raptor takes you wherever it pleases, turning you upside down six different times before returning you safely to solid ground. It all starts when you hear, \"There goes the floor, you're out the door - enjoy your ride on Raptor!\"\n";
    		textView = this.CreateTextView(duration, heightreq, speed, description);
    		
			layout.addView(textView);
			
			imageView = CreateImageView(R.drawable.raptor_thumb);
			layout.addView(imageView);
			
			break;
			
	    case R.string.scrambler:
			heightreq = "52\"\n";
			description = " It’s 300 feet of steel rising into the sky, and a choice: you can rocket 240 feet up to the top at incredible speed, or you can start at the top and thrust downward faster than a free fall. Two towers rocket up, and two towers thrust down. Well, what’s it gonna be?\n";
			textView = this.CreateTextView(heightreq, description);
			layout.addView(textView);
			
			imageView = CreateImageView(R.drawable.oceanmotion_thumb);
			layout.addView(imageView);
			
			break;
			
	    case R.string.skyhawk:
			heightreq = "48\"\n";
			description = "We’ve got a swing set. And it’s waaaaaay bigger than yours. In fact, the Skyhawk is the world’s tallest swing ride at 125 feet. Two giant arms, each holding 20 riders, swing in a 60 mph scissor motion, reaching high into the deep blue sky.\n";
			textView = this.CreateTextView(heightreq, description);
			layout.addView(textView);
			
			imageView = CreateImageView(R.drawable.skyhawk_thumb);
			layout.addView(imageView);
			
			break;
			
	    case R.string.super_himalaya:
			heightreq = "52\"\n";
			description = "Who knew something like centrifugal force could squeeze out so many laughs! The Super Himalaya takes you and your seatmates around and around, up and down and by the end everyone’s happily squeezed together.\n";
			textView = this.CreateTextView(heightreq, description);
			layout.addView(textView);
			
			imageView = CreateImageView(R.drawable.super_thumb);
			layout.addView(imageView);
			
			break;
			
	    case R.string.top_thrill:
	    	duration = "0 min, 17 sec\n";
    		heightreq = "52\"\n";
    		speed = "120 mph\n";
    		description = "Zero to 120 MPH in less than 4 seconds. A few seconds later, you’re 420 feet in the air. In the race for pure adrenaline thrills, there is one winner: Top Thrill Dragster. Nothing else compares to this high-horsepower shot into the sky. From a standing start you’re launched forward, then straight up, then straight down and back to the finish line. The ride may be over in 17 seconds, but it’ll stay with you forever.\n";
    		textView = this.CreateTextView(duration, heightreq, speed, description);
    		
			layout.addView(textView);
			
			imageView = CreateImageView(R.drawable.ttd_thumb);
			layout.addView(imageView);
			
			break;
			
	    case R.string.troika:
			heightreq = "42\"\n";
			description = "For people who want more scramble than even the Scrambler: Troika. Rising 25 feet off the ground with a swinging scramble, the Troika is fun to the power of three!\n";
			textView = this.CreateTextView(heightreq, description);
			layout.addView(textView);
			
			imageView = CreateImageView(R.drawable.troika_thumb);
			layout.addView(imageView);
			
			break;
			
	    case R.string.wave_swinger:
			heightreq = "48\"\n";
			description = " This classic midway ride is as beautiful to look at as it is to ride. Swing around and around, rising 16 feet in the air as the tower reaches its full height.\n";
			textView = this.CreateTextView(heightreq, description);
			layout.addView(textView);
			
			imageView = CreateImageView(R.drawable.waveswinger_thumb);
			layout.addView(imageView);
			
			break;
			
	    case R.string.wicked_twister:
	    	duration = "0 min, 40 sec\n";
    		heightreq = "52\"\n";
    		speed = "72 mph\n";
    		description = "Just steps from the Cedar Point Beach you can launch yourself into a spiraling scream-fest on the Wicked Twister. It’s not just a coaster, it’s a double-twisting impulse coaster. One of the tallest--and fastest--in the world. You’ll be rocked, rolled and launched into two 450-degree spirals at each end of the tracks. You will be twisted. Wickedly. What are you waiting for?\n";
    		textView = this.CreateTextView(duration, heightreq, speed, description);
    		
			layout.addView(textView);
			
			imageView = CreateImageView(R.drawable.wicked_thumb);
			layout.addView(imageView);
			
			break;
			
	    case R.string.wind_seeker:
			heightreq = "52\"\n";
			description = "How would you like to swing in a chair that rises higher than Magnum? You can. Just grab a seat on WindSeeker and it’ll take you 301 feet into the sky with NOTHING below your chair but air!\n";
			textView = this.CreateTextView(heightreq, description);
			layout.addView(textView);
			
			imageView = CreateImageView(R.drawable.ws_thumb);
			layout.addView(imageView);
			
			break;
			
	    case R.string.witches_wheel:
			heightreq = "54\"\n";
			description = "It looks innocent enough. But step into one of its unique tandem-style cars and things change. First you spin. Faster and faster until the whole ride tips up and suddenly you’re going up and down and upside down, snug in your seat thanks to all the positive g-forces.\n";
			textView = this.CreateTextView(heightreq, description);
			layout.addView(textView);
			
			imageView = CreateImageView(R.drawable.witches_thumb);
			layout.addView(imageView);
			
			break;
			
	    case R.string.woodstock_express:
	    	duration = "1 min, 40 sec\n";
    		heightreq = "48\"\n";
    		speed = "25 mph\n";
    		description = "Looking for some thrills in Camp Snoopy? It’s time to board the Woodstock Express. The perfect size for parents and kids to ride together, this junior coaster takes you on a zippy ride through hills, turns, and curves. And giggles.\n";
    		textView = this.CreateTextView(duration, heightreq, speed, description);
    		
			layout.addView(textView);
			
			imageView = CreateImageView(R.drawable.woodstock_thumb);
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
