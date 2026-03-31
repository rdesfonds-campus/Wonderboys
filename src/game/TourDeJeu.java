package game;

import board.Board;
import board.Cell;
import board.EnemyCell;
import combat.CombatResult;
import combat.Dice;
import combat.ResultatTour;

/**
 * Gère le déroulement d'un tour de jeu sur le plateau.
 * <p>
 * Responsable du calcul de la nouvelle position, de la vérification
 * des limites du plateau, de l'interaction avec la case atteinte
 * et de la gestion des résultats de combat.
 * Soulage {@link Game} de toute la logique de déplacement.
 * </p>
 *
 * @author Romain D
 * @version 1.0
 */
public class TourDeJeu {

    /** Interface de dialogue avec le joueur. */
    private final Menu menu;

    /** Plateau de jeu. */
    private final Board plateau;

    /** Dé à 6 faces pour les déplacements. */
    private final Dice de;

    /**
     * Crée un gestionnaire de tour de jeu.
     *
     * @param menu    interface de saisie et d'affichage
     * @param plateau plateau de 64 cases
     * @param de      dé à 6 faces
     */
    public TourDeJeu(Menu menu, Board plateau, Dice de) {
        this.menu    = menu;
        this.plateau = plateau;
        this.de      = de;
    }

    /**
     * Joue un tour complet : lance le dé, déplace le personnage,
     * résout la case atteinte et retourne l'état de la partie.
     * <p>
     * Gère les cas suivants :
     * <ul>
     *   <li>Dépassement du plateau → {@link EtatPartie#HORS_PLATEAU}</li>
     *   <li>Case 64 atteinte exactement → {@link EtatPartie#VICTOIRE}</li>
     *   <li>Combat perdu → {@link EtatPartie#DEFAITE}</li>
     *   <li>Fuite → recule le personnage, retourne {@link EtatPartie#EN_COURS}</li>
     *   <li>Sinon → {@link EtatPartie#EN_COURS}</li>
     * </ul>
     * </p>
     *
     * @param hero     personnage du joueur
     * @param position position actuelle du joueur
     * @return résultat du tour contenant le nouvel état et la nouvelle position
     */
    public ResultatTour jouer(characters.Character hero, int position) {

        int lancer = de.roll();
        int nouvellePosition = position + lancer;
        menu.showMessage("Tu lances le dé : " + lancer);

        // Dépassement du plateau
        if (nouvellePosition > plateau.getTotalCases()) {
            menu.showMessage("Tu es allé trop vite et tu as raté le trésor, dommage !");
            return new ResultatTour(EtatPartie.HORS_PLATEAU, position);
        }

        // Victoire exacte
        if (nouvellePosition == plateau.getTotalCases()) {
            hero.setScore(hero.getScore() + 1000);
            menu.showMessage("Tu tombes pile sur la case 64 - Salle du trésor !");
            menu.showMessage("BRAVO ! Tu as trouvé le trésor ! +1000 points !");
            menu.showMessage("Score final : " + hero.getScore());
            return new ResultatTour(EtatPartie.VICTOIRE, nouvellePosition);
        }

        // Déplacement normal
        menu.showMessage("Tu avances à la case " + nouvellePosition + " / " + plateau.getTotalCases());

        Cell caseActuelle = plateau.getCase(nouvellePosition);
        menu.showMessage("Tu es sur : " + caseActuelle);
        caseActuelle.interact(hero);

        // Résolution d'un combat
        if (caseActuelle instanceof EnemyCell) {
            CombatResult resultat = ((EnemyCell) caseActuelle).getDernierResultat();

            if (resultat.getIssue() == CombatResult.Issue.DEFAITE) {
                return new ResultatTour(EtatPartie.DEFAITE, nouvellePosition);
            }

            if (resultat.getIssue() == CombatResult.Issue.FUITE) {
                int positionApresFuite = Math.max(1, nouvellePosition - resultat.getReculFuite());
                menu.showMessage("Tu recules à la case " + positionApresFuite + ".");
                return new ResultatTour(EtatPartie.EN_COURS, positionApresFuite);
            }
        }

        // Vérification mort hors combat
        if (hero.getLifeLevel() <= 0) {
            return new ResultatTour(EtatPartie.DEFAITE, nouvellePosition);
        }

        return new ResultatTour(EtatPartie.EN_COURS, nouvellePosition);
    }
}