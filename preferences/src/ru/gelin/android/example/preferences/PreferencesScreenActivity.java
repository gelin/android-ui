package ru.gelin.android.example.preferences;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class PreferencesScreenActivity extends PreferenceActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}