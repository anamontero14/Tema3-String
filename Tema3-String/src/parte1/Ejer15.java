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
				System.out.println("Enhorabuena, ¡has acertado!");
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
				System.out.println("Enhorabuena, ¡has acertado!");
			}
		}

		// cerrar scanner
		leer.close();

	}

	// Función para desordenar la frase
	static String transposicionDeCaracteres(String frase) {

		// creación de clase random
		Random rand = new Random();

		// creación de variable para almacenar la frase cambiada
		String resultado = "";

		// conversión de la frase a array
		char[] fraseCambiada = frase.toCharArray();

		// variable para almacenar la letra que se va a machacar a continuación
		char aux;

		// variable para almacenar el número aleatorio
		int numAleatorio;

		// bucle para recorrer el array e ir intercambiando los datos
		for (int i = 0; i < fraseCambiada.length; i++) {

			// genero un nº aleatorio y lo almaceno en la variable
			numAleatorio = rand.nextInt(0, fraseCambiada.length);

			// en la variable almaceno lo que haya en la posicion i para que no se pierda
			aux = fraseCambiada[i];

			// en la posición i almaceno lo que haya en la posición aleatoria
			fraseCambiada[i] = fraseCambiada[numAleatorio];

			// en la posición aleatoria almaceno lo que haya en la variable
			fraseCambiada[numAleatorio] = aux;
		}

		// paso el array a string y lo almaceno
		resultado = String.valueOf(fraseCambiada);

		return resultado;

	}

}