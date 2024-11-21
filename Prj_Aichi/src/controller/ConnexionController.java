package controller;

import model.UserDAO;
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
        String login = view.getLogin(); // Assurez-vous que cette méthode existe
        String password = view.getMotDePasse(); // Assurez-vous que cette méthode existe
        User user = userDAO.authenticateUser (login, password);

        if (user != null) {
            view.showMessage("Connexion Validée");
        } else {
            view.showMessage("Connexion Refusée");
        }
    }
}