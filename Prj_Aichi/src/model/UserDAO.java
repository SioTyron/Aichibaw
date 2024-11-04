package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {
    private ConnexionDAO connection;
    public UserDAO() throws SQLException {
        connection = ConnexionDAO.getConnexion();
    }

    public void ajoutUser(User user) {
        String query = "INSERT INTO Utilisateurs (nom, mot_de_passe, type_acces) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = ((Connection) connection).prepareStatement(query)) {
            stmt.setString(1, user.getNom());
            stmt.setString(2, user.getMot_de_passe());
            stmt.setString(3, user.getType_acces());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User authenticateUser(String nom, String mot_de_passe) {
        User utilisateur = null;
        String query = "SELECT * FROM Utilisateurs WHERE nom = ? AND mot_de_passe = ?";

        try (PreparedStatement stmt = ((Connection) connection).prepareStatement(query)) {
            stmt.setString(1, nom);
            stmt.setString(2, mot_de_passe);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                utilisateur = new User(
                    resultSet.getInt("id"),
                    resultSet.getString("nom"),
                    resultSet.getString("mot_de_passe"),
                    resultSet.getString("type_acces")
                );
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return utilisateur;
    }

    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        String query = "SELECT * FROM Utilisateurs";

        try (PreparedStatement stmt = ((Connection) connection).prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String mot_de_passe = rs.getString("mot_de_passe");
                String type_acces = rs.getString("type_acces");
                users.add(new User(id, nom, mot_de_passe, type_acces));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
}