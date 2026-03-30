package game;

import characters.enemies.Goblin;
import characters.enemies.Orc;
import characters.enemies.Dragon;
import characters.enemies.Enemy;

public class EnemyCell extends Cell {

    private Enemy ennemi;

    public EnemyCell() {
        int tirage = (int)(Math.random() * 3);
        switch (tirage) {
            case 0:  this.ennemi = new Goblin(); break;
            case 1:  this.ennemi = new Orc();    break;
            default: this.ennemi = new Dragon(); break;
        }
    }

    @Override
    public void interact(characters.Character hero) {
        CombatSystem combat = new CombatSystem(new Menu());
        combat.combattre(hero, ennemi);
    }

    @Override
    public String toString() {
        return "Case ennemi (" + ennemi.getName() + ")";
    }
}