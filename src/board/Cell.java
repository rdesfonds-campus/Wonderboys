package board;

import game.Menu;

public abstract class Cell implements Interactable {

    protected Menu menu;

    public Cell(Menu menu) {
        this.menu = menu;
    }

    @Override
    public abstract void interact(characters.Character hero);

    @Override
    public abstract String toString();
}