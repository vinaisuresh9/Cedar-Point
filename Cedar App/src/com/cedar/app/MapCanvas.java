package com.cedar.app;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

import android.content.*;
import android.graphics.*;
import android.graphics.Paint.Align;
import android.graphics.Paint.Cap;
import android.widget.*;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.*;
import android.view.*;

/**
 * @author Eric Mellino
 * MapCanvas creates a custom view with the map as the background and allows custom drawing on the map for route information and ride information
 *
 */
public class MapCanvas extends View implements OnTouchListener {
	Bitmap b;
	int height;
	int width;
	Context c;
	ArrayList<IntermediateMapNode> pathMapNodes = new ArrayList<IntermediateMapNode>();
	private LinkedList<IntermediateMapNode> ridesInOrder = new LinkedList<IntermediateMapNode>();
	
	/**
	 * @author Vinai Suresh
	 * @param Context context
	 * @param Bitmap map
	 * Constructor
	 */
	public MapCanvas(Context context, Bitmap map){
		super(context);
		c = context;
		
		setOnTouchListener(this);
		
		
		WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		height = display.getHeight();
		width = display.getWidth();
		
		//Calculate the statusbarheight per device so that we can subtract it from the map scale
		int statusBarHeight = (int)Math.ceil(25 * getContext().getResources().getDisplayMetrics().density);
		
		b = Bitmap.createScaledBitmap(map, width, height - statusBarHeight, true);	
		
	}
	
	/* (non-Javadoc)
	 * @see android.view.View#onDraw(android.graphics.Canvas)
	 */
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		canvas.drawBitmap(b, 0,0, null);
		
		//Black paint
    	Paint paint = new Paint();
		paint.setColor(Color.BLACK);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(5);
		paint.setAntiAlias(true);
		
		//Red paint
		Paint n = new Paint();
		n.setColor(Color.RED);
		n.setStyle(Paint.Style.STROKE);
		n.setStrokeWidth(5);
		n.setAntiAlias(true);
		n.setStrokeCap(Cap.ROUND);

		//white paint
		Paint textPaint = new Paint();
		textPaint.setColor(Color.WHITE);
		textPaint.setTextSize(25f);
		textPaint.setTextAlign(Align.CENTER);
		
		//Black paint for ride text
		Paint backPaint = new Paint();
		backPaint.setColor(Color.BLACK);
		backPaint.setTypeface(Typeface.DEFAULT_BOLD);
		backPaint.setStrokeWidth(2f);
		backPaint.setTextSize(25f);
		backPaint.setStyle(Paint.Style.STROKE);
		backPaint.setTextAlign(Align.CENTER);

		
		//Display all of the rides with their names
		for (Ride ride : ListofRides.fullListofRides)
		{
			canvas.drawText(ride.name, ride.mapX * width, ride.mapY * height, backPaint);
			canvas.drawText(ride.name, ride.mapX * width, ride.mapY * height, textPaint);		
		}
		
		//Display route when ridesList is populated
		for (int g = 0; g < ridesInOrder.size()-1; g++)
		{
			canvas.drawLine(ridesInOrder.get(g).x * width, ridesInOrder.get(g).y * height, ridesInOrder.get(g+1).x * width, ridesInOrder.get(g+1).y * height, n);
		}
		//Draw nodes that contain the rides that the user wants to visit
		for (IntermediateMapNode mn : RidePath.needToVisit)
		{
			canvas.drawCircle(width*mn.x,height* mn.y, 3, paint);
		}
		
		
		invalidate();
	}
	
	
	/**
	 * @author Aaron Noviski
	 * @param float x
	 * @param float y
	 * Check to see if user pressed near one of the ride names then goes to that description
	 */
	void buttonPressedAt(float x, float y)
	{
		for (Ride r : ListofRides.fullListofRides)
		{
			if (Math.abs((r.mapX * width - x)) < 25 && Math.abs((r.mapY * height - y)) < 25)
			{
				showRideInfo(r);
				return;
			}
		}
	}
	
	/**
	 * @author Aaron Noviski
	 * @param Ride r
	 * Load the description of the Ride pressed
	 */
	private void showRideInfo(Ride r) {
		Intent intent = new Intent(c, RideDetails.class);
		String[] array = {r.name, r.ridetype, r.duration, r.heightreq,
				r.speed, r.description, r.video};
		
   		intent.putExtra(ListofRides.RIDE, array);

   		c.startActivity(intent);
		
	}


	/* (non-Javadoc)
	 * @see android.view.View.OnTouchListener#onTouch(android.view.View, android.view.MotionEvent)
	 */
	public boolean onTouch(View v, MotionEvent event) {
		final int action = event.getAction();
        switch (action & MotionEvent.ACTION_MASK) 
        {
	        case 0: 
	        {	
	        	float x = event.getX();
	        	float y = event.getY();
	        	buttonPressedAt(x, y);
	        	break;	
	        }
        }
        return true;
	}

	/**
	 * @author Aaron Noviski
	 * @param LinkedList<IntermediateMapNode> ridesInOrder
	 * Sets rides that user wants to visit for drawing route
	 */
	public void drawUserRoute(LinkedList<IntermediateMapNode> ridesInOrder) {
		this.ridesInOrder = ridesInOrder;
		invalidate();
	}
	

}
