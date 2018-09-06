package array;

import java.util.Stack;

//https://codility.com/media/train/6-Leader.pdf
public class Leaders {

	// sample question: find leader element in an array
	// leader means appears> n/2 times
	// solution is to remove pairs of different elements.
	// O(N) solution

	public int findLeader(int[] A) {
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < A.length; i++) {
			if (stack.isEmpty())
				stack.push(A[i]);
			else {
				int current = stack.peek();
				if (current == A[i])
					stack.push(A[i]);
				else
					stack.pop();
			}
		}

		int candidate = -1, leader = -1, count = 0;
		if (stack.size() > 0)
			candidate = stack.get(0);

		// as array may not contain a leader, so iterat it again to see if
		// candidate is leader.
		for (int i : A) {
			if (i == candidate)
				count++;
		}

		if (count > A.length / 2)
			leader = candidate;

		return leader;
	}

	// actually, instead of using stack directly to save space,
	// domimator question and answer can be seen
	// https://app.codility.com/demo/results/trainingCPP9WP-DW2/
	public int findLeader1(int[] A) {

		int candidate = -1, leader = -1, count = 0, size = 0;

		// first iterate array to find candidate
		for (int i : A) {
			if (size == 0) {
				size++;
				candidate = i;
			} else {
				if (i == candidate)
					size++;
				else
					size--;
			}
		}

		if (size > 0) {
			for (int i = 0; i < A.length; i++) {
				if (A[i] == candidate) {
					count++;
					leader = i;
				}
			}
		}
		if (count > A.length / 2)
			return leader;
		else
			return -1;

	}

	// https://app.codility.com/demo/results/training8FE97R-YEA/
	// 1. EquiLeader
	// Find the index S such that the leaders of the sequences A[0], A[1], ...,
	// A[S] and A[S + 1], A[S + 2], ..., A[N - 1] are the same.
	// O(N) 100% acceptance
	public int equiLeaders(int[] A) {

		int candidate = -1, position = -1, count = 0, size = 0;

		// first iterate array to find candidate
		for (int i : A) {
			if (size == 0) {
				size++;
				candidate = i;
			} else {
				if (i == candidate)
					size++;
				else
					size--;
			}
		}

		Stack<Integer> stack = new Stack<Integer>();

		if (size > 0) {
			for (int i = A.length - 1; i > -1; i--) {
				if (A[i] == candidate) {
					count++;
					stack.push(i);
				}
			}
		}

		int result = 0;

		if (count > A.length / 2) {

			int itemsInLeft = 0;

			for (int i = stack.get(count - 1); i < stack.get(0); i++) {
				int left = i + 1;
				int right = A.length - left;

				int currentInStack = stack.peek();
				if (i == currentInStack) {
					itemsInLeft++;
					stack.pop();
				}

				if (itemsInLeft > left / 2 && (count - itemsInLeft) > right / 2)
					result++;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		Leaders test = new Leaders();
		int[] nums = { 4, 6, 6, 6, 6, 8, 8 };
		int[] nums2 = { 4, 4, 2, 5, 3, 4, 4, 4 };
		// test.findLeader1(nums2);
		test.equiLeaders(nums2);

	}
}
