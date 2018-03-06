package practiseAlgrothim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumNumbers {

	boolean FindTwoNumbersWithSum(int data[], int length, int sum, int excludeIndex) {
		boolean found = false;
		int ahead = length - 1;
		int behind = 0;

		while (ahead > behind) {
			if (ahead == excludeIndex)
				ahead--;
			if (behind == excludeIndex)
				behind++;

			long curSum = data[ahead] + data[behind];

			if (curSum == sum) {
				found = true;
				break;
			} else if (curSum > sum)
				ahead--;
			else
				behind++;
		}

		return found;
	}

	// Given an increasingly sorted array and a number s, please find two
	// numbers whose sum is s. If there are multiple pairs with sum s, just
	// output any one of them.
	static boolean findNumbersWithSum(int[] nums, int target) {

		if (nums.length < 1)
			return false;
		// two pointers
		int i = 0;
		int j = nums.length - 1;

		while (i < j) {
			if (nums[i] + nums[j] > target)
				j--;
			if (nums[i] + nums[j] < target)
				i++;
			if (nums[i] + nums[j] == target) {
				System.out.println(nums[i] + "  " + nums[j]);
				return true;
			}

		}
		return false;

	}

	// return triples
	public List<List<Integer>> threeSum(int[] nums) {
		if (nums.length == 0 || nums.length < 3)
			return null;

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();

		for (int i = 0; i < nums.length; ++i) {
			int sum = -nums[i];

			int[] twonumbers = FindNumbersWithSum(nums, nums.length, sum, i);
			if (twonumbers[0] == 1) {
				temp.add(nums[i]);
				temp.add(twonumbers[1]);
				temp.add(twonumbers[2]);

				result.add(temp);
				temp.clear();
			}

		}
		return result;

	}

	int[] FindNumbersWithSum(int data[], int length, int sum, int excludeIndex) {

		int[] temp = new int[3];
		int ahead = length - 1;
		int behind = 0;

		while (ahead > behind) {
			if (ahead == excludeIndex)
				ahead--;
			if (behind == excludeIndex)
				behind++;

			long curSum = data[ahead] + data[behind];

			if (curSum == sum) {
				temp[0] = 1;
				temp[1] = data[ahead];
				temp[2] = data[behind];
				break;
			} else if (curSum > sum)
				ahead--;
			else
				behind++;
		}

		return temp;
	}

	public List<List<Integer>> threeSumEquals0(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && (nums[i] == nums[i - 1]))
				continue; // avoid duplicates
			for (int j = i + 1, k = nums.length - 1; j < k;) {
				if (nums[i] + nums[j] + nums[k] == 0) {
					list.add(Arrays.asList(nums[i], nums[j], nums[k]));
					j++;
					k--;
					while ((j < k) && (nums[j] == nums[j - 1]))
						j++;// avoid duplicates
					while ((j < k) && (nums[k] == nums[k + 1]))
						k--;// avoid duplicates
				} else if (nums[i] + nums[j] + nums[k] > 0)
					k--;
				else
					j++;
			}
		}
		return list;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 4, 7, 11, 15 };
		int[] nums1 = { 0, 1, 2 };
		int[] nums2 = { 0, 1, 2 };
		// System.out.println(findNumbersWithSum(nums, 15));
		System.out.println("e".equals("e"));
		System.out.println(nums.hashCode());
	}

	// @Override
	// public boolean equals(Object obj) {
	// return (this.hashCode() == obj.hashCode());
	// }

}
