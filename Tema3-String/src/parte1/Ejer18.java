package parte1;

import java.util.Scanner;

public class Ejer18 {

	public static void main(String[] args) {

		/*
		 * Escribe una función que reciba el título y el contenido de una página web. La
		 * función devolverá una cadena con un código HTML, donde el título será un
		 * encabezado de primer nivel (<h1>), y el resto del contenido será un párrafo
		 * (<p>). El documento HTML debe contar con todas las etiquetas mínimas que todo
		 * documento HTML tiene
		 */

		// creamos el scanner
		Scanner leer = new Scanner(System.in);

		// declaramos las variables para guardar el título y el contenido de la página
		String titulo;
		String contenido;

		// variable para guardar el código html que vamos a crear
		String codigoHTML;

		// pedimos al usuario que ingrese el título de la página
		System.out.print("Introduce el título de la página: ");
		// guardamos el título que escribe el usuario
		titulo = leer.nextLine();

		// pedimos al usuario que ingrese el contenido de la página
		System.out.print("Introduce el contenido de la página: ");
		// guardamos el contenido que escribe el usuario
		contenido = leer.nextLine();

		// llamamos a la función que genera el código html y lo guardamos en la variable
		// codigoHTML
		codigoHTML = generarHTML(titulo, contenido);

		// mostramos el código html que generamos
		System.out.println("\nEl código HTML generado es:\n");
		// mostramos el código completo
		System.out.println(codigoHTML);

		// cerramos el scanner
		leer.close();
	}

	static String generarHTML(String titulo, String contenido) {
		// declaramos las partes del código html

		// abrimos el documento html y la parte del título
		String aperturaHTML = "<!DOCTYPE html>\n<html>\n<head>\n<title>";

		// cerramos la etiqueta del título y abrimos el cuerpo de la página
		String cierreTitulo = "</title>\n</head>\n<body>\n";

		// ponemos el título como un encabezado grande
		String encabezado = "<h1>" + titulo + "</h1>\n";

		// ponemos el contenido como un párrafo
		String parrafo = "<p>" + contenido + "</p>\n";

		// cerramos el cuerpo y el documento html
		String cierreHTML = "</body>\n</html>";

		// juntamos todas las partes del código html en una sola cadena
		String codigoCompleto = aperturaHTML + titulo + cierreTitulo + encabezado + parrafo + cierreHTML;

		// devolvemos el código html completo
		return codigoCompleto;
	}
}