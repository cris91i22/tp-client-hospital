package com.tp.up.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.HttpClientBuilder;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Proxy {

	private ObjectMapper mapper;
	public Proxy(){mapper = new ObjectMapper();}


	public void crearPaciente(java.lang.String param0, java.lang.Integer param1, java.lang.String param2) throws Exception {
		String url = "http://localhost:8080/service/create/pacient" + "/" + param0.toString() + "/" + param1.toString() + "/" + param2.toString();
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(url);
		request.addHeader("Content-Type", "application/json");
		HttpResponse response = client.execute(request);
		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
		
	}

	public ArrayList<com.tp.up.client.Pacient> getPatients() throws Exception {
		String url = "http://localhost:8080/service/patients";
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		
		HttpResponse response = client.execute(request);
		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
				BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		ArrayList<com.tp.up.client.Pacient> myObjects = mapper.readValue(result.toString(), new TypeReference<ArrayList<com.tp.up.client.Pacient>>(){});
		return myObjects;
	}

	public void deletePatient(java.lang.Integer param0) throws Exception {
		String url = "http://localhost:8080/service/patient" + "/" + param0.toString();
		HttpClient client = HttpClientBuilder.create().build();
		HttpDelete request = new HttpDelete(url);
		
		HttpResponse response = client.execute(request);
		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
		
	}

	public java.lang.Integer crearConsulta(java.lang.Integer param0, java.lang.String param1) throws Exception {
		String url = "http://localhost:8080/service/create/consultation" + "/" + param0.toString() + "/" + param1.toString();
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(url);
		request.addHeader("Content-Type", "application/json");
		HttpResponse response = client.execute(request);
		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
				BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		java.lang.Integer myObjects = mapper.readValue(result.toString(), new TypeReference<java.lang.Integer>(){});
		return myObjects;
	}

	public ArrayList<com.tp.up.client.Consultation> getConsultations() throws Exception {
		String url = "http://localhost:8080/service/consultations";
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		
		HttpResponse response = client.execute(request);
		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
				BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		ArrayList<com.tp.up.client.Consultation> myObjects = mapper.readValue(result.toString(), new TypeReference<ArrayList<com.tp.up.client.Consultation>>(){});
		return myObjects;
	}

	public void atender(java.lang.Integer param0) throws Exception {
		String url = "http://localhost:8080/service/atender" + "/" + param0.toString();
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(url);
		request.addHeader("Content-Type", "application/json");
		HttpResponse response = client.execute(request);
		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
		
	}

	public void finalizarConsulta(java.lang.Integer param0) throws Exception {
		String url = "http://localhost:8080/service/finalizar" + "/" + param0.toString();
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(url);
		request.addHeader("Content-Type", "application/json");
		HttpResponse response = client.execute(request);
		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
		
	}
}