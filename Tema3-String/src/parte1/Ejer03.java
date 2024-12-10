package parte1;

import java.util.Scanner;

public class Ejer03 {

	public static void main(String[] args) {

		/*
		 * Diseña una función que recibe una frase como parámetro y devuelva cuántos
		 * espacios en blanco tiene. Recuerda probar la función en un main
		 */

		// creo el scanner
		Scanner leer = new Scanner(System.in);

		// variable para almacenar la frase
		String frase;

		// variable para almacenar la funcion
		int funcion;

		// pregunto al usuario por la frase
		System.out.print("Introduzca una frase: ");

		// almaceno la respuesta en la variable
		frase = leer.nextLine();

		// llamo a la función y la almaceno en una variable
		funcion = comprobarEspacios(frase);

		// muestro la funcion
		System.out.println("La frase tiene " + funcion + " espacios");

		// cierro el scanner
		leer.close();

	}

	static int comprobarEspacios(String frase) {

		// variable que contendrá el número de espacios de la frase
		int numEspacios = 0;

		// recorro la frase
		for (int i = 0; i < frase.length(); i++) {
			// si es un espacio incrementa
			if (frase.charAt(i) == ' ') {
				numEspacios++;
			}
		}

		// variable a devolver
		return numEspacios;

	}

}
