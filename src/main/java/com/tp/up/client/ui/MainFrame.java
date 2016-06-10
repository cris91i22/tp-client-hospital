package com.tp.up.client.ui;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
    
	private MainPanel mp = new MainPanel();
	
	public MainFrame(){
        super("Hospital");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        this.add(mp);
    }
	
}
