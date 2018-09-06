package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class IntArray {

	// Given an array nums, write a function to move all 0's to the end of it
	// while maintaining the relative order of the non-zero elements.
	//
	// For example, given nums = [0, 1,0, 0, 3, 12], after calling your
	// function, nums should be [1, 3, 12, 0, 0].
	//
	// Note:
	// You must do this in-place without making a copy of the array.
	// Minimize the total number of operations.

	public void moveZeroes(int[] nums) {

		int countZeroes = 0;

		for (int i = 0; i < nums.length; i++) {

			if (nums[i] == 0) {
				countZeroes++;
				if (i + 1 < nums.length && nums[i + 1] != 0) {
					nums[i + 1 - countZeroes] = nums[i + 1];
					nums[i + 1] = 0;
					countZeroes--;
				}
			}
		}

	}

	// Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
	// find the one that is missing from the array.
	//
	// For example,
	// Given nums = [0, 1, 3] return 2.

	public int missingNumber(int[] nums) {

		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i)
				return i;
		}

		return nums.length - nums[0];
	}

	// given an array A of N integers, returns the smallest positive integer
	// (greater than 0) that does not occur in A.

	public int smallestInteger(int[] nums) {
		Arrays.sort(nums);

		int current = 1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == current)
				current++;
			if (nums[i] > current)
				return current;
		}
		return current;
	}

	// Given a sorted array and a target value, return the index if the target
	// is found.
	// If not, return the index where it would be if it were inserted in order

	public int searchInsert(int[] nums, int target) {

		int index = 0;

		for (int i = 0; i < nums.length; i++) {

			if (target > nums[i])
				index = i + 1;
			if (target == nums[i])
				return i;
			if (target < nums[i])
				break;
		}

		return index;
	}

	// BinaryGap
	// Find longest sequence of zeros in binary representation of an integer

	public int longestBinaryGap(int N) {
		char[] chars = Integer.toBinaryString(N).toCharArray();
		boolean count = false;
		int tmp = 0, result = 0;

		for (char c : chars) {
			if (c == '1' && count == false)
				count = true;
			if (c == '1' && count == true) {
				if (tmp > result)
					result = tmp;
				tmp = 0;
			}
			if (c == '0' && count == true)
				tmp++;
		}
		return result;
	}

	public int longestBinaryGap2(int N) {
		int maxLength = 0;
		int tmpLength = 0;
		boolean inGap = false;

		while (N > 0) {
			System.out.print(N % 2);
			if (N % 2 == 1) {
				if (inGap) {
					if (tmpLength > 0) {
						maxLength = maxLength > tmpLength ? maxLength : tmpLength;
						tmpLength = 0;
					}
				} else {
					inGap = true;
				}
			} else {
				if (inGap) {
					tmpLength++;
				}
			}
			N /= 2;
		}
		return maxLength;
	}

	// rotate an array to the right by a given number of steps
	public int[] rotateArrays(int[] A, int K) {

		if (A.length < 2)
			return A;
		if (K % A.length == 0)
			return A;

		if (K > A.length)
			K = K % A.length;
		int[] results = new int[A.length];

		for (int i = 0; i < A.length; i++) {
			int stepsCanMove = A.length - i - 1;
			if (K <= stepsCanMove)
				results[i + K] = A[i];
			else
				results[K - stepsCanMove - 1] = A[i];
		}
		return results;
	}

	// remove duplicates from sorted array, space complexity O(1)
	public int removeDuplicates(int[] nums) {

		if (nums.length < 2)
			return nums.length;

		if (nums.length == 2) {
			if (nums[0] == nums[1])
				return 1;
			else
				return 2;
		}

		int slow = 0, fast = 1;
		int toFill = -1;

		while (fast < nums.length) {

			if (nums[slow] == nums[fast]) {
				fast++;
				if (toFill < 0)
					toFill = slow + 1;
			} else {
				slow = fast;
				fast++;
				// move nums[slow] to nums[toFill]
				if (toFill > -1) {
					nums[toFill] = nums[slow];
					toFill++;
				}
			}
		}
		if (toFill < 0)
			return nums.length;
		return toFill;
	}

	// find value that occurs in odd number of elements
	public int findUnpairedValue(int[] A) {
		Arrays.sort(A);

		for (int i = 0; i + 2 < A.length; i = i + 2) {
			if (A[i] != A[i + 1])
				return A[i];
		}
		return A[A.length - 1];
	}

	// O(n) time complexity
	public int findUnpairedValue1(int[] A) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		HashSet<Integer> val = new HashSet<>();

		for (int i : A) {
			if (map.get(i) == null)
				map.put(i, 1);
			else
				map.put(i, map.get(i) + 1);
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() % 2 == 1)
				val.add(entry.getKey());
		}

		Iterator<Integer> itr = val.iterator();
		return itr.next();

	}

	// Given n non-negative integers a1, a2, ..., an, where each represents a point
	// at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
	// of line i is at (i, ai) and (i, 0). Find two lines, which together with
	// x-axis forms a container, such that the container contains the most water.
	// height length>=2
	public int maxArea(int[] height) {

		int i = 0;
		int j = height.length - 1;
		int max = Integer.MIN_VALUE;

		while (i < j) {
			int heightI = height[i];
			int heightJ = height[j];
			int area = 0;
			if (heightI < heightJ) {
				area = (j - i) * heightI;
				++i;
			} else {
				area = (j - i) * heightJ;
				--j;
			}
			max = Math.max(area, max);
		}
		return max;

	}

	public int removeElement(int[] nums, int val) {
		if (nums.length == 0)
			return 0;

		int valPosition = -1;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == val) {
				valPosition = i;
				break;
			}
		}
		if (valPosition == -1)
			return nums.length;
		if (valPosition == nums.length - 1)
			return nums.length - 1;

		int nonValPosition = valPosition;

		while (nonValPosition < nums.length) {
			if (nums[nonValPosition] == val)
				nonValPosition++;
			else {
				int temp = nums[nonValPosition];
				nums[nonValPosition] = nums[valPosition];
				nums[valPosition] = temp;
				valPosition++;
				nonValPosition++;
			}
		}

		return valPosition;
	}

//Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
//Your algorithm's runtime complexity must be in the order of O(log n).
//If the target is not found in the array, return [-1, -1].
	public int[] findPositionOfValue(int[] a, int target) {
		int result[] = { -1, -1 };

		int left = findRangeIndex(a, 0, a.length, target, true);

		if (left == a.length || a[left] != target) {

			return result;
		}

		int right = findRangeIndex(a, 0, a.length, target, false);
		result[0] = left;
		result[1] = right;
		return result;

	}

	private int findRangeIndex(int[] a, int low, int high, int target, boolean isLeft) {
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (isLeft) {// to find left index, we move high to the left side
				if (a[mid] >= target) {
					high = mid;
				} else {
					low = mid + 1;
				}
			} else {
				if (a[mid] <= target) {// to find right index, we move low to right side
					low = mid + 1;
				} else {
					high = mid;
				}
			}
		}
		return isLeft ? high : low - 1;
	}

	public static void main(String[] args) {
		IntArray test = new IntArray();
		int[] nums = { 4, 5 };
		int[] heights = { 1, 3, 4, 3, 5, 2 };
		int[] arrays = { 5, 7, 7, 8, 8, 10 };
		test.findPositionOfValue(arrays, 8);

		// test.searchInsert(nums, 4);
		// test.removeDuplicates(nums);
		test.longestBinaryGap2(1041);
		test.removeElement(nums, 5);
	}

}
