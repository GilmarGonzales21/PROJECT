import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

// Clase para representar los datos del registro
class RegistroDatos {
    String username;
    String password;
    String nombre;
    String apellido;
    String correo;
    int edad;
    String genero;

    public RegistroDatos(String username, String password, String nombre, String apellido, String correo, int edad, String genero) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.edad = edad;
        this.genero = genero;
    }

    // Método para convertir los datos del registro a una cadena de texto
    @Override
    public String toString() {
        return "Username: " + username + "\nPassword: " + password + "\nNombre: " + nombre + "\nApellido: " + apellido + "\nCorreo: " + correo + "\nEdad: " + edad + "\nGénero: " + genero;
    }
}

// Clase principal para la interfaz de registro
public class registro extends JFrame implements ActionListener {
    // Componentes de la interfaz
    private JLabel labelTitulo;
    private JTextField nombreField, apellidoField, correoField, usernameField;
    private JPasswordField passwordField;
    private JSpinner edadSpinner;
    private JComboBox<String> generoComboBox;
    private JButton submitButton;

    // Constructor de la interfaz
    public registro() {
        setLayout(null);

        // Configuración del título
        labelTitulo = new JLabel("Registro");
        labelTitulo.setBounds(60, 20, 300, 40);
        labelTitulo.setFont(new Font("Playground", 3, 35));
        labelTitulo.setForeground(new Color(222, 42, 42));
        add(labelTitulo);

        // Campo de entrada para el nombre de usuario
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(25, 80, 100, 30);
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(130, 80, 200, 30);
        add(usernameField);

        // Campo de entrada para la contraseña
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(25, 120, 100, 30);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(130, 120, 200, 30);
        add(passwordField);

        // Campo de entrada para el nombre
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setBounds(25, 160, 100, 30);
        add(nombreLabel);

        nombreField = new JTextField();
        nombreField.setBounds(130, 160, 200, 30);
        add(nombreField);

        // Campo de entrada para el apellido
        JLabel apellidoLabel = new JLabel("Apellido:");
        apellidoLabel.setBounds(25, 200, 100, 30);
        add(apellidoLabel);
        
        apellidoField = new JTextField();
        apellidoField.setBounds(130, 200, 200, 30);
        add(apellidoField);

        // Campo de entrada para el correo
        JLabel correoLabel = new JLabel("Correo:");
        correoLabel.setBounds(25, 240, 100, 30);
        add(correoLabel);

        correoField = new JTextField();
        correoField.setBounds(130, 240, 200, 30);
        add(correoField);

        // Campo de entrada para la edad
        JLabel edadLabel = new JLabel("Edad:");
        edadLabel.setBounds(25, 280, 100, 30);
        add(edadLabel);

        edadSpinner = new JSpinner(new SpinnerNumberModel(18, 0, 100, 1));
        edadSpinner.setBounds(130, 280, 50, 30);
        add(edadSpinner);

        // Campo de entrada para el género
        JLabel generoLabel = new JLabel("Género:");
        generoLabel.setBounds(25, 320, 100, 30);
        add(generoLabel);
        
        String[] generos = {"Masculino", "Femenino", "Otro"};
        generoComboBox = new JComboBox<>(generos);
        generoComboBox.setBounds(130, 320, 200, 30);
        add(generoComboBox);

        // Botón para enviar el registro
        submitButton = new JButton("Registrarse");
        submitButton.setBounds(130, 360, 200, 30);
        submitButton.addActionListener(this);
        add(submitButton);
    }

    // Método para manejar el evento de clic en el botón de registro
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            // Obtener los valores de los campos de entrada
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String nombre = nombreField.getText();
            String apellido = apellidoField.getText();
            String correo = correoField.getText();
            int edad = (int) edadSpinner.getValue();
            String genero = (String) generoComboBox.getSelectedItem();

            // Crear un objeto RegistroDatos con los datos ingresados
            RegistroDatos registro = new RegistroDatos(username, password, nombre, apellido, correo, edad, genero);
            
            // Guardar el registro en un archivo
            guardarRegistroEnArchivo(registro);

            // Mostrar un cuadro de diálogo con los datos del registro
            JOptionPane.showMessageDialog(this,
                    registro.toString(),
                    "Datos de Registro",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Método para guardar el registro en un archivo de texto
    private void guardarRegistroEnArchivo(RegistroDatos registro) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("registros.txt", true))) {
            writer.write(registro.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método principal para iniciar la aplicación
    public static void main(String args[]) {
        registro registro = new registro();
        registro.setBounds(0, 0, 362, 640);
        registro.getContentPane().setBackground(new Color(252, 254, 190));
        registro.setResizable(false);
        registro.setLocationRelativeTo(null);
        registro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registro.setVisible(true);
    }
}
