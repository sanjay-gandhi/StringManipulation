/**
 * @author Sanjay Gandhi
 *
 *         Reversal of a String using 5 different methods
 * 
 */

public class Reverse_String {
	/*
	 * Reverse a String by appending the characters to an empty string in
	 * reverse order
	 */
	public static String reverseWithCharConcat(String string) {
		String output = "";
		for (int i = string.length() - 1; i >= 0; i--)
			output += string.charAt(i);
		return output;
	}

	/*
	 * Reverse a String using concatenation of characters and String Builder
	 */
	public static String reverseWithCharConcatBuilder(String string) {
		StringBuilder output = new StringBuilder();
		for (int i = string.length() - 1; i >= 0; i--)
			output.append(string.charAt(i));
		return output.toString();
	}

	/*
	 * Reverse a String using Built-in Method in String Builder
	 */
	public static String reverseUsingBuilderMethod(String string) {
		StringBuilder output = new StringBuilder(string);
		return output.reverse().toString();
	}

	/*
	 * Reverse a String by swapping Characters
	 */
	public static String reverseUsingCharSwaps(String string) {
		char[] output = string.toCharArray();
		int length = string.length();
		char temp;
		for (int i = 0; i < length / 2; i++) {
			temp = output[i];
			output[i] = output[length - i - 1];
			output[length - i - 1] = temp;
		}
		return String.copyValueOf(output);
	}

	/*
	 * Reverse a String by swapping using XORS
	 */
	public static String reverseUsingXOR(String string) {
		char[] output = string.toCharArray();
		int length = string.length();
		
		for (int i = 0; i < length / 2; i++) {
			output[i] ^= output[length - i - 1];
			output[length - i - 1] ^= output[i];
			output[i] ^= output[length - i - 1];
		}
		return String.valueOf(output);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String string1 = "MALAYALAM";
		String stringRev1 = "MALAYALAM";

		String string2 = "abcdefghijklmnopqrstuvwxyz";
		String stringRev2 = "zyxwvutsrqponmlkjihgfedcba";

		System.out.print("String 1 Reversal Status : ");
		if (reverseWithCharConcat(string1).equals(stringRev1))
			System.out.print("Correct ");
		else
			System.out.print("Wrong ");
		
		if (reverseWithCharConcatBuilder(string1).equals(stringRev1))
			System.out.print("Correct ");
		else
			System.out.print("Wrong ");
		
		if (reverseUsingBuilderMethod(string1).equals(stringRev1))
			System.out.print("Correct ");
		else
			System.out.print("Wrong ");
		
		if (reverseUsingCharSwaps(string1).equals(stringRev1))
			System.out.print("Correct ");
		else
			System.out.print("Wrong ");
		
		if (reverseUsingXOR(string1).equals(stringRev1))
			System.out.print("Correct ");
		else
			System.out.print("Wrong ");
		
		System.out.println();
		
		System.out.print("String 2 Reversal Status : ");
		if (reverseWithCharConcat(string2).equals(stringRev2))
			System.out.print("Correct ");
		else
			System.out.print("Wrong ");
		
		if (reverseWithCharConcatBuilder(string2).equals(stringRev2))
			System.out.print("Correct ");
		else
			System.out.print("Wrong ");
		
		if (reverseUsingBuilderMethod(string2).equals(stringRev2))
			System.out.print("Correct ");
		else
			System.out.print("Wrong ");
		
		if (reverseUsingCharSwaps(string2).equals(stringRev2))
			System.out.print("Correct ");
		else
			System.out.print("Wrong ");
		
		if (reverseUsingXOR(string2).equals(stringRev2))
			System.out.print("Correct ");
		else
			System.out.print("Wrong ");
		
	}
}
