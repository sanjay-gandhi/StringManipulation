import java.util.StringTokenizer;

/**
 * @author Sanjay
 * 
 *         Reverse the words of a sentence using 4 methods
 */

public class Reverse_Words {

	/*
	 * Method 1 : Using Characters. Traverse in reverse direction till a space
	 * is encountered and append the string to the output
	 */
	public static String reverseUsingChar(String string) {
		String output = "";
		int length = string.length();
		int wordEnd = length;
		for (int i = length - 1; i >= 0; i--) {
			if (i == 0 || string.charAt(i) == ' ') {
				int wordStart = ((i == 0) ? 0 : i + 1);
				output += string.substring(wordStart, wordEnd) + ' ';
				wordEnd = i;
			}
		}
		return output.trim();
	}

	/*
	 * Method 2 : Using String tokenizer
	 */
	public static String reverseUsingTokenizer(String string) {
		String output = "";
		StringTokenizer st = new StringTokenizer(string);
		while (st.hasMoreTokens()) {
			output = st.nextToken() + ' ' + output;
		}
		return output.trim();
	}

	/*
	 * Method 3 : Using Split function
	 */
	public static String reverseUsingSplit(String string) {
		String output = "";
		String[] split = string.split(" ");
		for (int i = split.length - 1; i >= 0; i--)
			output += split[i] + ' ';
		return output.trim();
	}

	/*
	 * Method 4 : IN PLACE REVERSAL using word swapping
	 */
	public static String reverseInPlace(String string) {
		char[] output = string.toCharArray();
		int length = string.length();
		int word1length = 0;
		int word1Start = 0;
		int word1End = 0;
		int word2length = 0;
		int word2Start = length - 1;
		int word2End = length - 1;
		int i = 0;
		while (i < length && i < word2End) {
			if (output[i] == ' ') {
				word1End = i - 1;
				word1length = i - word1Start;
				for (int j = word2End; j >= i; j--) {
					if (output[j] == ' ') {
						word2length = word2End - j;
						word2Start = j + 1;

						swapWords(output, word1Start, word1End, word2Start,
								word2End);

						// Move left by the length of the first word
						word2End -= (word1length + 1);
						break;
					}
				}
				// Move right by the length of the second word
				word1Start += (word2length + 1);
				i = word1Start;
			} else
				i++;
		}

		return String.valueOf(output);
	}

	// Swap two words in place
	public static void swapWords(char[] output, int start1, int end1,
			int start2, int end2) {
		int length1 = end1 - start1 + 1;
		int length2 = end2 - start2 + 1;
		// Length = minimum of 2 words length
		int length = (length1 > length2) ? length2 : length1;

		char temp;
		for (int i = 0; i < length; i++) {
			temp = output[start1 + i];
			output[start1 + i] = output[start2 + i];
			output[start2 + i] = temp;
		}

		if (length1 > length2) {
			length = length1 - length2;
			start1 += length2;
			for (int i = 0; i < length; i++) {
				temp = output[start1];
				shiftLeft(output, start1, end2);
				output[end2] = temp;
			}
		} else if (length2 > length1) {
			length = length2 - length1;
			end1++;
			for (int i = 0; i < length; i++) {
				temp = output[end2];
				shiftRight(output, end1, end2);
				output[end1] = temp;
			}

		}
	}

	public static void shiftLeft(char[] output, int start, int end) {
		for (int i = start; i < end; i++)
			output[i] = output[i + 1];
	}

	public static void shiftRight(char[] output, int start, int end) {
		for (int i = end; i > start; i--)
			output[i] = output[i - 1];
	}

	public static void main(String[] args) {

		String string1 = "Sanjay Very Good Person";
		String stringRev1 = "Person Good Very Sanjay";

		String string2 = "Love lasts Forever";
		String stringRev2 = "Forever lasts Love";

		System.out.print("String 1 reversal Status : ");
		if (reverseUsingChar(string1).equals(stringRev1))
			System.out.print("Correct ");
		else
			System.out.print("Wrong ");

		if (reverseUsingTokenizer(string1).equals(stringRev1))
			System.out.print("Correct ");
		else
			System.out.print("Wrong ");

		if (reverseUsingSplit(string1).equals(stringRev1))
			System.out.print("Correct ");
		else
			System.out.print("Wrong ");

		if (reverseInPlace(string1).equals(stringRev1))
			System.out.print("Correct ");
		else
			System.out.print("Wrong ");

		System.out.println();

		System.out.print("String 2 reversal Status : ");
		if (reverseUsingChar(string2).equals(stringRev2))
			System.out.print("Correct ");
		else
			System.out.print("Wrong ");

		if (reverseUsingTokenizer(string2).equals(stringRev2))
			System.out.print("Correct ");
		else
			System.out.print("Wrong ");

		if (reverseUsingSplit(string2).equals(stringRev2))
			System.out.print("Correct ");
		else
			System.out.print("Wrong ");

		if (reverseInPlace(string2).equals(stringRev2))
			System.out.print("Correct ");
		else
			System.out.print("Wrong ");

	}

}
