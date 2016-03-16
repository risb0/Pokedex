package com.example.risbo.pokedex;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import stanford.androidlib.SimpleActivity;

public class DetailsActivity extends SimpleActivity {
    private int pokeIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        pokeIcon = intent.getIntExtra("pokeImageDrawable",-1);




    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("debug", "pokeIcon = " + pokeIcon);


        ImageView pokeView = (ImageView) findViewById(R.id.pokemon_image);

        pokeView.setImageResource(pokeIcon);

    }
}
