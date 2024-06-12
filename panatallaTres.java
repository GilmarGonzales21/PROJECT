public class pantallaTres extends JFrame implements ActionListener{
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

public class ContactosApp extends JFrame implements ActionListener {

    public ContactosApp() {
        setTitle("Contactos");
        setSize(362, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon("C:\\Users\\ROGER\\Music\\instagram.jpg");
                g.drawImage(icon.getImage(), 0, 0, null);
            }
        };

        // Panel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(245, 235, 215));

        // Menú de hamburguesa
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuPanel.setBackground(new Color(245, 235, 215));
        JButton menuButton = new JButton("≡");
        menuButton.setPreferredSize(new Dimension(50, 30)); // Ajustar tamaño del botón
        menuButton.addActionListener(this);
        menuPanel.add(menuButton);

        // Título
        JLabel titleLabel = new JLabel("CONTACTOS");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Número de contacto
        JPanel numberPanel = new JPanel();
        numberPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        numberPanel.setBackground(new Color(245, 235, 215));
        JLabel numberLabel = new JLabel("NÚMERO: 984 577 322");
        numberLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        JButton callButton = createCircularButton("📞", new Color(245, 235, 215));
        numberPanel.add(numberLabel);
        numberPanel.add(callButton);

        // Redes sociales
        JPanel redesPanel = new JPanel();
        redesPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        redesPanel.setBackground(new Color(245, 235, 215));
        JLabel redesLabel = new JLabel("REDES:");
        redesLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        redesPanel.add(redesLabel);

        JButton facebookButton = createCircularButton("F", new Color(245, 235, 215));
        JButton instagramButton = createCircularButton("📸", new Color(245, 235, 215));
        JButton linkButton = createCircularButton("🔗", new Color(245, 235, 215));
        redesPanel.add(facebookButton);
        redesPanel.add(instagramButton);
        redesPanel.add(linkButton);

        // Correos
        JPanel correosPanel = new JPanel();
        correosPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        correosPanel.setBackground(new Color(245, 235, 215));
        JLabel correosLabel = new JLabel("CORREOS:");
        correosLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        correosPanel.add(correosLabel);

        JLabel emailLabel1 = new JLabel("hogar20@GMAIL.COM");
        JLabel emailLabel2 = new JLabel("nayeli2401@GMAIL.COM");
        correosPanel.add(emailLabel1);
        correosPanel.add(emailLabel2);

        // Logo
        JButton logoButton = createCircularButton("Hogar", new Color(245, 235, 215));
        logoButton.setFont(new Font("Arial", Font.ITALIC, 24));
        logoButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Agregar componentes al panel principal
        mainPanel.add(menuPanel);
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(numberPanel);
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(redesPanel);
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(correosPanel);
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(logoButton);
        mainPanel.add(Box.createVerticalGlue());

        add(mainPanel, BorderLayout.CENTER);
    }

    private JButton createCircularButton(String label, Color backgroundColor) {
        JButton button = new JButton(label) {
            @Override
            protected void paintComponent(Graphics g) {
                if (getModel().isArmed()) {
                    g.setColor(Color.LIGHT_GRAY);
                } else {
                    g.setColor(backgroundColor);
                }
                g.fillOval(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }

            @Override
            protected void paintBorder(Graphics g) {
                // No pintamos el borde
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(50, 50); // Tamaño circular
            }

            @Override
            public boolean contains(int x, int y) {
                Ellipse2D shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
                return shape.contains(x, y);
            }
        };
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(false);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Acciones del botón de menú
    }

    public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        ContactosApp app = new ContactosApp();
        app.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        app.setVisible(true);
    });
}
}


}


