package org.androidtown.callbackexam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements ColorListFragment.OnColorSelectedListener {
    private ColorFragment mcolorFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mcolorFragment = (ColorFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_color);
    }

    @Override
    public void onColorSelected(int color) {
        mcolorFragment.setColor(color);
    }
}
