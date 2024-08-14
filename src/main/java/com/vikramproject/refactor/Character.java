package com.vikramproject.refactor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Character {
    String name;
    int level = 1;
    int hp = 100;
    
    /**
     * -1 means none is selected, otherwise this value should be between 0 and inventory.size().
     */
    Optional<Integer> currentPokemonIndex = Optional.empty();
    List<Pokemon> inventory = new ArrayList<>();

    public void setCurrentPokemon(int index) {
        currentPokemonIndex = Optional.of(index);

    }

    /**
     * 
     * @return
     */
    public Optional<Pokemon> getCurrentPokemon() {
       /* if(currentPokemonIndex.isPresent()){
            return Optional.of(inventory.get(currentPokemonIndex.get()));
        }else{
            return Optional.empty();
        } */
        return currentPokemonIndex.map(inventory::get);
    }

    /**
     * 
     * @return
     */
    public Pokemon getCurrentPokemonOrNull() {
        try {
            return inventory.get(currentPokemonIndex.get());
        } catch (Exception e) {
            App.debug(e);
            return null;
        }
    }
}
