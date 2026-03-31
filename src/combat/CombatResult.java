package combat;

/**
 * Résultat d'un combat entre le héros et un ennemi.
 * <p>
 * Encapsule l'issue du combat et, en cas de fuite,
 * le nombre de cases dont le héros recule.
 * </p>
 *
 * @author Romain D
 * @version 1.0
 */
public class CombatResult {

    /**
     * Issue possible d'un combat.
     */
    public enum Issue {
        /** Le héros a vaincu l'ennemi. */
        VICTOIRE,
        /** Le héros a été tué par l'ennemi. */
        DEFAITE,
        /** Le héros a choisi de fuir. */
        FUITE
    }

    /** Issue du combat. */
    private Issue issue;

    /** Nombre de cases à reculer en cas de fuite (0 sinon). */
    private int reculFuite;

    /**
     * Crée un résultat de combat.
     *
     * @param issue      issue du combat (VICTOIRE, DEFAITE ou FUITE)
     * @param reculFuite cases à reculer si fuite, 0 sinon
     */
    public CombatResult(Issue issue, int reculFuite) {
        this.issue = issue;
        this.reculFuite = reculFuite;
    }

    /** @return l'issue du combat */
    public Issue getIssue()    { return issue; }

    /** @return le nombre de cases à reculer */
    public int getReculFuite() { return reculFuite; }
}