package com.example.risbo.pokedex;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Scanner;

import stanford.androidlib.SimpleActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {

    private String pokemonName;
    private String pokeDetailsText;
    private Scanner scan;
    private SimpleActivity myActivity;

    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        myActivity = (SimpleActivity) getActivity();

        //initialization code
        Intent intent = myActivity.getIntent();
        pokemonName = intent.getStringExtra("pokemonName");
        if (pokemonName == null) {
            pokemonName = "Nidoking";

        }

        setPokemonName(pokemonName);

    }

    public void setPokemonName(String pokemonName){
        myActivity = (SimpleActivity) getActivity();

        ImageView pokeImageView = (ImageView) myActivity.findViewById(R.id.pokemon_image);
        int pokeIcon = getResources().getIdentifier(pokemonName.toLowerCase(),"drawable",myActivity.getPackageName());
        pokeImageView.setImageResource(pokeIcon);



        TextView pokeTextView = (TextView) (myActivity.findViewById(R.id.pokemon_name));
        pokeTextView.setText(pokemonName.toUpperCase());



        readDetails(pokemonName);

        TextView pokeDetailsTextView = (TextView) myActivity.findViewById(R.id.pokemon_details);
        pokeDetailsTextView.setText(pokeDetailsText);
        scan.close();

    }


    public void readDetails(String pokemonName) {
        Log.d("tag", "pokeFile = " + pokemonName );
        int pokeFile = getResources().getIdentifier(pokemonName.toLowerCase(), "raw", myActivity.getPackageName());


        scan = new Scanner(
                getResources().openRawResource(pokeFile));

        while (scan.hasNextLine()) {
            pokeDetailsText = scan.nextLine();

        }

    }
}
