package combat;

import characters.enemies.Enemy;
import game.Menu;

/**
 * Gère les combats au tour par tour entre le héros et un ennemi.
 * <p>
 * Système inspiré du D20 AD&D :
 * le joueur et l'ennemi lancent chacun un dé à 20 faces pour leurs attaques.
 * </p>
 * <ul>
 *   <li>Jet = 1 : échec critique, l'attaque inflige 0 dégâts.</li>
 *   <li>Jet = 20 : réussite critique, +2 dégâts.</li>
 *   <li>Fuite : le héros recule d'1 à 6 cases (dé à 6 faces).</li>
 * </ul>
 *
 * @author Romain D
 * @version 1.0
 */
public class CombatSystem {

    /** Interface de dialogue avec le joueur. */
    private Menu menu;

    /** Dé à 20 faces pour les jets d'attaque. */
    private Dice d20;

    /** Dé à 6 faces pour le recul en cas de fuite. */
    private Dice d6;

    /**
     * Crée le système de combat avec son interface d'affichage.
     *
     * @param menu interface de saisie et d'affichage
     */
    public CombatSystem(Menu menu) {
        this.menu = menu;
        this.d20 = new Dice(20);
        this.d6  = new Dice(6);
    }

    /**
     * Lance un combat complet entre le héros et un ennemi.
     * <p>
     * Le joueur choisit à chaque tour d'attaquer (1) ou de fuir (2).
     * Les deux combattants lancent un D20 avant chaque attaque :
     * </p>
     * <ul>
     *   <li>Jet = 1 : échec critique, 0 dégâts.</li>
     *   <li>Jet = 20 : réussite critique, +2 dégâts.</li>
     *   <li>Autre : dégâts normaux.</li>
     * </ul>
     * <p>
     * Les dégâts reçus par le héros sont réduits par son niveau de défense.
     * </p>
     *
     * @param hero   personnage du joueur
     * @param ennemi ennemi rencontré sur la case
     * @return {@link CombatResult} indiquant l'issue du combat
     */

    public CombatResult combattre(characters.Character hero, Enemy ennemi) {
        menu.showMessage("\n⚔ Un " + ennemi.getName() + " apparaît !");
        menu.showMessage(ennemi.toString());

        while (hero.getLifeLevel() > 0 && ennemi.getLifeLevel() > 0) {

            menu.showMessage("1 - Attaquer");
            menu.showMessage("2 - Fuir");
            int choix = menu.askInt("Ton choix :");

            if (choix == 2) {
                int recul = d6.roll();
                menu.showMessage("Tu fuis ! Tu recules de " + recul + " cases.");
                return new CombatResult(CombatResult.Issue.FUITE, recul);
            }

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
                hero.setScore(hero.getScore() + ennemi.getScoreValue());
                menu.showMessage("Tu gagnes " + ennemi.getScoreValue() + " points ! Score : " + hero.getScore());
                return new CombatResult(CombatResult.Issue.VICTOIRE, 0);
            }

            // Tour de l'ennemi - jet D20
            int jetEnnemi = d20.roll();
            menu.showMessage(ennemi.getName() + " lance le D20 : " + jetEnnemi);

            if (jetEnnemi == 1) {
                menu.showMessage(ennemi.getName() + " rate son attaque ! Échec critique !");
            } else {
                int degatsEnnemi = Math.max(0, ennemi.getAttackLevel() - hero.getDefense().getDefenseLevel());
                if (jetEnnemi == 20) {
                    degatsEnnemi += 2;
                    menu.showMessage(ennemi.getName() + " coup critique ! +2 dégâts !");
                }
                hero.setLifeLevel(hero.getLifeLevel() - degatsEnnemi);
                menu.showMessage(ennemi.getName() + " t'attaque et inflige " + degatsEnnemi + " dégâts.");
                menu.showMessage(hero.getName() + " PV restants : " + Math.max(hero.getLifeLevel(), 0));
            }
        }

        return new CombatResult(CombatResult.Issue.DEFAITE, 0);
    }
}
