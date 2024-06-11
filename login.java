import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    // Array para almacenar los registros de usuarios y contraseñas
    private RegistroDatos[] registros;
    private int numRegistros;

    public login(RegistroDatos[] registros, int numRegistros) {
        this.registros = registros;
        this.numRegistros = numRegistros;

        setLayout(null);

        labelTitulo = new JLabel("Inicio de Sesión");
        labelTitulo.setBounds(60, 20, 300, 40);
        labelTitulo.setFont(new Font("Playground", 3, 25));
        labelTitulo.setForeground(new Color(222, 42, 42));
        add(labelTitulo);

        userLabel = new JLabel("Username:");
        userLabel.setBounds(25, 80, 100, 30);
        add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(130, 80, 200, 30);
        add(usernameField);

        passLabel = new JLabel("Password:");
        passLabel.setBounds(25, 120, 100, 30);
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
        for (int i = 0; i < numRegistros; i++) {
            if (registros[i].username.equals(username) && registros[i].password.equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        // Ejemplo de uso con registros precargados
        RegistroDatos[] registros = {
            new RegistroDatos("usuario1", "contrasena1", "Nombre1", "Apellido1", "correo1@example.com", 25, "Masculino"),
            new RegistroDatos("usuario2", "contrasena2", "Nombre2", "Apellido2", "correo2@example.com", 30, "Femenino"),
            // Agregar más registros si es necesario
        };
        int numRegistros = registros.length;

        login login = new login(registros, numRegistros);
        login.setBounds(0, 0, 362, 240);
        login.getContentPane().setBackground(new Color(252, 254, 190));
        login.setResizable(false);
        login.setLocationRelativeTo(null);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setVisible(true);
    }
}
