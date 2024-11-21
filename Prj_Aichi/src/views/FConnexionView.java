package views;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionListener;

import model.User;
import model.UserDAO;

public class FConnexionView extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnCancel;
    private JLabel lblStatus;

    public FConnexionView() {
        initComponents();
        setupLayout();
        setupListeners();
    }

    private void initComponents() {
        setTitle("Connexion - Système Aichi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 350);
        setLocationRelativeTo(null);
        
        // Styling
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setupLayout() {
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Titre
        JLabel titleLabel = new JLabel("Connexion", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Formulaire de connexion
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Champ Utilisateur
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Nom d'utilisateur :"), gbc);
        gbc.gridx = 1;
        txtUsername = new JTextField(20);
        formPanel.add(txtUsername, gbc);

        // Champ Mot de passe
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Mot de passe :"), gbc);
        gbc.gridx = 1;
        txtPassword = new JPasswordField(20);
        formPanel.add(txtPassword, gbc);

        // Boutons
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnLogin = new JButton("Connexion");
        btnCancel = new JButton("Annuler");
        buttonPanel.add(btnLogin);
        buttonPanel.add(btnCancel);
        formPanel.add(buttonPanel, gbc);

        // Label de statut
        gbc.gridy = 3;
        lblStatus = new JLabel("", SwingConstants.CENTER);
        lblStatus.setForeground(Color.RED);
        formPanel.add(lblStatus, gbc);

        mainPanel.add(formPanel, BorderLayout.CENTER);
        setContentPane(mainPanel);
    }

    private void setupListeners() {
        btnLogin.addActionListener(e -> login());
        btnCancel.addActionListener(e -> System.exit(0));

        // Permettre la connexion avec la touche Entrée
        txtPassword.addActionListener(e -> login());
    }

    private void login() {
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            lblStatus.setText("Veuillez remplir tous les champs");
            return;
        }

        UserDAO userDAO = new UserDAO();
        User user = userDAO.authenticateUser(username, password);

        if (user != null) {
            // Connexion réussie
            new MainMenuView(user).setVisible(true);
            dispose(); // Ferme la fenêtre de connexion
        } else {
            // Échec de connexion
            lblStatus.setText("Identifiants incorrects");
            txtPassword.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FConnexionView().setVisible(true);
        });
    }

    public void addValiderListener(ActionListener listener) {
        btnLogin.addActionListener(listener); // btnLogin est le bouton de connexion
    }
	public String getLogin() {
	    return txtUsername.getText(); // Assurez-vous que txtUsername est défini
	}

	public String getMotDePasse() {
	    return new String(txtPassword.getPassword()); // Assurez-vous que txtPassword est défini
	}

	public void showMessage(String message) {
	    lblStatus.setText(message); // Assurez-vous que lblStatus est défini
	}
}