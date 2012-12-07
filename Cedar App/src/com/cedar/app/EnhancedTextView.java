package com.cedar.app;

import android.content.Context;
import android.widget.TextView;


/**
 * @author Vinai Suresh
 * EnhancedTextView is a child class of android.view.TextView and allows a Ride to be associated with the Textview
 */
public class EnhancedTextView extends TextView {
	Ride ride;

	/**
	 * @param context
	 * @param r
	 */
	public EnhancedTextView(Context context, Ride r) {
		super(context);
		ride = r;
		// TODO Auto-generated constructor stub
	}

}
