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

		//int shift;

		// we ask the user for a phrase
		System.out.print("Write a phrase to codify it: ");

		// we store the phrase in the variable
		phrase = read.nextLine().toUpperCase();

		/*System.out.println("How much do you want the letter to increment?");

		shift = read.nextInt();*/

		// loop to modify the characters
		for (int i = 0; i < phrase.length(); i++) {

			// i grab a character
			character = phrase.charAt(i);

			// if the character is between a and y or between 0 and 8
			if ((character >= 'A' && character < 'Z') || (character >= '0' && character < '9')) {
				// it increments
				character++;
				// if it is a z
			} else if (character == 'Z') {
				// it goes back to a
				character = 'A';
				// if its a 9
			} else if (character == '9') {
				// it goes back to 0
				character = '0';
			}

			// it adds the chatacter to the phrase
			modifiedPhrase += character;
		}

		// we show the modified phrase
		System.out.println(modifiedPhrase);

		// close the scanner
		read.close();

	}

}
