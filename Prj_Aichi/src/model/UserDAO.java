package model;

import java.sql.*;

public class UserDAO {
    private Connection connection;

    public UserDAO() {
        this.connection = ConnexionDAO.getConnexion();
    }

    public User authenticateUser (String username, String password) {
        User user = null;
        String query = "SELECT * FROM utilisateurs WHERE nom = ? AND mot_de_passe = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Si un utilisateur est trouvé, créez un objet User
                user = new User(rs.getInt("id"), rs.getString("nom"), rs.getString("mot_de_passe"), rs.getString("type_acces")); // Changement de 'role' à 'type_acces'
                System.out.println("Authentification réussie pour l'utilisateur : " + username);
            } else {
                System.out.println("Authentification échouée pour l'utilisateur : " + username);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'authentification : " + e.getMessage());
            e.printStackTrace();
        }

        return user; // Renvoie l'utilisateur ou null si non trouvé
    }
}