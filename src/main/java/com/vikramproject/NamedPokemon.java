package com.vikramproject;

import java.util.List;

public class NamedPokemon extends Pokemon {
    String name;

    public NamedPokemon(String name, PokemonType type, List<AttackTypes> attackSlots, int level, boolean isRandom) {
        super(type, attackSlots, level);
        this.name = name;
    }
}
