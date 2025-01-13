package english;

import java.util.Arrays;
import java.util.Scanner;

public class TheHangmanGame {

	static Scanner read = new Scanner(System.in);

	public static void main(String[] args) {

		// word to guess
		char[] guessWord = { 'T', 'A', 'B', 'L', 'E' };

		// array for the attempts of the user
		char[] userAttempts = new char[guessWord.length];

		// boolean var to exit
		boolean exit = false;

		// var to store the try of the user
		char letter;

		// number of attempts
		int counter = 10;

		// fill the array with _
		Arrays.fill(userAttempts, '_');

		// until the counter reaches 0 or until the user guesses the word
		do {
			showUsersAttempt(userAttempts);

			// ask the user for a letter
			System.out.print("Try introducing a letter: ");

			// store the answer in the variable
			letter = read.nextLine().toUpperCase().charAt(0);

			// if the letter isnt in the word it tells it to the user
			if (searchInTheWord(guessWord, letter) == true) {
				System.out.println("The letter is in the word");

				fillTheArray(guessWord, userAttempts, letter);

			} else {
				System.out.println("The letter isnt in the word");
			}

			checkForTheWord(guessWord, userAttempts, exit);

			// decrement the counter
			counter--;

		} while (counter > 0 || !exit);

		// congratulations
		System.out.println("Congratulations! You guessed the word!");

	}

	// function to show the array
	static void showUsersAttempt(char[] userAttempts) {

		// show the array
		for (int i = 0; i < userAttempts.length; i++) {
			System.out.print(userAttempts[i] + " ");
		}

		System.out.println();

	}

	// function to search if the letter is in the word
	static boolean searchInTheWord(char[] guessWord, char letter) {

		// var to store if the letter is or isnt in the word
		boolean isOrIsnt = true;

		char[] copyOfTheWord = guessWord;

		// sort the array
		Arrays.sort(copyOfTheWord);

		// var to store if the letter is in the word
		int search = Arrays.binarySearch(copyOfTheWord, letter);

		// if it isnt in the word it equals the variable to false
		if (search < 0) {
			isOrIsnt = false;
		}

		return isOrIsnt;
	}

	// function to check if the user guesses the word
	static boolean checkForTheWord(char[] guessWord, char[] userAttempts, boolean exit) {

		// if the words are the same it equals exit to true to exit the loop
		if (Arrays.equals(guessWord, userAttempts)) {
			exit = true;
		}

		// returns the modified variable
		return exit;
	}

	static char[] fillTheArray(char[] guessWord, char[] userAttempts, char letter) {

		/*
		 * If the position i has the same letter the user introduced it will put that
		 * letter in the users array
		 */
		for (int i = 0; i < guessWord.length; i++) {

			if (guessWord[i] == letter) {
				userAttempts[i] = letter;
			}
		}

		return userAttempts;
	}

}
