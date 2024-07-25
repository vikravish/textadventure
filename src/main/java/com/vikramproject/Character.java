package com.vikramproject;

import java.util.ArrayList;
import java.util.List;

public class Character {
    String name = "";
    int level;
    int currentPokemonIndex = -1;
    ArrayList<Pokemon> inventory = new ArrayList<Pokemon>();
    public Pokemon getCurrentPokemon(){
        
        return inventory.get(currentPokemonIndex);
    }
}

