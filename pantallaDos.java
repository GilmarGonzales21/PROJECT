import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class pantallaDos extends JFrame implements ActionListener {

    private JPanel menuPanel;
    private boolean menuVisible = false;

    public pantallaDos() {
        setTitle("Menú");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(362, 640); // Tamaño de la ventana

        // Crear el contenedor principal con BorderLayout
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(242, 228, 217));
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(124, 58, 237), 2),
                BorderFactory.createEmptyBorder(10, 10, 10, 10) // Añadir margen interior
        ));

        // Crear el botón de menú
        JButton menuButton = new JButton("≡");
        menuButton.setBounds(10,10,50,30); // Ajustar el tamaño del botón
        menuButton.addActionListener(this);
        panel.add(menuButton);

        // Crear el título del menú
        JLabel menuTitle = new JLabel("MENÚ");
        menuTitle.setFont(new Font("Arial", Font.BOLD, 24));
        menuTitle.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(menuTitle, BorderLayout.NORTH);

        // Crear el panel para los elementos del menú y centrarlo verticalmente
        menuPanel = new JPanel();
        menuPanel.setBackground(new Color(242, 228, 217));
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(menuPanel, BorderLayout.CENTER);

        // Agregar el panel principal al marco
        add(panel);
        setVisible(true);
    }

    private JPanel createMenuItem(String text) {
        JPanel menuItemPanel = new JPanel();
        menuItemPanel.setBackground(new Color(242, 228, 217));
        menuItemPanel.setLayout(new BoxLayout(menuItemPanel, BoxLayout.Y_AXIS));
        menuItemPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el elemento del menú

        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setBackground(new Color(242, 228, 217));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setOpaque(false);

        // Añadir ActionListener para cada botón
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Definir las acciones para cada botón
                switch (text) {
                    case "¿QUIÉNES SOMOS?":
                        // Acción para ¿QUIÉNES SOMOS?
                        JOptionPane.showMessageDialog(null, "Navegar a ¿QUIÉNES SOMOS?");
                        break;
                    case "LOGIN":
                        // Acción para LOGIN
                        JOptionPane.showMessageDialog(null, "Navegar a LOGIN");
                        break;
                    case "ORGANIZACION":
                        // Acción para ORGANIZACION
                        JOptionPane.showMessageDialog(null, "Navegar a ORGANIZACION");
                        break;
                    case "CONTACTOS":
                        // Acción para CONTACTOS
                        JOptionPane.showMessageDialog(null, "Navegar a CONTACTOS");
                        break;
                    case "VOLUNTARIADOS":
                        // Acción para VOLUNTARIADOS
                        JOptionPane.showMessageDialog(null, "Navegar a VOLUNTARIADOS");
                        break;
                }
            }
        });

        menuItemPanel.add(button);

        return menuItemPanel;
    }

    private JSeparator createSeparator() {
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setForeground(Color.BLACK);
        return separator;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("≡")) {
            // Mostrar u ocultar el menú
            if (!menuVisible) {
                // Limpiar el panel antes de agregar los elementos del menú
                menuPanel.removeAll();
                // Crear los elementos del menú
                String[] menuItems = {"¿QUIÉNES SOMOS?", "LOGIN", "ORGANIZACION", "CONTACTOS", "VOLUNTARIADOS"};
                for (String item : menuItems) {
                    menuPanel.add(createMenuItem(item));
                    menuPanel.add(createSeparator());
                }
                // Actualizar el panel
                menuPanel.revalidate();
                menuPanel.repaint();
            } else {
                // Limpiar el panel si el menú está oculto
                menuPanel.removeAll();
                menuPanel.revalidate();
                menuPanel.repaint();
            }
            menuVisible = !menuVisible;
        }
    }

    public static void main(String[] args) {
        new pantallaDos();
    }
}
