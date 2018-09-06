package array;

public class IncreasingTriplet {

	/***
	 * Return true if there exists i, j, k such that arr[i] < arr[j] < arr[k]
	 * given 0 ≤ i < j < k ≤ n-1 else return false.
	 * 
	 * @param nums
	 * @return
	 */
	public boolean increasingTriplet(int[] nums) {
		int len = nums.length;
		if (len < 3) {
			return false;
		}
		int small = nums[0];
		int middle = Integer.MAX_VALUE;
		for (int cur = 1; cur < len; cur++) {
			if (nums[cur] > middle) {
				return true;
			}
			if (nums[cur] < middle && nums[cur] > small) {
				middle = nums[cur];
			} else if (nums[cur] < small) {
				small = nums[cur];
			}
		}
		return false;

	}
}
