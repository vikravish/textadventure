package com.vikramproject;

import java.util.List;

public class PlayerPokemon extends NamedPokemon {
    public PlayerPokemon(String name, PokemonType type, List<AttackTypes> attackSlots, int level, boolean isRandom) {
        super(name, type, attackSlots, level, isRandom);
    }

}
