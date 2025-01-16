package parte1;

import java.util.Random;
import java.util.Scanner;

public class ExamenBuscaminas {

	// scanner
	static Scanner leer = new Scanner(System.in);

	// random
	static Random rand = new Random();

	// array bidimensional
	static char[][] tablero = new char[6][6];

	// tablero del jugador
	static char[][] tableroJ = new char[6][6];

	// numero de minas
	static final int NUMERO_MINAS = 10;

	// numero de movimientos posibles
	static int movimientosPosibles = tablero.length * tablero.length - NUMERO_MINAS;

	// fila y columna del usuario
	static int filaJ;
	static int colJ;

	public static void main(String[] args) {

		boolean exit = false;

		// relleno los dos tableros
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				tablero[i][j] = '.';
				tableroJ[i][j] = '.';
			}
		}

		colocalMinas();
		mostrarTablero(tablero);

		colocarPistas();

		System.out.println();
		System.out.println();
		mostrarTablero(tablero);

		do {
			try {
				// donde quiere mover la ficha
				System.out.println("¿Qué casilla desea desvelar?");

				System.out.print("Fila: ");
				filaJ = leer.nextInt();

				System.out.print("Columna: ");
				colJ = leer.nextInt();

				assert filaJ >= 0 && filaJ <= 5 && colJ >= 0 && colJ <= 5
						: "Ha intentado introducir un valor fuera del rango. Inténtelo de nuevo.";

				exit = true;

			} catch (AssertionError a) {
				System.err.println(a.getLocalizedMessage());
			} finally {
				leer.nextLine();
			}
		} while (!exit);

		movimientosPosibles--;

		while (movimientosPosibles > 0 && !movimientoUsuario()) {
			exit = false;

			mostrarTablero(tablero);
			System.out.println();
			System.out.println();
			mostrarTablero(tableroJ);

			do {
				try {
					// donde quiere mover la ficha
					System.out.println("¿Qué casilla desea desvelar?");

					System.out.print("Fila: ");
					filaJ = leer.nextInt();

					System.out.print("Columna: ");
					colJ = leer.nextInt();

					assert filaJ >= 0 && filaJ <= 5 && colJ >= 0 && colJ <= 5
							: "Ha intentado introducir un valor fuera del rango. Inténtelo de nuevo.";

					exit = true;

				} catch (AssertionError a) {
					System.err.println(a.getLocalizedMessage());
				} finally {
					leer.nextLine();
				}
			} while (!exit);

			movimientoUsuario();

			movimientosPosibles--;
		}

		/*
		 * determina si se ha acabado el programa porque ha encontrado una mina o porque
		 * ha desvelado todas las posiciones sin explotar
		 */
		ganaONoGana();

	}

	// mostrar los tableros
	static void mostrarTablero(char[][] tableroAMostrar) {

		for (char fila[] : tableroAMostrar) {
			for (char col : fila) {
				System.out.print(col + "  ");
			}
			System.out.println();
		}

	}

	// asignar las minas en el tablero
	static void colocalMinas() {

		// numero aleatorio de casilla para colocar la mina
		int posFila;
		int posCol;

		int contador = NUMERO_MINAS;

		// hago un bucle para crear tantas posiciones random como minas hay
		while (contador > 0) {

			// asigno un numero aleatorio a las filas y columnas
			posFila = rand.nextInt(0, tablero.length);
			posCol = rand.nextInt(0, tablero.length);

			if (tablero[posFila][posCol] == '.') {
				tablero[posFila][posCol] = '*';
				contador--;
			}

		}

	}

	// colocar las pistas en cada casilla
	static void colocarPistas() {

		// numero de minas encontradas
		int contMinas = 0;

		// recorrer todo el tablero
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {

				// distinguir si en la casilla hay una mina o no
				if (tablero[i][j] != '*') {
					// reinicio el contador
					contMinas = 0;

					// para la izquierda
					if (j - 1 >= 0 && tablero[i][j - 1] == '*') {
						contMinas++;
					}

					// a la derecha
					if (j + 1 < tablero[i].length && tablero[i][j + 1] == '*') {
						contMinas++;
					}

					// para arriba
					if (i - 1 >= 0 && tablero[i - 1][j] == '*') {
						contMinas++;
					}

					// para abajo
					if (i + 1 < tablero.length && tablero[i + 1][j] == '*') {
						contMinas++;
					}

					// para diagonal izquierda arriba
					if (i - 1 >= 0 && j - 1 >= 0 && tablero[i - 1][j - 1] == '*') {
						contMinas++;
					}

					// para diagonal derecha arriba
					if (i - 1 >= 0 && j + 1 < tablero[i].length && tablero[i - 1][j + 1] == '*') {
						contMinas++;
					}

					// para diagonal izquierda abajo
					if (i + 1 < tablero.length && j - 1 >= 0 && tablero[i + 1][j - 1] == '*') {
						contMinas++;
					}

					// para diagonal derecha abajo
					if (i + 1 < tablero.length && j + 1 < tablero[i].length && tablero[i + 1][j + 1] == '*') {
						contMinas++;
					}

					// metes la pista en la casilla
					tablero[i][j] = (char) ('0' + contMinas);
				}
			}
		}
	}

	// colocar ficha del usuario
	static boolean movimientoUsuario() {

		// variable para determinar si ha encontrado una mina o no
		boolean encuentraMina = false;

		// si la casilla no tiene mina la coloca ahi
		if (tablero[filaJ][colJ] != '*') {
			tableroJ[filaJ][colJ] = tablero[filaJ][colJ];
		} else {
			encuentraMina = true;
		}

		return encuentraMina;

	}

	static void ganaONoGana() {

		if (movimientoUsuario() == true) {
			System.out.println("¡Oh no! ¡Has explotado!");
		} else if (movimientosPosibles == 0) {
			System.out.println("Enhora buena, ¡has ganado!");
		}

	}

}
