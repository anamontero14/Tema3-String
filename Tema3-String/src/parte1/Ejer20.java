package parte1;

import java.util.Arrays;
import java.util.Scanner;

public class Ejer20 {

	public static void main(String[] args) {

		/*
		 * Construir una función que convierta una palabra pasada por parámetro en
		 * secuencias de n letras. El valor n también debe ser un parámetro de entrada.
		 * Por ejemplo, para la palabra “destornillador”, dividida en secuencias de 4
		 * letras, se devolverá un array de la siguiente forma
		 */

		// inicializamos el scanner para leer la entrada del usuario
		Scanner scanner = new Scanner(System.in);

		// declaramos la variable para almacenar la palabra introducida por el usuario
		String palabra;

		// declaramos la variable para almacenar el tamaño de las secuencias
		int tamañoSecuencia;

		// declaramos la variable para almacenar el resultado final (array de
		// secuencias)
		String[] secuencias;

		// pedimos al usuario que ingrese una palabra
		System.out.print("Introduce una palabra: ");

		// leemos la palabra que introduce el usuario
		palabra = scanner.nextLine();

		// pedimos al usuario que ingrese el tamaño de las secuencias
		System.out.print("Introduce el tamaño de las secuencias: ");

		// leemos el tamaño de las secuencias
		tamañoSecuencia = scanner.nextInt();

		// llamamos a la función que divide la palabra en secuencias y almacenamos el
		// resultado
		secuencias = dividirEnSecuencias(palabra, tamañoSecuencia);

		// mostramos el resultado (array de secuencias)
		System.out.println("Las secuencias de " + tamañoSecuencia + " letras son:");

		// muestro el array
		System.out.println(Arrays.toString(secuencias));

		// cerramos el scanner para liberar los recursos
		scanner.close();
	}

	static String[] dividirEnSecuencias(String palabra, int tamañoSecuencia) {

		// calculamos cuántas secuencias se pueden formar
		int cantidadSecuencias = (int) Math.ceil((double) palabra.length() / tamañoSecuencia);

		// declaramos un array para almacenar las secuencias
		String[] secuencias = new String[cantidadSecuencias];

		// recorremos cada secuencia y la vamos generando
		for (int i = 0; i < cantidadSecuencias; i++) {

			// calculamos el índice inicial de la subcadena para la secuencia actual
			int inicio = i * tamañoSecuencia;

			// calculamos el índice final de la subcadena (si excede el tamaño de la
			// palabra, usamos la longitud total de la palabra)
			int fin = Math.min(inicio + tamañoSecuencia, palabra.length());

			// generamos la secuencia utilizando substring y la guardamos en el array
			secuencias[i] = palabra.substring(inicio, fin);
		}

		// devolvemos el array con las secuencias
		return secuencias;
	}
}