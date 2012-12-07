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

public class MapCanvas extends View implements OnTouchListener {
	InputStream is;
	private Paint paint;
	Bitmap b;
	Path pathnodes;
	Path ridenodes;
	Path pathing;
	int height;
	int width;
	Context c;
	boolean pathdrawn;
	ArrayList<IntermediateMapNode> pathMapNodes = new ArrayList<IntermediateMapNode>();
	private ArrayList<MapEdge> pathMapEdges = new ArrayList<MapEdge>();
	private LinkedList<IntermediateMapNode> ridesInOrder = new LinkedList<IntermediateMapNode>();
	
	public MapCanvas(Context context, Bitmap map){
		super(context);
		c = context;
		pathnodes = new Path();
		ridenodes = new Path();
		pathing = new Path();
		pathdrawn = false;
		
		setOnTouchListener(this);
		
		
		WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		height = display.getHeight();
		width = display.getWidth();
		
		int statusBarHeight = (int)Math.ceil(25 * getContext().getResources().getDisplayMetrics().density);
		
		b = Bitmap.createScaledBitmap(map, width, height - statusBarHeight, true);	
		
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		canvas.drawBitmap(b, 0,0, null);
		
    	Paint paint = new Paint();
		paint.setColor(Color.BLACK);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(5);
		paint.setAntiAlias(true);
		
		Paint n = new Paint();
		n.setColor(Color.RED);
		n.setStyle(Paint.Style.STROKE);
		n.setStrokeWidth(5);
		n.setAntiAlias(true);
		n.setStrokeCap(Cap.ROUND);

		Paint textPaint = new Paint();
		textPaint.setColor(Color.WHITE);
		textPaint.setTextSize(25f);
		textPaint.setTextAlign(Align.CENTER);
		
		Paint backPaint = new Paint();
		backPaint.setColor(Color.BLACK);
		backPaint.setTypeface(Typeface.DEFAULT_BOLD);
		backPaint.setStrokeWidth(2f);
		backPaint.setTextSize(25f);
		backPaint.setStyle(Paint.Style.STROKE);
		backPaint.setTextAlign(Align.CENTER);
		
		
		ArrayList<IntermediateMapNode> nodes = pathMapNodes;
		ArrayList<MapEdge> edges = pathMapEdges;
		
//		for (MapEdge edge : edges)
//		{
//			canvas.drawLine(width*edge.node1.x, height*edge.node1.y, width*edge.node2.x, height*edge.node2.y, n);
//		}
		
		for (MapNode node : nodes)
		{
			canvas.drawCircle(width*node.x,height* node.y, 3, paint);
		}
		
		for (Ride ride : ListofRides.fullListofRides)
		{
			canvas.drawText(ride.name, ride.mapX * width, ride.mapY * height, backPaint);
			canvas.drawText(ride.name, ride.mapX * width, ride.mapY * height, textPaint);		
		}
		
		for (int g = 0; g < ridesInOrder.size()-1; g++)
		{
			canvas.drawLine(ridesInOrder.get(g).x * width, ridesInOrder.get(g).y * height, ridesInOrder.get(g+1).x * width, ridesInOrder.get(g+1).y * height, n);
		}
		invalidate();
	}
	
	
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
	
	private void showRideInfo(Ride r) {
		Intent intent = new Intent(c, RideDetails.class);
		String[] array = {r.name, r.ridetype, r.duration, r.heightreq,
				r.speed, r.description, r.video};
		
   		intent.putExtra(ListofRides.RIDE, array);

   		c.startActivity(intent);
		
	}


	public void drawPathNode(ArrayList<IntermediateMapNode> pathMapNodes) {
		this.pathMapNodes = pathMapNodes;
		invalidate();
	}

	public void DrawEdges(ArrayList<MapEdge> pathMapEdges) {

		this.pathMapEdges = pathMapEdges;
	}

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

	public void drawUserRoute(LinkedList<IntermediateMapNode> ridesInOrder) {
		this.ridesInOrder = ridesInOrder;
		invalidate();
	}
	

}
