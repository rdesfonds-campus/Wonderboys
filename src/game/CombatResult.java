package game;

public class CombatResult {

    public enum Issue { VICTOIRE, DEFAITE, FUITE }

    private Issue issue;
    private int reculFuite; // nombre de cases à reculer si fuite

    public CombatResult(Issue issue, int reculFuite) {
        this.issue = issue;
        this.reculFuite = reculFuite;
    }

    public Issue getIssue()      { return issue; }
    public int getReculFuite()   { return reculFuite; }
}