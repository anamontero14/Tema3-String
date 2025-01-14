package parte1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ExamenArrays {

	// scanner
	static Scanner leer = new Scanner(System.in);

	// clase random
	static Random rand = new Random();

	// tablero
	static char[][] tablero = new char[3][3];

	// variable para salir
	static boolean exit = false;

	public static void main(String[] args) {

		// variable de la fila del jugador
		int filaJ;

		// variable de la columna del jugador
		int colJ;

		// turno de jugadores
		int turno;

		// caracter del turno
		char charTurno = 'O';

		// relleno el tablero
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				tablero[i][j] = '-';
			}
		}

		System.out.println("Bienvenid@ al 3 en raya.");
		System.out.println();

		// se decide quién empieza a jugar
		turno = jugadorInicial();

		while (!esGanador(charTurno)) {

			if (turno == 1) {
				System.out.println("Comienza el jugador (X).");

				do {
					System.out.println("¿Dónde desea colocar la ficha?");

					// recojo sus respuestas
					System.out.print("Fila: ");
					filaJ = leer.nextInt();

					System.out.print("Columna: ");
					colJ = leer.nextInt();

					usuarioMueveFicha(filaJ, colJ);

					if (usuarioMueveFicha(filaJ, colJ) == false) {
						System.out.println("El movimiento no se pudo efectuar correctamente.");
					}

					// se sigue ejecutando mientras que el movimiento sea erroneo
				} while (!usuarioMueveFicha(filaJ, colJ));

			} else {
				System.out.println("Comienza la CPU (O).");
				// mueve ficha la máquina
				mueveFichaAleatoria();
			}

			System.out.println();
			imprimeTablero();

			/*
			 * Si el turno esta en 0 incrementa, pasandole el turno al jugador, en cambio si
			 * el turno ya estaba en 1 vuelve a 0 siendo ahora el turno de la maquina.
			 * 
			 * Si el turno es del jugador el caracter actual será la X y si no la O.
			 */
			if (turno == 0) {
				turno++;
				charTurno = 'X';
			} else {
				turno = 0;
				charTurno = 'O';
			}

		}

	}

	// función para imprimir el tablero
	static void imprimeTablero() {

		for (char[] filas : tablero) {
			for (char columnas : filas) {
				System.out.print(columnas + " ");
			}
			System.out.println();
		}

	}

	// función para decidir quién empezará a jugar
	static int jugadorInicial() {

		// variable para indicar el turno
		int turno = rand.nextInt(0, 2);

		return turno;
	}

	// mover aleatoriamente las fichas de la maquina
	static void mueveFichaAleatoria() {

		// variable para almacenar la fila aleatoria
		int filaRandom;

		// variable para almacenar la columna aleatoria
		int colRandom;

		// variable para salir del bucle
		boolean exit = false;

		// mientras que en la casilla aleatoria haya algo distinto a -
		while (!exit) {

			// filas y columnas aleatorias
			filaRandom = rand.nextInt(0, tablero.length);
			colRandom = rand.nextInt(0, tablero.length);

			// si lo que hay en la posición random está vacío le pone ficha, si no sigue
			if (tablero[filaRandom][colRandom] == '-') {
				tablero[filaRandom][colRandom] = 'O';
				exit = true;
			}

		}

	}

	// jugador asigna la posición de su ficha
	static boolean usuarioMueveFicha(int filaJ, int colJ) {

		boolean validezMovimiento = true;

		// si la posicion del tablero está vacía añade la X
		if (tablero[filaJ][colJ] == '-') {
			tablero[filaJ][colJ] = 'X';
		} else {
			// es false porque no se ha podido ejecutar el movimiento
			validezMovimiento = false;
		}

		return validezMovimiento;

	}

	static boolean esGanador(char charTurno) {

		boolean ganador = false;

		// contador
		int contador = 0;

		// recorrer las columnas en horizontal
		for (char[] fila : tablero) {
			for (char col : fila) {
				// si lo que hay en la columna es lo mismo que el caracter incrementa
				if (col == charTurno) {
					contador++;
				}

				// si el contador llega a 3 ha ganado
				if (contador == 3) {
					ganador = true;
				}
			}
			contador = 0;
		}

		// recorrer en vertical
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				// si lo que hay en la columna es lo mismo que el caracter incrementa
				if (tablero[j][i] == charTurno) {
					contador++;
				}
				// si el contador llega a 3 ha ganado
				if (contador == 3) {
					ganador = true;
				}
			}
			contador = 0;
		}

		// recorrer diagonal izq der
		for (int i = 0, j = 0; i < tablero.length; i++, j++) {
			// si lo que hay en la columna es lo mismo que el caracter incrementa
			if (tablero[j][i] == charTurno) {
				contador++;
			}
			// si el contador llega a 3 ha ganado
			if (contador == 3) {
				ganador = true;
			}
		}

		contador = 0;

		// recorrer diagonal der izq
		for (int i = tablero.length - 1, j = tablero.length - 1; i >= 0; i--, j--) {
			// si lo que hay en la columna es lo mismo que el caracter incrementa
			if (tablero[j][i] == charTurno) {
				contador++;
			}
			// si el contador llega a 3 ha ganado
			if (contador == 3) {
				ganador = true;
			}
		}

		contador = 0;

		return ganador;
	}
}
