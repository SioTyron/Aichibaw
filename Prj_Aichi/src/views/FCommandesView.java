package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import model.Commande;

public class FCommandesView extends JFrame {
    private JTable tableCommandes;
    private DefaultTableModel tableModel;
    private JButton btnRetour;

    public FCommandesView() {
        initializeFrame();
        createComponents();
        layoutComponents();
    }

    private void initializeFrame() {
        setTitle("Gestion des Commandes - Aichi");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
    }

    private void createComponents() {
        // Création du modèle de tableau
        String[] columnNames = {"ID", "Date", "Total"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Rend le tableau non éditable
            }
        };

        // Création du tableau
        tableCommandes = new JTable(tableModel);
        tableCommandes.setFont(new Font("Arial", Font.PLAIN, 12));
        tableCommandes.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        tableCommandes.setRowHeight(25);
        tableCommandes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Bouton retour
        btnRetour = new JButton("Retour au menu");
        btnRetour.setFont(new Font("Arial", Font.BOLD, 12));
        btnRetour.setForeground(Color.BLACK); // Texte en noir
    }

    private void layoutComponents() {
        setLayout(new BorderLayout(10, 10));

        // Panel principal avec le tableau
        JScrollPane scrollPane = new JScrollPane(tableCommandes);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        // Panel du bas avec le bouton retour
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        bottomPanel.add(btnRetour);

        // Ajout des composants à la fenêtre
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    public void updateTableData(List<Commande> commandes) {
        tableModel.setRowCount(0); // Efface toutes les lignes
        for (Commande commande : commandes) {
            tableModel.addRow(new Object[]{
                commande.getId(),
                commande.getDate(),
                String.format("%.2f €", commande.getTotal())
            });
        }
    }

    public void addRetourListener(ActionListener listener) {
        btnRetour.addActionListener(listener);
    }
}