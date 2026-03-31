package characters;

import equipment.OffensiveEquipment;
import equipment.DefensiveEquipment;

/**
 * Magicien jouable du jeu Wonderboys.
 * <p>
 * Personnage plus fragile (6 PV maximum) mais avec une attaque magique élevée.
 * Peut s'équiper de sorts (boule de feu, éclair, rayon de givre).
 * Hérite de {@link Character}.
 * </p>
 *
 * @author Romain D
 * @version 1.0
 */
public class Wizard extends Character {

    /**
     * Crée un Wizard avec ses attributs et sorts de départ.
     *
     * @param name        nom du magicien
     * @param lifeLevel   points de vie de départ (généralement 6)
     * @param attackLevel niveau d'attaque magique de départ
     * @param weapon      sort offensif équipé
     * @param defense     potion équipée
     */
    public Wizard(String name, int lifeLevel, int attackLevel,
                  OffensiveEquipment weapon, DefensiveEquipment defense) {
        super("Wizard", name, lifeLevel, attackLevel, weapon, defense);
        setMaxLifeLevel(6);
    }

    @Override
    public String toString() {
        return "Wizard : " + getName()
                + " | PV : " + getLifeLevel()
                + " | Attaque : " + getAttackLevel()
                + " | Arme : " + getWeapon()
                + " | Défense : " + getDefense();
    }
}