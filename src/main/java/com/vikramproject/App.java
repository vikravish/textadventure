package com.vikramproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void makePokemon() {
        System.out.println("Welcome to your new adventure!");
        System.out.println("Choose your Pokemon: Snivy, Charmander, Squirtle");
        Scanner scanner = new Scanner(System.in);
        String writtenPokemon = scanner.nextLine().trim();
        Pokemon pokemon = null;
        // System.out.println(writtenPokemon);
        for (int character : writtenPokemon.codePoints().toArray()) {
            System.out.println("[\u001b[41m" + java.lang.Character.valueOf((char) character) + "\u001b[0m]");
        }
        if (!writtenPokemon.equals("Snivy") && !writtenPokemon.equals("Charmander")
                && !writtenPokemon.equals("Squirtle")) {
            // Input: Rock | Output: True && True && True = True / Input: Snivy | Output:
            // False && True && True = False
            System.out.println("Please choose a valid Pokemon");
            return;
            // System.out.println("test");
        }
        PokemonType type = null;
        if (writtenPokemon.equals("Snivy")) {
            type = PokemonType.SNIVY;
        }
        if (writtenPokemon.equals("Charmander")) {
            type = PokemonType.CHARMANDER;
        }
        if (writtenPokemon.equals("Squirtle")) {
            type = PokemonType.SQUIRTLE;
        }
        System.out.println("Please name your Pokemon:");
        String name = scanner.nextLine();
        System.out
                .println("Choose three attacks: (Note: Elemental attacks may be disadvantaged against other Pokemon)");
        if (type == PokemonType.CHARMANDER) {
            List<String> availableMoves = List.of("Ember", "Flamethrower", "Punch", "Tail Whip");
            System.out.println("Please choose one of the following attacks:");
            for (String attackType : availableMoves) {
                System.out.println(attackType);
            }
        }
        if (type == PokemonType.SNIVY) {
            List<String> availableMoves = List.of("Vine Whip", "Seed Bomb", "Punch", "Tail Whip");
            System.out.println("Please choose one of the following attacks:");
            for (String attackType : availableMoves) {
                System.out.println(attackType);
            }
        }
        if (type == PokemonType.SQUIRTLE) {

            List<String> availableMoves = List.of("Aqua Jet", "Water Pulse", "Punch", "Tail Whip");
            System.out.println("Please choose one of the following attacks:");
            for (String attackType : availableMoves) {
                System.out.println(attackType);
            }
        }
        String[] rawChosenAttacks = new String[3];
        for (int i = 1; i <= 3; i++) {
            System.out.println("Please choose attack #" + i);
            rawChosenAttacks[i - 1] = scanner.nextLine();
            if (i == 3) {
                System.out.println("Thank you for choosing your attacks.");
                break;
            }
        }
        List<Object> attackList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String rawChosenAttack = rawChosenAttacks[i];
            Pokemon.allAttackTypesWithName.forEach((attackName, attackType) -> {
                if (rawChosenAttack.equals(attackName))
                    attackList.add(attackType);
            });
        }
        pokemon = new Pokemon(name, type, attackList, 1);
        System.out.println("You have chosen the Pokemon: " + pokemon.type + ", with the name: " + pokemon.name);
        System.out.println("Your Pokemon '" + pokemon.name + "' can use the following moves:");
        for (int i = 0; i < 3; i++) {
            System.out.println(rawChosenAttacks[i]);
        }
        System.out.println("Good luck on your adventure!");

    }

    public static void battle(){

    }
    public static void main(String[] args) {
        makePokemon();
        battle();
    }

}
