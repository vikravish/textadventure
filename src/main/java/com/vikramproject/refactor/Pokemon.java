package com.vikramproject.refactor;

import java.util.List;
import java.util.Optional;
import java.util.Arrays;

public class Pokemon {
    public static enum Type {
        SNIVY("Snivy", Attack.VINE_WHIP, Attack.SEED_BOMB, Attack.PUNCH, Attack.TAIL_WHIP),
        CHARMANDER("Charmander", Attack.EMBER, Attack.FLAMETHROWER, Attack.PUNCH, Attack.TAIL_WHIP),
        SQUIRTLE("Squirtle", Attack.AQUA_JET, Attack.WATER_PULSE, Attack.PUNCH, Attack.TAIL_WHIP);

        public static enum Attack {
            VINE_WHIP("Vine Whip"),
            SEED_BOMB("Seed Bomb"),
            PUNCH("Punch"),
            EMBER("Ember"),
            FLAMETHROWER("Flamethrower"),
            TAIL_WHIP("Tail Whip"),
            AQUA_JET("Aqua Jet"),
            WATER_PULSE("Water Pulse");

            private String name;

            private Attack(String name) {
                this.name = name;
            }

            public String getName() {
                return this.name;
            }

            public static Optional<Attack> fromString(String name) {
                for (Attack attack : Attack.values()) {
                    if (attack.getName().equals(name)) {
                        return Optional.of(attack);
                    }
                }
                return Optional.empty();
            }

            public static List<Attack> List() {
                return Arrays.asList(Attack.values());
            }
        }

        private String name;
        private List<Attack> attacks;

        private Type(String name, Attack... attacks) {
            this.name = name;
            this.attacks = Arrays.asList(attacks);
        }

        public String getName() {
            return this.name;
        }

        public List<Pokemon.Type.Attack> getAttacks() {
            return this.attacks;
        }

        public static Optional<Type> fromString(String name) {
            for (Type type : Type.values()) {
                if (type.getName().equals(name)) {
                    return Optional.of(type);
                }
            }
            return Optional.empty();
        }

        public static List<Type> valuesList() {
            return Arrays.asList(Type.values());
        }
    }

    String name;
    Pokemon.Type type;
    List<Pokemon.Type.Attack> attacks;
    int level;
    boolean isRandom;
}
