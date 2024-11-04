package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionDAO {
    private static Connection connexion = null;
    private static final String URL = "jdbc:mysql://localhost:3306/aichidb?serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnexion() {
        try {
            if (connexion == null || connexion.isClosed()) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    System.out.println("Tentative de connexion à " + URL);
                    connexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                    System.out.println("Connexion réussie à la base de données");
                } catch (ClassNotFoundException e) {
                    System.err.println("Driver MySQL non trouvé : " + e.getMessage());
                    e.printStackTrace();
                    throw new SQLException("Driver MySQL non trouvé");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur de connexion à la base de données : " + e.getMessage());
            e.printStackTrace();
        }
        return connexion;
    }
}