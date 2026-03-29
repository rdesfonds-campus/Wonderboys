package game;

import characters.Character;

public abstract class Cell {

    // Ce que fait la case quand le joueur arrive dessus
    public abstract void interact(characters.Character hero);

    // Description de la case
    @Override
    public abstract String toString();
}