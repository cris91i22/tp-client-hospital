package com.tp.up.client;

public class MAin {

	public static void main(String[] args) {
		Proxy c = new Proxy();
		
		try {
			c.crearPaciente("COCO", 1234, "GALENO");
			printPAc(c);
			c.deletePatient(5553333);
			printPAc(c);
			System.out.println(c.crearConsulta(8884444, "GRIPE"));
			c.finalizarConsulta(1);
			printCon(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}	
	
	public static void printPAc(Proxy t){
		try {
			for (Pacient p : t.getPatients()) {
				System.out.println(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void printCon(Proxy t){
		try {
			for (Consultation p : t.getConsultations()) {
				System.out.println(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}	
