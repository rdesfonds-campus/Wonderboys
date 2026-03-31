package game;

import java.util.ArrayList;
import java.util.Collections;

public class Board {

    private static final int TOTAL = 64;
    private ArrayList<Cell> cases;

    public Board(Menu menu) {
        cases = new ArrayList<>();
        initialiser(menu);
    }

    private void initialiser(Menu menu) {

        // 5 potions
        for (int i = 0; i < 5; i++) {
            cases.add(new PotionCell(menu));
        }

        // 5 armes
        for (int i = 0; i < 5; i++) {
            cases.add(new WeaponCell(menu));
        }

        // 16 ennemis - on leur donnera leur vraie position après le mélange
        for (int i = 0; i < 16; i++) {
            cases.add(new EnemyCell(menu, i + 1));
        }

        // Cases vides pour compléter jusqu'à 64
        while (cases.size() < TOTAL) {
            cases.add(new EmptyCell(menu));
        }

        // Mélange aléatoire
        Collections.shuffle(cases);
    }

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