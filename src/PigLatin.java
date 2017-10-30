import java.util.ArrayList;
import java.util.Scanner;

//Emanuel Pelean
//Official English to Pig Latin Translator

public class PigLatin {
	/**
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Boolean choice = true;

		System.out.println("Welcome to the Pig Latin Translator! \n");

		// This is the token that is used to continue the program, based on user input
		while (choice) {
			
			// Get the user input and send the value to the convert()
			//Test to make sure the input is valid and not null
			try {
				String userInput = Validator.getStringLine(scan, "\nPlease enter a sentence: \n \n");
				System.out.println();

				if (!(userInput == null)) {
					convert(userInput);

					//Ask user if they want to continue, then continue or end the program
					System.out.println("\n \nTranslate another line? (y/n):");
					String userChoice = Validator.getString(scan, "\n");
				
					if (!Character.toString(userChoice.charAt(0)).matches("y")) {

						System.out.println("Thank you for using the Pig Latin Translator");
						choice = false;
					} 
				}

				// Possible exception if user enters a "null" value for their sentence
			} catch (IndexOutOfBoundsException e) {
				System.out.println("You have entered an invisible sentence, unfortunately \n"
						+ "this feature will only be available in the next upgrade! \n");
			}
		}

		scan.close();
	}
	/**
	 * 
	 * @param userVal
	 */

	//Method used to convert user input to Pig Latin
	private static void convert(String userVal) {

		System.out.println("In Pig Latin this means: ");

		//Create an array list, then split the user sentence into separate words
		//Add each lower case version of the words to the array list
		ArrayList<String> valArr = new ArrayList<String>();

		for (String word : userVal.split(" ")) {
			valArr.add(word.toLowerCase());
		}

		//Loop through the array list items and compare them to each condition
		for (int i = 0; i < valArr.size(); i++) {
			String arrWord = valArr.get(i);

			// If the words start with a vowel, just append "way" and print
			if (Character.toString(arrWord.charAt(0)).matches("[aeiou]")) {
				StringBuilder valSB = new StringBuilder(arrWord).append("way");
				System.out.print(valSB + " ");
			} else {

				/*If the words don't start with a vowel, check to see at which index
				 * they have the first vowel. Then copy the substring from the beginning
				 * up to that first vowel index. Append the substring, then delete it 
				 * from the original location, and append "ay"
				 */
				
				String vowels = "aeiou";
				Boolean proceed = true;

				for (int a = 0; a < arrWord.length(); a++) {
					if (proceed) {
						if (vowels.contains(String.valueOf(arrWord.charAt(a)))) {
							StringBuilder resultWord = new StringBuilder(arrWord);
							resultWord = resultWord.append(resultWord.substring(0, a));
							System.out.print(resultWord.append("ay").delete(0, a) + " ");
							proceed = false;

						}
					}
				}
			}
		}
	}
}
