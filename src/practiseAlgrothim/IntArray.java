package practiseAlgrothim;

import java.util.Arrays;

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

	public static void main(String[] args) {
		IntArray test = new IntArray();
		// int[] nums = { 0, 1, 2 };
		// test.moveZeroes(nums);
		// for (int i : nums)
		// System.out.println(i);
		int[] nums = { 1, 3 };

		test.searchInsert(nums, 4);
	}

}
