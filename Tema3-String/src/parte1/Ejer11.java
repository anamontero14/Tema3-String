package parte1;

import java.util.Scanner;

public class Ejer11 {

	public static void main(String[] args) {

		/*
		 * Realizar un programa descodificador. La solución es tan sencilla como
		 * utilizar la función diseñada en el ejercicio anterior intercambiando los
		 * conjuntos entre sí.
		 */

		// Creación del scanner
		Scanner leer = new Scanner(System.in);

		// conjunto de letras 1
		char conjunto1[] = { 'p', 'v', 'i', 'u', 'm', 't', 'e', 'r', 'k', 'q', 's' };

		// conjunto de letras 2
		char conjunto2[] = { 'e', 'i', 'k', 'm', 'p', 'q', 'r', 's', 't', 'u', 'v' };

		// variable para recoger la frase a cambiar del usuario
		String frase;

		// variable para almacenar la frase cambiada
		String fraseCambiada = "";

		// variable para almacenar la frase caracter a caracter
		char caracter = ' ';

		// variable para controlar si está o no
		boolean estaOno = false;

		// le pido al usuario que introduzca la frase
		System.out.print("Introduzca la frase a cambiar: ");

		// recojo la frase en la variable
		frase = leer.nextLine().toLowerCase();

		// voy separando la frase en caracteres SI están en el conjunto 1
		for (int i = 0; i < frase.length(); i++) {
			// igualo el caracter actual a la variable
			caracter = frase.charAt(i);

			// recorro el conjunto
			for (int j = 0; j < conjunto1.length; j++) {

				// si el caracter está en la tabla
				if (frase.charAt(i) == conjunto1[j]) {

					// igualo a true
					estaOno = true;
				}
			}

			if (estaOno == false) {
				// concatena sin cambiar
				fraseCambiada += caracter;
			} else {

				// concatena cambiando
				fraseCambiada += codifica(conjunto1, conjunto2, caracter);
			}

		}

		// muestro la frase cambiada
		System.out.println(fraseCambiada);

		// cerrrar el scanner
		leer.close();

	}

	static char codifica(char conjunto1[], char conjunto2[], char caracter) {

		// variable que almacenará el caracter cambiado pero que si no es cambiado
		// almacenará lo mismo que caracter
		char nuevoCaracter = caracter;

		// busco el caracter en el conjunto
		for (int i = 0; i < conjunto1.length; i++) {
			// si el caracter es el mismo que en el conjunto lo iguala
			if (caracter == conjunto1[i]) {
				nuevoCaracter = conjunto2[i];
			}
		}

		// para la posición x ponle x

		return nuevoCaracter;
	}

}
