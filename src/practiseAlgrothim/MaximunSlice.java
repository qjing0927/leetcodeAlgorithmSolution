package practiseAlgrothim;

public class MaximunSlice {

	// MaxDoubleSliceSum
	// array length is an integer within the range [3..100,000];
	// each element of array A is an integer within the range [−10,000..10,000].
	public int MaxDoubleSliceSum(int[] A) {
		if (A.length == 3)
			return 0;

		int maxEnding = 0, maxSlice = 0;

		int smallest = 0, smallestIndex = 1;
		for (int i = 1; i < A.length - 2; i++) {
			if (A[i] < smallest) {
				smallest = A[i];
				smallestIndex = i;
			}
		}

		for (int i = 1; i < A.length - 2; i++) {
			if (i != smallestIndex) {
				maxEnding = Math.max(0, maxEnding + A[i]);
				maxSlice = Math.max(maxSlice, maxEnding);
			}
		}

		return maxSlice;

	}

	// https://rafal.io/posts/codility-max-double-slice-sum.html
	public int solution(int[] A) {
		int N = A.length;
		int[] K1 = new int[N];
		int[] K2 = new int[N];

		for (int i = 1; i < N - 1; i++) {
			K1[i] = Math.max(K1[i - 1] + A[i], 0);
		}
		for (int i = N - 2; i > 0; i--) {
			K2[i] = Math.max(K2[i + 1] + A[i], 0);
		}

		int max = 0;

		for (int i = 1; i < N - 1; i++) {
			max = Math.max(max, K1[i - 1] + K2[i + 1]);
		}

		return max;
	}

	// max profit https://app.codility.com/demo/results/trainingCBXMYF-R7F/
	public int maxProfit(int[] A) {
		if (A.length < 2)
			return 0;

		int maxProfit = 0;
		int minNumber = A[0];

		for (int i = 1; i < A.length; i++) {
			if (A[i] - minNumber > 0)
				maxProfit = Math.max(A[i] - minNumber, maxProfit);
			else
				minNumber = Math.min(A[i], minNumber);
		}
		return maxProfit;
	}

	// maxSliceSum https://app.codility.com/demo/results/training9VYQY2-WAJ/
	public int maxSliceSum(int[] A) {
		int maxEnding = A[0];
		int maxSum = A[0];

		for (int i = 1; i < A.length; i++) {
			maxEnding = Math.max(A[i], maxEnding + A[i]);
			maxSum = Math.max(maxEnding, maxSum);
		}

		return maxSum;
	}
}
