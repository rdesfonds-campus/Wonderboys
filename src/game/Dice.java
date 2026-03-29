package game;

public class Dice {

    private int sides; // nombre de faces du dé

    public Dice(int sides) {
        this.sides = sides;
    }

    // Lance le dé et retourne un résultat entre 1 et sides
    public int roll() {
        return (int)(Math.random() * sides) + 1;
    }

    public int getSides() {
        return sides;
    }

    @Override
    public String toString() {
        return "Dé à " + sides + " faces";
    }
}