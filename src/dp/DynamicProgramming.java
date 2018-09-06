package dp;

import java.util.Arrays;

public class DynamicProgramming {

	// find the subset of maximal sum in which the distance between consecutive
	// elements is at most 6.
	// https://app.codility.com/demo/results/trainingGYF5M2-UPU/
	public static int maxSum(int[] A) {

		int[] maxTill = new int[A.length];

		maxTill[0] = A[0];

		for (int i = 1; i < A.length; i++) {

			maxTill[i] = findMaxSumInPreviousSix(maxTill, i) + A[i];

		}

		return maxTill[A.length - 1];
	}

	private static int findMaxSumInPreviousSix(int[] maxTill, int index) {
		// TODO Auto-generated method stub
		int maxSum = maxTill[index - 1];
		for (int i = 1; i < 7; i++) {
			if ((index - i) < 0)
				break;
			else {
				maxSum = Math.max(maxSum, maxTill[index - i]);
			}
		}

		return maxSum;
	}

	public static int minAbsSum(int[] A) {
		if (A.length == 0)
			return 0;
		if (A.length == 1)
			return Math.abs(A[0]);

		int[] sumA = new int[A.length + 1];
		int[] minAbsTill = new int[A.length];

		for (int i = 0; i < A.length; i++) {
			A[i] = Math.abs(A[i]);
		}

		Arrays.sort(A);

		for (int i = 1; i < A.length + 1; i++) {
			sumA[i] = sumA[i - 1] + A[i - 1];
		}

		minAbsTill[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			minAbsTill[i] = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				// minAbsTill[i] = Math.min(minAbsTill[i], Math.abs(A[i] + 2 *
				// sumA[j] - sumA[i]));
				minAbsTill[i] = Math.min(minAbsTill[i], Math.abs(A[i] - Math.abs(2 * sumA[j] - sumA[i])));

				if (minAbsTill[i] == 0)
					break;
				// minAbsTill[i] = Math.min(minAbsTill[i], Math.abs(A[i] - 2 *
				// sumA[j] + sumA[i]));

			}
			minAbsTill[i] = Math.min(minAbsTill[i], Math.abs(A[i] - minAbsTill[i - 1]));
		}

		return minAbsTill[A.length - 1];

	}

	public static int buttom_up_cut(int[] p) {
		int[] r = new int[p.length + 1];
		for (int i = 1; i <= p.length; i++) {
			int q = -1;
			// ①
			for (int j = 1; j <= i; j++)
				q = Math.max(q, p[j - 1] + r[i - j]);
			r[i] = q;
		}
		return r[p.length];
	}

	public static int solution(int[] A) {
		int max = 0;
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			A[i] = Math.abs(A[i]);
			max = Math.max(max, A[i]);
			sum += A[i];
		}

		int[] counts = new int[max + 1];
		for (int number : A) {
			counts[number]++;
		}

		boolean[] reaches = new boolean[sum / 2 + 1];
		reaches[0] = true;
		for (int i = 1; i < counts.length; i++) {
			if (counts[i] == 0) {
				continue;
			}
			int[] remains = new int[reaches.length];
			for (int j = 0; j < remains.length; j++) {
				remains[j] = reaches[j] ? counts[i] : -1;
			}
			for (int j = 0; j + i < remains.length; j++) {
				if (remains[j] > 0) {
					remains[j + i] = Math.max(remains[j + i], remains[j] - 1);
				}
			}
			for (int j = 0; j < remains.length; j++) {
				if (remains[j] >= 0) {
					reaches[j] = true;
				}
			}
		}

		for (int i = reaches.length - 1;; i--) {
			if (reaches[i]) {
				return sum - i - i;
			}
		}
	}

	public static void main(String[] args) {
		int[] A = { 1, 5, -2, 5, 2, 3 };
		int[] B = { 1, -2, 0, 9, -1, -2 };
		minAbsSum(A);
		maxSum(B);

		buttom_up_cut(A);
		solution(A);

	}
}
