package parte1;

import java.util.Scanner;

public class Ejer17 {

	public static void main(String[] args) {

		/*
		 * El preprocesador del lenguaje C elimina los comentarios del código fuente
		 * antes de compilar. Diseña una función que reciba como parámetro una sentencia
		 * en C, y devuelva una cadena sin los comentarios
		 */

		// creacion del scanner
		Scanner leer = new Scanner(System.in);

		// variable para almacenar la sentencia
		String sentencia;

		// le pido al usuario que la introduzca
		System.out.print("Introduzca la sentencia en C: ");

		// almaceno la respuesta en la variable
		sentencia = leer.nextLine();

		System.out.println(sinComentarios(sentencia));

		// cerrar el scanner
		leer.close();

	}

	static String sinComentarios(String sentencia) {

		// Variable para almacenar la sentencia sin comentarios
		String sentenciaSinComentarios = sentencia;

		int inicioComentarioLinea;

		int inicioComentarioBloque;

		int finComentarioBloque;

		// Eliminar comentarios de línea (// ...)
		inicioComentarioLinea = sentenciaSinComentarios.indexOf("//");
		if (inicioComentarioLinea != -1) {
			sentenciaSinComentarios = sentenciaSinComentarios.substring(0, inicioComentarioLinea);
		}

		// Eliminar comentarios de bloque (/* ... */)
		inicioComentarioBloque = sentenciaSinComentarios.indexOf("/*");
		while (inicioComentarioBloque != -1) {
			finComentarioBloque = sentenciaSinComentarios.indexOf("*/", inicioComentarioBloque + 2);
			if (finComentarioBloque == -1) {
				// Si no se encuentra el cierre del bloque, elimina todo desde /* hasta el final
				finComentarioBloque = sentenciaSinComentarios.length() - 2; // Simula el cierre al final
			}
			// Eliminar el bloque completo
			sentenciaSinComentarios = sentenciaSinComentarios.substring(0, inicioComentarioBloque)
					+ sentenciaSinComentarios.substring(finComentarioBloque + 2);
			// Buscar otro bloque
			inicioComentarioBloque = sentenciaSinComentarios.indexOf("/*");
		}

		// Retornar la sentencia sin comentarios
		return sentenciaSinComentarios.trim();
	}
}