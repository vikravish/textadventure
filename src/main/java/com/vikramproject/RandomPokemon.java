package com.vikramproject;

import java.util.List;

public class RandomPokemon extends Pokemon {
    boolean isRandom = true;
    public RandomPokemon(PokemonType type, List<AttackTypes> attackSlots, int level, boolean isRandom){
        super(type, attackSlots, level);

    }
}
