import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class Menu extends JFrame implements ActionListener {
    
    // Declaración de variables
    private JPanel menuPanel;
    private boolean menuVisible = false;
    private JButton menuButton;
    private JPanel panel;
    private JLabel menuTitle;
    private JPanel titlePanel;
    private JPanel centerPanel;
    private JSeparator separator;
    private JButton button;
    private JPanel menuItemPanel;

    public Menu() {
        setTitle("Menú");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(362, 640); // Tamaño de la ventana

        // Crear el contenedor principal con BorderLayout
        panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(209, 243, 219));
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(124, 58, 237), 2),
                BorderFactory.createEmptyBorder(10, 10, 10, 10) // Añadir margen interior
        ));

        // Crear el botón de menú
        menuButton = new JButton("≡");
        menuButton.setBounds(16,16,50,30);
        menuButton.setForeground(new Color(255, 255, 255));
        menuButton.setBackground(new Color(62, 89, 175)); 
        menuButton.addActionListener(this);
        panel.add(menuButton, BorderLayout.NORTH);

        // Crear un panel para el título del menú y centrarlo
        titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setBackground(new Color(209, 243, 219));
        menuTitle = new JLabel("MENÚ");
        menuTitle.setFont(new Font("Playground", 1, 65));
        menuTitle.setForeground(new Color(62, 89, 175));
        titlePanel.add(menuTitle);
        panel.add(titlePanel, BorderLayout.NORTH);

        // Crear el panel para los elementos del menú y centrarlo verticalmente
        centerPanel = new JPanel();
        centerPanel.setBackground(new Color(209, 243, 219));
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        menuPanel = new JPanel();
        menuPanel.setBackground(new Color(209, 243, 219));
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Añadir espacios para centrar el menú verticalmente
        centerPanel.add(Box.createVerticalGlue());
        centerPanel.add(menuPanel);
        centerPanel.add(Box.createVerticalGlue());

        panel.add(centerPanel, BorderLayout.CENTER);

        // Agregar el panel principal al marco
        add(panel);
        setVisible(true);
    }

    private JPanel createMenuItem(String text) {
        menuItemPanel = new JPanel();
        menuItemPanel.setLayout(new BoxLayout(menuItemPanel, BoxLayout.Y_AXIS));
        menuItemPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el elemento del menú

        button = new JButton(text);
        button.setFont(new Font("Times Sans Serif", 3 , 16));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
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
                        login loginScreen = new login();
                        loginScreen.setVisible(true);
                        loginScreen.setBounds(0 , 0, 362, 640);
                        dispose(); // Cierra la ventana del menú
                        break;
                    case "REGISTER":
                        // Acción para REGISTER
                        registro registroScreem = new registro();
                        registroScreem.setVisible(true);
                        registroScreem.setBounds(0, 0, 362, 640);
                        dispose(); // Cierra la ventana del menú
                        break;
                    case "ORGANIZACION":
                        // Acción para ORGANIZACION
                        JOptionPane.showMessageDialog(null, "Navegar a ORGANIZACION");
                        break;
                    case "CONTACTOS":
                    ContactosApp contactosScreem = new ContactosApp();
                    contactosScreem.setVisible(true);
                    dispose(); // cierra la ventana del menú
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
        separator = new JSeparator(SwingConstants.HORIZONTAL);
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
                String[] menuItems = {"¿QUIÉNES SOMOS?", "LOGIN", "REGISTER", "ORGANIZACION", "CONTACTOS", "VOLUNTARIADOS"};
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
        Menu pantalla = new Menu();
        pantalla.setBounds(0, 0, 362, 640);
        pantalla.getContentPane().setBackground(new Color(209, 243, 219));
        pantalla.setResizable(false);
        pantalla.setLocationRelativeTo(null);
        pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pantalla.setVisible(true);
    }
}
