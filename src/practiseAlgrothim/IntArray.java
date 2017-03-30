package practiseAlgrothim;

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

	public static void main(String[] args) {
		IntArray test = new IntArray();
		int[] nums = { 0, 1, 2 };
		test.moveZeroes(nums);
		for (int i : nums)
			System.out.println(i);
	}

}
