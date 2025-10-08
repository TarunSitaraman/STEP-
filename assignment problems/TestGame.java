class Game {
    private String name;
    private int players;

    public Game(String name, int players) {
        this.name = name;
        this.players = players;
    }

    @Override
    public String toString() {
        return "Game{name='" + name + "', players=" + players + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Game other = (Game) obj;
        return players == other.players && name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return 31 * name.hashCode() + players;
    }
}

class CardGame extends Game {
    private String deckType;

    public CardGame(String name, int players, String deckType) {
        super(name, players);
        this.deckType = deckType;
    }

    @Override
    public String toString() {
        return super.toString() + ", deckType='" + deckType + "'";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        CardGame other = (CardGame) obj;
        return deckType.equals(other.deckType);
    }

    @Override
    public int hashCode() {
        return super.hashCode() * 31 + deckType.hashCode();
    }
}

public class TestGame {
    public static void main(String[] args) {
        Game g1 = new Game("Chess", 2);
        Game g2 = new Game("Chess", 2);
        CardGame c1 = new CardGame("Poker", 4, "Standard");
        CardGame c2 = new CardGame("Poker", 4, "Standard");
        CardGame c3 = new CardGame("Poker", 4, "Custom");

        System.out.println(g1); // Game{name='Chess', players=2}
        System.out.println(c1); // Game{name='Poker', players=4}, deckType='Standard'

        System.out.println(g1.equals(g2));   // true
        System.out.println(c1.equals(c2));   // true
        System.out.println(c1.equals(c3));   // false
        System.out.println(g1.equals(c1));   // false

        System.out.println(g1.hashCode());   // consistent for same data
        System.out.println(c1.hashCode());   // consistent for same data
        System.out.println(c3.hashCode());   // different deckType, different hash
    }
}
