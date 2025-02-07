import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class pantallaUno extends JFrame implements ActionListener {
    private JLabel label1; // Etiquetas de texto
    private JScrollPane scrollPane; // Área de scroll para las noticias
    private JButton menuButton; // Botón de tres rayitas

    // Constructor de la clase
    public pantallaUno() {
        // Establecer el diseño nulo
        setLayout(null);

        // Crear y configurar el botón de tres rayitas
        menuButton = new JButton("≡");
        menuButton.setBounds(10, 10, 50, 30);
        menuButton.addActionListener(this);
        add(menuButton);

        // Crear y configurar la primera etiqueta de texto
        label1 = new JLabel("HOGAR");
        label1.setBounds(25, 60, 300, 80);
        label1.setFont(new Font("Playground", Font.BOLD, 89));
        label1.setForeground(new Color(62, 89, 175));
        add(label1);

        // Crear el panel que contendrá las noticias
        JPanel newsPanel = new JPanel();
        newsPanel.setLayout(new BoxLayout(newsPanel, BoxLayout.Y_AXIS));
        newsPanel.setBackground(new Color(209, 243, 219)); // Mismo color de fondo que el panel principal
        newsPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Agregar un borde vacío para dar espacio

        // Crear y agregar 10 noticias al panel
        for (int i = 1; i <= 10; i++) {
            JPanel newsItem = createNewsItem("Noticia " + i, "Descripción breve de la noticia " + i);
            newsPanel.add(newsItem);
        }

        // Crear el JScrollPane con el panel de noticias y configurar el scroll vertical
        scrollPane = new JScrollPane(newsPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(0, 170, 350, 435); // Establecer la posición y el tamaño
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(15, 0)); // Configurar el tamaño del scroll vertical
        scrollPane.getViewport().setBackground(new Color(252, 254, 190)); // Configurar el color de fondo del viewport
        add(scrollPane); // Agregar el JScrollPane al panel principal
    }

    // Método para crear un panel de noticia con título y descripción
    private JPanel createNewsItem(String title, String description) {
        JPanel newsItem = new JPanel();
        newsItem.setLayout(new BoxLayout(newsItem, BoxLayout.Y_AXIS));
        newsItem.setBackground(new Color(209, 243, 219)); // Mismo color de fondo que el panel principal

        JLabel newsTitle = new JLabel(title);
        newsTitle.setFont(new Font("Times Sans Serif", 1, 16));
        newsTitle.setForeground(new Color(30, 22, 62));

        JTextArea newsDescription = new JTextArea(description);
        newsDescription.setFont(new Font("Times Sans Serif", 1, 14));
        newsDescription.setForeground(new Color(77, 60, 37));

        newsDescription.setLineWrap(true);
        newsDescription.setWrapStyleWord(true);
        newsDescription.setBackground(new Color(209, 243, 219)); // Mismo color de fondo que el panel principal
        newsDescription.setEditable(false);
        newsDescription.setPreferredSize(new Dimension(280, 100)); // Tamaño fijo para la descripción

        newsItem.add(newsTitle);
        newsItem.add(newsDescription);

        return newsItem;
    }

    // Método actionPerformed para manejar eventos de botón
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuButton) {
            // Crear una instancia de la pantallaDos
            Menu frame = new Menu();
            frame.setBounds(0, 0, 362, 640); // Establecer el tamaño del marco
            frame.getContentPane().setBackground(new Color(242, 228, 217));
            frame.setResizable(false); // Deshabilitar la capacidad de cambiar el tamaño del marco
            frame.setLocationRelativeTo(null); // Centrar el marco en la pantalla
            frame.setVisible(true); // Mostrar la segunda pantalla

            // Ocultar la instancia actual de pantallaUno
            setVisible(false);
        }
    }

    // Método principal para iniciar la aplicación
    public static void main(String args[]) {
        pantallaUno principal = new pantallaUno(); // Crear una instancia de la clase pantallaUno
        principal.setBounds(0, 0, 362, 640); // Establecer el tamaño del marco
        principal.getContentPane().setBackground(new Color(209, 243, 219));
        principal.setResizable(false); // Deshabilitar la capacidad de cambiar el tamaño del marco
        principal.setLocationRelativeTo(null); // Centrar el marco en la pantalla
        principal.setVisible(true); // Hacer visible el marco
    }
}
