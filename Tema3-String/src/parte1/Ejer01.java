package parte1;

import java.util.Scanner;

public class Ejer01 {

	public static void main(String[] args) {

		/*
		 * Introducir por teclado dos frases e indicar cuál de ellas es la más corta, es
		 * decir, la que contiene menos caracteres.
		 */

		// creacion del scanner
		Scanner leer = new Scanner(System.in);

		// variable para almacenar la primera cadena
		String cadena1;

		// variable para almacenar la segunda cadena
		String cadena2;

		// decirle al usuario que introduzca dos cadenas
		System.out.print("Introduzca la primera frase: ");

		// almaceno la cadena en la variable
		cadena1 = leer.nextLine();

		// decirle al usuario que introduzca dos cadenas
		System.out.print("Introduzca la segunda frase: ");

		// almaceno la cadena en la variable
		cadena2 = leer.nextLine();

		// si la longitud de la frase 1 es mayor
		if (cadena1.length() > cadena2.length()) {
			// dice que la 1 es más larga
			System.out.println("La primera frase es más larga");

			// si la cadena 2 es más larga dice lo contrario
		} else if (cadena2.length() > cadena1.length()) {
			// dice que la cadena 2 es más larga
			System.out.println("La segunda frase es más larga");
		} else {
			// si las cadenas son iguales lo dice
			System.out.println("Las cadenas son igual de largas");
		}

		// cerrar scanner
		leer.close();

	}

}
