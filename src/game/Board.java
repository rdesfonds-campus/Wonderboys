package game;

import java.util.ArrayList;

public class Board {

    private static final int TOTAL = 64;
    private ArrayList<Cell> cases;

    public Board() {
        cases = new ArrayList<>();
        initialiser();
    }

    private void initialiser() {
        for (int i = 0; i < TOTAL; i++) {
            switch (i % 4) {
                case 0: cases.add(new EmptyCell());  break;
                case 1: cases.add(new EnemyCell());  break;
                case 2: cases.add(new WeaponCell()); break;
                case 3: cases.add(new PotionCell()); break;
            }
        }
    }

    // Retourne la case à la position donnée (1 à 64)
    public Cell getCase(int position) {
        return cases.get(position - 1);
    }

    public int getTotalCases() {
        return TOTAL;
    }

    @Override
    public String toString() {
        return "Plateau de " + TOTAL + " cases";
    }
}