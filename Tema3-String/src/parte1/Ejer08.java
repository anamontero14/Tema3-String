package parte1;

import java.util.Arrays;
import java.util.Scanner;

public class Ejer08 {

	public static void main(String[] args) {

		/*
		 * Implementa un programa que lea una frase y muestre todas sus palabras
		 * ordenadas de forma alfabética. Suponemos que cada palabra de la frase se
		 * separa de otra por un único espacio
		 */

		// creación del scanner
		Scanner leer = new Scanner(System.in);

		// creo la variable donde se almacenará la frase
		String frase;

		// creo un string que almacenará las palabras divididas
		String palabras[];

		// pregunto al usuario por la frase
		System.out.print("Escriba una frase a continuación: ");

		// almaceno lo introducido en la variable frase
		frase = leer.nextLine();

		// meto en el array las palabras divididas
		palabras = frase.split(" ");

		// ordeno las palabras alfabéticamente
		Arrays.sort(palabras);

		// muestro el array
		System.out.println(Arrays.toString(palabras));

		// cierro el Scanner
		leer.close();

	}

}
