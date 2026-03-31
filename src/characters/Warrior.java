package characters;

import equipment.OffensiveEquipment;
import equipment.DefensiveEquipment;

/**
 * Guerrier jouable du jeu Wonderboys.
 * <p>
 * Personnage solide avec 10 PV maximum. Peut s'équiper d'armes physiques
 * (épée, hache, dague). Hérite de {@link Character}.
 * </p>
 *
 * @author Romain D
 * @version 1.0
 */
public class Warrior extends Character {

    /**
     * Crée un Warrior avec ses attributs et équipements de départ.
     *
     * @param name        nom du guerrier
     * @param lifeLevel   points de vie de départ
     * @param attackLevel niveau d'attaque de départ
     * @param weapon      arme équipée
     * @param defense     bouclier équipé
     */
    public Warrior(String name, int lifeLevel, int attackLevel,
                   OffensiveEquipment weapon, DefensiveEquipment defense) {
        super("Warrior", name, lifeLevel, attackLevel, weapon, defense);
        setMaxLifeLevel(10);
    }

    @Override
    public String toString() {
        return "Warrior : " + getName()
                + " | PV : " + getLifeLevel()
                + " | Attaque : " + getAttackLevel()
                + " | Arme : " + getWeapon()
                + " | Défense : " + getDefense();
    }
}