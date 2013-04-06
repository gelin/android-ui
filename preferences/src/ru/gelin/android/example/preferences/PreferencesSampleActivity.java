package ru.gelin.android.example.preferences;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

public class PreferencesSampleActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView text = (TextView)findViewById(R.id.text);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        text.setText("Checkbox: " + preferences.getBoolean("checkbox", true) + "\n" +
                "Text: " + preferences.getString("text", "") + "\n" +
                "List: " + preferences.getString("list", "") + "\n" +
                "Switch: " + preferences.getBoolean("switch", true));
    }

    public void showPreferences(View view) {
        Intent intent = new Intent(this, PreferencesScreenActivity.class);
        startActivity(intent);
    }
}
