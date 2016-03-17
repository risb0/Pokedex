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

import java.util.Scanner;

import stanford.androidlib.SimpleActivity;


public class PokedexActivity extends SimpleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokedex);



    }


    public void pokemonClick(View view) {

        int imageId = view.getId();

        ImageButton pokeImage = (ImageButton) findViewById(imageId);

        String pokemonName = pokeImage.getTag().toString();

        //Stanford library methods for orientaiton
        if(isPortrait()){




            // Stanford library method to get the id of anything: getResourceId()
            //int pokeImagedraw = getResourceId(pokeImage.getTag().toString());
//        int pokeImageDrawable =  getResources().getIdentifier(pokemonName.toLowerCase(), "drawable", getApplicationContext().getPackageName());


            Intent intent = new Intent(this,DetailsActivity.class);
//        intent.putExtra("pokeImageDrawable",pokeImageDrawable);
            intent.putExtra("pokemonName",pokemonName);
            startActivity(intent);


        } else {
            //landscape mode; update fragment
            DetailsFragment frag = (DetailsFragment) getFragmentManager().findFragmentById(R.id.detailsfrag);

            frag.setPokemonName(pokemonName);

        }



    }
}


