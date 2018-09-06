package codility;

public class prefixSums {
	// number of integers divisible by k in range [a..b].
	public int divisibleNumber(int A, int B, int K) {
		if (K == 1)
			return B - A + 1;

		if (A == B)
			return A % K == 0 ? 1 : 0;

		int x = 0;

		if (A % K == 0)
			x++;

		return B / K - A / K + x;
	}

	// count the number of passing cars on the road.
	// A.length = n; 0<=p<q<n how many pairs of(p,q)
	public int passingCars(int[] A) {
		if (A.length < 2)
			return 0;

		int result = 0, countOne = 0;

		for (int i = A.length - 1; i > -1; i--) {
			if (A[i] == 1) {
				countOne++;
			}
			if (A[i] == 0 && countOne > 0) {
				result += countOne;
			}
			if (result > 1000000000)
				return -1;
		}
		return result;
	}

	// get mimimal character in non empty string based on range [p[i], q[i]],
	// 0<=p[i]<=q[i]<string.length
	// time complexity O(N+M)

	public int[] genomicRangeQuery(String S, int[] P, int[] Q) {
		int[] result = new int[P.length];

		// O(N*m)
		for (int i = 0; i < P.length; i++) {
			String temp = S.substring(P[i], Q[i] + 1);
			if (temp.contains("A"))
				result[i] = 1;
			else if (temp.contains("C"))
				result[i] = 2;
			else if (temp.contains("G"))
				result[i] = 3;
			else if (temp.contains("T"))
				result[i] = 4;
		}
		return result;

	}

	public int[] solution(String S, int[] P, int[] Q) {
		int[][] genoms = new int[3][S.length() + 1];
		// if the char is found in the index i, then we set it to be 1 else they
		// are 0
		// 3 short values are needed for this reason
		short a, c, g;
		for (int i = 0; i < S.length(); i++) {
			a = 0;
			c = 0;
			g = 0;
			if ('A' == (S.charAt(i))) {
				a = 1;
			}
			if ('C' == (S.charAt(i))) {
				c = 1;
			}
			if ('G' == (S.charAt(i))) {
				g = 1;
			}
			// here we calculate prefix sums. To learn what's prefix sums look
			// at here https://codility.com/media/train/3-PrefixSums.pdf
			genoms[0][i + 1] = genoms[0][i] + a;
			genoms[1][i + 1] = genoms[1][i] + c;
			genoms[2][i + 1] = genoms[2][i] + g;
		}

		int[] result = new int[P.length];
		// here we go through the provided P[] and Q[] arrays as intervals
		for (int i = 0; i < P.length; i++) {
			int fromIndex = P[i];
			// we need to add 1 to Q[i],
			// because our genoms[0][0], genoms[1][0] and genoms[2][0]
			// have 0 values by default, look above genoms[0][i+1] =
			// genoms[0][i] + a;
			int toIndex = Q[i] + 1;
			if (genoms[0][toIndex] - genoms[0][fromIndex] > 0) {
				result[i] = 1;
			} else if (genoms[1][toIndex] - genoms[1][fromIndex] > 0) {
				result[i] = 2;
			} else if (genoms[2][toIndex] - genoms[2][fromIndex] > 0) {
				result[i] = 3;
			} else {
				result[i] = 4;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		// System.out.println(new prefixSums().divisibleNumber(6, 8, 12));
		System.out.println(("CAGCCTA".substring(2, 4)));
	}
}
