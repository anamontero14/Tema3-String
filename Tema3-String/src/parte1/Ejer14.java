package parte1;

import java.util.Arrays;
import java.util.Scanner;

public class Ejer14 {

	public static void main(String[] args) {

		/*
		 * Diseñar un algoritmo que lea del teclado una frase e indique, para las letras
		 * que aparecen en la frase, cuántas veces se repite cada una. Se consideran
		 * iguales las letras mayúsculas y las minúsculas para realizar la cuenta. Un
		 * ejemplo sería
		 */

		// creacion del scanner
		Scanner leer = new Scanner(System.in);

		// variable para almacenar la frase
		String frase;

		// array para almacenar las letras
		char letras[];

		int posicion;

		int contador = 0;

		// le pregunto al usuario por la frase
		System.out.print("Introduzca una frase: ");

		// lo que introduzca lo almaceno en la variable en minuscula
		frase = leer.nextLine().toLowerCase().replace(" ", "");

		// paso la frase a letras en el array
		letras = frase.toCharArray();

		// bucle para recorrer la frase
		for (int i = 0; i < letras.length; i++) {
			// busco a ver si la letra está antes que la letra actual
			posicion = frase.lastIndexOf(letras[i], i - 1);
			// si es negativo (si no la encuentra) entonces
			if (posicion < 0) {
				// hago un bucle para poder buscar cuántas veces se repite
				for (int j = 0; j < letras.length; j++) {
					// si la letra en i es igual a la de la j significa que la han encontrado y
					// aumenta el contador
					if (letras[i] == letras[j]) {
						contador++;
					}

				}

				// muestro el resultado del contador
				System.out.println(letras[i] + ": " + contador + " veces");

				// pongo el contador a 0
				contador = 0;
			}

		}

		// cerrar el scanner
		leer.close();

	}

}
