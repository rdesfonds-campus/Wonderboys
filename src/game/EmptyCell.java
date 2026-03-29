package game;

public class EmptyCell extends Cell {

    @Override
    public void interact(characters.Character hero) {
        System.out.println("Case vide. Tu continues ta route.");
    }

    @Override
    public String toString() {
        return "Case vide";
    }
}