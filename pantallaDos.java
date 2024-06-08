public class pantalloDos extends JFrame implements ActionListener{
import javax.swing.*;
import java.awt.*;

public class MenuExample {

    public static void main(String[] args) {
        // Crear el marco (window)
        JFrame frame = new JFrame("Menú");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 450);
        
        // Crear el contenedor principal
        JPanel panel = new JPanel();
        panel.setBackground(new Color(242, 228, 217));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 8));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        // Agregar borde interior de color púrpura
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 8),
                BorderFactory.createLineBorder(new Color(124, 58, 237), 2)
        ));
        
        // Crear el encabezado del menú
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(242, 228, 217));
        headerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JLabel menuIcon = new JLabel("☰");
        menuIcon.setFont(new Font("Arial", Font.BOLD, 24));
        
        JLabel menuTitle = new JLabel("MENÚ");
        menuTitle.setFont(new Font("Arial", Font.BOLD, 24));
        
        headerPanel.add(menuIcon);
        headerPanel.add(menuTitle);
        
        panel.add(headerPanel);
        
        // Crear los elementos del menú
        String[] menuItems = {"¿QUIÉNES SOMOS?", "LOGIN", "ORGANIZACION", "CONTACTOS", "VOLUNTARIADOS"};
        
        for (String item : menuItems) {
            panel.add(createMenuItem(item));
        }
        
        // Agregar el panel principal al marco
        frame.add(panel);
        frame.setVisible(true);
    }
    
    private static JPanel createMenuItem(String text) {
        JPanel menuItemPanel = new JPanel();
        menuItemPanel.setBackground(new Color(242, 228, 217));
        menuItemPanel.setLayout(new BoxLayout(menuItemPanel, BoxLayout.Y_AXIS));
        
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JPanel lineAbove = new JPanel();
        lineAbove.setBackground(Color.BLACK);
        lineAbove.setPreferredSize(new Dimension(150, 2));
        lineAbove.setMaximumSize(new Dimension(150, 2));
        
        JPanel lineBelow = new JPanel();
        lineBelow.setBackground(Color.BLACK);
        lineBelow.setPreferredSize(new Dimension(150, 2));
        lineBelow.setMaximumSize(new Dimension(150, 2));
        
        menuItemPanel.add(Box.createVerticalStrut(10));
        menuItemPanel.add(lineAbove);
        menuItemPanel.add(label);
        menuItemPanel.add(lineBelow);
        menuItemPanel.add(Box.createVerticalStrut(10));
        
        return menuItemPanel;
    }
}
}
