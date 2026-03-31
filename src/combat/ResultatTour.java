package combat;

import game.EtatPartie;

/**
 * Résultat d'un tour de jeu.
 * <p>
 * Encapsule l'état de la partie après le tour
 * et la nouvelle position du joueur sur le plateau.
 * </p>
 *
 * @author Romain D
 * @version 1.0
 */
public class ResultatTour {

    /** État de la partie après ce tour. */
    private final EtatPartie etat;

    /** Nouvelle position du joueur (1 à 64). */
    private final int nouvellePosition;

    /**
     * Crée un résultat de tour.
     *
     * @param etat             état de la partie après le tour
     * @param nouvellePosition nouvelle position du joueur
     */
    public ResultatTour(EtatPartie etat, int nouvellePosition) {
        this.etat             = etat;
        this.nouvellePosition = nouvellePosition;
    }

    /** @return l'état de la partie */
    public EtatPartie getEtat()           { return etat; }

    /** @return la nouvelle position du joueur */
    public int getNouvellePosition()      { return nouvellePosition; }
}