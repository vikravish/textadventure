package com.vikramproject.refactor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 
 */
public class App {
    private static Player player = null;
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * @param args
     */
    public static void main(String[] args) {
        introduction();
        encounter();
    }

    /**
     * Introduces characters and gives information to players about their first play
     * session.
     */
    private static void introduction() {
        System.out.println("Welcome to your new adventure!");

        // Prompt to create player, including pokedex.
        player = promptCreatePlayer(1);

        System.out.println("Good luck on your adventure!");
    }

    /**
     * Everything that happens within an encounter.
     */
    private static void encounter() {
        // Temporarily create random NPC and Pokemon.
        Pokemon randomPokemon = new Pokemon();
        randomPokemon.type = Pokemon.Type.SNIVY;
        randomPokemon.attacks = List.of(Pokemon.Type.Attack.VINE_WHIP, Pokemon.Type.Attack.PUNCH);
        @SuppressWarnings("unused")
        String randomPokemonElement = "grass";
        Npc npc = new Npc();
        npc.inventory.add(randomPokemon);

        // Retrieve element type for every Pokemon
        @SuppressWarnings("unused")
        String playerPokemonElement = "water";

        // Launch dialogue (Fight or run)
        System.out.println("A wild Pokemon has appeared! fight or run?");
        String decision = scanner.nextLine();

        List<Character> characters = List.of(player, npc);
        int currentCharacterIndex = -1;

        // Force all characters to use their first pokemon.
        for (Character character : characters)
            character.setCurrentPokemon(0);

        // Start loop.
        double roll = 0;
        while (characters.size() == 2) {
            roll = Math.random();

            switch (decision) {
                case "fight" -> {
                    // Skip turn.
                    if (roll <= 0.4)
                        continue;

                    currentCharacterIndex = (currentCharacterIndex + 1) % characters.size();
                    Character currentCharacter = characters.get(currentCharacterIndex);
                    Pokemon currentPokemon = currentCharacter.getCurrentPokemon().get();

                    // Choose attack.
                    if (currentCharacter == player) {
                        // If player.
                        String allPossibleAttacks_pretty = currentPokemon.attacks
                                .stream()
                                .map(Pokemon.Type.Attack::getName)
                                .collect(Collectors.joining(", "));
                        System.out.println(
                                "What move will " + player.getCurrentPokemon() + " use? " + allPossibleAttacks_pretty);
                        String inputAttack = scanner.nextLine();

                        Optional<Pokemon.Type.Attack> optionalAttack = Pokemon.Type.Attack.fromString(inputAttack);

                        if (optionalAttack.isEmpty()) {
                            System.out.println("Please input a valid attack.");
                            System.exit(1);
                        }
                    } else {
                        // If NPC.
                        // Choose random attack.
                        // TODO: Explain why this works.
                        int randomPokemonAttackIndex = (int) Math.floor(roll * currentPokemon.attacks.size());
                        @SuppressWarnings("unused")
                        Pokemon.Type.Attack randomPokemonAttack = currentPokemon.attacks.get(randomPokemonAttackIndex);
                    }

                    // Apply attack.
                    for (Character character : characters) {
                        // For all _other_ characters.
                        if (character != currentCharacter) {
                            // Attack other all other characters.
                            character.hp -= 10;
                        }
                    }
                }
                case "run" -> {
                    var anyCharacterHasARandomPokemon = characters.stream().anyMatch(character -> character.getCurrentPokemon().get().isRandom == false);
                    if (anyCharacterHasARandomPokemon) {
                        System.out.println("You cannot run from this battle.");
                    } else {
                        System.out.println("Successfully got away.");
                    }
                }
            }
        }

        // if (decision == "fight") {
        // fight(randomPokemon);
        // } else {
        // run(randomPokemon);
        // }
        // // Fight sequence (Random roll to who goes first)
        // String firstMove = "Player";
        // // Give rewards
    }

    /**
     * Overload with default arguments.
     * 
     * @return
     */
    @SuppressWarnings("unused")
    private static Player promptCreatePlayer() {
        return promptCreatePlayer(-1);
    }

    /**
     * TODO: More than one pokemon.
     * 
     * @param promptPokemon defaults to -1, meaning don't prompt. If value is
     *                      greater than 1, then will prompt per pokemon.
     * @return
     */
    private static Player promptCreatePlayer(int promptPokemon) {
        // Will be returned at the end.
        Player player = new Player();
        player.level = 1;
        player.currentPokemonIndex = Optional.empty();

        // Choose player name.
        System.out.print("What is your name? ");
        String inputName = scanner.nextLine().trim();
        System.out.println("Hi " + inputName + "!");
        // Set name.
        player.name = inputName;

        if (promptPokemon != -1) {
            // Choose pokemon.
            Pokemon pokemon = promptCreatePokemon();
            // Add pokemon.
            player.inventory.add(pokemon);
        }

        return player;
    }

