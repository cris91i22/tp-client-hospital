package com.tp.up.client.ui;

import javax.swing.*;
import java.awt.*;

/*
 * FUNCION: Administrar los LayOuts de cada Panel.
 * 			Hay 2 paneles: Para botones y para texto de entrada/salida.
 * 			Todos los componentes tienen que estar contenidos en el Container.
 */


public class MainFrame extends JFrame {
    
	private MainPanel mp = new MainPanel();
	
	public MainFrame(){
        super("Hospital");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        JPanel panelBotones =new JPanel();
        JPanel panelMensajes =new JPanel();
        
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelMensajes.setLayout(new BoxLayout(panelMensajes, BoxLayout.Y_AXIS));
        
        panelBotones.add(mp.getMostrarPacientes());
        panelBotones.add(Box.createVerticalGlue());
        panelBotones.add(mp.getMostrarConsultas());
        panelBotones.add(Box.createVerticalGlue());
        panelBotones.add(mp.getCrearPaciente());
        panelBotones.add(Box.createVerticalGlue());
        panelBotones.add(mp.getCrearConsulta());
        panelBotones.add(Box.createVerticalGlue());
        panelBotones.add(mp.getBorrarPaciente());
        panelBotones.add(Box.createVerticalGlue());
        panelBotones.add(mp.getAtenderPaciente());
        panelBotones.add(Box.createVerticalGlue());
        panelBotones.add(mp.getFinalizarConsulta());
        
        panelMensajes.add(mp.getTextMostrarP());
        panelMensajes.add(mp.getTextMostrarC());
        panelMensajes.add(mp.getTextCrearP());
        panelMensajes.add(mp.getTextCrearC());
        panelMensajes.add(mp.getTextBorrarP());
        panelMensajes.add(mp.getTextAtenderP());
        panelMensajes.add(mp.getTextFinalizarC());
        
        //panelMensajes.setBorder(BorderFactory.createCompoundBorder(
          //      BorderFactory.createLineBorder(Color.red),
            //    panelMensajes.getBorder()));
        
        Container c = getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.X_AXIS));
        
        c.add(panelBotones);
        c.add(panelMensajes);
        
        pack();
        setSize(800, 600);
        setVisible(true);

    }
	
}
