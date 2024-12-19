package parte1;

import java.util.Random;
import java.util.Scanner;

public class Ejer15 {

	public static void main(String[] args) {

		/*
		 * Implementar el juego del anagrama, que consiste en que un jugador escribe una
		 * palabra o frase, y la aplicación muestra un anagrama (transposición de los
		 * caracteres) del texto introducido generado al azar. A continuación otro
		 * jugador tiene que acertar cuál es el texto original. La aplicación no debe
		 * permitir que el texto introducido por el jugador 1 sea la cadena vacía. Por
		 * ejemplo, si el jugador 1 escribe “teclado”, la aplicación muestra como pista
		 * un anagrama al azar: “etcloda”. Crea una función que realice la desordenación
		 * del texto
		 */

		// creación del scanner
		Scanner leer = new Scanner(System.in);

		// variable para almacenar la frase
		String frase;

		// variable para almacenar el resultado de la funcion
		String fraseFuncion;

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

			// la comparo
			if (frase.equals(respuesta)) {
				// si ha acertado
				System.out.println("Enhora buena, ¡has acertado!");
			} else {

				// mientras que el jugador no acierte
				while (!acierta) {

					fraseFuncion = transposicionDeCaracteres(frase);
					
					// muestro otra vez la frase
					System.out.println(fraseFuncion);

					// pregunta otra vez hasta que acierte
					System.out.print("Inténtalo otra vez: ");

					// recoje la respuesta
					respuesta = leer.nextLine().toLowerCase();

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

}
