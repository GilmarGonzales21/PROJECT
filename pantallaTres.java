import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class pantallaThree extends JFrame implements ActionListener{
    private JLabel labContacto, labNumero, labRedes, labCorreos, labCorreo1, labCorreo2;
    private JButton boton1, boton2, boton3;

    public pantallaThree(){
        setLayout(null);
        setTitle("Informes");

        labContacto = new JLabel("CONTACTOS");
        labContacto.setBounds(75, 20, 300, 55);
        labContacto.setFont(new Font("Playground", 1, 40));
        labContacto.setForeground(new Color(62, 89, 175));
        add(labContacto);

        labNumero = new JLabel("Número:");
        labNumero.setBounds(35, 105, 100, 20);
        labNumero.setFont(new Font("Times Sans Serif", 1, 14));
        add(labNumero);

        
        labNumero = new JLabel("998 992 868");
        labNumero.setBounds(105, 105, 100, 20);
        labNumero.setFont(new Font("Times Sans Serif", 1, 14));
        add(labNumero);

        labRedes = new JLabel("Redes:");
        labRedes.setBounds(35, 140, 300, 55);
        labRedes.setFont(new Font("Times Sans Serif", 1, 14));
        add(labRedes);

        labCorreos = new JLabel("Correos:");
        labCorreos.setBounds(35, 210, 300, 55);
        labCorreos.setFont(new Font("Times Sans Serif", 1, 14));
        add(labCorreos);
        
        labCorreo1 = new JLabel("hogar20@gmail.com");
        labCorreo1.setBounds( 105, 210, 300, 55);
        labCorreo1.setFont(new Font("Times Sans Serif", 1, 14));
        add(labCorreo1);
        
        labCorreo2 = new JLabel("javiercito1@gmail.com");
        labCorreo2.setBounds(105, 230, 300, 55);
        labCorreo2.setFont(new Font("Times Sans Serif", 1, 14));
        add(labCorreo2);

        boton1 = new JButton();
        boton1.setBounds(107, 140, 60, 40);
        boton1.setBackground(new Color(62, 89, 175));
        boton1.addActionListener(this);
        add(boton1);
 
        boton2 = new JButton();
        boton2.setBounds(190, 140, 60, 40);
        boton2.setBackground(new Color(62, 89, 175));
        boton2.addActionListener(this);
        add(boton2);
        
        boton3 = new JButton();
        boton3.setBounds(45, 490, 140, 40);
        boton3.setBackground(new Color(62, 89, 175));
        boton3.addActionListener(this);
        add(boton3);
    }

    public void actionPerformed(ActionEvent n){
    
    }

    public static void main(String[] args) {
        pantallaThree pantalla = new pantallaThree();
        pantalla.setBounds(0, 0, 362, 640);
        pantalla.getContentPane().setBackground(new Color(209, 243, 219));
        pantalla.setResizable(false);
        pantalla.setLocationRelativeTo(null);
        pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pantalla.setVisible(true);
    }
}
