package game;

public class WeaponCell extends Cell {

    @Override
    public void interact(characters.Character hero) {
        System.out.println("Tu trouves une arme !");
    }

    @Override
    public String toString() {
        return "Case arme";
    }
}