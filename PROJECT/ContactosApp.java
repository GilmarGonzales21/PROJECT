import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ContactosApp extends JFrame implements ActionListener {
    private JLabel labContacto, labNumero, labRedes, labCorreos, labCorreo1, labCorreo2;
    private JButton botonInstagram, botonCamera, botonTelefono, boton2;

    public ContactosApp() {
        setLayout(null);
        setTitle("Informes");

        // Título "CONTACTOS"
        labContacto = new JLabel("CONTACTOS");
        labContacto.setBounds(75, 20, 300, 55);
        labContacto.setFont(new Font("Playground", Font.BOLD, 40));
        labContacto.setForeground(new Color(62, 89, 175));
        add(labContacto);

        // Etiqueta "Número"
        labNumero = new JLabel("Número:");
        labNumero.setBounds(35, 105, 100, 20);
        labNumero.setFont(new Font("Times Sans Serif", Font.BOLD, 14));
        add(labNumero);

        // Número de teléfono
        JLabel numeroTelefono = new JLabel("998 992 868");
        numeroTelefono.setBounds(105, 105, 150, 20);
        numeroTelefono.setFont(new Font("Times Sans Serif", Font.PLAIN, 14));
        add(numeroTelefono);

        // Etiqueta "Redes"
        labRedes = new JLabel("Redes:");
        labRedes.setBounds(35, 140, 300, 55);
        labRedes.setFont(new Font("Times Sans Serif", Font.BOLD, 14));
        add(labRedes);

        // Botón para Instagram
        botonInstagram = new JButton(new ImageIcon("instagram_icon.png"));
        botonInstagram.setBounds(105, 140, 40, 40);
        botonInstagram.setBackground(new Color(62, 89, 175));
        botonInstagram.addActionListener(this);
        add(botonInstagram);

        // Botón para Cámara
        botonCamera = new JButton(new ImageIcon("camera_icon.png"));
        botonCamera.setBounds(160, 140, 40, 40);
        botonCamera.setBackground(new Color(62, 89, 175));
        botonCamera.addActionListener(this);
        add(botonCamera);

        // Etiqueta "Correos"
        labCorreos = new JLabel("Correos:");
        labCorreos.setBounds(35, 210, 300, 55);
        labCorreos.setFont(new Font("Times Sans Serif", Font.BOLD, 14));
        add(labCorreos);

        // Correo electrónico 1
        labCorreo1 = new JLabel("hogar20@gmail.com");
        labCorreo1.setBounds(105, 210, 300, 25);
        labCorreo1.setFont(new Font("Times Sans Serif", Font.PLAIN, 14));
        add(labCorreo1);

        // Correo electrónico 2
        labCorreo2 = new JLabel("javiercito1@gmail.com");
        labCorreo2.setBounds(105, 235, 300, 25);
        labCorreo2.setFont(new Font("Times Sans Serif", Font.PLAIN, 14));
        add(labCorreo2);

        // Botón para Teléfono
        botonTelefono = new JButton("☎ Llamar");
        botonTelefono.setBounds(45, 290, 140, 40);
        botonTelefono.setBackground(new Color(62, 89, 175));
        botonTelefono.addActionListener(this);
        add(botonTelefono);

        boton2 = new JButton();
        boton2.setBounds(15, 15, 45, 45);
        boton2.setBackground(new Color(62, 89, 175));
        boton2.addActionListener(this);
        add(boton2);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Manejar eventos de los botones aquí
        if (e.getSource() == botonInstagram) {
            // Acción para el botón de Instagram (por ejemplo, abrir Instagram)
            System.out.println("Acción de Instagram");
        } else if (e.getSource() == botonCamera) {
            // Acción para el botón de Cámara (por ejemplo, abrir cámara)
            System.out.println("Acción de Cámara");
        } else if (e.getSource() == botonTelefono) {
            // Acción para el botón de Teléfono (por ejemplo, realizar llamada)
            System.out.println("Llamando...");
        } else if (e.getSource() == boton2) {
            pantallaUno pantallaUnoScreen = new pantallaUno();
            pantallaUnoScreen.setVisible(true);
            pantallaUnoScreen.setBounds(0 , 0, 362, 640);
            pantallaUnoScreen.setLocationRelativeTo(null);
            dispose();
        }
    }

    public static void main(String[] args) {
        ContactosApp pantalla = new ContactosApp();
        pantalla.setBounds(0, 0, 362, 640); // Ajusta la altura según necesites
        pantalla.getContentPane().setBackground(new Color(209, 243, 219));
        pantalla.setResizable(false);
        pantalla.setLocationRelativeTo(null);
        pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pantalla.setVisible(true);
    }
}