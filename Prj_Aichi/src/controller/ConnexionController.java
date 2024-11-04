package controller;

import model.UserDAO;

import java.sql.SQLException;

import model.User;
import views.FConnexionView;

public class ConnexionController {
    private FConnexionView view;
    private UserDAO userDAO;

    public ConnexionController(FConnexionView view) {
        this.view = view;
        this.userDAO = new UserDAO();
        this.view.addValiderListener(e -> validerConnexion());
    }

    private void validerConnexion() {
        String login = view.getLogin();
        String password = view.getMotDePasse();
        User user = userDAO.authenticateUser(login, password);
        System.out.println(user);
        if (user != null) {
            view.showMessage("Connexion Validée");
        } else {
            view.showMessage("Connexion Refusée");
        }
    }
}