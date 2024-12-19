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

		String palabra;

		String palabraLarga = "";

		// pregunto al usuario por la frase
		System.out.print("Introduzca una frase para ver qué palabra es más larga: ");

		// almaceno la frase en la variable
		frase = leer.nextLine();

		// divido la frase en palabras
		palabras = frase.split(" ");

		// igualo la variable a la primera palabra para que haya un mínimo
		palabra = palabras[0];

		// recorro el array
		for (int i = 0; i < palabras.length; i++) {
			// si la palabra que toca es más larga que la palabra almacenada en la palabra
			// larga
			if (palabra.length() < palabras[i].length()) {
				// almacena la palabra larga en la variable
				palabraLarga = palabras[i];
			}

			// iguala la siguiente palabra
			palabra = palabras[i];

		}
		// muestra la solucion
		System.out.println("La palabra más larga es: " + palabraLarga);

		// cerrar el scanner
		leer.close();

	}

}
