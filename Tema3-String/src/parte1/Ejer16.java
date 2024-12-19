package parte1;

import java.util.Random;
import java.util.Scanner;

public class Ejer16 {

	public static void main(String[] args) {

		/*
		 * Modificar el ejercicio anterior para que el programa indique al jugador 2, en
		 * cada intento, cuántas letras coinciden con el texto original
		 */

		// creación del scanner
		Scanner leer = new Scanner(System.in);

		// variable para almacenar la frase
		String frase;

		// variable para almacenar el resultado de la funcion
		String fraseFuncion;

		// vaiable para almacenar el resultado de la funcion de recuento de aciertos
		int aciertosFuncion;

		// variable para almacenar la respuesta del jugador
		String respuesta;

		// variable para gestionar el acierto
		boolean acierta = false;

		// pregunto al usuario por la frase
		System.out.print("Introduzca una frase: ");

		// almaceno la frase en la variable
		frase = leer.nextLine().toLowerCase();

		// compruebo si la frase está vacía
		if (frase.isEmpty() == true) {

			// la frase esta vacia
			System.err.println("La frase está vacía");

		} else {
			// igualo el resultado de la funcion a la variable
			fraseFuncion = transposicionDeCaracteres(frase);

			// muestro la frase transpuesta
			System.out.println("Jugador 2, esta es la frase: " + fraseFuncion);

			System.out.print("Introduzca su respuesta: ");

			// recojo la respuesta
			respuesta = leer.nextLine().toLowerCase();

			// almaceno los aciertos en la funcion
			aciertosFuncion = letrasCoinciden(frase, respuesta);

			// muestra los aciertos
			System.out.println("Le coinciden: " + aciertosFuncion);

			// la comparo
			if (frase.equals(respuesta)) {
				// si ha acertado
				System.out.println("Enhora buena, ¡has acertado!");
			} else {

				// mientras que el jugador no acierte
				while (!acierta) {

					// muestro otra vez la frase
					System.out.println(fraseFuncion);

					// pregunta otra vez hasta que acierte
					System.out.print("Inténtalo otra vez: ");

					// recoje la respuesta
					respuesta = leer.nextLine().toLowerCase();

					// almaceno los aciertos en la funcion
					aciertosFuncion = letrasCoinciden(frase, respuesta);

					// muestra los aciertos
					System.out.println("Le coinciden: " + aciertosFuncion);

					// si son iguales pone acierta a positivo
					if (frase.equals(respuesta)) {
						acierta = true;
					}

				}

				// felicito al usuario
				System.out.println("Enhora buena, ¡has acertado!");
			}
		}

		// cerrar scanner
		leer.close();

	}

	static String transposicionDeCaracteres(String frase) {

		// creo una variable para almacenar la frase transpuesta
		String fraseTranspuesta = "";

		// creo una variable para almacenar un numero aleatorio
		int numRandom;

		// creo la clase random
		Random rand = new Random();

		// creo un bucle para recorrer la frase
		for (int i = 0; i < frase.length(); i++) {

			// doy un numero random
			numRandom = rand.nextInt(0, frase.length());

			if (frase.charAt(numRandom) == ' ') {

				fraseTranspuesta += ' ';

			} else {

				// va concatenando
				fraseTranspuesta += frase.charAt(numRandom);
			}

		}

		// devuelvo la frase cambiada
		return fraseTranspuesta;

	}

	static int letrasCoinciden(String frase, String respuesta) {

		// variable para almacenar el numero de aciertos
		int aciertos = 0;

		// variable para almacenar la longitud minima de entre las dos frases
		int longitudMinima = Math.min(frase.length(), respuesta.length());

		// bucle para recorrer la frase
		for (int i = 0; i < longitudMinima; i++) {
			// si el caracter de la frase original es igual que el de la respuesta entonces
			// incrementa
			if (frase.charAt(i) == respuesta.charAt(i)) {
				aciertos++;
			}

		}
		// devuelve el numero de aciertos
		return aciertos;

	}

}
