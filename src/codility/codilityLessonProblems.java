package codility;

import java.util.Arrays;
import java.util.Stack;

public class codilityLessonProblems {

	// count minimal number of jumps from position X to Y. frog jumps
	// X, Y and D are integers within the range [1..1,000,000,000]; X <=Y.
	public int frogJump(int X, int Y, int D) {
		if (X == Y)
			return 0;
		return ((Y - X) % D > 0) ? (Y - X) / D + 1 : (Y - X) / D;

	}

	// Given an array containing n distinct numbers taken from 1, 2, ..., n+1,
	// find the one that is missing from the array.
	//
	// For example,
	// Given nums = [2, 1, 4] return 3.
	public int missingNumber(int[] A) {

		int sum = 0;

		for (int i = 0; i < A.length; i++) {

			sum += A[i];
		}

		int total = (1 + A.length + 1) * (A.length + 1) / 2;

		return (total - sum);
	}

	public int missingNumberXOR(int[] a) {

		int i;
		int x1 = a[0];
		int x2 = 1;

		/*
		 * For xor of all the elements in array
		 */
		for (i = 1; i < a.length; i++) {

			x1 = x1 ^ a[i];
		}

		/*
		 * For xor of all the elements from 1 to n+1
		 */
		for (i = 2; i <= a.length + 1; i++) {

			x2 = x2 ^ i;
		}

		return (x1 ^ x2);
	}

	// earliest time when a frog can jump to the other side of a river
	public int frogRiverOne(int X, int[] A) {

		int steps = X;
		boolean[] bitmap = new boolean[steps + 1];
		for (int i = 0; i < A.length; i++) {
			if (!bitmap[A[i] - 1]) {
				bitmap[A[i] - 1] = true;
				steps--;
			}
			if (steps == 0)
				return i;
		}
		return -1;

	}

	// A permutation is a sequence containing each element from 1 to N once, and
	// only once, returns 1 if array A is a permutation and 0 if it is not.
	public int permutationArray(int[] A) {

		int steps = A.length;
		boolean[] bitmap = new boolean[steps];
		for (int i = 0; i < A.length; i++) {
			if (A[i] > A.length)
				return 0;
			if (!bitmap[A[i] - 1]) {
				bitmap[A[i] - 1] = true;
				steps--;
			}
			if (steps == 0)
				return 1;
		}
		return 0;
	}

	// the values of counters after applying all alternating operations:
	// increase counter by 1; set value of all counters to current maximum.
	// Integer N and a non-empty zero-indexed array A consisting of M integersN
	// and M are integers within the range [1..100,000];
	// each element of array A is an integer within the range [1..N + 1].

	public int[] maxCounter(int N, int[] A) {

		int[] results = new int[N];
		Stack<Integer> s = new Stack<Integer>();

		for (int i = A.length - 1; i > -1; i--) {
			if (A[i] == N + 1)
				s.push(i);
		}
		int from = 0, to = A.length, maxCounter = 0;

		while (!s.isEmpty()) {
			to = s.pop();
			maxCounter = Math.max(findMaxCounter(A, from, to, results, maxCounter, N), maxCounter);
			from = to + 1;
		}

		Arrays.fill(results, maxCounter);

		if (from < A.length) {
			for (int i = from; i < A.length; i++) {
				results[A[i] - 1]++;
			}
		}

		return results;
	}

	public int findMaxCounter(int[] A, int from, int to, int[] results, int maxCounter, int N) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = from; i < to; i++) {
			if (results[A[i] - 1] < maxCounter) {
				results[A[i] - 1] = maxCounter + 1;
			} else
				results[A[i] - 1]++;

			count = results[A[i] - 1] > count ? results[A[i] - 1] : count;
		}
		return count;
	}

	public static void main(String[] args) {
		int a[] = { 4850, 100, 30, 30, 50, 100, 100 };
		int A[] = { 1, 6, 6 };
		codilityLessonProblems test = new codilityLessonProblems();
		// System.out.println(test.missingNumberXOR(a));
		// test.permutationArray(a);
		// test.maxCounter(5, a);
		// System.out.println(test.indenticalSubstring("zzzyz"));
		// test.solution42(A);
		// test.maxApple(a);
		// System.out.println(test.hexpeakString("267"));
		test.maxCounter(5, A);

	}
}
