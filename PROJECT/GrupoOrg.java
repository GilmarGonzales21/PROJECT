import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingUtilities;

// Clase principal que extiende JFrame
public class GrupoOrg extends JFrame {
    private JLabel label1, label2, label3, label4, label5, label6; // Etiquetas de texto
    private CircularButton[] botones; // Array de botones personalizados
    private JLayeredPane layeredPane; // Panel en capas para manejar la superposición de botones
    private JButton boton2;

    // Constructor de la clase
    public GrupoOrg() {
        // Establecer el diseño nulo
        setLayout(null);
        setTitle("Organizaciones");

        // Crear y configurar la primera etiqueta de texto
        label1 = new JLabel("ORGANIZACIONES");
        label1.setBounds(25, 20, 300, 55);
        label1.setFont(new Font("Playground", Font.BOLD, 35));
        label1.setForeground(new Color(62, 89, 175));
        add(label1);

        // Crear y configurar la segunda etiqueta de texto
        label2 = new JLabel("@2024 USIL");
        label2.setBounds(140, 560, 300, 30);
        label2.setFont(new Font("Andale Mono", Font.ITALIC, 12));
        label2.setForeground(new Color(62, 89, 175));
        add(label2);

        label3 = new JLabel("TECHO Perú");
        label3.setBounds(42, 280, 300, 25);
        label3.setFont(new Font("Times Sans Serif", Font.BOLD, 17));
        label3.setForeground(new Color(62, 89, 175));
        add(label3);

        label4 = new JLabel("CARITAS Perú");
        label4.setBounds(197, 280, 300, 25);
        label4.setFont(new Font("Times Sans Serif", Font.BOLD, 17));
        label4.setForeground(new Color(62, 89, 175));
        add(label4);

        label5 = new JLabel("TECHO, mi país");
        label5.setBounds(30, 480, 300, 25);
        label5.setFont(new Font("Times Sans Serif", Font.BOLD, 17));
        label5.setForeground(new Color(62, 89, 175));
        add(label5);

        label6 = new JLabel("AYLLU Initiative");
        label6.setBounds(190, 480, 300, 25);
        label6.setFont(new Font("Times Sans Serif", Font.BOLD, 17));
        label6.setForeground(new Color(62, 89, 175));
        add(label6);

        boton2 = new JButton();
        boton2.setBounds(15, 15, 45, 45);
        boton2.setBackground(new Color(62, 89, 175));
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción para el botón 2 (pantallaUno)
                pantallaUno pantallaUnoScreen = new pantallaUno();
                pantallaUnoScreen.setVisible(true);
                pantallaUnoScreen.setBounds(0, 0, 362, 640);
                pantallaUnoScreen.setLocationRelativeTo(null);
                dispose(); // Cierra la ventana del menú
            }
        });
        add(boton2);

        // Inicializar el JLayeredPane
        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 100, 400, 400); // Reducir la altura para acomodar 3 filas de botones
        add(layeredPane);

        // Crear un array de botones personalizados
        botones = new CircularButton[10];
        int x = 30, y = 30; // Coordenadas iniciales
        int buttonSize = 130; // Tamaño de cada botón
        for (int i = 0; i < 10; i++) {
            ImageIcon icon = new ImageIcon("image" + (i + 1) + ".jpg");
            botones[i] = new CircularButton(icon);
            botones[i].setBounds(x, y, buttonSize, buttonSize); // Ajustar la posición y tamaño de los botones
            layeredPane.add(botones[i], Integer.valueOf(i)); // Agregar el botón al panel en capas con índice i

            // Asignar eventos diferentes a cada botón
            final int index = i;
            botones[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    switch (index) {
                        case 0:
                            techoPeru techoPeruScreem = new techoPeru();
                            techoPeruScreem.setVisible(true);
                            techoPeruScreem.setBounds(0, 0, 362, 640);
                            techoPeruScreem.setLocationRelativeTo(null);
                            dispose(); // Cierra la ventana del menú
                            break;
                        case 1:
                            caritasdelPeru caritasdelPeruScreem = new caritasdelPeru();
                            caritasdelPeruScreem.setVisible(true);
                            caritasdelPeruScreem.setBounds(0, 0, 362, 640);
                            caritasdelPeruScreem.setLocationRelativeTo(null);
                            dispose(); // Cierra la ventana del menú
                            break;
                        case 2:
                            unTechoParaMiPais unTechoParaMiPaisScreem = new unTechoParaMiPais();
                            unTechoParaMiPaisScreem.setVisible(true);
                            unTechoParaMiPaisScreem.setBounds(0, 0, 362, 640);
                            unTechoParaMiPaisScreem.setLocationRelativeTo(null);
                            dispose(); // Cierra la ventana del menú
                            break;
                        case 3:
                            aylluInitiative aylluInitiativeScreem = new aylluInitiative();
                            aylluInitiativeScreem.setVisible(true);
                            aylluInitiativeScreem.setBounds(0, 0, 362, 640);
                            aylluInitiativeScreem.setLocationRelativeTo(null);
                            dispose(); // Cierra la ventana del menú
                            break;
                        // Agregar más casos según necesites
                    }
                }
            });

            // Actualizar las coordenadas para el siguiente botón
            x += 160; // Mover a la derecha

            // Cambiar a la siguiente fila después de cada 2 botones
            if ((i + 1) % 2 == 0) {
                x = 30;
                y += 200; // Mover hacia abajo
            }
        }

        // Establecer el tamaño del marco y otras configuraciones
        setBounds(0, 0, 362, 640); // Establecer el tamaño del marco
        getContentPane().setBackground(new Color(209, 243, 219));
        setResizable(false); // Deshabilitar la capacidad de cambiar el tamaño del marco
        setLocationRelativeTo(null); // Centrar el marco en la pantalla
        setVisible(true); // Hacer visible el marco
    }

    // Método principal para iniciar la aplicación
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GrupoOrg(); // Crear una instancia de la clase GrupoOrg
            }
        });
    }
}

// Clase CircularButton que extiende JButton para crear un botón personalizado con una imagen
class CircularButton extends JButton {
    private ImageIcon icon;

    // Constructor de la clase
    public CircularButton(ImageIcon icon) {
        super(icon); // Llamar al constructor de la clase base JButton con el icono
        this.icon = icon;
        setContentAreaFilled(false); // Establecer el área de contenido del botón como no rellena
        setBorderPainted(false); // Eliminar el borde del botón
        setFocusPainted(false); // Eliminar la pintura de enfoque del botón
    }
}
