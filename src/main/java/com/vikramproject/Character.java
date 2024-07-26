package com.vikramproject;

import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    String name = "";
    int level;
    int currentPokemonIndex = -1;
    ArrayList<Pokemon> inventory = new ArrayList<Pokemon>();

    public Character(String name, int level, int currentPokemonIndex, ArrayList<Pokemon> inventory) {
        this.name = name;
        this.level = level;
        this.currentPokemonIndex = -1;
        this.inventory = inventory;
    }

    public Pokemon getCurrentPokemon() {

        return inventory.get(currentPokemonIndex);
    }
}
