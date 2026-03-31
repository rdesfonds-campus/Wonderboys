package equipment;

/**
 * Équipement offensif du personnage (arme ou sort).
 * <p>
 * Caractérisé par un type ("Weapon" ou "Spell"), un niveau d'attaque
 * et un nom. Equippé sur les personnages et les ennemis.
 * </p>
 *
 * @author Romain D
 * @version 1.0
 */
public class OffensiveEquipment {

    /** Type de l'équipement : "Weapon" (arme) ou "Spell" (sort). */
    private String type;

    /** Niveau d'attaque de l'équipement. */
    private int attackLevel;

    /** Nom de l'équipement affiché dans le jeu. */
    private String name;

    /**
     * Crée un équipement offensif.
     *
     * @param type        "Weapon" ou "Spell"
     * @param attackLevel niveau d'attaque
     * @param name        nom affiché
     */
    public OffensiveEquipment(String type, int attackLevel, String name) {
        this.type = type;
        this.attackLevel = attackLevel;
        this.name = name;
    }

    /** @return le type de l'équipement */
    public String getType()       { return type; }

    /** @return le niveau d'attaque */
    public int getAttackLevel()   { return attackLevel; }

    /** @return le nom de l'équipement */
    public String getName()       { return name; }

    /** @param type nouveau type */
    public void setType(String type)            { this.type = type; }

    /** @param attackLevel nouveau niveau d'attaque */
    public void setAttackLevel(int attackLevel) { this.attackLevel = attackLevel; }

    /** @param name nouveau nom */
    public void setName(String name)            { this.name = name; }

    @Override
    public String toString() {
        return type + " : " + name + " (Attaque : " + attackLevel + ")";
    }
}