import java.util.ArrayList;
import java.util.Scanner;

//Emanuel Pelean
// English to Pig Latin Translator

public class PigLatin {

	public static void main(String[] args) {
		
		//Create scanner and boolean that allows the program to continue again
		Scanner scan = new Scanner(System.in);
		Boolean proceedFirst = true;

		System.out.println("Welcome to the Pig Latin Translator!");
		
		//Boolean based on user input that allows the system to continue again
		while (proceedFirst) {

			System.out.println("\nPlease enter a line to be translated: ");

			//Once the user enters a value, the value is sent to the convertWord() 
			if (scan.hasNext()) {
				convertWord(scan.nextLine());

				System.out.println("\n");

				System.out.println("Translate another line? (y/n)");
				if (!scan.next().equalsIgnoreCase("y")) {
					System.out.println("Thank you for using the Pig Latin translator!");
					proceedFirst = false;
					scan.next();
					
				}
			}
		}

		scan.close();
	}
	// This method takes the user input and splits the sentence
	public static void convertWord(String value) {

		ArrayList<String> arrVal = new ArrayList<String>();
		//As this method splits the sentence, it changes all the words to lowercase and 
		//adds them to the arraylist
		for (String word : value.split(" ")) {
			arrVal.add(word.toLowerCase());
		}

		//Then we loop through the array to get the words back
		for (int i = 0; i < arrVal.size(); i++) {
			String arrWord = arrVal.get(i);

			//If the words start with a vowel we just add "way" to them and print them
			// to the console
			if (Character.toString(arrWord.charAt(0)).matches("[aeiou]")) {
				StringBuilder valSB = new StringBuilder(arrWord).append("way");
				System.out.print(valSB + " ");
			} else {
				// If the words don't start with the vowel we pass them to the indexOfVowel()
				indexOfVowel(arrWord);

			}
		}
	}
	//This method compares the word with the string vowels to see if it matches
	//any of the charaters in the string, and if so it then stores that value.
	//Then it deletes the characters before that index and appends them to the end 
	// of the word while also adding "ay" to each word.
	public static void indexOfVowel(String word) {

		String vowels = "aeiou";
		String testWord = word;
		Boolean proceed = true;

		for (int i = 0; i < testWord.length(); i++) {
			if (proceed) {
				if (vowels.contains(String.valueOf(testWord.charAt(i)))) {
					StringBuilder resultWord = new StringBuilder(testWord);
					resultWord = resultWord.append(resultWord.substring(0, i));
					System.out.print(resultWord.append("ay").delete(0, i) + " ");
					proceed = false;
				}
			}
		}

	}
}
