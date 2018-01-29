package practiseAlgrothim;

public class SumNumbers {

	// Given an array, please determine whether it contains three numbers whose
	// sum equals to 0.
	// bool FindNumbersWithSum(int data[], int length, int sum, int
	// excludeIndex)
	// {
	// bool found = false;
	// int ahead = length - 1;
	// int behind = 0;
	//
	// while(ahead > behind)
	// {
	// if(ahead == excludeIndex)
	// ahead --;
	// if(behind == excludeIndex)
	// behind ++;
	//
	// long long curSum = data[ahead] + data[behind];
	//
	// if(curSum == sum)
	// {
	// found = true;
	// break;
	// }
	// else if(curSum > sum)
	// ahead --;
	// else
	// behind ++;
	// }
	//
	// return found;
	// }
	// It determines whether there are two numbers whose sum is sum in array
	// data excluding the number with index excludeIndex. We can determine
	// whether there are three numbers in an array with sum 0 based on this
	// function:
	// bool HasThreeNumbersWithSum0(int data[], int length)
	// {
	// bool found = false;
	// if(data == NULL || length < 3)
	// return found;
	//
	// std::sort(data, data + length - 1);
	//
	// for(int i = 0; i < length; ++i)
	// {
	// int sum = -data[i];
	// int num1, num2;
	// found = FindNumbersWithSum(data, length, sum, i);
	//
	// if(found)
	// break;
	// }
	//
	// return found;
	// }

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
