package com.cedar.app;

import android.content.Context;
import android.widget.CheckBox;



/**
 * @author Vinai Suresh
 * EnhancedCheckBox extends android.view.CheckBox but allows a Ride object to be associated with the CheckBoxes
 */
public class EnhancedCheckBox extends CheckBox {
	Ride ride;

	/**
	 * @param context
	 * @param r
	 */
	public EnhancedCheckBox(Context context, Ride r) {
		super(context);
		ride = r;
		// TODO Auto-generated constructor stub
	}

}
