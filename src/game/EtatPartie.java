package game;

/**
 * États possibles d'une partie de Wonderboys après chaque tour.
 *
 * @author Romain D
 * @version 1.0
 */
public enum EtatPartie {

    /** La partie continue normalement. */
    EN_COURS,

    /** Le joueur a atteint exactement la case 64. */
    VICTOIRE,

    /** Le joueur est mort au combat ou ses PV sont tombés à 0. */
    DEFAITE,

    /** Le joueur a dépassé la case 64 sans y tomber pile. */
    HORS_PLATEAU
}