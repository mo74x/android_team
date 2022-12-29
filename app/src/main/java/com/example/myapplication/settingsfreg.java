package com.example.myapplication;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

public class settingsfreg extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences( Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.preferences);
    }
}
