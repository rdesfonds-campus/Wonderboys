package game;

import characters.Character;
import characters.Warrior;
import characters.Wizard;

public class Main {

    public static void main(String[] args) {

        Warrior guerrier = new Warrior("Thor", 10, 5);
        Wizard magicien = new Wizard("Merlin", 6, 8);

        System.out.println(guerrier);
        System.out.println(magicien);
}
}