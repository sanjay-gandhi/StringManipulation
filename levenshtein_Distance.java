/**
 * @author Sanjay Gandhi
 *
 */

public class levenshtein_Distance {

	public static int levenshteinDustance(String s1, String s2) {
		int l1 = s1.length();
		int l2 = s2.length();
		int[][] distMatrix = new int[l1 + 1][l2 + 1];

		for (int i = 1; i <= l1; i++)
			distMatrix[i][0] = i;

		for (int i = 1; i <= l2; i++)
			distMatrix[0][i] = i;

		for (int i = 1; i <= l1; i++) {
			for (int j = 1; j <= l2; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					distMatrix[i][j] = distMatrix[i - 1][j - 1];
				else
					distMatrix[i][j] = min(distMatrix[i - 1][j - 1] + 1,
							distMatrix[i][j - 1] + 1, distMatrix[i - 1][j] + 1);
			}
		}
		return distMatrix[l1][l2];
	}

	public static int min(int n1, int n2, int n3) {
		int min = (n1 > n2) ? n2 : n1;
		min = (min > n3) ? n3 : min;
		return min;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(" Test 1 Distance : "
				+ levenshteinDustance("Sitting", "Kitten"));
		System.out.println(" Test 2 Distance : "
				+ levenshteinDustance("Sunday", "Saturday"));
		System.out.println(" Test 3 Distance : "
				+ levenshteinDustance("Sanjay", "Payal"));
	}

}
