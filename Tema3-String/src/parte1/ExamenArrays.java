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

		// variable para controlar si esta todo lleno
		boolean lleno = false;

		// contador para comprobar que la tabla esta llena
		int contTablaLlena = 0;

		// respuesta del usuario a seguir jugando o no
		char respuesta;

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
		imprimeTablero();

		// mientras que no haya ganador
		while (!esGanador(charTurno) && contTablaLlena < 9) {

			if (turno == 1) {
				System.out.println("Turno del jugador (X).");

				// imprimeTablero();

				System.out.println("¿Dónde desea colocar la ficha?");

				// recojo sus respuestas
				System.out.print("Fila: ");
				filaJ = leer.nextInt();

				System.out.print("Columna: ");
				colJ = leer.nextInt();

				while (!usuarioMueveFicha(filaJ, colJ)) {
					System.err.println("El movimiento no se pudo efectuar correctamente.");
					// recojo sus respuestas
					System.out.print("Fila: ");
					filaJ = leer.nextInt();

					System.out.print("Columna: ");
					colJ = leer.nextInt();
				}

				// se sigue ejecutando mientras que el movimiento sea erroneo

			} else {
				System.out.println("Turno de la CPU (O).");
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
				charTurno = 'O';
			} else {
				turno = 0;
				charTurno = 'X';
			}

			contTablaLlena++;

			// si el contador está a 9
			if (contTablaLlena == 9) {
				lleno = true;

				// le pregunto al usuario si quiere continuar
				System.out.print("¿Desea seguir jugando? (S/N): ");
				respuesta = leer.next().toUpperCase().charAt(0);

				// si quiere seguir jugando se reinicia el contador
				if (respuesta == 'S') {
					limpiarTablero(lleno);
					contTablaLlena = 0;
					lleno = false;
				}

			}

		}

		// como se ha salido del bucle significa que ha ganado alguien
		if (charTurno == 'X') {
			System.out.println("¡Has ganado, enhorabuena!");
		} else if (esGanador(charTurno) == false) {
			System.out.println("No ha ganado nadie.");
		} else {
			System.out.println("¡Has perdido! ¡Ha ganado la máquina!");
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

		boolean validezMovimiento = false;

		// si la posicion del tablero está vacía añade la X
		if (tablero[filaJ][colJ] == '-') {
			tablero[filaJ][colJ] = 'X';
			validezMovimiento = true;
		}

		return validezMovimiento;

	}

	// funcion para limpiar el tablero
	static void limpiarTablero(boolean lleno) {

		// si lleno es positivo limpia la tabla
		if (lleno == true) {
			for (int i = 0; i < tablero.length; i++) {
				for (int j = 0; j < tablero.length; j++) {
					tablero[i][j] = '-';
				}
			}
		}

	}

	static boolean esGanador(char charTurno) {

		boolean ganador = false;

		// contador
		int contador = 0;

		// variable contador para el indice del array
		int indice = 0;

		// recorrido por filas
		while (!ganador && indice < tablero.length) {
			contador = 0;
			for (int j = 0; j < tablero[indice].length; j++) {
				if (tablero[indice][j] == charTurno) {
					contador++;
				}
			}

			if (contador == 3) {
				ganador = true;
			}

			indice++;
		}

		indice = 0;

		// recorrido por columnas
		while (!ganador && indice < tablero[0].length) {
			contador = 0;
			for (int j = 0; j < tablero.length; j++) {
				if (tablero[j][indice] == charTurno) {
					contador++;
				}
			}

			if (contador == 3) {
				ganador = true;
			}

			indice++;
		}

		indice = 0;
		contador = 0;

		// recorrer diagonal izq der
		while (!ganador && indice < tablero.length) {
			if (tablero[indice][indice] == charTurno) {
				contador++;
			}

			indice++;

			if (contador == 3) {
				ganador = true;
			}

		}

		contador = 0;
		indice = 0;

		// recorrer diagonal der izq
		while (!ganador && indice < tablero.length) {
			if (tablero[indice][indice] == charTurno) {
				contador++;
			}

			indice++;

			if (contador == 3) {
				ganador = true;
			}

		}

		return ganador;
	}
}
