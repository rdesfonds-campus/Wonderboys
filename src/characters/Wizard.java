package characters;

public class Wizard extends Character {

    public Wizard(String name, int lifeLevel, int attackLevel) {
        super("Wizard", name, lifeLevel, attackLevel);
    }

    @Override
    public String toString() {
        return "Wizard : " + getName()
                + " | PV : " + getLifeLevel()
                + " | Attaque : " + getAttackLevel();
    }
}