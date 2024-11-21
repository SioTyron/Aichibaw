package controller;

import views.FMenuPrincipalView;
import views.FArticlesView;
import views.FConnexionView;

public class MenuPrincipalController {
    private FMenuPrincipalView view;

    public MenuPrincipalController(FMenuPrincipalView view) {
        this.view = view;
        initializeListeners();
    }

    private void initializeListeners() {
        view.addArticlesListener(e -> ouvrirGestionArticles());
        //view.addCommandesListener(e -> ouvrirGestionCommandes());
        //view.addClientsListener(e -> ouvrirGestionClients());
        view.addDeconnexionListener(e -> deconnexion());
    }

    private void ouvrirGestionArticles() {
        view.dispose(); // Ferme la fenêtre du menu principal
        FArticlesView articlesView = new FArticlesView();
        new ArticlesController(articlesView);
        articlesView.setVisible(true);
    }

    private void ouvrirGestionCommandes() {
        // À implémenter : ouvrir la fenêtre de gestion des commandes
        System.out.println("Ouverture de la gestion des commandes");
    }

    private void ouvrirGestionClients() {
        // À implémenter : ouvrir la fenêtre de gestion des clients
        System.out.println("Ouverture de la gestion des clients");
    }

    private void deconnexion() {
        view.dispose();
        // Réouvrir la fenêtre de connexion
        FConnexionView connexionView = new FConnexionView();
        new ConnexionController(connexionView);
        connexionView.setVisible(true);
    }
}