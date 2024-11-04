package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private Connection connection;

    public UserDAO() {
        try {
            this.connection = ConnexionDAO.getConnexion();
            if (this.connection == null) {
                throw new SQLException("Impossible d'établir la connexion à la base de données");
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'initialisation de UserDAO : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public User authenticateUser(String nom, String mot_de_passe) {
        User utilisateur = null;
        String query = "SELECT * FROM Utilisateurs WHERE nom = ? AND mot_de_passe = ?";

        try {
            if (connection == null || connection.isClosed()) {
                connection = ConnexionDAO.getConnexion();
            }
            
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, nom);
                stmt.setString(2, mot_de_passe);
                
                try (ResultSet resultSet = stmt.executeQuery()) {
                    if (resultSet.next()) {
                        utilisateur = new User(
                            resultSet.getInt("id"),
                            resultSet.getString("nom"),
                            resultSet.getString("mot_de_passe"),
                            resultSet.getString("type_acces")
                        );
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'authentification : " + e.getMessage());
            e.printStackTrace();
        }
        return utilisateur;
    }
}