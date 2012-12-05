package com.cedar.app;

import java.io.*;

import android.content.*;
import android.graphics.*;
import android.widget.*;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class MapCanvas extends SurfaceView implements SurfaceHolder.Callback {
	InputStream is;
	private Paint paint;
	Bitmap b;
	
	public MapCanvas(Context context, Bitmap map){
		super(context);
		b = map;
		
		paint = new Paint();
		paint.setColor(Color.GREEN);
		paint.setTextSize(25);
		paint.setAntiAlias(true);
		
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawBitmap(b, 0, 0, null);
		super.onDraw(canvas);
		
		

		
		//invalidate();
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}

	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}

}
