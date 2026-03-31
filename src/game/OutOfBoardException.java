package game;

/**
 * Exception levée quand le joueur dépasse la dernière case du plateau.
 * <p>
 * Déclenchée dans {@link Game} quand la nouvelle position calculée
 * dépasse 64. Indique que le joueur a "raté" la salle du trésor.
 * </p>
 *
 * @author Romain D
 * @version 1.0
 */
public class OutOfBoardException extends Exception {

    /**
     * Crée l'exception avec un message explicatif.
     *
     * @param message description du dépassement
     */
    public OutOfBoardException(String message) {
        super(message);
    }
}
