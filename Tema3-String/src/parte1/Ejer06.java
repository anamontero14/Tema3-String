package parte1;

import java.util.Scanner;

public class Ejer06 {

	public static void main(String[] args) {

		/*
		 * Realizar una función que reciba una frase como parámetro de entrada y nos
		 * indique si es palíndroma, es decir, que la frase sea igual leyendo de
		 * izquierda a derecha, que de derecha a izquierda, sin tener en cuenta los
		 * espacios. Un ejemplo de frase palíndroma es: “Dabale arroz a la zorra el
		 * abad”. Las vocales con tilde hacen que un algoritmo tome una frase palíndroma
		 * como si no lo fuese. Por esto, supondremos que el usuario introduce la frase
		 * sin tildes
		 */

		// creacion del scanner
		Scanner leer = new Scanner(System.in);

		// creo la variable para almacenar la frase
		String frase;

		// creo una variable para almacenar la cadena vaciada
		String fraseCambiada;

		// pregunto al usuario para que introduzca una frase
		System.out.print("Introduzca una frase: ");

		// la almaceno en la variable
		frase = leer.nextLine();

		// almaceno la frase sin espacios en la variable
		fraseCambiada = frase.replace(" ", "");

		// paso la frase a minúsculas
		fraseCambiada = fraseCambiada.toLowerCase();

		// si la función es false
		if (cadenaPalindroma(fraseCambiada) == false) {

			// muestro la solución
			System.out.println("La cadena NO es palíndroma.");

		} else {
			System.out.println("La cadena ES palíndroma.");
		}

		// cierro el scanner
		leer.close();

	}

	// funcion para comprobar si es palíndroma o no
	static boolean cadenaPalindroma(String fraseCambiada) {

		// creo una variable booleana para decir si la cadena lo es o no
		boolean igual = true;

		// compruebo si es palíndroma o no
		for (int i = 0, j = fraseCambiada.length() - 1; i < fraseCambiada.length(); i++, j--) {

			// si no son iguales igualo a false
			if (fraseCambiada.charAt(i) != fraseCambiada.charAt(j)) {
				// igualo a false
				igual = false;
			}
		}

		// devuelvo el valor booleano
		return igual;
	}

}
