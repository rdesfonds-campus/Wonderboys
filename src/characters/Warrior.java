package characters;

public class Warrior extends Character {

    // Warrior appelle le constructeur de Character avec "Warrior" comme type
    public Warrior(String name, int lifeLevel, int attackLevel) {
        super("Warrior", name, lifeLevel, attackLevel);
    }

    @Override
    public String toString() {
        return "Warrior : " + getName()
                + " | PV : " + getLifeLevel()
                + " | Attaque : " + getAttackLevel();
    }
}