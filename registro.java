import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class registro extends JFrame implements ActionListener {
    private JLabel labelTitulo; // Etiquetas de texto para el título
    private JTextField nombreField, apellidoField, correoField; // Campos de texto para nombre, apellido y correo
    private JSpinner edadSpinner; // Spinner para la edad
    private JComboBox<String> generoComboBox; // ComboBox para el género
    private JButton submitButton; // Botón de envío

    // Constructor de la clase
    public registro() {
        // Establecer el diseño nulo
        setLayout(null);

        // Crear y configurar la etiqueta de título
        labelTitulo = new JLabel("Registro");
        labelTitulo.setBounds(60, 20, 300, 80);
        labelTitulo.setFont(new Font("Playground", Font.BOLD, 50));
        labelTitulo.setForeground(new Color(222, 42, 42));
        add(labelTitulo);

        // Crear y configurar la etiqueta y campo de texto para el nombre
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setBounds(25, 120, 100, 30);
        add(nombreLabel);

        nombreField = new JTextField();
        nombreField.setBounds(130, 120, 200, 30);
        add(nombreField);

        // Crear y configurar la etiqueta y campo de texto para el apellido
        JLabel apellidoLabel = new JLabel("Apellido:");
        apellidoLabel.setBounds(25, 160, 100, 30);
        add(apellidoLabel);
        
        apellidoField = new JTextField();
        apellidoField.setBounds(130, 160, 200, 30);
        add(apellidoField);

        // Crear y configurar la etiqueta y campo de texto para el correo
        JLabel correoLabel = new JLabel("Correo:");
        correoLabel.setBounds(25, 200, 100, 30);
        add(correoLabel);

        correoField = new JTextField();
        correoField.setBounds(130, 200, 200, 30);
        add(correoField);

        // Crear y configurar la etiqueta y spinner para la edad
        JLabel edadLabel = new JLabel("Edad:");
        edadLabel.setBounds(25, 240, 100, 30);
        add(edadLabel);

        edadSpinner = new JSpinner(new SpinnerNumberModel(18, 0, 100, 1));
        edadSpinner.setBounds(130, 240, 50, 30);
        add(edadSpinner);

        // Crear y configurar la etiqueta y comboBox para el género
        JLabel generoLabel = new JLabel("Género:");
        generoLabel.setBounds(25, 280, 100, 30);
        add(generoLabel);
        
        String[] generos = {"Masculino", "Femenino", "Otro"};
        generoComboBox = new JComboBox<>(generos);
        generoComboBox.setBounds(130, 280, 200, 30);
        add(generoComboBox);

        // Crear y configurar el botón de envío
        submitButton = new JButton("Registrarse");
        submitButton.setBounds(130, 320, 200, 30);
        submitButton.addActionListener(this);
        add(submitButton);
    }

    // Método actionPerformed para manejar eventos de botón
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            // Obtener los datos ingresados
            String nombre = nombreField.getText();
            String apellido = apellidoField.getText();
            String correo = correoField.getText();
            int edad = (int) edadSpinner.getValue();
            String genero = (String) generoComboBox.getSelectedItem();

            // Mostrar un mensaje con los datos
            JOptionPane.showMessageDialog(this,
                    "Nombre: " + nombre + "\nApellido: " + apellido + "\nCorreo: " + correo + "\nEdad: " + edad + "\nGénero: " + genero,
                    "Datos de Registro",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Método principal para iniciar la aplicación
    public static void main(String args[]) {
        registro registro = new registro(); // Crear una instancia de la clase Registro
        registro.setBounds(0, 0, 362, 640); // Establecer el tamaño del marco
        registro.getContentPane().setBackground(new Color(252, 254, 190));
        registro.setResizable(false); // Deshabilitar la capacidad de cambiar el tamaño del marco
        registro.setLocationRelativeTo(null); // Centrar el marco en la pantalla
        registro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar la aplicación al cerrar la ventana
        registro.setVisible(true); // Hacer visible el marco
    }
}
