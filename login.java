import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login extends JFrame implements ActionListener {
    private JLabel labelTitulo, userLabel, passLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    // Constructor
    public login() {
        setLayout(null);

        labelTitulo = new JLabel("Inicio de Sesión");
        labelTitulo.setBounds(50, 20, 300, 40);
        labelTitulo.setFont(new Font("Playground", 1, 30));
        labelTitulo.setForeground(new Color(62, 89, 175));
        add(labelTitulo);

        userLabel = new JLabel("Username:");
        userLabel.setBounds(25, 80, 100, 30);
        userLabel.setFont(new Font("Times Sans Serif", 1, 14));
        add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(130, 80, 200, 30);
        add(usernameField);

        passLabel = new JLabel("Password:");
        passLabel.setBounds(25, 120, 100, 30);
        passLabel.setFont(new Font("Times Sans Serif", 1, 14));
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(130, 120, 200, 30);
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(130, 160, 200, 30);
        loginButton.addActionListener(this);
        add(loginButton);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (verificarCredenciales(username, password)) {
                JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso", "Login", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Credenciales incorrectas", "Login", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean verificarCredenciales(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\gilma\\Desktop\\PROJECT\\registros.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(": ");
                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String args[]) {
        login login = new login();
        login.setBounds(0, 0, 362, 240);
        login.getContentPane().setBackground(new Color(209, 243, 219));
        login.setResizable(false);
        login.setLocationRelativeTo(null);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setVisible(true);
    }
}
