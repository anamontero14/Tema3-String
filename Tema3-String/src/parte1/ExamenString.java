package parte1;

import java.util.Random;
import java.util.Scanner;

public class ExamenString {

	static Scanner leer = new Scanner(System.in);

	// array de las palabras
	static String[] palabras = { "humanidad", "persona", "hombre", "mujer", "individuo", "cuerpo", "pierna", "cabeza",
			"brazo", "familia" };

	// constante con el numero de intentos que tendra el usuario para adivinar la
	// palabra
	static final int NUMINTENTOS = 7;

	// almacena la palabra a acertar
	static String palabraSecreta;

	/*
	 * almacenará la pista del juego. Ejemplo: si la palabra a adivinar es
	 * “individuo” y el jugador ha introducido i, esta variable almacenará la
	 * siguiente cadena: i__i_i___
	 */
	static String palabraPista = "";

	// almacena las letras con las que el jugador lo ha intentado pero que no están
	static String noAcertadas = "";

	public static void main(String[] args) {

		// variable que almacenara la letra que el usuario quiere adivinar
		char letra;

		String palabra = "";

		int contador = 0;

		int opcion;

		boolean error = false;

		// boolean salir = false;

		generaPalabra();

		System.out.println(palabraSecreta);

		// relleno la palabra pista con rallones
		for (int i = 0; i < palabraSecreta.length(); i++) {
			palabraPista += "_";
		}

		do {
			// incrementa el contador
			contador++;

			pintaPista();

			// imprimo el numero de intentos
			System.out.println("Número de intentos " + contador + "/" + NUMINTENTOS);

			do {
				opcion = menu();

				if (opcion == 1) {

					// recoge la letra a mostrar
					System.out.print("Introduzca la letra: ");
					letra = leer.next().toLowerCase().charAt(0);

					compruebaLetra(letra);

					error = true;

				} else if (opcion == 2) {
					// recoge la palabra
					System.out.print("Introduzca la palabra: ");
					leer.nextLine();
					palabra = leer.nextLine().toLowerCase();

					compruebaPalabra(palabra);

					error = true;

				} else {
					System.err.println("Ha introducido una opción incorrecta, escoja otra.");
				}
			} while (!error);

		} while (contador < 7 && !palabraSecreta.equalsIgnoreCase(palabraPista));

		if (contador == NUMINTENTOS && !palabraSecreta.equalsIgnoreCase(palabraPista)) {
			System.out.println("GAME OVER");
		} else {
			System.out.println("¡¡ENHORABUENA!! HAS ACERTADO");
		}

	}

	/*
	 * No recibe ningún parámetro de entrada ni devuelve nada. Almacena en la
	 * variable palabraSecreta una de las palabras almacenadas en el array palabras.
	 * La palabra se selecciona de forma aleatoria.
	 */
	static void generaPalabra() {

		Random rand = new Random();

		// Asigna una palabra aleatoria del array
		palabraSecreta = palabras[rand.nextInt(0, palabras.length)];

	}

	/*
	 * No tiene parámetros de entrada y devuelve un número entero con la opción
	 * seleccionada. Debe pintar lo siguiente por consola
	 */
	static int menu() {

		int opcion = 0;

		System.out.println("Seleccione una de las siguientes opciones:");

		System.out.println("\t 1. Introducir una letra \n \t 2. Introducir una palabra");

		System.out.print("Opción: ");
		opcion = leer.nextInt();

		return opcion;

	}

	/*
	 * Recibe como parámetro de entrada una letra. Esta letra puede estar en
	 * mayúscula o en minúscula. No devuelve nada. A continuación, comprueba si esa
	 * letra se encuentra en la palabra a acertar. En caso afirmativo, actualiza la
	 * variable palabraPista con las posiciones acertadas. En caso contrario, añade
	 * la letra a noAcertadas.
	 */
	static void compruebaLetra(char letra) {

		// letra en cadena
		String letraAuxiliar = String.valueOf(letra);

		if (palabraSecreta.contains(letraAuxiliar)) {

			// si se encuentra en la cadena
			for (int i = 0; i < palabraSecreta.length(); i++) {
				// si recorre la palabra y se encuentra la letra
				if (palabraSecreta.charAt(i) == letra) {
					// se añade lo que haya entre esos valores
					palabraPista = palabraPista.substring(0, i) + letra + palabraPista.substring(i + 1);
				}
			}
		} else {
			// si no la contiene se añade a las letras no acertadas
			noAcertadas += letraAuxiliar + "  ";
		}
	}

	// comprueba que la palabra y la palabra a adivinar sean o no iguales
	static void compruebaPalabra(String palabra) {

		// comprobar si son iguales
		if (palabraSecreta.equalsIgnoreCase(palabra)) {
			// si son iguales pone la palabra introducida en palabra pista
			palabraPista = palabra;
		}

	}

	// muestra la palabra pista y las letras no acertadas
	static void pintaPista() {

		// muestro la pista
		System.out.println("Pista: " + palabraPista);

		System.out.println();
		// muestro las no acertadas
		System.out.println("Letras no acertadas: " + noAcertadas);

	}

}
