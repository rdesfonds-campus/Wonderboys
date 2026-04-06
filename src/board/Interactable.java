package board;

import characters.Character;

/**
 * Interface définissant le comportement d'interaction avec un personnage.
 * <p>
 * Toute case du plateau susceptible d'interagir avec le héros
 * doit implémenter cette interface.
 * </p>
 *
 * @author Romain D
 * @version 1.0
 */
public interface Interactable {

    /**
     * Déclenche l'interaction entre cette case et le personnage.
     *
     * @param hero personnage du joueur qui entre sur la case
     */
    void interact(characters.Character hero);
}