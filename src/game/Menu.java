package game;

import java.util.Scanner;

/**
 * Gère les interactions textuelles avec le joueur via la console.
 * <p>
 * Centralise tous les affichages et toutes les saisies clavier.
 * Un seul {@link Scanner} est utilisé pour toute la durée du programme.
 * </p>
 *
 * @author Romain D
 * @version 1.0
 */
public class Menu {

    /** Scanner partagé pour toutes les saisies clavier. */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Affiche un message dans la console.
     *
     * @param message texte à afficher
     */
    public void showMessage(String message) {
        System.out.println(message);
    }

    /**
     * Pose une question et retourne la réponse textuelle du joueur.
     *
     * @param question texte de la question
     * @return chaîne saisie par le joueur
     */
    public String askString(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    /**
     * Pose une question et retourne la réponse entière du joueur.
     * Vide le buffer après lecture pour éviter les bugs.
     *
     * @param question texte de la question
     * @return entier saisi par le joueur
     */
    public int askInt(String question) {
        System.out.println(question);
        int valeur = scanner.nextInt();
        scanner.nextLine();
        return valeur;
    }
}