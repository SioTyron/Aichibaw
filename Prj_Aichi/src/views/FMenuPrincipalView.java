package views;

import javax.swing.*;

import model.User;

import java.awt.*;
import java.awt.event.ActionListener;

public class FMenuPrincipalView<currentUser> extends JFrame {
    private JButton btnArticles;
    private JButton btnGestionCommandes;
    private JButton btnGestionUtilisateurs;
    private JButton btnSuiviCommandes;
    private JButton btnDeconnexion;
    private User currentUser ;

    public FMenuPrincipalView(User user) {
        this.currentUser  = user;
        initializeFrame();
        createComponents();
        layoutComponents();
    }

    private void initializeFrame() {
        setTitle("Menu Principal - Aichi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
    }

    private void createComponents() {
        btnArticles = new JButton("Gestion des Articles");
        btnDeconnexion = new JButton("Déconnexion");

        // Personnalisation des boutons
        Dimension buttonSize = new Dimension(200, 100);
        btnArticles.setPreferredSize(buttonSize);
        btnDeconnexion.setPreferredSize(new Dimension(150, 50));

        // Style des boutons
        Font buttonFont = new Font("Arial", Font.BOLD, 14);
        btnArticles.setFont(buttonFont);
        btnDeconnexion.setFont(buttonFont);
        btnArticles.setForeground(Color.BLACK);
        btnDeconnexion.setForeground(Color.BLACK);

        // Créer un menu déroulant pour les options
        JMenuBar menuBar = new JMenuBar();
        JMenu optionsMenu = new JMenu("Options");
        optionsMenu.setForeground(Color.BLACK); // Texte en noir

        // Ajouter le bouton de déconnexion dans le menu déroulant
        JMenuItem logoutItem = new JMenuItem("Déconnexion");
        optionsMenu.add(logoutItem);

        // Ajouter le logo
        JLabel logoLabel = new JLabel(new ImageIcon("path/to/logo.png")); // Remplacez par le chemin de votre logo
        logoLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logoLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                optionsMenu.show();
            }
        });

        // Ajouter le menu à la barre de menu
        menuBar.add(Box.createHorizontalGlue()); // Pour pousser le logo à droite
        menuBar.add(logoLabel);
        menuBar.add(optionsMenu);
        setJMenuBar(menuBar);
    }

    private void layoutComponents() {
        // Panel principal avec BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Panel central avec GridLayout pour les boutons principaux
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 20, 20));

        // Ajouter les boutons en fonction du type d'accès
        buttonPanel.add(btnArticles);
        if ("admin".equals(currentUser .getRole())) {
            btnGestionCommandes = new JButton("Gestion des Commandes");
            btnGestionUtilisateurs = new JButton("Gestion des Utilisateurs");
            btnGestionCommandes.setFont(new Font("Arial", Font.BOLD, 14));
            btnGestionUtilisateurs.setFont(new Font("Arial", Font.BOLD, 14));
            btnGestionCommandes.setForeground(Color.BLACK);
            btnGestionUtilisateurs.setForeground(Color.BLACK);
            buttonPanel.add(btnGestionCommandes);
            buttonPanel.add(btnGestionUtilisateurs);
        } else {
            btnSuiviCommandes = new JButton("Suivi de Commande");
            btnSuiviCommandes.setFont(new Font("Arial", Font.BOLD, 14));
            btnSuiviCommandes.setForeground(Color.BLACK);
            buttonPanel.add(btnSuiviCommandes);
        }

        // Panel pour le bouton déconnexion en bas
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(btnDeconnexion);

        mainPanel.add(createTitlePanel(), BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        setContentPane(mainPanel);
    }

    private JPanel createTitlePanel() {
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel(" Menu Principal");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLACK); // Texte en noir
        titlePanel.add(titleLabel);
        return titlePanel;
    }

    // Méthodes pour ajouter les listeners
    public void addArticlesListener(ActionListener listener) {
        btnArticles.addActionListener(listener);
    }

    public void addGestionCommandesListener(ActionListener listener) {
        btnGestionCommandes.addActionListener(listener);
    }

    public void addGestionUtilisateursListener(ActionListener listener) {
        btnGestionUtilisateurs.addActionListener(listener);
    }

    public void addSuiviCommandesListener(ActionListener listener) {
        btnSuiviCommandes.addActionListener(listener);
    }

    public void addDeconnexionListener(ActionListener listener) {
        btnDeconnexion.addActionListener(listener);
    }
}