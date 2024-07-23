package com.vikramproject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Pokemon {
    String name;
    PokemonType type;
    List<Object> attackSlots;
    int level;
    int hp = level * 100;
    public Pokemon(String name, PokemonType type, List<Object> attackSlots, int level){
        this.name = name; //the name given to the Pokemon by the player
        this.type = type; //the Pokemon that the player chooses
        this.attackSlots = attackSlots;
        this.level = level;
    }

    public static Map<String, AttackTypes> allAttackTypesWithName = Map.ofEntries(
        Map.entry("Aqua Jet", AttackTypes.AQUA_JET),
        Map.entry("Water Pulse", AttackTypes.WATER_PULSE),
        Map.entry("Vine Whip", AttackTypes.VINE_WHIP),
        Map.entry("Seed Bomb", AttackTypes.SEED_BOMB),
        Map.entry("Ember", AttackTypes.EMBER),
        Map.entry("Flamethrower", AttackTypes.FLAMETHROWER),
        Map.entry("Punch", AttackTypes.PUNCH),
        Map.entry("Tail Whip", AttackTypes.TAIL_WHIP)
        );
        //Converts the correlating String to each of the AttackTypes
    public static AttackTypes getAttackType(String attack){
        return allAttackTypesWithName.get(attack);
    }

        //Converts each of the AttackTypes to their correlating String
    public static String getAttackString(AttackTypes attackType){
        List<Map.Entry<String, AttackTypes>> resultFound = allAttackTypesWithName.entrySet().stream().filter((entry) -> entry.getValue() == attackType).collect(Collectors.toList());
        if(resultFound.size() == 0){
            return null;
        }
        return resultFound.get(0).getKey();
    }
}