    /**
     * TODO: Move to Pokemon class as `promptCreate`.
     * 
     * @return
     */
    private static Pokemon promptCreatePokemon() {
        // Will be returned at the end.
        Pokemon pokemon = new Pokemon();
        pokemon.level = 1;
        pokemon.isRandom = false;

        // Choose pokemon type.
        // https://stackoverflow.com/a/23183963/14238358
        String allTypes_pretty = Pokemon.Type.valuesList()
                .stream()
                // .map((Pokemon.Type value) -> { return value.getName(); })
                // .map(value -> value.getName())
                .map(Pokemon.Type::getName)
                .collect(Collectors.joining(", "));
        System.out.println("Choose your Pokemon: " + allTypes_pretty);
        String inputType = scanner.nextLine().trim();
        boolean isValidType = Pokemon.Type.valuesList()
                .stream()
                .anyMatch(type -> type.getName().equals(inputType));
        if (isValidType) {
            // Set type.
            pokemon.type = Pokemon.Type.fromString(inputType).get();
        } else {
            // TODO: Keep asking user until valid.
            // Invalid.
            System.out.println("Please choose a valid Pokemon");
            System.exit(1);
        }

        // Choose pokemon name.
        System.out.print("Please name your Pokemon: ");
        String inputName = scanner.nextLine().trim();
        System.out.println("Your pokemon " + inputType + " is named " + inputName);
        // Set name.
        pokemon.name = inputName;

        // Choose 3 pokemon attacks
        System.out
                .println("Choose three attacks: (Note: Elemental attacks may be disadvantaged against other Pokemon)");
        List<String> inputAttacks = new ArrayList<>();
        for (@SuppressWarnings("unused") int index : IntStream.rangeClosed(1, 3).toArray()) {
            String availableAttacks_pretty = pokemon.type.getAttacks()
                    .stream()
                    .map(Pokemon.Type.Attack::getName)
                    .collect(Collectors.joining(", "));

            System.out.print("Please choose one of the following attacks: " + availableAttacks_pretty);
            String inputAttack = scanner.nextLine().trim();
            boolean isValidAttack = pokemon.type.getAttacks()
                    .stream()
                    .anyMatch(attack -> attack.getName().equals(inputAttack));
            if (isValidAttack) {
                inputAttacks.add(inputAttack);
            } else {
                // TODO: Keep asking user until valid.
                // Invalid.
                System.out.println("Please choose a valid Pokemon attack");
                System.exit(1);
            }
        }
        List<Pokemon.Type.Attack> attacks = inputAttacks
                .stream()
                // .map(inputAttack -> Pokemon.Type.Attack.fromString(inputAttack))
                .map(Pokemon.Type.Attack::fromString)
                .map(Optional::get)
                .collect(Collectors.toList());
        // Set attacks.
        pokemon.attacks = attacks;

        // Print information for user.
        String attacks_pretty = pokemon.type.getAttacks()
                .stream()
                .map(Pokemon.Type.Attack::getName)
                .collect(Collectors.joining(", "));
        System.out.println("You have chosen the Pokemon: " + pokemon.type + ", with the name: " + pokemon.name);
        System.out.println("Your Pokemon \"" + pokemon.name + "\" can use the following moves: " + attacks_pretty);

        return pokemon;
    }

    // Utils

    public static void debug(Exception runtimeException) {
        debug(runtimeException.toString());
    }

    /**
     * 
     * @param string
     */
    public static void debug(String string) {
        System.out.println("-".repeat(10));
        System.out.println(string);
        System.out.println("-".repeat(10));
    }

    /**
     * We could make our own `mkString` function, but streams help us out a lot, so
     * there's no need: https://stackoverflow.com/a/23183963/14238358
     * 
     * @param List
     * @param between
     * @return
     */
    @SuppressWarnings("unused")
    private static String mkString(List<String> List, String between) {
        String result = "";
        for (int i = 0; i < List.size(); i += 1) {
            String item = List.get(i);
            int lastIndex = List.size() - 1;

            if (i != lastIndex)
                item += ", ";
            result += item;
        }
        return result;
    }
}
