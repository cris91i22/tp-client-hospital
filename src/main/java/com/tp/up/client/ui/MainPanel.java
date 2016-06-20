package com.tp.up.client.ui;

import javax.swing.*;

import com.tp.up.client.Proxy;
import com.tp.up.client.model.Consultation;
import com.tp.up.client.model.Pacient;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * FUNCION: Proporciona la logica para cada componente del GUI.
 */

public class MainPanel implements ActionListener {

	private JButton mostrarPacientes, mostrarConsultas, crearPaciente, borrarPaciente, crearConsulta, atenderPaciente, finalizarConsulta;
	private JTextArea textMostrarP, textMostrarC, textCrearP, textCrearC, textBorrarP, textAtenderP, textFinalizarC; 
	
	public JTextArea getTextCrearC() {
		return textCrearC;
	}

	public void setTextCrearC(JTextArea textCrearC) {
		this.textCrearC = textCrearC;
	}

	private String parametros;
    
    public MainPanel(){
    	
    	this.mostrarPacientes = new JButton("Mostrar");
    	this.crearPaciente = new JButton("Crear");
    	this.mostrarConsultas = new JButton("Mostrar");
    	this.borrarPaciente = new JButton("Eliminar");
    	this.crearConsulta = new JButton("Crear");
    	this.finalizarConsulta = new JButton("Finalizar");
    	this.atenderPaciente = new JButton("Atender");
    	
    	this.textMostrarP = new JTextArea("Mostrar los pacientes");
    	this.textCrearP = new JTextArea("Crear Paciente. Escribir aca! Son 3 parametros: Nombre.DNI.ObraSocial Deben estar delimitado por PUNTOS");
    	this.textBorrarP = new JTextArea("Eliminar Paciente. Escribir aca! 1 parametro: DNI");
    	this.textMostrarC = new JTextArea("Muestra las consultas");
    	this.textCrearC = new JTextArea("Crear Consulta. Escribir aca! Son 2 parametros: DNI Paciente.TipoConsulta Deben estar delimitado por PUNTOS");
    	this.textFinalizarC = new JTextArea("Finalizar Consulta. Escribir aca! 1 parametro: Nro. Consulta");
    	this.textAtenderP = new JTextArea("Atender Paciente. Escribir aca! 1 parametro: Nro. Consulta");
    	
    	textMostrarP.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.red),
                textMostrarP.getBorder()));
    	textMostrarP.setEditable(false);
    	
    	textMostrarC.setEditable(false);
    	textMostrarC.setLineWrap(true);
    	textMostrarC.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.gray),
                textMostrarC.getBorder()));
    	
    	textBorrarP.setLineWrap(true);
    	textBorrarP.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.green),
                textBorrarP.getBorder()));
    	
    	textCrearP.setLineWrap(true);
    	textCrearP.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.blue),
                textCrearP.getBorder()));
    	
    	textCrearC.setLineWrap(true);
    	textCrearC.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.ORANGE),
                textCrearC.getBorder()));
    	
    	textAtenderP.setLineWrap(true);
    	textAtenderP.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.CYAN),
                textAtenderP.getBorder()));
    	
    	textFinalizarC.setLineWrap(true);
    	textFinalizarC.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.MAGENTA),
                textFinalizarC.getBorder()));
    	
    	mostrarPacientes.addActionListener(this);
    	mostrarConsultas.addActionListener(this);
    	crearPaciente.addActionListener(this);
    	borrarPaciente.addActionListener(this);
    	crearConsulta.addActionListener(this);
    	finalizarConsulta.addActionListener(this);
    	atenderPaciente.addActionListener(this);
    }
    
    public JButton getCrearConsulta() {
		return crearConsulta;
	}

	public void setCrearConsulta(JButton crearConsulta) {
		this.crearConsulta = crearConsulta;
	}

	@Override
    public void actionPerformed(ActionEvent e) {
        
    	if(e.getSource() == mostrarPacientes){
        	try {
        		Proxy p = new Proxy();
        		textMostrarP.setText("");
				ArrayList<Pacient> t = p.getPatients();
				for (Pacient pacient : t) {
					textMostrarP.append(pacient.toString() + "\n");
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
        
        if(e.getSource() == crearPaciente) {
        	try{
        		Proxy p = new Proxy();
        		parametros = textCrearP.getText();
        	   String[] parts = parametros.split("\\.");
        	   String param0 = parts[0];
        	   Integer param1 = Integer.parseInt(parts[1]);
        	   String param2 = parts[2];
        	   
        	   p.crearPaciente(param0, param1, param2);
        	} catch (Exception e1) {
        		e1.printStackTrace();
        	}
        
        }
        
        if(e.getSource() == crearConsulta) {
        	try{
        	   Proxy p = new Proxy();
        	   parametros = textCrearC.getText();
        	   String[] parts = parametros.split("\\.");
        	   Integer param0 = Integer.parseInt(parts[0]); 
        	   String param1 = parts[1]; 
        	   
        	   textCrearC.setText("Nro. de Consulta: " + Integer.toString(p.crearConsulta(param0, param1)));
        	} catch (Exception e1) {
        		e1.printStackTrace();
        	}
        
        }
        
        if(e.getSource() == borrarPaciente) {
        	try{
        		Proxy p = new Proxy();
        		parametros = textBorrarP.getText();
        		Integer param0 = Integer.parseInt(parametros);
        		
        		p.deletePatient(param0);
        	} catch (Exception e1) {
        		e1.printStackTrace();
        	}
        }
        
        if(e.getSource() == mostrarConsultas){
        	try {
        		Proxy p = new Proxy();
        		textMostrarC.setText("");
        		ArrayList<Consultation> con = p.getConsultations();
    			for (Consultation consulta : con) {
    				textMostrarC.append(consulta.toString() + "\n");
    				}
    		} catch (Exception e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    			}
            }
        
        if(e.getSource() == finalizarConsulta) {
        	try{
        		Proxy p = new Proxy();
        		parametros = textFinalizarC.getText();
        		Integer param0 = Integer.parseInt(parametros);
        		
        		p.finalizarConsulta(param0);
        	} catch (Exception e1) {
        		e1.printStackTrace();
        	}
        }
        
        if(e.getSource() == atenderPaciente) {
        	try{
        		Proxy p = new Proxy();
        		parametros = textAtenderP.getText();
        		Integer param0 = Integer.parseInt(parametros);
        		
        		p.atender(param0);
        	} catch (Exception e1) {
        		e1.printStackTrace();
        	}
        }
        
        }
    

	public JButton getMostrarPacientes() {
		return mostrarPacientes;
	}

	public void setMostrarPacientes(JButton mostrarPacientes) {
		this.mostrarPacientes = mostrarPacientes;
	}

	public JButton getCrearPaciente() {
		return crearPaciente;
	}

	public void setCrearPaciente(JButton crearPaciente) {
		this.crearPaciente = crearPaciente;
	}

	public JButton getMostrarConsultas() {
		return mostrarConsultas;
	}

	public void setMostrarConsultas(JButton mostrarConsultas) {
		this.mostrarConsultas = mostrarConsultas;
	}

	public JButton getBorrarPaciente() {
		return borrarPaciente;
	}

	public void setBorrarPaciente(JButton borrarPaciente) {
		this.borrarPaciente = borrarPaciente;
	}

	public JTextArea getTextMostrarC() {
		return textMostrarC;
	}

	public void setTextMostrarC(JTextArea textMostrarC) {
		this.textMostrarC = textMostrarC;
	}

	public JTextArea getTextBorrarP() {
		return textBorrarP;
	}

	public void setTextBorrarP(JTextArea textBorrarP) {
		this.textBorrarP = textBorrarP;
	}

	public JTextArea getTextMostrarP() {
		return textMostrarP;
	}

	public void setTextMostrarP(JTextArea textMostrarP) {
		this.textMostrarP = textMostrarP;
	}

	public JTextArea getTextCrearP() {
		return textCrearP;
	}

	public void setTextCrearP(JTextArea textCrearP) {
		this.textCrearP = textCrearP;
	}

	public JButton getAtenderPaciente() {
		return atenderPaciente;
	}

	public void setAtenderPaciente(JButton atenderPaciente) {
		this.atenderPaciente = atenderPaciente;
	}

	public JButton getFinalizarConsulta() {
		return finalizarConsulta;
	}

	public void setFinalizarConsulta(JButton finalizarConsulta) {
		this.finalizarConsulta = finalizarConsulta;
	}

	public JTextArea getTextAtenderP() {
		return textAtenderP;
	}

	public void setTextAtenderP(JTextArea textAtenderP) {
		this.textAtenderP = textAtenderP;
	}

	public JTextArea getTextFinalizarC() {
		return textFinalizarC;
	}

	public void setTextFinalizarC(JTextArea textFinalizarC) {
		this.textFinalizarC = textFinalizarC;
	}
	
}
