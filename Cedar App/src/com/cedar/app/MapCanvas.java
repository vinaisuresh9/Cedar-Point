package com.cedar.app;

import java.io.*;

import android.content.*;
import android.graphics.*;
import android.widget.*;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;

public class MapCanvas extends View {
	InputStream is;
	private Paint paint;
	Bitmap b;
	Path p;
	boolean pathdrawn;
	
	public MapCanvas(Context context, Bitmap map){
		super(context);
		p = new Path();
		pathdrawn = false;
		
		WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		int height = display.getHeight();
		int width = display.getWidth();
		
		int statusBarHeight = (int)Math.ceil(25 * getContext().getResources().getDisplayMetrics().density);
		
		b = Bitmap.createScaledBitmap(map, width, height - statusBarHeight, true);
		
		
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		canvas.drawBitmap(b, 0,0, null);
		
    	Paint paint = new Paint();
		paint = new Paint();
		paint.setColor(Color.BLACK);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(10);
		paint.setAntiAlias(true);
		
		Path route = new Path();
		route.set(p);
		
		if (pathdrawn)
		{
			canvas.drawPath(route, paint);
		}
		invalidate();
	}
	
	public void DrawPath(Path path)
	{
		p.set(path);
		pathdrawn = true;
		invalidate();
		
		
	}


}
