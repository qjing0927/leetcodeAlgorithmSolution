package practiseAlgrothim;

import java.util.Arrays;

public class medianTwoArray {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int size = nums1.length + nums2.length;
		int[] nums = new int[size];

		System.arraycopy(nums1, 0, nums, 0, nums1.length);
		System.arraycopy(nums2, 0, nums, nums1.length, nums2.length);

		Arrays.sort(nums);

		double result = 0;
		if (size % 2 == 1) {
			result = nums[((size - 1) / 2)];
		} else {

			result = 0.5 * (nums[(size - 1) / 2] + nums[size / 2]);
			;
		}

		return result;

	}

	public boolean isNumber(String s) {

		// remove blank space in string s.trim();
		String temp = s.replaceAll("[\uFEFF-\uFFFF]", "");

		int count = 0;

		// "959440.94f" is not a valid float number in math
		if (temp.endsWith("f") || temp.endsWith("D"))
			return false;

		try {
			int result = Integer.parseInt(temp);
		} catch (java.lang.NumberFormatException e) {
			count++;
		}

		try {
			double dresult = Double.parseDouble(temp);
		} catch (java.lang.NumberFormatException e) {
			count++;
		}

		if (count == 2)
			return false;

		return true;

		/*
		 * or s = s.trim(); if (s.length() == 0) return false; if (s.matches(
		 * "[+-]?(([0-9]*\\.?[0-9]+)|([0-9]+\\.?[0-9]*))([eE][+-]?[0-9]+)?"))
		 * return true; else return false;
		 */
	}

	public static void main(String[] args) {
		medianTwoArray test = new medianTwoArray();

		int[] nums1 = {};
		int[] nums2 = { 1, 2 };

		test.findMedianSortedArrays(nums1, nums2);

		System.out.println(Integer.parseInt("0"));
		System.out.println(Double.parseDouble("2e10"));
		System.out.println(Double.parseDouble("959440.94f"));

	}
}
