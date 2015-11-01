import java.util.BitSet;

/**
 * @author Sanjay Gandhi
 *
 */

public class Generate_Subsets {
	public static void generateSubsets(String input) {
		int length = input.length();
		int size = (int) Math.pow(2, length);
		BitSet[] sets = new BitSet[size];
		String[] output = new String[size];

		for (int i = 0; i < size; i++) {
			BitSet set = new BitSet(size);
			StringBuilder builder = new StringBuilder();
			if (i > 0) {
				for (int j = length - 1; j >= 0; j--) {
					if (j == length - 1) {
						if (i % 2 != 0)
							set.set(j, true);
					} else {
						boolean prev = sets[i - 1].get(j);
						boolean next = true;
						for (int k = j + 1; k < length; k++) {
							next = next && sets[i - 1].get(k);
						}
						if (next)
							prev = !prev;
						set.set(j, prev);
					}
					if (set.get(j))
						builder.append(input.charAt(j));
				}
			}
			sets[i] = set;
			output[i] = builder.toString();
		}

		for (String i : output)
			System.out.print("{ " + i + " }, ");

	}

	public static void main(String[] args) {
		String input = "ABC";
		generateSubsets(input);
	}
}
