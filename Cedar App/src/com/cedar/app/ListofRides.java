package com.cedar.app;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ListofRides extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listof_rides);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_listof_rides, menu);
        return true;
    }
}
