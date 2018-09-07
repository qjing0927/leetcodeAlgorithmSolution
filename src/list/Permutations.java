package list;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	/**
	 * Given a collection of distinct integers, return all possible permutations.
	 * Input: [1,2,3] Output: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]
	 * ]
	 */

	public List<List<Integer>> permute(int[] nums) {
		return permuteN(nums, nums.length - 1);
	}

	// permution for an array nums[0, length-1] is inserting nums[length-1] to
	// the permution for nums[0, lenght-2]
	public List<List<Integer>> permuteN(int[] nums, int indexToProceed) {
		if (nums.length == 0)
			return null;
		if (indexToProceed == 0) {
			ArrayList<Integer> item = new ArrayList<Integer>();
			item.add(nums[0]);
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			result.add(item);
			return result;
		}

		List<List<Integer>> permution = permuteN(nums, indexToProceed - 1);
		int length = permution.size();
		int currentNumber = nums[indexToProceed];

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < indexToProceed + 1; j++) {
				ArrayList<Integer> current = new ArrayList<Integer>((ArrayList<Integer>) permution.get(0));
				current.add(j, currentNumber);
				permution.add(current);
			}
			permution.remove(permution.get(0));
		}

		return permution;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		System.out.println(new Permutations().permute(nums));
	}
}
