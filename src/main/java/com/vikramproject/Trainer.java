package com.vikramproject;

import java.util.ArrayList;
import java.util.List;

public class Trainer extends Character {
    String name = "";
    int level;
    int currentPokemonIndex = -1;
    ArrayList<TrainerPokemon> inventory = new ArrayList<TrainerPokemon>();

    public Trainer(String name, int level, int currentPokemonIndex, ArrayList<TrainerPokemon> inventory){
        super(name, level, currentPokemonIndex, inventory);
    }
    public static Trainer create(String name, int level, int currentPokemonIndex, ArrayList<TrainerPokemon> inventory){
        return new Trainer(name, level, currentPokemonIndex, inventory);
    }

    public Pokemon getCurrentPokemon(){

        return inventory.get(currentPokemonIndex);
    }
}

