package parte1;

import java.util.Arrays;
import java.util.Scanner;

public class Ejer02 {

	public static void main(String[] args) {

		/*
		 * Diseña el juego “Acierta la contraseña”. La mecánica del juego es la
		 * siguiente: el primer jugador introduce la contraseña; a continuación, el
		 * segundo jugador debe teclear palabras hasta que la acierte. El juego debe
		 * indicar si la palabra introducida es mayor o menor alfabéticamente que la
		 * contraseña. 
		 * VERSIÓN AVANZADA: El juego, en vez de indicar si la palabra es
		 * mayor o menor alfabéticamente que la contraseña, debe mostrar una cadena con
		 * los caracteres acertados en sus lugares respectivos y asteriscos en los no
		 * acertados
		 */

		// creo el scanner
		Scanner leer = new Scanner(System.in);

		// creo un array para introducir los aciertos
		char contenerAciertos[];

		// creo un array para contener los intentos
		char contenerIntentos[];

		// creo la variable que almacenará la contraseña
		String contraseña;

		// creo la variable que almacenará los intentos a adivinar la contraseña
		String adivinar;

		// le pregunto al jugador 1 por la contraseña
		System.out.print("Introduzca la contraseña: ");

		// almaceno la respuesta en la variable
		contraseña = leer.nextLine();

		// le indico los array cuánto miden
		contenerAciertos = new char[contraseña.length()];
		contenerIntentos = new char[contraseña.length()];

		// almaceno la contraseña en un array
		for (int i = 0; i < contraseña.length(); i++) {
			// en cada posicion del array le igualo lo que va cogiendo el charAt
			contenerAciertos[i] = contraseña.charAt(i);
			contenerIntentos[i] = '*';
		}

		// el jugador 2 intenta acertar la contraseña
		System.out.print("¿Cuál cree que es la contraseña?: ");

		// almaceno la respuesta en la variable
		adivinar = leer.nextLine();

		// mientras que el usuario no acierte sigue preguntando
		while (!contraseña.equals(adivinar)) {

			// indica que ha fallado
			System.out.println("¡Has fallado!");

			// si el intento introducido es mas largo
			if (contraseña.length() < adivinar.length()) {

				// creo un bucle for para comprobar si los caracteres son iguales
				for (int i = 0; i < adivinar.length() - (adivinar.length() - contraseña.length()); i++) {
					// si la posición que recorre el array es igual al caráter del string:
					if (contenerAciertos[i] == adivinar.charAt(i)) {
						// igualo lo que haya en contener aciertos
						contenerIntentos[i] = contenerAciertos[i];
					}
				}
				// si es al revés
			} else {

				// creo un bucle for para comprobar si los caracteres son iguales
				for (int i = 0; i < adivinar.length(); i++) {
					// si la posición que recorre el array es igual al caráter del string:
					if (contenerAciertos[i] == adivinar.charAt(i)) {
						// igualo lo que haya en contener aciertos
						contenerIntentos[i] = contenerAciertos[i];
					}
				}
			}

			// muestro el array de los intentos
			System.out.println(Arrays.toString(contenerIntentos));

			// el jugador 2 intenta acertar la contraseña
			System.out.print("¿Cuál cree que es la contraseña?: ");

			// almaceno la respuesta en la variable
			adivinar = leer.nextLine();

		}

		// si acierta
		System.out.println("¡Acertaste!");

		// cierro el scanner
		leer.close();

	}

}
