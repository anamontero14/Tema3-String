package parte1;

import java.util.Scanner;

public class Ejer07 {

	public static void main(String[] args) {

		/*
		 * Diseñar una función que reciba por parámetros una frase y una palabra. Debe
		 * devolver cuántas veces aparece la palabra en la frase
		 */

		// creo el scanner
		Scanner leer = new Scanner(System.in);

		// variable para almacenar la frase
		String frase;

		// variable para almacenar la palabra a buscar
		String palabra;

		// variable para almacenar el resultado de la función
		int funcion;

		// pregunto al usuario por la frase
		System.out.print("Escriba una frase: ");

		// almaceno la respuesta en la variable
		frase = leer.nextLine();

		// pregunto al usuario por la palabra a buscar
		System.out.print("Introduzca la palabra a buscar: ");

		// almaceno la respuesta en la variable
		palabra = leer.next();

		// igualo la funcion a la variable
		funcion = vecesQueAparece(frase, palabra);

		// muestro las veces que aparece la palabra
		System.out.println("La palabra aparece " + funcion + " veces.");

		// cierro el scanner
		leer.close();

	}

	static int vecesQueAparece(String frase, String palabra) {

		// variable para contar cuántas veces aparece la palabra
		int contador = 0;

		// variable para ir almacenando la posición
		int pos = 0;

		// variable para almacenar la posición desde que se tiene que empezar a buscar
		int posInicio = 0;

		// busco si la palabra de por sí está en la frase o no
		pos = frase.indexOf(palabra);

		// si está en la frase devolverá un nº positivo (la psosición en donde se
		// encuentra la palabra) y entrará al while
		while (pos >= 0) {

			// como he encontrado la palabra aumento el contador
			contador++;

			// la posición de inicio para buscar a continuación va a ser la posición donde
			// empezaba la palabra en la frase + la longitud de la palabra
			posInicio = pos + palabra.length();

			// a continuacion la posición será igualada a si se encuentra la palabra o no
			pos = frase.indexOf(palabra, posInicio);

		}

		// devuelvo las veces que se ha encontrado la cadena
		return contador;
	}

}
