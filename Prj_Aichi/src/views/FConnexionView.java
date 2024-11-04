package views;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FConnexionView extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtSaisieUtilisateur;
    private JPasswordField pwdMotDePasse;
    private JButton btnValider;
    private JButton btnQuitter;

    public FConnexionView() {
        initializeFrame();
        createComponents();
        layoutComponents();
    }

    private void initializeFrame() {
        setTitle("Connexion - Aichi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 370);
        setLocationRelativeTo(null);
    }

    private void createComponents() {
        txtSaisieUtilisateur = new JTextField(20);
        pwdMotDePasse = new JPasswordField(20);
        btnValider = new JButton("Valider");
        btnQuitter = new JButton("Quitter");
        
        // Action par défaut pour le bouton Quitter
        btnQuitter.addActionListener(e -> fermerFenetre());
    }

    private void layoutComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Panel de connexion
        JPanel loginPanel = createLoginPanel();
        mainPanel.add(loginPanel, BorderLayout.CENTER);

        // Panel des boutons
        JPanel buttonPanel = createButtonPanel();
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        setContentPane(mainPanel);
    }

    private JPanel createLoginPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new CompoundBorder(
            new LineBorder(new Color(0x33, 0XB5, 0XE5), 3, true),
            new EmptyBorder(20, 20, 20, 20)
        ));
        panel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Utilisateur
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Nom d'utilisateur :"), gbc);

        gbc.gridx = 1; gbc.gridy = 0;
        panel.add(txtSaisieUtilisateur, gbc);

        // Mot de passe
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Mot de passe :"), gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(pwdMotDePasse, gbc);

        // Message d'information
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2;
        JTextPane txtpnInfo = new JTextPane();
        txtpnInfo.setText("Veuillez saisir vos identifiants pour accéder à l'application");
        txtpnInfo.setForeground(Color.GRAY);
        txtpnInfo.setBackground(Color.WHITE);
        txtpnInfo.setEditable(false);
        panel.add(txtpnInfo, gbc);

        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.add(btnValider);
        panel.add(btnQuitter);
        return panel;
    }

    public String getLogin() {
        return txtSaisieUtilisateur.getText();
    }

    public String getMotDePasse() {
        return new String(pwdMotDePasse.getPassword());
    }

    public void addValiderListener(ActionListener listener) {
        btnValider.addActionListener(listener);
    }

    public void addQuitterListener(ActionListener listener) {
        btnQuitter.addActionListener(listener);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void fermerFenetre() {
        dispose();
    }
}