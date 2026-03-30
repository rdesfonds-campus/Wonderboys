package characters.enemies;

import equipment.DefensiveEquipment;
import equipment.OffensiveEquipment;

public abstract class Enemy extends characters.Character {

    public Enemy(String type, String name, int lifeLevel, int attackLevel,
                 OffensiveEquipment weapon, DefensiveEquipment defense) {
        super(type, name, lifeLevel, attackLevel, weapon, defense);
    }
}