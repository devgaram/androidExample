package org.androidtown.fragmentexam;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        ColorFragment colorFragment = (ColorFragment) fragmentManager.findFragmentById(R.id.color_fragment);
        colorFragment.setColor(Color.BLUE);
    }

    public void change(View view) {
        ColorFragment fragment = new ColorFragment();
        int red = new Random().nextInt(256);
        int green = new Random().nextInt(256);
        int blue = new Random().nextInt(256);
        fragment.setColor(Color.rgb(red, green, blue));
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }
}
