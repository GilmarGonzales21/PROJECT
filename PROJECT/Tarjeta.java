import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Tarjeta extends JFrame implements ActionListener {

    JTextField campoMonto, campoNumeroTarjeta, campoFechaVencimiento, campoCvc;
    JButton botonDonar, boton2;

    // Constructor de la ventana de donativos
    public Tarjeta() {
        setTitle("Donar");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        // Panel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(209, 243, 219));
        
        // Configuración del título
        JLabel labelTitulo = new JLabel("Donar");
        labelTitulo.setBounds(50, 15, 262, 100); // Ajustamos el tamaño y posición del título
        labelTitulo.setFont(new Font("Playground", Font.BOLD, 60)); // Ajustamos el tamaño de la fuente
        labelTitulo.setForeground(new Color(62, 89, 175));
        labelTitulo.setHorizontalAlignment(JLabel.CENTER); // Centramos horizontalmente
        labelTitulo.setVerticalAlignment(JLabel.CENTER); // Centramos verticalmente
        mainPanel.add(labelTitulo);

        // Campos para la información de la tarjeta
        JLabel labelMonto = new JLabel("Monto a donar:");
        labelMonto.setBounds(30, 140, 150, 25);
        labelMonto.setFont(new Font("Times Sans Serif", Font.PLAIN, 14));
        labelMonto.setForeground(new Color(62, 89, 175));
        mainPanel.add(labelMonto);

        campoMonto = new JTextField();
        campoMonto.setBounds(180, 140, 150, 25);
        mainPanel.add(campoMonto);

        JLabel labelNumeroTarjeta = new JLabel("Número de tarjeta:");
        labelNumeroTarjeta.setBounds(30, 180, 150, 25);
        labelNumeroTarjeta.setFont(new Font("Times Sans Serif", Font.PLAIN, 14));
        labelNumeroTarjeta.setForeground(new Color(62, 89, 175));
        mainPanel.add(labelNumeroTarjeta);

        campoNumeroTarjeta = new JTextField();
        campoNumeroTarjeta.setBounds(180, 180, 150, 25);
        mainPanel.add(campoNumeroTarjeta);

        JLabel labelFechaVencimiento = new JLabel("Fecha de vencimiento:");
        labelFechaVencimiento.setBounds(30, 220, 150, 25);
        labelFechaVencimiento.setFont(new Font("Times Sans Serif", Font.PLAIN, 14));
        labelFechaVencimiento.setForeground(new Color(62, 89, 175));
        mainPanel.add(labelFechaVencimiento);

        campoFechaVencimiento = new JTextField();
        campoFechaVencimiento.setBounds(180, 220, 150, 25);
        mainPanel.add(campoFechaVencimiento);

        JLabel labelCvc = new JLabel("CVC:");
        labelCvc.setBounds(30, 260, 150, 25);
        labelCvc.setFont(new Font("Times Sans Serif", Font.PLAIN, 14));
        labelCvc.setForeground(new Color(62, 89, 175));
        mainPanel.add(labelCvc);

        campoCvc = new JTextField();
        campoCvc.setBounds(180, 260, 150, 25);
        mainPanel.add(campoCvc);

        // Botón para realizar la donación con bordes a los costados
        botonDonar = new JButton("Donar");
        botonDonar.setBounds(100, 330, 160, 40); // Aumentamos el tamaño del botón
        botonDonar.setFont(new Font("Times Sans Serif", Font.BOLD, 16)); // Ajustamos la fuente del botón
        botonDonar.setForeground(Color.WHITE);
        botonDonar.setBackground(new Color(62, 89, 175));
        botonDonar.addActionListener(this);
        mainPanel.add(botonDonar);

        // Añadir la imagen en la parte inferior
        JLabel labelImagen = new JLabel();
        labelImagen.setBounds(15, 380, 318, 200); // Ajustar las coordenadas y tamaño según sea necesario
        ImageIcon icon = new ImageIcon("techoperu.jpeg"); // Cambiar esto a la ruta de tu imagen
        labelImagen.setIcon(icon);
        mainPanel.add(labelImagen);

        boton2 = new JButton();
        boton2.setBounds(15, 15, 45, 45);
        boton2.setBackground(new Color(62, 89, 175));
        boton2.addActionListener(this);
        mainPanel.add(boton2);

        // Añadir el panel principal al JFrame
        getContentPane().add(mainPanel);
        setSize(362, 640); // Establecer el tamaño del JFrame
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
    }

    // Método actionPerformed para manejar eventos de acción
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonDonar) {
            realizarDonacion();
        } else if (e.getSource() == boton2) {
            abrirVentanaPantallaUno();
        }
    }

    // Método para realizar la acción de donación
    private void realizarDonacion() {
        String monto = campoMonto.getText();
        String numeroTarjeta = campoNumeroTarjeta.getText();
        String fechaVencimiento = campoFechaVencimiento.getText();
        String cvc = campoCvc.getText();

        // Aquí podrías añadir validaciones más robustas
        if (monto.isEmpty() || numeroTarjeta.isEmpty() || fechaVencimiento.isEmpty() || cvc.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Gracias por su donación");
        }
    }

    // Método para abrir la ventana pantallaUno
    private void abrirVentanaPantallaUno() {
        dispose(); // Cierra la ventana actual (Tarjeta)
        pantallaUno pantallaUnoScreen = new pantallaUno();
        pantallaUnoScreen.setVisible(true);
        pantallaUnoScreen.setBounds(0, 0, 362, 640);
        pantallaUnoScreen.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        Tarjeta ventana = new Tarjeta();
        ventana.setVisible(true);
    }
}
