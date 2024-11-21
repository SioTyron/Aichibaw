package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.List;
import model.Article;

public class FArticlesView extends JFrame {
    private JTable tableArticles;
    private DefaultTableModel tableModel;
    private JTextField searchField;
    private JButton btnRetour;

    public FArticlesView() {
        initializeFrame();
        createComponents();
        layoutComponents();
    }

    private void initializeFrame() {
        setTitle("Gestion des Articles - Aichi");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
    }

    private void createComponents() {
        // Création du modèle de tableau
        String[] columnNames = {"ID", "Nom", "Description", "Prix", "Quantité En Stock"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Rend le tableau non éditable
            }
        };

        // Création du tableau
        tableArticles = new JTable(tableModel);
        tableArticles.setFont(new Font("Arial", Font.PLAIN, 12));
        tableArticles.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        tableArticles.setRowHeight(25);
        tableArticles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Barre de recherche
        searchField = new JTextField(20);
        searchField.setFont(new Font("Arial", Font.PLAIN, 14));

        // Bouton retour
        btnRetour = new JButton("Retour au menu");
        btnRetour.setFont(new Font("Arial", Font.BOLD, 12));
        btnRetour.setForeground(Color.BLACK); // Texte en noir
    }

    private void layoutComponents() {
        setLayout(new BorderLayout(10, 10));

        // Panel de recherche en haut
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel searchLabel = new JLabel("Rechercher : ");
        searchLabel.setFont(new Font("Arial", Font.BOLD, 14));
        searchLabel.setForeground(Color.BLACK); // Texte en noir
        searchPanel.add(searchLabel);
        searchPanel.add(searchField);

        // Panel principal avec le tableau
        JScrollPane scrollPane = new JScrollPane(tableArticles);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        // Panel du bas avec le bouton retour
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        bottomPanel.add(btnRetour);

        // Ajout des composants à la fenêtre
        add(searchPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    public void updateTableData(List<Article> articles) {
        tableModel.setRowCount(0); // Efface toutes les lignes
        for (Article article : articles) {
            tableModel.addRow(new Object[]{
                article.getId(),
                article.getReference(),
                article.getDesignation(),
                String.format("%.2f €", article.getPrix()),
                article.getQuantite()
            });
        }
    }

    public void addSearchListener(KeyListener listener) {
        searchField.addKeyListener(listener);
    }

    public void addRetourListener(ActionListener listener) {
        btnRetour.addActionListener(listener);
    }

    public String getSearchText() {
        return searchField.getText();
    }
}