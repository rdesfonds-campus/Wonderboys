package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Fournit la connexion à la base de données MySQL du projet.
 * <p>
 * Utilise le driver JDBC MySQL. La méthode {@link #getConnection()}
 * ouvre une nouvelle connexion à chaque appel — à fermer après usage
 * (de préférence dans un bloc try-with-resources).
 * </p>
 *
 * @author Romain D
 * @version 1.0
 */
public class DatabaseConnection {

    /** URL JDBC de la base de données. */
    private static final String URL      = "jdbc:mysql://localhost/wonderboys";

    /** Nom d'utilisateur MySQL. */
    private static final String USER     = "root";

    /** Mot de passe MySQL. */
    private static final String PASSWORD = "root";

    /**
     * Ouvre et retourne une connexion à la base de données.
     *
     * @return connexion active
     * @throws SQLException si la connexion échoue
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}