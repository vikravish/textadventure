package com.vikramproject;

import java.util.ArrayList;
import java.util.List;
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
        String writtenPokemon = scanner.nextLine();
        Pokemon pokemon = null;
        //System.out.println(writtenPokemon);
        for (int character : writtenPokemon.codePoints().toArray()) {
            System.out.println("[\u001b[41m" + Character.valueOf((char)character) + "\u001b[0m]");
        }
        if (!writtenPokemon.equals("Snivy") || !writtenPokemon.equals("Charmander") ||!writtenPokemon.equals("Squirtle")Snivy) {
            System.out.println("Please choose a valid Pokemon");
            System.exit(0);
            System.out.println("test");
        }
        PokemonType type = null;
        if (writtenPokemon == "Snivy") {
            type = PokemonType.SNIVY;
        }
        if (writtenPokemon == "Charmander") {
            type = PokemonType.CHARMANDER;
        }
        if (writtenPokemon == "Squirtle") {
            type = PokemonType.SQUIRTLE;
        }
        System.out.println("Please name your Pokemon:");
        String name = scanner.nextLine();
        System.out
                .println("Choose three attacks: (Note: Elemental attacks may be disadvantaged against other Pokemon)");
        if (type == PokemonType.CHARMANDER) {
            List<String> availableMoves = List.of("Ember", "Flamethrower", "Punch", "Tail Whip");
            System.out.print("Please choose one of the following attacks:");
            for (String attackType : availableMoves) {
                System.out.print(attackType);
            }
        }
        if (type == PokemonType.SNIVY) {
            List<String> availableMoves = List.of("Vine Whip", "Seed Bomb", "Punch", "Tail Whip");
            System.out.print("Please choose one of the following attacks:");
            for (String attackType : availableMoves) {
                System.out.print(attackType);
            }
        }
        if (type == PokemonType.SQUIRTLE) {

            List<String> availableMoves = List.of("Aqua Jet", "Water Pulse", "Punch", "Tail Whip");
            System.out.print("Please choose one of the following attacks:");
            for (String attackType : availableMoves) {
                System.out.print(attackType);
            }
        }
        String[] attacksString = new String[3];
        for (int i = 1; i <= 3; i++) {
            attacksString[i] = scanner.nextLine();
            if (i == 3) {
                System.out.println("Thank you for choosing your attacks.");
            }
        }
        List<Object> attackList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (attacksString[i].equals("Aqua Jet")) {
                attackList.add(i, AttackTypes.AQUA_JET);
            }
            if (attacksString[i].equals("Water Pulse")) {
                attackList.add(i, AttackTypes.WATER_PULSE);
            }
            if (attacksString[i].equals("Vine Whip")) {
                attackList.add(i, AttackTypes.VINE_WHIP);
            }
            if (attacksString[i].equals("Seed Bomb")) {
                attackList.add(i, AttackTypes.SEED_BOMB);
            }
            if (attacksString[i].equals("Ember")) {
                attackList.add(i, AttackTypes.EMBER);
            }
            if (attacksString[i].equals("Flamethrower")) {
                attackList.add(i, AttackTypes.FLAMETHROWER);
            }
            if (attacksString[i].equals("Punch")) {
                attackList.add(i, AttackTypes.PUNCH);
            }
            if (attacksString[i].equals("Tail Whip")) {
                attackList.add(i, AttackTypes.TAIL_WHIP);
            }
        }
        pokemon = new Pokemon(name, type, attackList);
        System.out.println("You have chosen the Pokemon: " + pokemon.type + ", with the name: " + pokemon.name);
        System.out.println("Your Pokemon '" + pokemon.name + "' can use the following moves:");
        for (int i = 0; i < 3; i++) {
            System.out.println(attacksString[i]);
        }
        System.out.println("Good luck on your adventure!");

    }

    public static void main(String[] args) {
        makePokemon();
    }
}
