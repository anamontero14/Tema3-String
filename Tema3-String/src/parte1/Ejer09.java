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
		String fraseTraducida = "";

		// variable para almacenar el prefijo y el sufijo
		String prefijo = "Javalín, javalón			";
		String sufijo = "			javalén, len, len";

		// variable para comprobar si la frase está en javalín javalón
		boolean empieza = true;
		boolean acaba = true;

		// pregunto al usuario por la frase
		System.out.print("Escriba una frase para traducirla del Javalín, Javalón a español: ");

		// almaceno la frase en la variable
		frase = leer.nextLine();

		// compruebo si la frase está en javalín javalón y lo almaceno en variab
		empieza = frase.startsWith("Javalín, javalón			");
		acaba = frase.endsWith("			javalén, len, len");

		// si la variable es verdad entonces
		if (empieza == true || acaba == true) {
			// si solo tiene el prefijo
			if (empieza == true && acaba == false) {
				// agarra toda la frase desde el final del prefijo
				fraseTraducida = frase.substring(prefijo.length());

				// muestro la frase traducida
				System.out.println("Traducción de la frase: " + fraseTraducida);

				// si solo acaba por el sufijo
			} else if (acaba == true && empieza == false) {

				// agarra toda la frase menos el final
				fraseTraducida = frase.substring(0, (frase.length() - sufijo.length()));

				// muestro la frase traducida
				System.out.println("Traducción de la frase: " + fraseTraducida);

				// si tiene prefijo y sufijo
			} else {

				// agarro lo del "en medio"
				fraseTraducida = frase.substring(prefijo.length(), (frase.length() - sufijo.length()));

				// muestro la frase traducida
				System.out.println("Traducción de la frase: " + fraseTraducida);
			}
		} else {
			// si la frase no está en Javalín Javalón muestra la frase normal
			System.out.println("La frase no está en Javalín, Javalón: " + frase);
		}

		// cierro el scanner
		leer.close();

	}

}
