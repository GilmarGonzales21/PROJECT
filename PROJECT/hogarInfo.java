import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class hogarInfo extends JFrame implements ActionListener {
    private JLabel labelTitulo, labelPreConcepto, labelImagen;
    private JTextArea textAreaConcepto, textAreaPropositos, textAreaValores;
    private JButton boton1;

    public hogarInfo() {
        setLayout(null);

        // Título "HOGAR"
        labelTitulo = new JLabel("HOGAR");
        labelTitulo.setBounds(100, 20, 200, 50);
        labelTitulo.setFont(new Font("Playground", Font.BOLD, 50));
        labelTitulo.setForeground(new Color(62, 89, 175));
        add(labelTitulo);

        // Etiqueta "Nosotros..."
        labelPreConcepto = new JLabel("Nosotros...");
        labelPreConcepto.setBounds(15, 70, 200, 20);
        labelPreConcepto.setFont(new Font("Times Sans Serif", Font.BOLD, 14));
        labelPreConcepto.setForeground(new Color(62, 89, 175));
        add(labelPreConcepto);

        // JTextArea para el concepto principal
        textAreaConcepto = new JTextArea();
        textAreaConcepto.setBounds(15, 100, 330, 150);
        textAreaConcepto.setFont(new Font("Times Sans Serif", Font.PLAIN, 12));
        textAreaConcepto.setLineWrap(true);
        textAreaConcepto.setWrapStyleWord(true);
        textAreaConcepto.setEditable(false);
        textAreaConcepto.setBackground(getContentPane().getBackground());
        textAreaConcepto.setOpaque(false);

        boton1 = new JButton();
        boton1.setBounds(15, 15, 45, 45);
        boton1.setBackground(new Color(62, 89, 175));
        boton1.addActionListener(this);
        add(boton1);

        // Texto completo del concepto
        String textoConcepto = "Somos una organización conformada por jóvenes voluntarios y voluntarias, " +
                "junto con los habitantes de asentamientos populares de América Latina. " +
                "Trabajamos para superar la pobreza en estos asentamientos, promoviendo " +
                "el desarrollo sostenible y la inclusión social. Creemos firmemente que " +
                "cada persona merece vivir con dignidad, seguridad y bienestar.";
        textAreaConcepto.setText(textoConcepto);
        add(textAreaConcepto); // Aquí es donde se agrega el textAreaConcepto correctamente

        // JTextArea para los propósitos
        textAreaPropositos = new JTextArea();
        textAreaPropositos.setBounds(15, 210, 330, 90);
        textAreaPropositos.setFont(new Font("Times Sans Serif", Font.PLAIN, 12));
        textAreaPropositos.setLineWrap(true);
        textAreaPropositos.setWrapStyleWord(true);
        textAreaPropositos.setEditable(false);
        textAreaPropositos.setBackground(getContentPane().getBackground());
        textAreaPropositos.setOpaque(false);

        // Texto de los propósitos
        String textoPropositos = "NUESTROS PROPÓSITOS\n" +
                "• Superar la pobreza en asentamientos populares.\n" +
                "• Formar a jóvenes voluntarios y voluntarias mediante la colaboración.";
        textAreaPropositos.setText(textoPropositos);
        add(textAreaPropositos);

        // JTextArea para los valores
        textAreaValores = new JTextArea();
        textAreaValores.setBounds(15, 310, 330, 180);
        textAreaValores.setFont(new Font("Times Sans Serif", Font.PLAIN, 12));
        textAreaValores.setLineWrap(true);
        textAreaValores.setWrapStyleWord(true);
        textAreaValores.setEditable(false);
        textAreaValores.setBackground(getContentPane().getBackground());
        textAreaValores.setOpaque(false);

        // Texto de los valores
        String textoValores = "VALORES\n" +
                "Solidaridad: Actuamos en búsqueda del bien común y contra las injusticias.\n" +
                "Convicción: Tenemos la certeza de que, a través de nuestro trabajo, vamos a mejorar la sociedad.\n" +
                "Diversidad: Enriquecemos nuestro propósito a través de la colaboración entre personas diferentes.\n" +
                "Optimismo: Somos creativos y proactivos en el desarrollo de soluciones.\n" +
                "Excelencia: Realizamos proyectos de calidad apuntando a una mejora permanente.";
        textAreaValores.setText(textoValores);
        add(textAreaValores);

        // Imagen asociada
        labelImagen = new JLabel();
        labelImagen.setBounds(15, 500, 317, 110);
        ImageIcon icono = new ImageIcon("hogar12345.jpg"); // Ajustar la ruta de la imagen según corresponda
        labelImagen.setIcon(icono);
        add(labelImagen);

        // Configuración básica del JFrame
        setTitle("Información de la Organización");
        setBounds(0, 0, 362, 640); // Dimensiones específicas de la ventana
        getContentPane().setBackground(new Color(209, 243, 219));
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        hogarInfo pantalla = new hogarInfo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        pantallaUno pantallaUnoScreen = new pantallaUno();
        pantallaUnoScreen.setVisible(true);
        pantallaUnoScreen.setBounds(0 , 0, 362, 640);
        pantallaUnoScreen.setLocationRelativeTo(null);
        dispose();
    }
}
