/**
 * @author Sanjay Gandhi
 * 
 *         Palindrome Check ignoring the extra characters using 2 Methods
 *
 */

public class Palindrome_String {

	/*
	 * Checking if Palindrome using String Builder Reverse Method
	 */

	public static boolean isPalindromeUsingBuilder(String string) {
		boolean output = true;
		string = string.replaceAll("[^A-Za-z]", "");
		StringBuilder reverse = new StringBuilder(string);
		if (!string.equalsIgnoreCase(reverse.reverse().toString()))
			output = false;
		return output;
	}

	/*
	 * In Place Algorithm
	 */
	public static boolean isPalindromeInPlace(String string) {
		boolean output = true;
		int i = 0;
		int j = string.length() - 1;
		while (i < j) {
			while(! ( Character.isLetter(string.charAt(i)) || Character.isDigit(string.charAt(i)) ) )
				i++;
			while(! ( Character.isLetter(string.charAt(j)) || Character.isDigit(string.charAt(j)) ) )
				j--;
			if (Character.toLowerCase(string.charAt(i)) != Character.toLowerCase(string.charAt(j))) {
				output = false;
				break;
			}
			i++;
			j--;
		}

		return output;
	}

	public static void main(String[] args) {
		String string1 = "No, son! Onanism’s a gross orgasm sin – a no-no, son!";
		String string2 = "Animal loots foliated detail of stool lamina.";
		String string3 = "Avid Madam Diva";
		String string4 = "Malayalam";

		System.out.print("String 1 Palindrome Check : ");
		if (isPalindromeUsingBuilder(string1))
			System.out.print("Yes ");
		else
			System.out.print("No ");

		if (isPalindromeInPlace(string1))
			System.out.print("Yes ");
		else
			System.out.print("No ");

		System.out.println();

		System.out.print("String 2 Palindrome Check : ");
		if (isPalindromeUsingBuilder(string2))
			System.out.print("Yes ");
		else
			System.out.print("No ");

		if (isPalindromeInPlace(string2))
			System.out.print("Yes ");
		else
			System.out.print("No ");

		System.out.println();

		System.out.print("String 3 Palindrome Check : ");
		if (isPalindromeUsingBuilder(string3))
			System.out.print("Yes ");
		else
			System.out.print("No ");

		if (isPalindromeInPlace(string3))
			System.out.print("Yes ");
		else
			System.out.print("No ");

		System.out.println();

		System.out.print("String 4 Palindrome Check : ");
		if (isPalindromeUsingBuilder(string4))
			System.out.print("Yes ");
		else
			System.out.print("No ");

		if (isPalindromeInPlace(string4))
			System.out.print("Yes ");
		else
			System.out.print("No ");
	}
}
