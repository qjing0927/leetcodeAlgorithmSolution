package practiseAlgrothim;

public class GreedyAlgothrim {

	// https://app.codility.com/demo/results/trainingUPPKRZ-HDK/
	public int maxSizeOfNonoverlappingSegements(int[] A, int[] B) {
		if (A.length < 1)
			return 0;
		int count = 1;
		int pre_end = B[0];

		for (int i = 1; i < A.length; i++) {
			if (A[i] > pre_end) {
				count++;
				pre_end = B[i];
			}
		}
		return count;
	}

	public int tieRopes(int K, int[] A) {
		int result = 0;
		int current = 0;

		for (int i = 0; i < A.length; i++) {
			current += A[i];
			if (current >= K) {
				result++;
				current = 0;
			}
		}

		return result;

	}

}
