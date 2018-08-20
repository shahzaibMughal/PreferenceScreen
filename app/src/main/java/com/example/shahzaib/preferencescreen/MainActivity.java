package com.example.shahzaib.preferencescreen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    ImageView face;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        face = findViewById(R.id.faceIV);


    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean shouldFaceShown = sharedPreferences.getBoolean("show_face", true);
        showFace(shouldFaceShown);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if(key.equals(getString(R.string.show_face)))
        {
            boolean shouldFaceShown = sharedPreferences.getBoolean(key,true);
            showFace(shouldFaceShown);

        }
    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
        PreferenceManager.getDefaultSharedPreferences(this).unregisterOnSharedPreferenceChangeListener(this);
    }



    private void showFace(boolean shouldFaceShown) {
        if (shouldFaceShown) {
            face.setVisibility(View.VISIBLE);
        } else {
            face.setVisibility(View.GONE);
        }
    }


    public void startSettingsActivity(View view) {
        startActivity(new Intent(this, Settings.class));
    }


}
