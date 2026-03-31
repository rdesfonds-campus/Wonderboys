package combat;

/**
 * Représente un dé à N faces.
 * <p>
 * Utilisé pour les déplacements (6 faces) et les jets de combat (20 faces).
 * Le résultat est aléatoire entre 1 et le nombre de faces inclus.
 * </p>
 *
 * @author Romain D
 * @version 1.0
 */
public class Dice {

    /** Nombre de faces du dé. */
    private int sides;

    /**
     * Crée un dé avec le nombre de faces souhaité.
     *
     * @param sides nombre de faces (ex : 6 pour déplacement, 20 pour combat)
     */
    public Dice(int sides) {
        this.sides = sides;
    }

    /**
     * Lance le dé et retourne un résultat aléatoire.
     *
     * @return entier aléatoire entre 1 et {@code sides} inclus
     */
    public int roll() {
        return (int)(Math.random() * sides) + 1;
    }

    /**
     * Retourne le nombre de faces du dé.
     *
     * @return nombre de faces
     */
    public int getSides() {
        return sides;
    }

    @Override
    public String toString() {
        return "Dé à " + sides + " faces";
    }
}