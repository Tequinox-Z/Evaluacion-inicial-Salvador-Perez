import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

import com.google.gson.GsonBuilder;

public class Edificio {
	
	private ArrayList<Planta> plantas;
	
	public Edificio() {
		super();
		this.plantas = new ArrayList<Planta>();
	}
	
	private String obtenerInformacionPlantas() {
		StringBuilder resultado = new StringBuilder();
		Collections.sort(plantas, new ComparadorPlantas());
		
		if (plantas.size() == 0) {
			resultado.append("El edificio aún no tiene ninguna planta agregada");
		}
		else {
			for (Planta plantaActual : plantas) {
				resultado.append(plantaActual.toString() + "\n" + plantaActual.mostrarZonas());
			}
		}
		return resultado.toString();
	}
	
	public void mostrarPlantas() {
		System.out.println(obtenerInformacionPlantas());
	}
	
	public void agregarPlanta() {
		String resultado = leerNumeroPlanta();
		
		Planta nuevaPlanta = new Planta(Integer.parseInt(resultado));
		
		if (plantas.contains(nuevaPlanta)) {
			resultado = "La planta " + resultado + " ya existe";
		}
		else {
			plantas.add(nuevaPlanta);
			resultado = "Planta " + resultado + " agregada correctamente";
		}
		
		System.out.println(resultado);
	}
	
	public void agregarZonaAPlanta() {
		String resultado = leerNumeroPlanta();
		
		int indice = plantas.indexOf(new Planta(Integer.parseInt(resultado)));
		
		if (indice == -1) {
			System.out.println("La planta no existe");
		}
		else {
			Planta plantaSeleccionada = plantas.get(indice);
			String nombreZona = leerCadena("Indique nombre de la zona");
			
			resultado = leerCadena("¿La zona es cuadrada o rectangular? [Cuadrada]");
			
			Zona nuevaZona = null;
			
			if (resultado.toUpperCase().equals("RECTANGULAR")) {
				nuevaZona = new ZonaRectangular(nombreZona, leerMedida("Inserte largo"), leerMedida("Inserte ancho"));
			}
			else {
				nuevaZona = new ZonaCuadrada(nombreZona, leerMedida("Inserte medida de uno de los lados"));

			}
			
			System.out.println("Zona creada");
			plantaSeleccionada.annadirZona(nuevaZona);
		}
	}
	
	public void calcularArea() {
		Double metrosTotales = 0.0;
		
		for (Planta plantaActual: plantas) {
			metrosTotales += plantaActual.calcularArea();
		}
		
		System.out.println("El edificio mide " + metrosTotales + " m²");
	}
	
	public void calcularAreaPlanta() {
		String numeroPlanta = leerNumeroPlanta();
		
		int indice = plantas.indexOf(new Planta(Integer.parseInt(numeroPlanta)));
		
		if (indice == -1) {
			System.out.println("La planta " + numeroPlanta + " no existe");
		}
		else {
			System.out.println("La planta " + numeroPlanta + " tiene " + plantas.get(indice).calcularArea() + " m²");
		}
		
	}
	
	public void calcularAreaZona() {
		String numeroPlanta = leerNumeroPlanta();
		
		int indice = plantas.indexOf(new Planta(Integer.parseInt(numeroPlanta)));
		
		if (indice == -1) {
			System.out.println("La planta " + numeroPlanta + " no existe");
		}
		else {
			numeroPlanta = leerCadena("Indique nombre zona");
			
			Iterator<Zona> zonaIterator = plantas.get(indice).getZonas().iterator();
			
			boolean encontradaZona = false;
			Zona zona = null;
			
			while (!encontradaZona && zonaIterator.hasNext()) {
				zona = zonaIterator.next();
				if (zona.getNombre().toUpperCase().equals(numeroPlanta.toUpperCase())) {
					encontradaZona = true;
				}
			}
			
			if (encontradaZona) {
				System.out.println("La zona " + numeroPlanta + " tiene " + zona.calcularArea() + " m²");
			}
			else {
				System.out.println("Zona " + numeroPlanta + " no encontrada");
			}
			
		}
	}
	
	public void exportarPlantasAJson() throws EdificioException {
		String Json = new GsonBuilder().setPrettyPrinting().create().toJson(plantas);
		String ficheroName = "Plantas";
		
		try {
			File newFile = new File(ficheroName + ".json");
			FileWriter flujoEscritura = new FileWriter(newFile);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);
			
			filtroEscritura.append(Json);
			
			filtroEscritura.close();
			flujoEscritura.close();
			System.out.println(ficheroName + ".json : Exportado con éxito");
		} 
		catch (IOException e) {
			throw new EdificioException("Error al crear el fichero: " + e);
		}
		
	}
	
	public void exportarPlantasAarchivo() throws EdificioException {
		String resultado = obtenerInformacionPlantas();
	
		try {
			File newFile = new File(leerCadena("Inserte nombre del fichero"));
			FileWriter flujoEscritura = new FileWriter(newFile);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);
			
			filtroEscritura.append(resultado);
			
			filtroEscritura.close();
			flujoEscritura.close();
		}
		catch(Exception e) {
			throw new EdificioException("Error: " + e);
		}
	}
	
	private String leerNumeroPlanta() {
		String resultado;
		
		do {
			resultado = leerCadena("Inserte el número de la planta").trim();
		}
		while (!resultado.matches("[+-]?\\d*(\\.\\d+)?"));
		
		return resultado;
	}
	
	private Double leerMedida(String mensaje) {
		String resultado;
		
		do {
			resultado = leerCadena(mensaje).trim();
		}
		while (!resultado.matches("[+-]?\\d*(\\.\\d+)?"));
		
		return Double.parseDouble(resultado);
	}
	
	private String leerCadena(String mensaje) {
		Scanner entradaCadena = new Scanner(System.in);
		String resultado;
		
		do {
			System.out.print(mensaje + " >> ");
			resultado = entradaCadena.nextLine().trim();
		}
		while(resultado.length() == 0);
		return resultado;
	}
}
