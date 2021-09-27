import java.util.Scanner;

public class Main {
	
	static Scanner entradaTexto = new Scanner(System.in);												// Creamos un nuevo Scanner del teclado estático
	
	public static void main(String[] args) {
		Edificio edificio = new Edificio();																// Creamos un nuevo edificio
		int opcion = 0;																					// Esta variable almacenará la última opción elegida por el usuario
		
		do {
			mostrarMenu();																				// Mostramos el menú
			
			String entrada;																				// Esta variable almacenará la respuesta del usuario
			
			do {
				entrada = leerCadena("Seleccione número de función");									// Pedimos un número de función mientras no sea correcta la respuesta
			}
			while (!entrada.matches("[+-]?\\d*(\\.\\d+)?"));
			
			opcion = Integer.parseInt(entrada);															// Convertimos a entero u lo añadimos a opcion
			
			try {
				switch (opcion) {																		// Evaluamos la opción y lanzamos la función correspondiente
					case 1: {
						edificio.agregarPlanta();																// Agrega una planta
						break;
					}
					case 2: {
						edificio.agregarZonaAPlanta();															// Agrega una zona a una planta
						break;
					}
					case 3: {
						edificio.calcularArea();																// Calcula el área del edificio
						break;
					}
					case 4: {
						edificio.calcularAreaPlanta();															// Calcula el área de una planta
						break;	
					}
					case 5: {
						edificio.calcularAreaZona();															// Calcula el área de una zona
						break;
					}
					case 6: {
						edificio.exportarPlantasAJson();														// Exporta las plantas a Json
						break;
					}
					case 7: {
						edificio.exportarPlantasAarchivo();														// Exporta plantas a archivo de texto plano
						break;
					}
					case 8: {	
						edificio.mostrarPlantas();																// Muestra las plantas
						break;
					}
					case 9: {
						System.out.println("Cerrando ...");														// Indicamos que se va a cerrar el programa
						entradaTexto.close();																	// Cerramos el scanner
						break;
					}
					default: {
						System.out.println("Opción incorrecta");												// Indicamos que la opción es incorrecta en caso de que el número no corresponda con un número de función váida
					}
				}
			}
			catch(Exception e) {
				System.out.println("Error: " + e);																// En caso de excepción la capturamos y la mostramos
			}
		}
		while (opcion != 9);																					// Mostramos el menú mientras no se quiera salir
	}
	
	/**
	 * Muestra el menú de la aplicación
	 */
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
	/**
	 * Pide una cadena, la valida y la devuelve
	 * @param mensaje
	 * @return
	 */
	static String leerCadena(String mensaje) {
		String resultado;																// Esta variable almacenará el resultado
		do {	
			System.out.print(mensaje + " >> ");												// Mostramos el mensaje
			resultado = entradaTexto.nextLine().trim();										// Pedimos una cadena
		}
		while (resultado.length() == 0);												// Pedimos mientras no se inserte nada
		return resultado;																// Retornamos el resultado
	}
}
