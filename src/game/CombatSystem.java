package game;

import characters.enemies.Enemy;

public class CombatSystem {

    private Menu menu;
    private Dice d20;
    private Dice d6;

    public CombatSystem(Menu menu) {
        this.menu = menu;
        this.d20 = new Dice(20);
        this.d6  = new Dice(6);
    }

    public void combattre(characters.Character hero, Enemy ennemi) {
        menu.showMessage("\n⚔ Un " + ennemi.getName() + " apparaît !");
        menu.showMessage(ennemi.toString());

        while (hero.getLifeLevel() > 0 && ennemi.getLifeLevel() > 0) {

            menu.askString("Appuie sur Entrée pour attaquer...");

            // Tour du héros
            int jet = d20.roll();
            menu.showMessage("Tu lances le D20 : " + jet);

            if (jet == 1) {
                menu.showMessage("Échec critique ! Tu rates ton attaque.");
            } else if (jet == 20) {
                int degats = hero.getAttackLevel() + 2;
                ennemi.setLifeLevel(ennemi.getLifeLevel() - degats);
                menu.showMessage("Coup critique ! Tu infliges " + degats + " dégâts !");
            } else {
                int degats = hero.getAttackLevel();
                ennemi.setLifeLevel(ennemi.getLifeLevel() - degats);
                menu.showMessage("Tu touches ! Tu infliges " + degats + " dégâts.");
            }

            menu.showMessage(ennemi.getName() + " PV restants : " + Math.max(ennemi.getLifeLevel(), 0));

            if (ennemi.getLifeLevel() <= 0) {
                menu.showMessage("Tu as vaincu le " + ennemi.getName() + " !");
                return;
            }

            // Tour de l'ennemi
            int degatsEnnemi = Math.max(0, ennemi.getAttackLevel() - hero.getDefense().getDefenseLevel());
            hero.setLifeLevel(hero.getLifeLevel() - degatsEnnemi);
            menu.showMessage(ennemi.getName() + " t'attaque et inflige " + degatsEnnemi + " dégâts.");
            menu.showMessage(hero.getName() + " PV restants : " + Math.max(hero.getLifeLevel(), 0));

            if (hero.getLifeLevel() <= 0) {
                menu.showMessage("Tu as été vaincu par le " + ennemi.getName() + "...");
                menu.showMessage("GAME OVER !");
                return;
            }
        }
    }
}