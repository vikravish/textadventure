package com.vikramproject;

import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Player extends Character{
    int xp = 0;
    ArrayList<PlayerPokemon> inventory = new ArrayList<PlayerPokemon>();
     ArrayList<PlayerPokemon> pokedex = new ArrayList<PlayerPokemon>();
     public Player(String name, int level, int currentPokemonIndex, ArrayList<PlayerPokemon> inventory, int xp, ArrayList<PlayerPokemon> pokedex){
        ArrayList<Pokemon> streamedInventory = inventory.stream().map((playerPokemon) -> (Pokemon)playerPokemon).collect(Collectors.toCollection(ArrayList::new));
        super(name, level, currentPokemonIndex, streamedInventory);
        this.xp = xp;
        this.pokedex = pokedex;
    }
    }
