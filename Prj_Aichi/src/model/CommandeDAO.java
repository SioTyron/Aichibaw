package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommandeDAO {
    private Connection connection;

    public CommandeDAO() {
        this.connection = ConnexionDAO.getConnexion();
    }

    public List<Commande> getAllCommandes() {
        List<Commande> commandes = new ArrayList<>();
        String query = "SELECT * FROM commandes";

        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Commande commande = new Commande(
                    rs.getInt("id"),
                    rs.getString("date"),
                    rs.getDouble("total")
                );
                commandes.add(commande);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commandes;
    }
}