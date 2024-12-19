package parte1;

import java.util.Arrays;
import java.util.Scanner;

public class Ejer13 {

	public static void main(String[] args) {

		/*
		 * Un anagrama es una palabra, o frase, que resulta de la transposición de otra
		 * palabra o frase. Ejemplos de anagramas para la palabra roma son: amor, ramo o
		 * mora. Construir una función que recibe dos palabras por parámetro e indique
		 * si son anagramas una de otra
		 */

		// creación del scanner
		Scanner leer = new Scanner(System.in);

		// variable para almacenar la primera palabra
		String palabra1;

		// variable para almacenar la segunda palabra
		String palabra2;

		// creo una variable para almacenar el resultado de la función
		boolean funcion;

		// le pregunto al usuario
		System.out.print("Introduzca una palabra: ");

		// almacena lo introducido en la variable
		palabra1 = leer.next().toLowerCase();

		// le pregunto al usuario
		System.out.print("Introduzca otra palabra: ");

		// almacena lo introducido en la variable
		palabra2 = leer.next().toLowerCase();

		// igualo el resultado de la funcion a la variable
		funcion = anagramaONo(palabra1, palabra2);

		// si es false entonces
		if (funcion == false) {
			System.out.println("Las palabras no son anagramas.");
		} else {
			// si no
			System.out.println("Las palabras son anagramas");
		}

		// cerrar el scanner
		leer.close();

	}

	static boolean anagramaONo(String palabra1, String palabra2) {

		// creo una variable booleana para decir si son o no anagramas
		boolean sonOno = true;

		// creo dos array para almacenar las palabras
		char pal1[];
		char pal2[];

		// paso las palabras a array
		pal1 = palabra1.toCharArray();
		pal2 = palabra2.toCharArray();

		// si los array no son de la misma longitud entonces significa que no van a ser
		if (pal1.length != pal2.length) {
			sonOno = false;
		} else {

			// ordeno los array
			Arrays.sort(pal1);
			Arrays.sort(pal2);

			// compruebo si son iguales
			if (!Arrays.equals(pal1, pal2)) {
				// si no son iguales entonces lo igualo a false
				sonOno = false;
			}
		}

		// devuelvo una variable booleana
		return sonOno;
	}

}
