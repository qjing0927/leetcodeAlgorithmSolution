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

	public static void main(String[] args) {
		medianTwoArray test = new medianTwoArray();

		int[] nums1 = {};
		int[] nums2 = { 1, 2 };

		test.findMedianSortedArrays(nums1, nums2);
	}
}
