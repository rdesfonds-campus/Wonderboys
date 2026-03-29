package game;

public class PotionCell extends Cell {

    @Override
    public void interact(characters.Character hero) {
        System.out.println("Tu trouves une potion !");
    }

    @Override
    public String toString() {
        return "Case potion";
    }
}