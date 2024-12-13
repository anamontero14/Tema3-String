package parte1;

import java.util.Scanner;

public class Ejer10 {

	public static void main(String[] args) {

		/*
		 * mediante la cual es posible codificar un texto, convirtiendo cada letra del
		 * conjunto 1, en su correspondiente del conjunto 2. El resto de las letras no
		 * se modifican. Los conjuntos se utilizan tanto para codificar mayúsculas como
		 * minúsculas, mostrando siempre la codificación en minúsculas. Un ejemplo: la
		 * palabra «PaquiTo» se codifica como «matqvko». Se pide realizar un programa
		 * codificador, en el que se implemente la función: char codifica(char
		 * conjunto1[],char conjunto2[], char c) que devuelve el carácter c codificado
		 * según los conjuntos 1 y 2 que se le pasan.
		 */

		// Creación del scanner
		Scanner leer = new Scanner(System.in);

		// conjunto de letras 1
		char conjunto1[] = { 'e', 'i', 'k', 'm', 'p', 'r', 's', 't', 'u', 'v' };

		// conjunto de letras 2
		char conjunto2[] = { 'p', 'v', 'i', 'u', 'm', 't', 'e', 'r', 'k', 'q', 's' };

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
		frase = leer.nextLine();

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

		// busco el caracter en el conjunto
		for (int i = 0; i < conjunto1.length; i++) {
			// si el caracter es el mismo que en el conjunto lo iguala
			if (caracter == conjunto1[i]) {
				caracter = conjunto2[i];
			}
		}

		// para la posición x ponle x

		return caracter;
	}

}
