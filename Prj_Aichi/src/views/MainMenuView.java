package views;

import javax.swing.*;
import java.awt.*;
import model.User;

public class MainMenuView extends JFrame {
    private User currentUser ;

    public MainMenuView(User user) {
        this.currentUser  = user;
        initComponents();
        setupLayout();
        setupListeners();
    }

    private void initComponents() {
        setTitle("Système Aichi - Menu Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Look and Feel moderne
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setupLayout() {
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Header personnalisé
        JPanel headerPanel = createHeaderPanel();
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // Menu principal avec des boutons élégants
        JPanel menuPanel = createMenuPanel();
        mainPanel.add(menuPanel, BorderLayout.CENTER);

        // Footer
        JPanel footerPanel = createFooterPanel();
        mainPanel.add(footerPanel, BorderLayout.SOUTH);

        setContentPane(mainPanel);
    }

    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(41, 128, 185));
        headerPanel.setPreferredSize(new Dimension(getWidth(), 80));

        JLabel titleLabel = new JLabel("Système de Gestion Aichi", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);

        JLabel userLabel = new JLabel("Connecté : " + currentUser .getNom(), SwingConstants.RIGHT);
        userLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        userLabel.setForeground(Color.WHITE);
        userLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 20));

        headerPanel.add(titleLabel, BorderLayout.CENTER);
        headerPanel.add(userLabel, BorderLayout.EAST);

        return headerPanel;
    }

    private JPanel createMenuPanel() {
        JPanel menuPanel = new JPanel(new GridLayout(2, 2, 20, 20));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        String[] buttonTitles = {"Gestion des Articles"};
        if ("admin".equals(currentUser .getRole())) {
            buttonTitles = new String[]{"Gestion des Articles", "Gestion des Commandes", "Gestion des Utilisateurs"};
        } else {
            buttonTitles = new String[]{"Gestion des Articles", "Suivi de Commande"};
        }

        for (String title : buttonTitles) {
            JButton button = createStyledButton(title, new Color(52, 152, 219));
            menuPanel.add(button);
        }

        return menuPanel;
    }

    private JButton createStyledButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Effet de survol
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(color.darker());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(color);
            }
        });

        return button;
    }

    private JPanel createFooterPanel() {
        JPanel footerPanel = new JPanel(new BorderLayout());
        footerPanel.setBackground(new Color( 236, 240, 241));
        footerPanel.setPreferredSize(new Dimension(getWidth(), 40));

        JLabel copyrightLabel = new JLabel("© 2023 Système Aichi - Tous droits réservés", SwingConstants.CENTER);
        copyrightLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        copyrightLabel.setForeground(Color.DARK_GRAY);

        JButton logoutButton = new JButton("Déconnexion");
        logoutButton.setBackground(new Color(231, 76, 60));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.addActionListener(e -> logout());

        footerPanel.add(copyrightLabel, BorderLayout.CENTER);
        footerPanel.add(logoutButton, BorderLayout.EAST);

        return footerPanel;
    }

    private void setupListeners() {
        // Ajoutez ici les écouteurs d'événements pour les boutons du menu
    }

    private void logout() {
        new FConnexionView().setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        // Pour les tests
        SwingUtilities.invokeLater(() -> {
            User testUser  = new User(1, "John Doe", "password", "admin");
            new MainMenuView(testUser ).setVisible(true);
        });
    }
}