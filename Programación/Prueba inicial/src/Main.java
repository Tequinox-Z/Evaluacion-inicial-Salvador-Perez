import java.util.Scanner;

public class Main {
	
	static Scanner entradaTexto = new Scanner(System.in);												// Creamos un nuevo Scanner del teclado est�tico
	
	public static void main(String[] args) {
		Edificio edificio = new Edificio();																// Creamos un nuevo edificio
		int opcion = 0;																					// Esta variable almacenar� la �ltima opci�n elegida por el usuario
		
		do {
			mostrarMenu();																				// Mostramos el men�
			
			String entrada;																				// Esta variable almacenar� la respuesta del usuario
			
			do {
				entrada = leerCadena("Seleccione n�mero de funci�n");									// Pedimos un n�mero de funci�n mientras no sea correcta la respuesta
			}
			while (!entrada.matches("[+-]?\\d*(\\.\\d+)?"));
			
			opcion = Integer.parseInt(entrada);															// Convertimos a entero u lo a�adimos a opcion
			
			try {
				switch (opcion) {																		// Evaluamos la opci�n y lanzamos la funci�n correspondiente
					case 1: {
						edificio.agregarPlanta();																// Agrega una planta
						break;
					}
					case 2: {
						edificio.agregarZonaAPlanta();															// Agrega una zona a una planta
						break;
					}
					case 3: {
						edificio.calcularArea();																// Calcula el �rea del edificio
						break;
					}
					case 4: {
						edificio.calcularAreaPlanta();															// Calcula el �rea de una planta
						break;	
					}
					case 5: {
						edificio.calcularAreaZona();															// Calcula el �rea de una zona
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
						System.out.println("Opci�n incorrecta");												// Indicamos que la opci�n es incorrecta en caso de que el n�mero no corresponda con un n�mero de funci�n v�ida
					}
				}
			}
			catch(Exception e) {
				System.out.println("Error: " + e);																// En caso de excepci�n la capturamos y la mostramos
			}
		}
		while (opcion != 9);																					// Mostramos el men� mientras no se quiera salir
	}
	
	/**
	 * Muestra el men� de la aplicaci�n
	 */
	static void mostrarMenu() {
		System.out.println(
							"\n" +
							"======= Calculadora de metros cuadrados ======= \n" +
							"\n" + 
							"1. Crear nueva planta \n" + 
							"2. Crear nueva zona en una planta \n" +
							"3. Calcular �rea total del edificio \n" +
							"4. Calcular �rea total de una planta espec�fica \n" +
							"5. Calcular �rea de una zona espec�fica \n" +
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
		String resultado;																// Esta variable almacenar� el resultado
		do {	
			System.out.print(mensaje + " >> ");												// Mostramos el mensaje
			resultado = entradaTexto.nextLine().trim();										// Pedimos una cadena
		}
		while (resultado.length() == 0);												// Pedimos mientras no se inserte nada
		return resultado;																// Retornamos el resultado
	}
}
