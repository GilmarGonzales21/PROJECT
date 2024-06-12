import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

// Clase principal que extiende JFrame y implementa ActionListener para manejar eventos de botón
public class pantallaPrincipal extends JFrame implements ActionListener {
    private JLabel label1, label2; // Etiquetas de texto
    private CircularButton boton1; // Botón personalizado

    // Constructor de la clase
    public pantallaPrincipal() {
        // Establecer el diseño nulo
        setLayout(null);

        // Crear y configurar la primera etiqueta de texto
        label1 = new JLabel("HOGAR");
        label1.setBounds(25, 60, 300, 80);
        label1.setFont(new Font("Playground", 1, 89));
        label1.setForeground(new Color(62, 89, 175));
        add(label1);

        // Crear y configurar la segunda etiqueta de texto
        label2 = new JLabel("@2024 USIL");
        label2.setBounds(140, 410, 300, 300);
        label2.setFont(new Font("Andale Mono", 3, 12));
        label2.setForeground(new Color(62, 89, 175));
        add(label2);

        // Crear el botón personalizado, establecer su posición y tamaño, y agregarlo al panel
        boton1 = new CircularButton(new ImageIcon("gaseosa.png"));
        boton1.setBounds(30, 170, 300, 300); // Centrar el botón en el panel con un tamaño de 300x300
        boton1.setBackground(new Color(255, 255, 255)); // Establecer el color de fondo del botón
        boton1.addActionListener(this); // Agregar un ActionListener al botón
        add(boton1); // Agregar el botón al panel
    }

    // Método actionPerformed para manejar eventos de botón
    public void actionPerformed(ActionEvent n) {
        // Si el evento proviene del botón1, salir del programa
        if (n.getSource() == boton1) {
            System.exit(0);
        }
    }

    // Método principal para iniciar la aplicación
    public static void main(String args[]) {
        pantallaPrincipal principal = new pantallaPrincipal(); // Crear una instancia de la clase pantallaPrincipal
        principal.setBounds(0, 0, 362, 640); // Establecer el tamaño del marco
        principal.getContentPane().setBackground(new Color(209, 243, 219));
        principal.setResizable(false); // Deshabilitar la capacidad de cambiar el tamaño del marco
        principal.setLocationRelativeTo(null); // Centrar el marco en la pantalla
        principal.setVisible(true); // Hacer visible el marco
    }
}

// Clase CircularButton que extiende JButton para crear un botón personalizado con una imagen
class CircularButton extends JButton {
    private ImageIcon icon;

    // Constructor de la clase
    public CircularButton(ImageIcon icon) {
        super(); // Llamar al constructor de la clase base JButton
        this.icon = icon;
        setContentAreaFilled(false); // Establecer el área de contenido del botón como no rellena
    }

    // Método para dibujar el componente del botón
    protected void paintComponent(Graphics g) {
        if (icon != null) {
            Image img = icon.getImage();
            int diameter = Math.min(getWidth(), getHeight());
            g.setClip(new java.awt.geom.Ellipse2D.Float(0, 0, diameter, diameter)); // Establecer el área de recorte como un círculo
            g.drawImage(img, 0, 0, diameter, diameter, this); // Dibujar la imagen ajustada al tamaño del botón circular
        }
        super.paintComponent(g); // Llamar al método paintComponent de la clase base JButton
    }

    // Método para dibujar el borde del componente del botón
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground()); // Establecer el color del borde del botón
        int diameter = Math.min(getSize().width, getSize().height);
        g.drawOval(0, 0, diameter - 1, diameter - 1); // Dibujar el borde como un óvalo
    }
}
