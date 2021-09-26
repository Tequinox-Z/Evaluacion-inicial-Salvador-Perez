import java.util.Scanner;

public class Main {
	
	static Scanner entradaTexto = new Scanner(System.in);
	
	public static void main(String[] args) {
		Edificio edificio = new Edificio();
		int opcion = 0;
		
		do {
			mostrarMenu();
			
			String entrada;
			
			do {
				entrada = leerCadena("Seleccione número de función");
			}
			while (!entrada.matches("[+-]?\\d*(\\.\\d+)?"));
			
			opcion = Integer.parseInt(entrada);
			
			try {
				switch (opcion) {
					case 1: {
						edificio.agregarPlanta();
						break;
					}
					case 2: {
						edificio.agregarZonaAPlanta();
						break;
					}
					case 3: {
						edificio.calcularArea();
						break;
					}
					case 4: {
						edificio.calcularAreaPlanta();
						break;
					}
					case 5: {
						edificio.calcularAreaZona();
						break;
					}
					case 6: {
						edificio.exportarPlantasAJson();
						break;
					}
					case 7: {
						edificio.exportarPlantasAarchivo();
						break;
					}
					case 8: {
						edificio.mostrarPlantas();
						break;
					}
					case 9: {
						System.out.println("Cerrando ...");
						entradaTexto.close();
						break;
					}
					default: {
						System.out.println("Opción incorrecta");
					}
				}
			}
			catch(Exception e) {
				System.out.println("Error: " + e);
			}
		}
		while (opcion != 9);
	}
	
	static void mostrarMenu() {
		System.out.println(
							"\n" +
							"======= Calculadora de metros cuadrados ======= \n" +
							"\n" + 
							"1. Crear nueva planta \n" + 
							"2. Crear nueva zona en una planta \n" +
							"3. Calcular área total del edificio \n" +
							"4. Calcular área total de una planta específica \n" +
							"5. Calcular área de una zona específica \n" +
							"6. Exportar plantas a Json \n" + 
							"7. Exportar datos a texto \n" + 
							"8. Mostrar plantas \n" +
							"9. Salir"
							
		);
	}
	
	static String leerCadena(String mensaje) {
		String resultado;
		do {
			System.out.print(mensaje + " >> ");
			resultado = entradaTexto.nextLine().trim();
		}
		while (resultado.length() == 0);
		return resultado;
	}
}
