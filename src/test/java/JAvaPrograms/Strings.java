package JAvaPrograms;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DuplicateWord();
	}
	
	public static void DuplicateWord() {
		String string = "Big black bug bit a big black dog on his big black nose";
		int count;

		// Converts the string into lowercase
		string = string.toLowerCase();

		// Split the string into words using built-in function
		String words[] = string.split(" ");

		System.out.println("Duplicate words in a given string : ");
		for (int i = 0; i < words.length; i++) {
			count = 1;
			for (int j = i + 1; j < words.length; j++) {
				if (words[i].equals(words[j])) {
					count++;
				}
			}
			// Displays the duplicate word if count is greater than 1
			if (count > 1) {
				System.out.println(words[i] + " and count is :" + count);
			} else if (count == 1) {
				System.out.println(words[i] + " and count is :" + count);

			}
		}

	}



}
