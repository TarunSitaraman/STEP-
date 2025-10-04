abstract class Character {
    String name;
    Character(String name) {
        this.name = name;
    }
    abstract void attack();
}

class Warrior extends Character {
    Warrior(String name) { super(name); }
    @Override
    void attack() {
        System.out.println(name + " swings sword! High defense active.");
    }
}

class Mage extends Character {
    int mana = 100;
    Mage(String name) { super(name); }
    @Override
    void attack() {
        if (mana >= 20) {
            mana -= 20;
            System.out.println(name + " casts Fireball! Mana left: " + mana);
        } else {
            System.out.println(name + " tries to cast a spell, but not enough mana!");
        }
    }
}

class Archer extends Character {
    int arrows = 6;
    Archer(String name) { super(name); }
    @Override
    void attack() {
        if (arrows > 0) {
            arrows--;
            System.out.println(name + " shoots an arrow! Arrows left: " + arrows);
        } else {
            System.out.println(name + " has no arrows!");
        }
    }
}

public class BattleSystem {
    public static void main(String[] args) {
        Character[] army = {
            new Warrior("Ragna"), new Mage("Lyra"), new Archer("Ivor"),
            new Warrior("Mira"), new Mage("Zane"), new Archer("Dana")
        };
        for (Character c : army) {
            c.attack();
        }
    }
}
