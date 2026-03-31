package characters;

import equipment.DefensiveEquipment;
import equipment.OffensiveEquipment;

/**
 * Classe abstraite représentant un personnage du jeu Wonderboys.
 * <p>
 * Contient tous les attributs communs aux personnages jouables et aux ennemis :
 * identité, points de vie, niveau d'attaque, équipements, score et identifiant BDD.
 * Les classes concrètes {@link Warrior} et {@link Wizard} en héritent,
 * ainsi que la hiérarchie des ennemis.
 * </p>
 *
 * @author Romain D
 * @version 1.0
 */
public abstract class Character {

    /** Type du personnage : "Warrior", "Wizard" ou type d'ennemi. */
    private String type;

    /** Nom du personnage choisi par le joueur. */
    private String name;

    /** Points de vie actuels. */
    private int lifeLevel;

    /** Niveau d'attaque de base. */
    private int attackLevel;

    /** Arme ou sort équipé (peut être null). */
    private OffensiveEquipment weapon;

    /** Bouclier ou potion équipé (peut être null). */
    private DefensiveEquipment defense;

    /** Identifiant en base de données (0 si non sauvegardé). */
    private int id;

    /** Score total accumulé pendant la partie. */
    private int score;

    /** Points de vie maximum. Initialisé à 10 par défaut. */
    private int maxLifeLevel = 10;

    /**
     * Crée un nouveau personnage avec ses attributs de départ.
     *
     * @param type        type du personnage ("Warrior", "Wizard"...)
     * @param name        nom du personnage
     * @param lifeLevel   points de vie de départ
     * @param attackLevel niveau d'attaque de départ
     * @param weapon      équipement offensif équipé (peut être null)
     * @param defense     équipement défensif équipé (peut être null)
     */
    public Character(String type, String name, int lifeLevel, int attackLevel,
                     OffensiveEquipment weapon, DefensiveEquipment defense) {
        this.type = type;
        this.name = name;
        this.lifeLevel = lifeLevel;
        this.attackLevel = attackLevel;
        this.weapon = weapon;
        this.defense = defense;
    }

    // ── Getters ──────────────────────────────────────────────────

    /** @return le type du personnage */
    public String getType()      { return type; }

    /** @return le nom du personnage */
    public String getName()      { return name; }

    /** @return les points de vie actuels */
    public int getLifeLevel()    { return lifeLevel; }

    /** @return le niveau d'attaque */
    public int getAttackLevel()  { return attackLevel; }

    /** @return l'équipement offensif équipé */
    public OffensiveEquipment getWeapon()  { return weapon; }

    /** @return l'équipement défensif équipé */
    public DefensiveEquipment getDefense() { return defense; }

    /** @return l'identifiant en base de données */
    public int getId()           { return id; }

    /** @return le score total */
    public int getScore()        { return score; }

    /** @return les points de vie maximum */
    public int getMaxLifeLevel() { return maxLifeLevel; }

    // ── Setters ──────────────────────────────────────────────────

    /** @param name nouveau nom du personnage */
    public void setName(String name)             { this.name = name; }

    /** @param lifeLevel nouveaux points de vie */
    public void setLifeLevel(int lifeLevel)      { this.lifeLevel = lifeLevel; }

    /** @param attackLevel nouveau niveau d'attaque */
    public void setAttackLevel(int attackLevel)  { this.attackLevel = attackLevel; }

    /** @param weapon nouvel équipement offensif */
    public void setWeapon(OffensiveEquipment weapon)   { this.weapon = weapon; }

    /** @param defense nouvel équipement défensif */
    public void setDefense(DefensiveEquipment defense) { this.defense = defense; }

    /** @param id identifiant de la base de données */
    public void setId(int id)                    { this.id = id; }

    /** @param score nouveau score total */
    public void setScore(int score)              { this.score = score; }

    /** @param max nouveaux points de vie maximum */
    public void setMaxLifeLevel(int max)         { this.maxLifeLevel = max; }

    /**
     * Retourne une représentation textuelle du personnage.
     *
     * @return chaîne formatée avec type, nom, PV, attaque, arme et défense
     */
    @Override
    public String toString() {
        return type + " : " + name
                + " | PV : " + lifeLevel
                + " | Attaque : " + attackLevel
                + " | Arme : " + weapon
                + " | Défense : " + defense;
    }
}
