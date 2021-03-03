package com.company.ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaPrincipal  {
    private JPanel Principal;
    private JLabel imagen;
    private JButton nuevaVia;
    private JButton MisVias;
    private JFrame frameFondo;


    public PaginaPrincipal() {



        imagen.setIcon(new ImageIcon("Assets/Fondo.png"));
        nuevaVia.setIcon(new ImageIcon("Assets/Botones/boton1.png"));
        MisVias.setIcon(new ImageIcon("Assets/Botones/boton2.png"));
        nuevaVia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Creacion");
                PaginaCreacion creacion = new PaginaCreacion();
                frame.setContentPane(creacion.getPanel());
                creacion.setVentanaCreacion(frame);
                creacion.setFrameVentanaPrincipal(frameFondo);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                nuevaVia.setEnabled(false);


            }
        });
        MisVias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Mis Vías");
                MisVias vias = new MisVias();
                frame.setContentPane(vias.getPanel());
                vias.setFrameVias(frame);
                vias.setFrameVentanaPrincipal(frameFondo);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                MisVias.setEnabled(false);

            }
        });
    }


    public JPanel getVentanaPrincipal() {
        return Principal;
    }


    public void setFrameVentanaPrincipal(JFrame frame) {
        this.frameFondo = frame;

    }
}
