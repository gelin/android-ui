package ru.gelin.android.example.relative;

import android.app.Activity;
import android.os.Bundle;

public class RelativeActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person);
    }
}
