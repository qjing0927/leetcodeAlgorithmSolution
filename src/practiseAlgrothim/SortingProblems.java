package practiseAlgrothim;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//https://codility.com/media/train/4-Sorting.pdf
public class SortingProblems {

	// Determine whether a triangle can be built from a given set of edges.
	public int isTrangle(int[] A) {
		if (A.length < 3)
			return 0;
		Arrays.sort(A);

		for (int i = 0; i < A.length - 2; i++) {
			// Beware of overflow
			if (A[i] >= 0 && A[i] > A[i + 2] - A[i + 1]) {
				return 1;
			}
		}
		return 0;
	}

	// Compute number of distinct values in an array.
	public int distinctValue(int[] A) {
		if (A.length < 2)
			return A.length;
		Arrays.sort(A);
		int sum = 1;
		for (int i = 1; i < A.length; i++) {
			if (A[i] > A[i - 1])
				sum++;
		}
		return sum;
	}

	// max produce of three
	public int maxProduceOfThree(int[] A) {

		// write your code in Java SE 8
		Arrays.sort(A);
		int length = A.length;
		return Math.max(A[length - 1] * A[length - 2] * A[length - 3], A[length - 1] * A[1] * A[0]);

	}

	// Compute the number of intersections in a sequence of discs
	// intersections of two sections condition: yuanxin ju< banjing he
	// j-i<=A[i]+A[j] j>i
	// A[i]+i >= -(A[j]-j)
	public int NumberOfDiscIntersections(int[] A) {
		int l = A.length;

		long[] A1 = new long[l];
		long[] A2 = new long[l];

		for (int i = 0; i < l; i++) {
			A1[i] = (long) A[i] + i;
			A2[i] = -((long) A[i] - i);
		}

		Arrays.sort(A1);
		Arrays.sort(A2);

		long cnt = 0;

		for (int i = A.length - 1; i >= 0; i--) {
			int pos = Arrays.binarySearch(A2, A1[i]);
			if (pos >= 0) {
				while (pos < A.length && A2[pos] == A1[i]) {
					pos++;
				}
				cnt += pos;
			} else { // element not there
				int insertionPoint = -(pos + 1);
				cnt += insertionPoint;
			}

		}

		long sub = (long) l * ((long) l + 1) / 2;
		cnt = cnt - sub;

		if (cnt > 1e7)
			return -1;

		return (int) cnt;

	}

	public int nthRare(int[] elements, int n) {
		Map<Integer, Integer> countMap = new HashMap<>();

		for (int i : elements) {
			if (countMap.containsKey(i)) {
				countMap.put(i, countMap.get(i) + 1);
			} else {
				countMap.put(i, 1);
			}
		}
		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>(
				(o1, o2) -> o1.getValue() - o2.getValue());
		pq.addAll(countMap.entrySet());

		int size = pq.size();

		for (int i = 1; i < n && i < size; i++) {
			pq.poll();
		}

		return pq.poll().getKey();
	}

	public static void main(String[] args) {
		int[] nums = { 1, 5, 2, 1, 4, 0 };
		int[] nums2 = { 5, 4, 3, 2, 1, 5, 4, 3, 2, 5, 4, 3, 5, 4, 5 };
		// System.out.println(new
		// SortingProblems().NumberOfDiscIntersections(nums2));
		System.out.println(new SortingProblems().nthRare(nums2, 2));
	}

}
