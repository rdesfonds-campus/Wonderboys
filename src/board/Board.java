package board;

import game.Menu;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Représente le plateau de jeu de 64 cases.
 * <p>
 * Les cases sont générées aléatoirement à chaque nouvelle partie
 * selon une répartition fixe : 5 potions, 5 armes, 16 ennemis,
 * et des cases vides pour le reste.
 * Le mélange est réalisé via {@link Collections#shuffle(java.util.List)}.
 * </p>
 *
 * @author Romain D
 * @version 1.0
 */
public class Board {

    /** Nombre total de cases du plateau. */
    private static final int TOTAL = 64;

    /** Liste ordonnée des cases (index 0 = case 1). */
    private ArrayList<Cell> cases;

    /**
     * Crée et initialise le plateau de jeu.
     *
     * @param menu interface transmise aux cases pour leurs interactions
     */
    public Board(Menu menu) {
        cases = new ArrayList<>();
        initialiser(menu);
    }

    /**
     * Génère les cases du plateau et les mélange aléatoirement.
     *
     * @param menu interface transmise aux cases
     */
    private void initialiser(Menu menu) {
        for (int i = 0; i < 5; i++)  cases.add(new PotionCell(menu));
        for (int i = 0; i < 5; i++)  cases.add(new WeaponCell(menu));
        for (int i = 0; i < 16; i++) cases.add(new EnemyCell(menu, i + 1));
        while (cases.size() < TOTAL) cases.add(new EmptyCell(menu));
        Collections.shuffle(cases);
    }

    /**
     * Retourne la case à la position donnée (1-indexée).
     *
     * @param position position du joueur entre 1 et 64
     * @return la {@link Cell} correspondante
     */
    public Cell getCase(int position) {
        return cases.get(position - 1);
    }

    /**
     * Retourne le nombre total de cases du plateau.
     *
     * @return 64
     */
    public int getTotalCases() {
        return TOTAL;
    }

    @Override
    public String toString() {
        return "Plateau de " + TOTAL + " cases";
    }
}