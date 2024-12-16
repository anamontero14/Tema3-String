package parte1;

import java.util.Scanner;

public class Ejer04 {

	public static void main(String[] args) {

		/*
		 * Diseñar una función a la que se le pase una cadena de caracteres y la
		 * devuelva invertida. Un ejemplo, la cadena “Hola mundo” quedaría “odnum aloH”.
		 * Recuerda probar la función en un main.
		 */

		// creo el scanner
		Scanner leer = new Scanner(System.in);

		// creo la variable donde se almacenará la frase
		String frase;

		// creo una variable para almacenar la función
		String funcion;

		// pregunto al usuario por la frase
		System.out.print("Escriba una frase: ");

		// almaceno la frase en la variable
		frase = leer.nextLine();

		// igualo la variable a la función
		funcion = invertirCadena(frase);

		// imprimo la solución
		System.out.println(funcion);

		// cierro el scanner
		leer.close();

	}

	static String invertirCadena(String frase) {

		// creo la variable que almacenará la cadena invertida
		String fraseInvertida = "";

		// creo un for que recorra la cadena al revés y la voy concatenando
		for (int i = frase.length() - 1; i >= 0; i--) {
			// cojo lo que haya en la posicion i de la cadena y lo concateno
			fraseInvertida += frase.charAt(i);
		}

		// devulvo la frase invertida
		return fraseInvertida;
	}

}
