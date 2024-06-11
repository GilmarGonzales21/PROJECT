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
    private JButton button1, button2;

    // Constructor de la interfaz
    public registro() {
        setLayout(null);

        // Configuración del título
        labelTitulo = new JLabel("REGISTRO");
        labelTitulo.setBounds(75, 20, 300, 55);
        labelTitulo.setFont(new Font("Playground", 1, 40));
        labelTitulo.setForeground(new Color(62, 89, 175));
        add(labelTitulo);

        // Campo de entrada para el nombre de usuario
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(35, 85, 100, 20);
        usernameLabel.setFont(new Font("Times Sans Serif", 1, 14));
        usernameLabel.setBackground(new Color(224, 224, 224));
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(125, 85, 190, 28);
        usernameField.setBackground(new Color(224, 224, 224));
        add(usernameField);

        // Campo de entrada para la contraseña
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(35, 130, 100, 20);
        passwordLabel.setFont(new Font("Times Sans Serif", 1, 14));
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(125, 130, 190, 28);
        passwordField.setFont(new Font("Times Sans Serif", 1, 18));
        passwordField.setBackground(new Color(224, 224, 224));
        add(passwordField);

        // Campo de entrada para el nombre
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setBounds(35, 170, 100, 20);
        nombreLabel.setFont(new Font("Times Sans Serif", 1 , 14));
        add(nombreLabel);

        nombreField = new JTextField();
        nombreField.setBounds(125, 170, 190, 28);
        nombreField.setFont(new Font("Times Sans Serif", 1, 18));
        nombreField.setBackground(new Color(224, 224, 224));
        add(nombreField);

        // Campo de entrada para el apellido
        JLabel apellidoLabel = new JLabel("Apellido:");
        apellidoLabel.setBounds(35, 210, 100, 20);
        apellidoLabel.setFont(new Font("Times Sans Serif", 1 , 14));
        add(apellidoLabel);
        
        apellidoField = new JTextField();
        apellidoField.setBounds(125, 210, 190, 28);
        apellidoField.setFont(new Font("Times Sans Serif", 1, 18));
        apellidoField.setBackground(new Color(224, 224, 224));
        add(apellidoField);

        // Campo de entrada para el correo
        JLabel correoLabel = new JLabel("Correo:");
        correoLabel.setBounds(35, 250, 100, 20);
        correoLabel.setFont(new Font("Times Sans Serif", 1 , 14));
        add(correoLabel);

        correoField = new JTextField();
        correoField.setBounds(125, 250, 190, 28);
        correoField.setFont(new Font("Times Sans Serif", 1, 10));
        correoField.setBackground(new Color(224, 224, 224));
        add(correoField);

        // Campo de entrada para la edad
        JLabel edadLabel = new JLabel("Edad:");
        edadLabel.setBounds(35, 290, 100, 30);
        nombreLabel.setFont(new Font("Times Sans Serif", 1 , 15));
        add(edadLabel);

        edadSpinner = new JSpinner(new SpinnerNumberModel(18, 0, 100, 1));
        edadSpinner.setBounds(125, 290, 55, 33);
        edadSpinner.setBackground(new Color(224, 224, 224));
        add(edadSpinner);

        // Campo de entrada para el género
        JLabel generoLabel = new JLabel("Género:");
        generoLabel.setBounds(35, 338, 190, 30);
        generoLabel.setFont(new Font("Times Sans Serif", 1 , 14));
        add(generoLabel);
        
        String[] generos = {"Masculino", "Femenino", "Otro"};
        generoComboBox = new JComboBox<>(generos);
        generoComboBox.setBounds(125, 338, 190, 30);
        generoComboBox.setBackground(new Color(224, 224, 224));
        add(generoComboBox);

        // Botón para enviar el registro
        button1 = new JButton("Regresar");
        button1.setFont(new Font("Times Sans Serif", 3 , 16));
        button1.setForeground(new Color(255, 255, 255));
        button1.setBounds(35, 395, 133, 40);
        button1.setBackground(new Color(62, 89, 175));
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("Registrarse");
        button2.setFont(new Font("Times Sans Serif", 3 , 16));
        button2.setForeground(new Color(255, 255, 255));
        button2.setBounds(182, 395, 133, 40);
        button2.setBackground(new Color(62, 89, 175));
        button2.addActionListener(this);
        add(button2);
    }

    // Método para manejar el evento de clic en el botón de registro
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
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
        registro.getContentPane().setBackground(new Color(209, 243, 219));
        registro.setResizable(false);
        registro.setLocationRelativeTo(null);
        registro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registro.setVisible(true);
    }
}
