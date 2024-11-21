package controller;

import views.FArticlesView;
import views.FMenuPrincipalView;
import model.ArticleDAO;
import model.Article;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class ArticlesController {
    private FArticlesView view;
    private ArticleDAO articleDAO;

    public ArticlesController(FArticlesView view) {
        this.view = view;
        this.articleDAO = new ArticleDAO();
        initializeListeners();
        loadAllArticles();
    }

    private void initializeListeners() {
        // Listener pour la recherche
        view.addSearchListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String searchTerm = view.getSearchText();
                if (searchTerm.isEmpty()) {
                    loadAllArticles();
                } else {
                    searchArticles(searchTerm);
                }
            }
        });

        // Listener pour le bouton retour
        view.addRetourListener(e -> retourMenuPrincipal());
    }

    private void loadAllArticles() {
        List<Article> articles = articleDAO.getAllArticles();
        view.updateTableData(articles);
    }

    private void searchArticles(String searchTerm) {
        List<Article> articles = articleDAO.searchArticles(searchTerm);
        view.updateTableData(articles);
    }

    private void retourMenuPrincipal() {
        view.dispose();
        FMenuPrincipalView menuView = new FMenuPrincipalView(null);
        new MenuPrincipalController(menuView);
        menuView.setVisible(true);
    }
}