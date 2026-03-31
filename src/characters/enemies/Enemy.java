package characters.enemies;

/**
 * Classe abstraite représentant un ennemi du jeu Wonderboys.
 * <p>
 * Hérite de {@link characters.Character} avec un type d'ennemi.
 * Ajoute la notion de valeur de score gagnée en vainquant l'ennemi.
 * Les sous-classes ({@link Goblin}, {@link Orc}, {@link Dragon})
 * définissent leurs propres statistiques et valeur de score.
 * </p>
 *
 * @author Romain D
 * @version 1.0
 */
public abstract class Enemy extends characters.Character {

    /** Points de score gagnés par le joueur en vainquant cet ennemi. */
    private int scoreValue;

    /**
     * Crée un ennemi avec ses caractéristiques de combat.
     *
     * @param type        type de l'ennemi (ex : "Goblin")
     * @param name        nom affiché dans le jeu
     * @param lifeLevel   points de vie de départ
     * @param attackLevel niveau d'attaque
     * @param weapon      arme équipée
     * @param defense     défense équipée
     */
    public Enemy(String type, String name, int lifeLevel, int attackLevel,
                 equipment.OffensiveEquipment weapon, equipment.DefensiveEquipment defense) {
        super(type, name, lifeLevel, attackLevel, weapon, defense);
    }

    /**
     * Retourne la valeur en points de score de cet ennemi.
     *
     * @return points gagnés en le vainquant
     */
    public int getScoreValue()           { return scoreValue; }

    /**
     * Définit la valeur en points de score de cet ennemi.
     *
     * @param score points à attribuer au joueur en cas de victoire
     */
    public void setScoreValue(int score) { this.scoreValue = score; }
}