package equipment;

/**
 * Équipement défensif du personnage (bouclier ou potion).
 * <p>
 * Caractérisé par un type ("Shield" ou "Potion"), un niveau de défense
 * et un nom. Le niveau de défense réduit les dégâts reçus en combat.
 * </p>
 *
 * @author Romain D
 * @version 1.0
 */
public class DefensiveEquipment {

    /** Type de l'équipement : "Shield" (bouclier) ou "Potion". */
    private String type;

    /** Niveau de défense : réduit les dégâts reçus. */
    private int defenseLevel;

    /** Nom de l'équipement affiché dans le jeu. */
    private String name;

    /**
     * Crée un équipement défensif.
     *
     * @param type         "Shield" ou "Potion"
     * @param defenseLevel niveau de défense
     * @param name         nom affiché
     */
    public DefensiveEquipment(String type, int defenseLevel, String name) {
        this.type = type;
        this.defenseLevel = defenseLevel;
        this.name = name;
    }

    /** @return le type de l'équipement */
    public String getType()       { return type; }

    /** @return le niveau de défense */
    public int getDefenseLevel()  { return defenseLevel; }

    /** @return le nom de l'équipement */
    public String getName()       { return name; }

    /** @param type nouveau type */
    public void setType(String type)              { this.type = type; }

    /** @param defenseLevel nouveau niveau de défense */
    public void setDefenseLevel(int defenseLevel) { this.defenseLevel = defenseLevel; }

    /** @param name nouveau nom */
    public void setName(String name)              { this.name = name; }

    @Override
    public String toString() {
        return type + " : " + name + " (Défense : " + defenseLevel + ")";
    }
}
