public class pantalloDos extends JFrame implements ActionListener{
import javax.swing.*;
import java.awt.*;

public class MenuExample {

    public static void main(String[] args) {
        // Crear el marco (window)
        JFrame frame = new JFrame("Menú");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(362, 640); // Aumentar el tamaño de la ventana
        
        // Crear el contenedor principal con BorderLayout
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(242, 228, 217));
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(124, 58, 237), 2),
                BorderFactory.createEmptyBorder(10, 10, 10, 10) // Añadir margen interior
        ));
        
        // Crear el encabezado del menú
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(242, 228, 217));
        headerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        // Cargar el ícono de la imagen
        ImageIcon menuIcon = new ImageIcon("rayita.png"); // Ajusta la ruta según tu entorno
        JLabel menuIconLabel = new JLabel(menuIcon);
        
        JLabel menuTitle = new JLabel("MENÚ");
        menuTitle.setFont(new Font("Arial", Font.BOLD, 24));
        
        headerPanel.add(menuIconLabel);
        headerPanel.add(menuTitle);
        
        panel.add(headerPanel, BorderLayout.NORTH);
        
        // Crear el panel para los elementos del menú y centrarlo verticalmente
        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(new Color(242, 228, 217));
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Crear los elementos del menú
        String[] menuItems = {"¿QUIÉNES SOMOS?", "LOGIN", "ORGANIZACION", "CONTACTOS", "VOLUNTARIADOS"};
        
        for (String item : menuItems) {
            menuPanel.add(createMenuItem(item));
        }
        
        // Crear un panel para centrar verticalmente los elementos del menú
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(242, 228, 217));
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(Box.createVerticalGlue());
        centerPanel.add(menuPanel);
        centerPanel.add(Box.createVerticalGlue());
        
        panel.add(centerPanel, BorderLayout.CENTER);
        
        // Agregar el panel principal al marco
        frame.add(panel);
        frame.setVisible(true);
    }
    
    private static JPanel createMenuItem(String text) {
        JPanel menuItemPanel = new JPanel();
        menuItemPanel.setBackground(new Color(242, 228, 217));
        menuItemPanel.setLayout(new BoxLayout(menuItemPanel, BoxLayout.Y_AXIS));
        menuItemPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el elemento del menú
        
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JPanel lineAbove = new JPanel();
        lineAbove.setBackground(Color.BLACK);
        lineAbove.setPreferredSize(new Dimension(100, 2)); // Reducir el tamaño de las rayitas
        lineAbove.setMaximumSize(new Dimension(100, 2));
        
        JPanel lineBelow = new JPanel();
        lineBelow.setBackground(Color.BLACK);
        lineBelow.setPreferredSize(new Dimension(100, 2)); // Reducir el tamaño de las rayitas
        lineBelow.setMaximumSize(new Dimension(100, 2));
        
        menuItemPanel.add(Box.createVerticalStrut(5)); // Reducir el margen superior
        menuItemPanel.add(lineAbove);
        menuItemPanel.add(label);
        menuItemPanel.add(lineBelow);
        menuItemPanel.add(Box.createVerticalStrut(5)); // Reducir el margen inferior
        
        return menuItemPanel;
    }
}
}
