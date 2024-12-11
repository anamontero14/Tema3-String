package parte1;

import java.util.Scanner;

public class Ejer05 {

	public static void main(String[] args) {

		/*
		 * Introducir por teclado una frase palabra a palabra, y mostrar la frase
		 * completa separando las palabras introducidas con espacios en blanco. Terminar
		 * de leer la frase cuando alguna de las palabras introducidas sea la cadena
		 * “fin” escrita con cualquier combinación de mayúsculas/minúsculas. La cadena
		 * “fin” no aparecerá en la frase final.
		 */

		// creo el scanner
		Scanner leer = new Scanner(System.in);

		// creo una variable que almacenará las letras
		String letra;

		// creo la variable que almacenará la frase completa
		String frase = "";

		// pregunto al usuario
		System.out.print("Introduzca un caracter: ");

		// leo solo hasta el espacio
		letra = leer.next();

		// creo un while para hacer la concatenación
		while (!letra.equalsIgnoreCase("fin")) {

			// concateno
			frase += letra;

			// muestro la frase
			System.out.println(frase);

			// pregunto al usuario
			System.out.print("Introduzca un caracter: ");

			// leo solo hasta el espacio
			letra = leer.next();

		}

		// muestro lo almacenado en la variable frase
		System.out.println(frase);

		// cierro el scanner
		leer.close();

	}

}
