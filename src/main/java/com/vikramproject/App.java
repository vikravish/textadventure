package com.vikramproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
// import java.util.random.RandomGenerator;

/**
 * Hello world!
 *
 */

public class App {
    public static Player player = null;

    public static void startPokemon() {
        System.out.println("Welcome to your new adventure!");
        System.out.println("What is your name?");
        Scanner scanner = new Scanner(System.in);
        String playerName = scanner.nextLine();
        System.out.println("Choose your Pokemon: Snivy, Charmander, Squirtle");
        String writtenPokemon = scanner.nextLine().trim();
        PlayerPokemon firstPokemon = null;
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
        List<AttackTypes> attackList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String rawChosenAttack = rawChosenAttacks[i];
            Pokemon.allAttackTypesWithName.forEach((attackName, attackType) -> {
                if (rawChosenAttack.equals(attackName))
                    attackList.add(attackType);
            });
        }
        firstPokemon = new PlayerPokemon(name, type, attackList, 1, false);
        System.out
                .println("You have chosen the Pokemon: " + firstPokemon.type + ", with the name: " + firstPokemon.name);
        System.out.println("Your Pokemon '" + firstPokemon.name + "' can use the following moves:");
        for (int i = 0; i < 3; i++) {
            System.out.println(rawChosenAttacks[i]);
        }
        ArrayList<PlayerPokemon> pokedex = new ArrayList<PlayerPokemon>();
        // player = new Player(name, 1, 0, null, 0, null);
        System.out.println("Good luck on your adventure!");

    }

    // TODO
    // 1. Get the element type for each pokemon (would have to add this to the
    // Pokemon class)
    // 2. Get the stats and information from the player and the opponent
    // 3. Create the text interface and dialogue
    // 4. Make a system for taking away or adding health to each Pokemon
    // 5. Make a system for leveling up/adding exp
    public static void battle() {
        // Create random Pokemon
        Pokemon randomPokemon = new Pokemon(PokemonType.SNIVY, List.of(AttackTypes.VINE_WHIP, AttackTypes.PUNCH),
                0);
        // Retrieve element type for every Pokemon
        String playerPokemonElement = "water";
        String randomPokemonElement = "grass";
        // Launch dialogue (Fight or run)
        System.out.println("A wild Pokemon has appeared! Fight or run?");
        Scanner scanner = new Scanner(System.in);
        String decision = scanner.nextLine();
        if (decision == "fight") {
            fight(randomPokemon);
        } else {
            run(randomPokemon);
        }
        // Fight sequence (Random roll to who goes first)
        String firstMove = "Player";
        // Give rewards
    }

    public static void fight(Pokemon randomPokemon) {
        double roll = Math.random();
        String firstMove;
        String secondMove;

        if (roll > 0.4) {
            firstMove = "Player"; // 60% chance that the player goes first
        } else {
            randomPokemonAttack(randomPokemon);

        }
        System.out.println("What move will " + player.getCurrentPokemon() + " use?");
        for (int i = 0; i < player.getCurrentPokemon().attackSlots.size(); i++) {
            if (i < player.getCurrentPokemon().attackSlots.size() - 1) {
                System.out.print(player.getCurrentPokemon().attackSlots.get(i) + ", ");
            } else {
                System.out.print(player.getCurrentPokemon().attackSlots.get(i));
            }
        }
        Scanner scanner = new Scanner(System.in);
        String currentAttack = scanner.nextLine();
        if (Pokemon.allAttackTypesWithName.containsKey(currentAttack)) {
            // use(currentAttack);
        } else {
            System.out.println("Please input a valid attack.");
            currentAttack = scanner.nextLine();
        }
    }

    public static void run(Pokemon randomPokemon) {
        if (randomPokemon.random == false) {
            System.out.println("You cannot run from this battle.");
        } else {
            System.out.println("Successfully got away.");
        }
    }

    /**
     * TODO: `use` is missing receiver
     * 
     * @param randomPokemon
     */
    public static void randomPokemonAttack(Pokemon randomPokemon) {
        double roll = Math.random();
        // if (roll > 0.67) {
        //     use(randomPokemon.attackSlots.get(0), null);
        // } else if (roll > 0.33) {
        //     use(randomPokemon.attackSlots.get(1), null);
        // } else {
        //     use(randomPokemon.attackSlots.get(2), null);
        // }
    }

    // public static void main(String[] args) {
    //     startPokemon();
    //     battle();
    // }

}
