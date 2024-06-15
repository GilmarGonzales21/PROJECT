import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

// Clase principal que extiende JFrame
public class GrupoOrg extends JFrame {
    private JLabel label1, label2; // Etiquetas de texto
    private CircularButton[] botones; // Array de botones personalizados
    private JLayeredPane layeredPane; // Panel en capas para manejar la superposición de botones

    // Constructor de la clase
    public GrupoOrg() {
        // Establecer el diseño nulo
        setLayout(null);
        setTitle("Organizaciones");

        // Crear y configurar la primera etiqueta de texto
        label1 = new JLabel("ORGANIZACIONES");
        label1.setBounds(25, 20, 300, 50);
        label1.setFont(new Font("Arial", Font.BOLD, 25));
        label1.setForeground(new Color(62, 89, 175));
        add(label1);

        // Crear y configurar la segunda etiqueta de texto
        label2 = new JLabel("@2024 USIL");
        label2.setBounds(140, 570, 300, 30);
        label2.setFont(new Font("Andale Mono", Font.ITALIC, 12));
        label2.setForeground(new Color(62, 89, 175));
        add(label2);

        // Inicializar el JLayeredPane
        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 100, 362, 480); // Reducido la altura para acomodar 3 filas de botones
        add(layeredPane);

        // Crear un array de botones personalizados
        botones = new CircularButton[10];
        int x = 30, y = 0; // Coordenadas iniciales
        int buttonSize = 100; // Tamaño de cada botón
        for (int i = 0; i < 10; i++) {
            botones[i] = new CircularButton(new ImageIcon("image" + (i + 1) + ".jpg"));
            botones[i].setBounds(x, y, buttonSize, buttonSize); // Ajustar la posición y tamaño de los botones
            botones[i].setBackground(new Color(255, 255, 255)); // Establecer el color de fondo del botón
            layeredPane.add(botones[i], Integer.valueOf(i)); // Agregar el botón al panel en capas con índice i

            // Actualizar las coordenadas para el siguiente botón
            x += 120; // Mover a la derecha

            // Cambiar a la siguiente fila después de cada 3 botones
            if ((i + 1) % 3 == 0) {
                x = 30;
                y += 120; // Mover hacia abajo
            }
        }
    }

    // Método principal para iniciar la aplicación
    public static void main(String args[]) {
        GrupoOrg principal = new GrupoOrg(); // Crear una instancia de la clase GrupoOrg
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
            int diameter = Math.min(getWidth() - 10, getHeight() - 10); // Reducir el tamaño para que quede centrado
            int x = (getWidth() - diameter) / 2;
            int y = (getHeight() - diameter) / 2;
            g.setClip(new java.awt.geom.Ellipse2D.Float(x, y, diameter, diameter)); // Establecer el área de recorte como un círculo
            g.drawImage(img, x, y, diameter, diameter, this); // Dibujar la imagen ajustada al tamaño del botón circular
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
