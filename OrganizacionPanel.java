import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class OrganizacionPanel extends JPanel {

    // Constructor que inicializa el panel con la información estática de la organización
    public OrganizacionPanel() {
        initComponents();
    }

    // Método para inicializar componentes gráficos
    private void initComponents() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(342, 600)); // Establecer dimensiones preferidas

        // Panel para el encabezado de la organización
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setBackground(new Color(209, 243, 219)); // Color de fondo
        headerPanel.setBorder(new EmptyBorder(20, 20, 20, 20)); // Borde con espacios

        // Etiqueta para mostrar el nombre de la organización
        JLabel nombreLabel = new JLabel("Techo");
        nombreLabel.setFont(new Font("Arial", Font.BOLD, 28));
        nombreLabel.setForeground(new Color(62, 89, 175)); // Color azul oscuro
        headerPanel.add(nombreLabel);

        // Espacio entre el nombre y la descripción
        headerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Etiqueta para mostrar la descripción de la organización
        JTextArea descripcionArea = new JTextArea(
                "Somos una organización conformada por jóvenes voluntarios y voluntarias junto con habitantes de asentamientos populares de América Latina.\n\n"
                        + "Mediante nuestra acción conjunta, trabajamos en superar la situación de pobreza en la que viven millones de personas.");
        descripcionArea.setFont(new Font("Arial", Font.PLAIN, 16));
        descripcionArea.setForeground(new Color(77, 60, 37)); // Color de texto oscuro
        descripcionArea.setLineWrap(true);
        descripcionArea.setWrapStyleWord(true);
        descripcionArea.setBackground(new Color(209, 243, 219)); // Color de fondo
        descripcionArea.setEditable(false);
        descripcionArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Borde interior
        headerPanel.add(descripcionArea);

        // Espacio entre la descripción y las funciones principales
        headerPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Etiqueta para las funciones principales
        JLabel funcionesLabel = new JLabel("Funciones principales:");
        funcionesLabel.setFont(new Font("Arial", Font.BOLD, 18));
        funcionesLabel.setForeground(new Color(62, 89, 175)); // Color azul oscuro
        headerPanel.add(funcionesLabel);

        // Lista de funciones principales
        String funciones = "<html>"
                + "<ul>"
                + "<li>Construcción de viviendas dignas.</li>"
                + "<li>Capacitación y desarrollo comunitario.</li>"
                + "<li>Promoción de derechos y acceso a servicios básicos.</li>"
                + "</ul>"
                + "</html>";
        JLabel funcionesList = new JLabel(funciones);
        funcionesList.setFont(new Font("Arial", Font.PLAIN, 16));
        funcionesList.setForeground(new Color(77, 60, 37)); // Color de texto oscuro
        headerPanel.add(funcionesList);

        // Espacio entre las funciones y el objetivo
        headerPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Etiqueta para el objetivo
        JLabel objetivoLabel = new JLabel("Objetivo:");
        objetivoLabel.setFont(new Font("Arial", Font.BOLD, 18));
        objetivoLabel.setForeground(new Color(62, 89, 175)); // Color azul oscuro
        headerPanel.add(objetivoLabel);

        // Descripción del objetivo
        JTextArea objetivoArea = new JTextArea(
                "Nuestro objetivo principal es mejorar las condiciones de vida de las comunidades más vulnerables, proporcionando acceso a viviendas seguras y promoviendo el desarrollo integral.");
        objetivoArea.setFont(new Font("Arial", Font.PLAIN, 16));
        objetivoArea.setForeground(new Color(77, 60, 37)); // Color de texto oscuro
        objetivoArea.setLineWrap(true);
        objetivoArea.setWrapStyleWord(true);
        objetivoArea.setBackground(new Color(209, 243, 219)); // Color de fondo
        objetivoArea.setEditable(false);
        objetivoArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Borde interior
        headerPanel.add(objetivoArea);

        // Espacio entre el objetivo y la imagen
        headerPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Etiqueta para la imagen de la organización
        JLabel imagenLabel = new JLabel("Aquí va la imagen de la organización");
        imagenLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        imagenLabel.setForeground(new Color(77, 60, 37)); // Color de texto oscuro
        imagenLabel.setHorizontalAlignment(JLabel.CENTER);
        headerPanel.add(imagenLabel);

        // Agregar el panel de encabezado al panel principal
        add(headerPanel, BorderLayout.CENTER);
    }

    // Método principal para pruebas simples
    public static void main(String[] args) {
        // Crear una instancia de JFrame
        JFrame frame = new JFrame("Información de Organización");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear un panel de OrganizacionPanel
        OrganizacionPanel organizacionPanel = new OrganizacionPanel();

        // Agregar el panel al JFrame
        frame.getContentPane().add(organizacionPanel);
        frame.pack();
        frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        frame.setVisible(true);
    }
}
