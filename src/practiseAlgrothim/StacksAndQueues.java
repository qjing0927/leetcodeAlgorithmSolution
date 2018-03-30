package practiseAlgrothim;

import java.util.Stack;

public class StacksAndQueues {

	// Cover "Manhattan skyline" using the minimum number of rectangles.
	public int StoneWall(int[] H) {
		if (H.length < 2)
			return H.length;
		Stack<Integer> stack = new Stack<Integer>();
		int result = 1;
		stack.push(H[0]);

		for (int i = 1; i < H.length; i++) {

			while (!stack.isEmpty()) {
				int current = stack.peek();
				if (H[i] > current) {

					stack.push(H[i]);
					result++;
					break;
				} else if (H[i] == current)
					break;
				else
					stack.pop();
			}
			if (stack.isEmpty()) {
				result++;
				stack.push(H[i]);
			}
		}

		return result;

	}

	// N voracious fish are moving along a river. Calculate how many fish are
	// alive
	// only when i=1 i+1=0 fish would meet each other
	// https://app.codility.com/demo/results/trainingXUAKT2-S5A/
	int liveFish(int A[], int B[]) {
		Stack<Integer> stack = new Stack<Integer>();
		int livefish = 0;

		for (int i = 0; i < B.length; i++) {
			if (B[i] == 1) {
				stack.push(A[i]);
				livefish++;
			} else {
				while (!stack.isEmpty()) {
					int size = stack.peek();
					if (size > A[i])
						break;
					else {
						livefish--;
						stack.pop();
					}
				}
				if (stack.isEmpty())
					livefish++;
			}
		}

		return livefish;
	}
}
