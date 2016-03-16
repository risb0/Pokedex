package com.example.risbo.pokedex;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import stanford.androidlib.SimpleActivity;

public class DetailsActivity extends SimpleActivity {
    private int pokeIcon;
    private String pokemonName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        pokeIcon = intent.getIntExtra("pokeImageDrawable",-1);
        pokemonName = intent.getStringExtra("pokemonName");
    }

    @Override
    protected void onStart() {
        super.onStart();

        ImageView pokeImageView = (ImageView) findViewById(R.id.pokemon_image);
        pokeImageView.setImageResource(pokeIcon);

        TextView pokeTextView = (TextView) (findViewById(R.id.pokemon_name));
        pokeTextView.setText(pokemonName.toUpperCase());

    }
}
