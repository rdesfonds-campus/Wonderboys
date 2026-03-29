package game;

public class EnemyCell extends Cell {

    @Override
    public void interact(characters.Character hero) {
        System.out.println("Un ennemi ! (combat à implémenter)");
    }

    @Override
    public String toString() {
        return "Case ennemi";
    }
}