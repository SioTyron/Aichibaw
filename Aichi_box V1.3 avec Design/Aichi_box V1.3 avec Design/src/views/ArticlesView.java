package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import model.Article;
import rojerusan.RSMaterialButtonRectangle;

public class ArticlesView extends JFrame {
    private JTable articlesTable;
    private JTextField barreRecherche;
    private JButton searchButton, addButton, deleteButton, backButton;

    private RSMaterialButtonRectangle boutonAjouter;
    private RSMaterialButtonRectangle boutonModifier;
    private RSMaterialButtonRectangle boutonRetour;
    private RSMaterialButtonRectangle boutonSupprimer;
   private RSMaterialButtonRectangle boutonRechercher;
   
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    
    public ArticlesView() {
        setTitle("Gestion des Articles");
  
         jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        barreRecherche = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        articlesTable = new javax.swing.JTable();
        boutonAjouter = new rojerusan.RSMaterialButtonRectangle();
        boutonSupprimer = new rojerusan.RSMaterialButtonRectangle();
        boutonRetour = new rojerusan.RSMaterialButtonRectangle();
        boutonRechercher = new rojerusan.RSMaterialButtonRectangle();
        boutonModifier = new rojerusan.RSMaterialButtonRectangle();
 
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Rechercher un article :");

        barreRecherche.setFont(new java.awt.Font("Gill Sans MT", 0, 12)); // NOI18N
        barreRecherche.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/LogoAichi2.png"))); // NOI18N

          articlesTable.getTableHeader().setFont(new Font("Gill Sans MT", 0, 14));
        articlesTable.getTableHeader().setOpaque(false);
        articlesTable.getTableHeader().setBackground(new Color(56, 182, 255));
        articlesTable.getTableHeader().setForeground(new Color(255,255,255));
        articlesTable.setRowHeight(25);
        articlesTable.setAutoCreateRowSorter(true);
        articlesTable.setFont(new java.awt.Font("Gill Sans MT", 0, 12)); // NOI18N
        articlesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Nom", "Description", "Prix", "Quantité"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        articlesTable.setFocusable(false);
        articlesTable.setRowHeight(25);
        articlesTable.setSelectionBackground(new java.awt.Color(255, 145, 77));
        articlesTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(articlesTable);

        boutonAjouter.setBackground(new java.awt.Color(56, 182, 255));
        boutonAjouter.setText("Ajouter");
      

        boutonSupprimer.setBackground(new java.awt.Color(56, 182, 255));
        boutonSupprimer.setText("Supprimer");
      

        boutonRetour.setBackground(new java.awt.Color(255,145,77));
        boutonRetour.setText("Retour");
        

         boutonRechercher.setBackground(new java.awt.Color(255,145,77));
        boutonRechercher.setText("Rechercher");
        boutonRechercher.setFont(new java.awt.Font("Roboto Medium", 0, 10)); // NOI18N
        
        boutonModifier.setBackground(new java.awt.Color(255,145,77));
        boutonModifier.setText("Modifier");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(19, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(5, 5, 5)
                                    .addComponent(barreRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(boutonRechercher, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 852, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(boutonAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(boutonModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(boutonSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(boutonRetour, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(barreRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boutonRechercher, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boutonAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boutonSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boutonRetour, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(boutonModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
                
    }                                          


    public JTable getArticlesTable() {
        return articlesTable;
    }

    public JTextField getSearchField() {
        return barreRecherche;
    }

    public JButton getSearchButton() {
        return boutonRechercher;
    }

    public JButton getAddButton() {
        return boutonAjouter;
    }
    
    public JButton getEditButton() {
        return boutonModifier;
    }

    public JButton getDeleteButton() {
        return boutonSupprimer;
    }
    
    public JButton getBackButton() {
        return boutonRetour;
    }

    public void updateTable(List<Article> articles) {
        DefaultTableModel model = (DefaultTableModel) articlesTable.getModel();
        model.setRowCount(0); // Effacer les lignes existantes
        for (Article article : articles) {
            model.addRow(new Object[]{article.getId(), article.getNom(), article.getDescription(), article.getPrix(), article.getQuantiteEnStock()});
        }
    }
}
