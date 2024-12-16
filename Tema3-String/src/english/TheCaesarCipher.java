package english;

import java.util.Scanner;

public class TheCaesarCipher {

	public static void main(String[] args) {

		// creation of the scanner
		Scanner read = new Scanner(System.in);

		// variable to store the phrase
		String phrase;

		// variable to store the modified phrase
		String modifiedPhrase = "";

		// variable to store each character
		char character;

		// we ask the user for a phrase
		System.out.print("Write a phrase to codify it: ");

		// we store the phrase in the variable
		phrase = read.nextLine().toUpperCase();

		// loop to modify the characters
		for (int i = 0; i < phrase.length(); i++) {
			character = phrase.charAt(i);

			// if the character is a z
			if (character == 'Z' || character == 9) {
				character = 'A';
			} else {
				character++;
			}
			
			modifiedPhrase += character;
		}

		// we show the modified phrase
		System.out.println(modifiedPhrase);

		// close the scanner
		read.close();

	}

}
