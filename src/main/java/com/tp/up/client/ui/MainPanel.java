package com.tp.up.client.ui;

import javax.swing.*;

import com.tp.up.client.Proxy;
import com.tp.up.client.model.Pacient;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainPanel extends JPanel implements ActionListener {

	private JLabel pat = new JLabel("Mostrar todos los pacientes: ");
	private JButton okpatients = new JButton("OK");
	private JTextArea get = new JTextArea();
    
    public MainPanel(){
    	super();
    	get.setSize(800, 600);
    	okpatients.addActionListener(this);
    	add(pat);
        add(okpatients);
        add(get);

        setLayout(new FlowLayout());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == okpatients){
        	Proxy p = new Proxy();
        	try {
				ArrayList<Pacient> t = p.getPatients();
				for (Pacient pacient : t) {
					get.append(pacient.toString() + "\n");
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
    }
	
}
