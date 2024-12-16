package parte1;

import java.util.Scanner;

public class Ejer12 {

	public static void main(String[] args) {

		/*
		 * Leer una frase y encontrar la palabra de mayor longitud. El programa debe
		 * imprimir tanto la palabra como el número de caracteres de la misma
		 */

		// creación del scanner
		Scanner leer = new Scanner(System.in);

		// variable para almacenar la frase
		String frase;

		// array para separar la frase en palabras
		String palabras[];

		// pregunto al usuario por la frase
		System.out.print("Introduzca una frase para ver qué palabra es más larga: ");

		// almaceno la frase en la variable
		frase = leer.nextLine();

		// cerrar el scanner
		leer.close();

	}

}
