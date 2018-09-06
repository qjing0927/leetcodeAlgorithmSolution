package array;

import java.util.Arrays;
import java.util.Comparator;

public class largestNumber {

	// Given a list of non negative integers, arrange them such that they form
	// the largest number.

	// For example, given [3, 30, 34, 5, 9], the largest formed number is
	// 9534330.

	// Note: The result may be very large, so you need to return a string
	// instead of an integer.

	public String Solution(int[] nums) {

		if (nums == null)
			return null;

		String[] stringArray = new String[nums.length];
		// transform int array to String
		for (int i = 0; i < nums.length; i++) {
			stringArray[i] = Integer.toString(nums[i]);
		}
		Arrays.sort(stringArray, new Comparator<String>() {
			@Override
			public int compare(String i, String j) {
				String s1 = i + j;
				String s2 = j + i;
				return s1.compareTo(s2);
			}
		});

		if (stringArray[stringArray.length - 1].charAt(0) == '0')
			return "0";

		String result = "";

		for (int i = 0; i < nums.length; i++) {

			result = stringArray[i] + result;
		}

		return result;

	}

	// this sort will mess up test case 12 and 121. so redefine comparator is
	// the solution
	public String[] sortByFirstDigit(int[] nums) {

		String[] stringArray = new String[nums.length];
		// transform int array to String
		for (int i = 0; i < nums.length; i++) {
			stringArray[i] = Integer.toString(nums[i]);
		}

		Arrays.sort(stringArray);
		return stringArray;

	}

	public static void main(String[] args) {
		largestNumber test = new largestNumber();
		int[] nums = { 121, 12 };
		test.Solution(nums);
	}

}
