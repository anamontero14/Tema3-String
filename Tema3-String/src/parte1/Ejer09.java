package parte1;

import java.util.Scanner;

public class Ejer09 {

	public static void main(String[] args) {

		/*
		 * Los habitantes de Javalandia tienen un idioma algo extraño; cuando hablan
		 * siempre comienzan sus frases con “Javalín, javalón”, para después hacer una
		 * pausa más o menos larga (la pausa se representa mediante espacios en blanco o
		 * tabuladores) y a continuación expresan el mensaje. Existe un dialecto que no
		 * comienza sus frases con la muletilla anterior, pero siempre las terminan con
		 * un silencio, más o menos prolongado y la coletilla “javalén, len, len”. Se
		 * pide diseñar un traductor que, en primer lugar, nos diga si la frase
		 * introducida está escrita en el idioma de Javalandia (en cualquiera de sus
		 * dialectos), y en caso afirmativo, nos muestre solo el mensaje sin muletillas.
		 */

		// creo el scanner
		Scanner leer = new Scanner(System.in);

		// creo la variable que almacenará la frase
		String frase;

		// variable para almacenar la frase traducida
		String fraseTraducida;

		// variable para comprobar si la frase está en javalín javalón
		boolean empieza = true;
		boolean acaba = true;

		// pregunto al usuario por la frase
		System.out.print("Escriba una frase para traducirla: ");

		// almaceno la frase en la variable
		frase = leer.nextLine();

		// compruebo si la frase está en javalín javalón
		empieza = frase.startsWith("Javalín, javalón			");
		acaba = frase.endsWith("			javalén, len, len.");

		// si la variable es verdad entonces
		if (empieza == true && acaba == true) {
			// reemplazo los prefijos y sufijos
			fraseTraducida = frase.replace("Javalín, javalón			", "");
			fraseTraducida = frase.replace("			javalén, len, len", "");

			// muestro la frase traducida
			System.out.println(fraseTraducida);
		}

		// cierro el scanner
		leer.close();

	}

}
