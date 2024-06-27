import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class unTechoParaMiPais extends JFrame implements ActionListener{
    JLabel labelTitulo, labelpreConcepto, labelImagen;
    JTextArea textAreaConcepto;
    JButton boton1, boton2;

    // Constructor de la interfaz
    public unTechoParaMiPais() {
        setLayout(null);
        setTitle("¿Quiénes somos?");

        // Configuración del título
        labelTitulo = new JLabel("Un Techo para mi Pais");
        labelTitulo.setBounds(25, 25, 300, 60);
        labelTitulo.setFont(new Font("Playground", Font.BOLD, 24));
        labelTitulo.setForeground(new Color(62, 89, 175));
        add(labelTitulo);

        labelpreConcepto = new JLabel("Nosotros...");
        labelpreConcepto.setBounds(15, 85, 300, 60);
        labelpreConcepto.setFont(new Font("Times Sans Serif", Font.BOLD, 20));
        labelpreConcepto.setForeground(new Color(62, 89, 175));
        add(labelpreConcepto);

        // Configuración del JTextArea para mostrar el texto ocupando todo el ancho disponible
        textAreaConcepto = new JTextArea();
        textAreaConcepto.setBounds(15, 140, 320, 380);
        textAreaConcepto.setFont(new Font("Times Sans Serif", Font.PLAIN, 14));
        textAreaConcepto.setLineWrap(true); // Activar el ajuste automático de línea
        textAreaConcepto.setWrapStyleWord(true); // Ajustar palabras al ajustar líneas
        textAreaConcepto.setEditable(false);
        textAreaConcepto.setBackground(getContentPane().getBackground()); // Para que el fondo coincida con el del JFrame
        textAreaConcepto.setOpaque(false); // Hacer el fondo transparente

        boton1 = new JButton("DONAR");
        boton1.setBounds(85, 525, 180, 50);
        boton1.setFont(new Font("Times Sans Serif", Font.BOLD, 20));
        boton1.setForeground(new Color(255, 255, 255));
        boton1.setBackground(new Color(62, 89, 175));
        boton1.addActionListener(this); // Añadir ActionListener a boton1
        add(boton1);

        boton2 = new JButton();
        boton2.setBounds(15, 15, 45, 45);
        boton2.setBackground(new Color(62, 89, 175));
        boton2.addActionListener(this);
        add(boton2);

        // Texto completo
        String textoCompleto =
                "Un Techo para mi País es una organización que, al igual que TECHO Perú, trabaja en la construcción de viviendas" +
                "de emergencia para familias en situación de pobreza. Además, implementan programas de desarrollo comunitario y fortalecen" +
                "las capacidades de los habitantes para que puedan mejorar sus condiciones de vida de manera sostenible.";

        textAreaConcepto.setText(textoCompleto);

        // Ajustar el ancho del JTextArea para ocupar todo el ancho disponible
        int anchoVentana = 340; // Ancho de la ventana
        int margenIzquierdo = 15; // Margen izquierdo del JTextArea
        int margenDerecho = 15; // Margen derecho del JTextArea
        textAreaConcepto.setColumns((anchoVentana - margenIzquierdo - margenDerecho) / 9); // Ajustar el número de columnas

        add(textAreaConcepto);

        // Añadir la imagen en la parte inferior
        labelImagen = new JLabel();
        labelImagen.setBounds(15, 310, 318, 200); // Ajustar las coordenadas y tamaño según sea necesario
        ImageIcon icon = new ImageIcon("untechoparamipais.jpg"); // Cambia esto a la ruta de tu imagen
        labelImagen.setIcon(icon);
        add(labelImagen);
    }

    // Método principal para iniciar la aplicación
    public static void main(String args[]) {
        unTechoParaMiPais pantalla = new unTechoParaMiPais();
        pantalla.setBounds(0, 0, 362, 640);
        pantalla.getContentPane().setBackground(new Color(209, 243, 219));
        pantalla.setResizable(false);
        pantalla.setLocationRelativeTo(null);
        pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pantalla.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1) {
            // Acciones para el botón 1 (boton1)
            Tarjeta TarjetaScreen = new Tarjeta();
            TarjetaScreen.setVisible(true);
            TarjetaScreen.setBounds(0, 0, 362, 640);
            TarjetaScreen.setLocationRelativeTo(null);
            dispose(); // Cierra la ventana del menú actual (unTechoParaMiPais)
        } else if (e.getSource() == boton2) {
            pantallaUno pantallaUnoScreen = new pantallaUno();
            pantallaUnoScreen.setVisible(true);
            pantallaUnoScreen.setBounds(0, 0, 362, 640);
            pantallaUnoScreen.setLocationRelativeTo(null);
            dispose(); // Cierra la ventana del menú actual (unTechoParaMiPais)
        }
    }
}
