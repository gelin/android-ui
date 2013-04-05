package ru.gelin.android.example.click;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Click extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.click);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Click.this, "Listened!", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void onClick(View button) {
        Toast.makeText(this, "Clicked!", Toast.LENGTH_LONG).show();
    }

}
