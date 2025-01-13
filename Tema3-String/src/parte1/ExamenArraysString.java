package parte1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ExamenArraysString {

	// creacion de la clase random
	static Random rand = new Random();

	static Scanner leer = new Scanner(System.in);

	// array del abecedario
	static char[][] abecedario = { { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i' },
			{ 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q' }, { 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' } };

	// contendrá las frases con la que vamos a jugar
	static String[] frases = {
			"las guerras seguiran mientras el color de la piel siga siendo mas importante que el de los ojos",
			"aprende a vivir y sabras morir bien", "cada dia sabemos mas y entendemos menos",
			"el dinero no puede comprar la vida", "la verdadera sabiduria esta en reconocer la propia ignorancia" };

	// almacenará la frase con la que se va a jugar
	static String fraseReal;

	// almacenará la codificación de la frase real
	static String fraseCodificada = "";

	public static void main(String[] args) {

		desordenaAbecedario();

		// llamo a la función
		System.out.println(Arrays.deepToString(abecedario));

		eligeFrase();

		System.out.println(fraseReal);

		codificaFrase();

		System.out.println(fraseCodificada);

		// se le da la enhorabuena al jugador

		// cierro el scanner
		leer.close();
	}

	// Modifica la tabla abecedario desordenando las letras de la misma
	static void desordenaAbecedario() {

		// variable para guardar el numero random para la fila
		int numRandFila;

		// variable para guardar el numero random para la columna
		int numRandCol;

		// variable auxiliar
		char aux;

		// bucle for para desordenar el abecedario
		for (int i = 0; i < abecedario.length; i++) {
			for (int j = 0; j < abecedario[i].length; j++) {

				// creo un nº random
				numRandFila = rand.nextInt(0, abecedario.length);

				// creo un nº random
				numRandCol = rand.nextInt(0, abecedario[i].length);

				// lo que haya en abecedario[i] lo meto an aux
				aux = abecedario[i][j];

				// en la posicion i almaceno lo que haya en la posición random
				abecedario[i][j] = abecedario[numRandFila][numRandCol];

				// en la posición aleatoria meto lo que haya en la variable auxiliar
				abecedario[numRandFila][numRandCol] = aux;

			}
		}

	}

	// Elige una frase al azar del array frases y la asigna al atributo fraseReal
	static void eligeFrase() {

		// variable para almacenar un numero random
		int numRand = rand.nextInt(0, frases.length);

		// almaceno lo que haya en la fila random de las frases en la variable frase
		// real
		fraseReal = frases[numRand];

	}

	/*
	 * Debe codificar fraseReal letra a letra. El código de cada letra es sus
	 * coordenadas en el array. La codificación se almacenará en fraseCodificada.
	 * Entre cada código debe haber un espacio (“ “). Los espacios de la fraseReal
	 * no se codifican, sino que aparecerán como dos espacios en la fraseCodificada
	 * 
	 * 
	 * fraseReal = “el dinero no puede comprar la vida” fraseCodificada = “14 02 13
	 * 18 04 14 20 06 04 06 07 23 14 13 14 …”
	 */
	static void codificaFrase() {

		// variable para almacenar la letra
		char letra = ' ';

		// bucle para recorrer la frase real
		for (int i = 0; i < fraseReal.length(); i++) {

			// si el caracter no es un espacio
			if (fraseReal.charAt(i) != ' ') {
				letra = fraseReal.charAt(i);
			} else {
				fraseCodificada += "   ";
			}

			// bucle para recorrer el abecedario
			for (int j = 0; j < abecedario.length; j++) {
				for (int k = 0; k < abecedario[0].length; k++) {

					if (letra == abecedario[j][k]) {
						fraseCodificada += j;
						fraseCodificada += " ";
						fraseCodificada += k;
					}

				}
			}
		}

	}

	/*
	 * Recibirá un código y una letra y comprobará si ese código se corresponde a la
	 * letra introducida, para lo cual tendrá que mirarlo en el array abecedario. En
	 * caso afirmativo, sustituirá en fraseCodificada el código introducido por la
	 * letra indicada y devolverá true. En caso de que el código introducido no
	 * coincida con la letra indicada no hace nada y devuelve false
	 */

	// Ejemplo: Código: 04 Letra: ‘n’ → La función devuelve true y se modifica
	// fraseCodificada: “14 02 13 18 n 14 20 06 n 06 07 23 14 13 14 …”
	static String compruebaCodigo(String fraseCodificada) {

		// variable que almacenará el código
		int codigo;

		// variable que almacenará la letra
		char letra;

		return fraseCodificada;
	}

	/*
	 * Devolverá true si la fraseCodificada coincide con la fraseReal y false en
	 * caso contrario
	 */
	static boolean sonIguales(String fraseCodificada, String fraseReal) {

		// variable que almacena si son o no iguales (por defecto lo son)
		boolean comprobacion = true;

		return comprobacion;
	}

}
