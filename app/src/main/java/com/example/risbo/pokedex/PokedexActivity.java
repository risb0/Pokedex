package com.example.risbo.pokedex;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import stanford.androidlib.SimpleActivity;


public class PokedexActivity extends SimpleActivity {

    private Drawable pokeIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokedex);
    }


    public void pokemonClick(View view) {

        int imageId = view.getId();

        ImageButton pokeImage = (ImageButton) findViewById(imageId);

        int pokeImageDrawable =  getResources().getIdentifier(pokeImage.getTag().toString(), "drawable", getApplicationContext().getPackageName());

        Intent intent = new Intent(this,DetailsActivity.class);
        intent.putExtra("pokeImageDrawable",pokeImageDrawable);
        startActivity(intent);

    }
}


