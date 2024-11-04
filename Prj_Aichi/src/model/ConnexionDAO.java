package model;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionDAO {
	private static ConnexionDAO connexion =null; 
	
	public static ConnexionDAO getConnexion() {
		try {
			// Connection à MySQL
			
			String url = "jdbc:mysql://localhost:3306/aichidb";
			String username = "root";
			String password = "root";
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connexion = (ConnexionDAO) DriverManager.getConnection(url,
			username, password);
			
		} catch (SQLException e) { 
			e.printStackTrace();
			System.err.println("Erreur de connexion à la base de données : " + e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Connexion réussie");
		}
		return connexion;
	}

	public static ConnexionDAO getConnection() {
		// TODO Auto-generated method stub
		return null;
	}
}

