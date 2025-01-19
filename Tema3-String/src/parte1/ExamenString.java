package parte1;

import java.util.Random;
import java.util.Scanner;

public class ExamenString {

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
	static String palabraPista;

	// almacena las letras con las que el jugador lo ha intentado pero que no están
	static String noAcertadas;

	public static void main(String[] args) {
		
		generaPalabra();
		
		pintaPista();
		
		if (menu() == 1) {
			compruebaLetra();
		} else {
			compruebaPalabra();
		}
		
		//

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

		Scanner leer = new Scanner(System.in);

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
	static void compruebaLetra() {

	}

	/*
	 * Recibe como parámetro una cadena y no devuelve nada. La cadena introducida
	 * puede estar en minúscula, mayúscula o una combinación de ambas. En caso de
	 * que la cadena introducida por parámetro coincida con la palabra a acertar,
	 * almacenará en palabraPista la cadena introducida por parámetro. En caso
	 * contrario, no hará nada.
	 */
	static void compruebaPalabra() {

	}

	/*
	 * Función estática. No recibe parámetros y no devuelve nada, sólo pinta por
	 * consola. Debe pintar dos cosas por consola: Letras usadas no acertadas: debe
	 * pintar una lista (en horizontal) con todas las letras que ha usado hasta
	 * ahora pero que no se encuentran en la palabra a adivinar. Para ello hay que
	 * hacer uso de la variable noAcertadas. Pista: pinta por pantalla el contenido
	 * de palabraPista.
	 */
	static void pintaPista() {

	}

}
