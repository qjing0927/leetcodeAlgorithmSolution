package practiseAlgrothim;

import java.util.LinkedList;
import java.util.Queue;

public class Sorting {

	// bubble sort. every iterate , swap bigger element to next
	// worst: O(n2) best:O(n)
	// not suitable for large array
	public static int[] bubbleSort(int[] A) {
		if (A.length < 2)
			return A;

		boolean isSwap = true;
		while (isSwap) {
			isSwap = false;
			for (int i = 0; i < A.length - 1; i++) {
				if (A[i] > A[i + 1]) {
					int temp = A[i];
					A[i] = A[i + 1];
					A[i + 1] = temp;
					isSwap = true;
				}
			}
		}
		return A;

	}

	// Selection sort:
	// During each pass, the unsorted element with the smallest (or largest)
	// value is moved to its proper position in the array. The number of times
	// the sort passes through the array is one less than the number of items in
	// the array. In the selection sort, the inner loop finds the next smallest
	// (or largest) value and the outer loop places that value into its proper
	// location
	// time complexity is O(n*(n-1)/2)
	public static int[] selectionSort(int[] A) {

		if (A.length < 2)
			return A;

		for (int i = 0; i < A.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < A.length; j++) {
				if (A[j] < A[index]) {
					index = j;
				}
			}

			if (index != i) {
				int temp = A[i];
				A[i] = A[index];
				A[index] = temp;
			}

		}

		return A;
	}

	// Insertion Sort
	// Insertion sort is a simple sorting algorithm, it builds the final sorted
	// array one item at a time. It is much less efficient on large lists than
	// other sort algorithms.
	// Insertion sort iterates through the list by consuming one input element
	// at each repetition, and growing a sorted output list
	// O(n2)
	public static int[] insertionSort(int[] A) {
		if (A.length < 2)
			return A;

		for (int i = 1; i < A.length; i++) {
			for (int j = i; j > 0; i--) {
				if (A[j] < A[j - 1]) {
					int temp = A[j];
					A[j] = A[j - 1];
					A[j - 1] = temp;
				}
			}
		}

		return A;
	}

	// Quick Sort
	// which is using divide and conquer algorithm. Quicksort first divides a
	// large list into two smaller sub-lists: the low elements and the high
	// elements. Quicksort can then recursively sort the sub-lists.
	public static int[] Sort(int[] A) {
		if (A.length < 2)
			return A;
		mergeSort(A, 0, A.length - 1);
		return A;
	}

	// average case is Θ(n log(n)) and in the worst case is Θ(n2)
	private static void quickSort(int[] a, int start, int end) {
		// TODO Auto-generated method stub
		int pivot = a[start + (end - start) / 2];
		int i = end;
		int j = start;
		while (i >= j) {
			while (a[i] > pivot)
				i--;
			while (a[j] < pivot)
				j++;
			if (i >= j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i--;
				j++;
			}
		}
		if (start < i)
			quickSort(a, start, i);
		if (j < end)
			quickSort(a, j, end);

	}

	// merge sort
	private static void mergeSort(int[] a, int start, int end) {
		if (start < end) {
			int mid = start + (end - start) / 2;
			mergeSort(a, start, mid);
			mergeSort(a, mid + 1, end);
			mergeParts(a, start, mid, end);
		}

	}

	private static void mergeParts(int[] a, int lowerIndex, int middle, int higherIndex) {
		// TODO Auto-generated method stub
		int[] tempMergArr = new int[a.length];
		for (int i = lowerIndex; i <= higherIndex; i++) {
			tempMergArr[i] = a[i];
		}

		int i = lowerIndex;
		int j = middle + 1;
		int k = lowerIndex;

		while (i <= middle && j <= higherIndex) {
			if (tempMergArr[i] <= tempMergArr[j]) {
				a[k] = tempMergArr[i];
				i++;
			} else {
				a[k] = tempMergArr[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			a[k] = tempMergArr[i];
			k++;
			i++;
		}

	}

	public static void main(String[] args) {
		int[] A = { 1, 5, -5, 12, 6, 16 };
		// A = bubbleSort(A);
		A = Sort(A);
		for (int i : A) {
			System.out.println(i);
		}
		Queue<Integer> que = new LinkedList<Integer>();
	}

}
