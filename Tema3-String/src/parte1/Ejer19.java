package parte1;

import java.util.Scanner;

public class Ejer19 {

	public static void main(String[] args) {

		/*
		 * Escribe una función que convierte una frase (que puede estar escrita con
		 * cualquier combinación de mayúsculas y minúsculas) en el nombre de una
		 * variable que utilice la nomenclatura Camel. Por ejemplo, la frase “Me GUsta
		 * merenDAR gaLLEtas”, se convertirá en “meGustaMerendarGalletas”. Supondremos
		 * que cada palabra que compone la frase está separada por un único espacio en
		 * blanco. NOTA: Puedes hacer uso de las funciones estáticas toLowerCase y
		 * toUpperCase definidas en la clase Character.
		 */

		// inicializamos el scanner para leer la entrada del usuario
		Scanner scanner = new Scanner(System.in);

		// declaramos la variable para almacenar la frase introducida por el usuario
		String frase;

		// declaramos la variable para almacenar el nombre de la variable en formato
		// camel
		String nombreVariableCamel;

		// pedimos al usuario que ingrese una frase
		System.out.print("Introduce una frase: ");

		// leemos la frase que introduce el usuario
		frase = scanner.nextLine();

		// llamamos a la función que convierte la frase en formato camel y almacenamos
		// el resultado
		nombreVariableCamel = convertirACamel(frase);

		// mostramos el nombre de la variable en formato camel
		System.out.println("La variable en formato camel es: " + nombreVariableCamel);

		// cerramos el scanner para liberar los recursos
		scanner.close();
	}

	static String convertirACamel(String frase) {

		// declaramos una variable para almacenar el resultado final
		String resultado = "";

		// declaramos una variable para separar las palabras de la frase
		String[] palabras;

		// separamos la frase en palabras usando el espacio como delimitador
		palabras = frase.split(" ");

		// recorremos todas las palabras que tenemos en la frase
		for (int i = 0; i < palabras.length; i++) {

			// si es la primera palabra, la convertimos en minúsculas y la agregamos al
			// resultado
			if (i == 0) {
				// convertimos la primera palabra a minúsculas
				resultado += palabras[i].toLowerCase();
			} else {
				// si no es la primera palabra, la ponemos en mayúsculas y agregamos al
				// resultado
				// convertimos la primera letra de la palabra a mayúscula y el resto a minúscula
				resultado += palabras[i].substring(0, 1).toUpperCase() + palabras[i].substring(1).toLowerCase();
			}
		}

		// devolvemos el resultado final que es el nombre de la variable en formato
		// camel
		return resultado;
	}
}