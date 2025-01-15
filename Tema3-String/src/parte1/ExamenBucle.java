package parte1;

import java.util.Random;
import java.util.Scanner;

public class ExamenBucle {

	// escaner
	static Scanner leer = new Scanner(System.in);

	// random
	static Random rand = new Random();

	// constante de las figuras
	static final double FIGURAS = 0.5;

	// respuesta del usuario
	static char respuesta;

	// valor de las cartas
	static int cartas;

	static String cartasLetra;

	// puntos
	static double puntosJ1;
	static double puntosJ2;

	static double puntosActuales = 0;

	// contador de jugadores
	static int contTurno = 1;

	static int palos;

	static String palosLetra;

	public static void main(String[] args) {

		// variable para salir
		boolean exit = false;

		System.out.println("Bienvenido a las siete y media:");
		System.out.println();

		while (!exit) {

			// comienza
			System.out.println("Turno del JUGADOR " + contTurno);
			System.out.print("¿Quiere sacar una carta? (S/N): ");
			respuesta = leer.nextLine().toUpperCase().charAt(0);

			while (respuesta == 'S' && puntosActuales <= 7.5) {
				// carta aleatoria
				cartas = rand.nextInt(1, 11);

				switch (cartas) {

				case 8 -> cartasLetra = "sota";
				case 9 -> cartasLetra = "caballo";
				case 10 -> cartasLetra = "rey";

				}

				// palo aleatorio
				palos = rand.nextInt(1, 5);

				// si el palo es cada cosa
				switch (palos) {

				case 1 -> palosLetra = "oros";
				case 2 -> palosLetra = "copas";
				case 3 -> palosLetra = "espadas";
				case 4 -> palosLetra = "bastos";

				}

				// si la carta no es una figura
				if (cartas < 8) {
					System.out.println("Tu carta es " + cartas + " de " + palosLetra);

					puntosActuales += cartas;

				} else {
					System.out.println("Tu carta es " + cartasLetra + " de " + palosLetra);

					puntosActuales += FIGURAS;
				}

				// si no se ha pasado
				if (puntosActuales <= 7.5) {
					System.out.println("Tienes " + puntosActuales + " puntos");

					// vuelve a preguntar
					System.out.print("¿Quiere sacar otra carta? (S/N): ");
					respuesta = leer.nextLine().toUpperCase().charAt(0);
				} else {
					System.out.println("¡Te has pasado!");
				}
			}

			if (contTurno == 1) {
				puntosJ1 = puntosActuales;
				puntosActuales = 0;
				contTurno++;
			} else {
				puntosJ2 = puntosActuales;
				exit = true;
			}

			/*
			 * // cambio de jugador if (contTurno <= 2) { contTurno++; } else { exit = true;
			 * }
			 */
		}

		System.out.println("El JUGADOR 1 tiene " + puntosJ1 + " puntos y el JUGADOR 2 tiene " + puntosJ2 + " puntos");

		if (puntosJ1 > puntosJ2 && puntosJ1 <= 7.5) {
			System.out.println("Gana el JUGADOR 1.");
		} else if (puntosJ1 > puntosJ2 && puntosJ1 > 7.5 && puntosJ2 <= 7.5) {
			System.out.println("Gana el JUGADOR 2.");
		} else if (puntosJ2 > puntosJ1 && puntosJ2 <= 7.5) {
			System.out.println("Gana el JUGADOR 2.");
		} else if (puntosJ2 > puntosJ1 && puntosJ2 > 7.5 && puntosJ1 <= 7.5) {
			System.out.println("Gana el JUGADOR 1.");
		} else if (puntosJ1 == puntosJ2) {
			System.out.println("Empate.");
		}

	}

}
