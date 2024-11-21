package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAO {
    private Connection connection;

    public ArticleDAO() {
        this.connection = ConnexionDAO.getConnexion();
    }

    public List<Article> getAllArticles() {
        List<Article> articles = new ArrayList<>();
        String query = "SELECT * FROM articles";
        
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Article article = new Article(
                    rs.getInt("Id"),
                    rs.getString("Nom"),
                    rs.getString("Description"),
                    rs.getDouble("Prix"),
                    rs.getInt("QuantiteEnStock")
                );
                articles.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }

    public List<Article> searchArticles(String searchTerm) {
        List<Article> articles = new ArrayList<>();
        String query = "SELECT * FROM articles WHERE Id LIKE ? OR Nom LIKE ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            String searchPattern = "%" + searchTerm + "%";
            stmt.setString(1, searchPattern);
            stmt.setString(2, searchPattern);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Article article = new Article(
                        rs.getInt("Id"),
                        rs.getString("Nom"),
                        rs.getString("Description"),
                        rs.getDouble("Prix"),
                        rs.getInt("QuantiteEnStock")
                    );
                    articles.add(article);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }
}