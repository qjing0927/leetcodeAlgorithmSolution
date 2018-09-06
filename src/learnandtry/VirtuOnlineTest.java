package learnandtry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VirtuOnlineTest {
	// Q1
	public int findNearestFibonacci(int X) {
		int f1 = 2, f2 = 3;
		if (X < 4)
			return 0;
		int cur = f1 + f2;
		while (cur < X) {
			f1 = f2;
			f2 = cur;
			cur = f1 + f2;
		}

		return Math.min(X - f2, cur - X);

	}

	// Q2
	public int solution2(int[] A) {
		if (A.length == 1) {
			return 0;
		}

		int capacity = 5000 - A[0];

		if (capacity <= 0) {
			return 0;
		}

		A[0] = -1;
		Arrays.sort(A);
		int sum = 0;
		for (int i = 1; i < A.length; i++) {
			capacity -= A[i];
			if (capacity <= 0) {
				break;
			}
			sum++;
		}
		return sum;
	}

	// Q3
	public String solution3(String S) {
		int decimalNumber = Integer.parseInt(S);
		String hexString = Integer.toHexString(decimalNumber);

		for (int i = 2; i <= 9; i++) {
			if (hexString.contains(i + "")) {
				return "ERROR";
			}
		}
		hexString = hexString.replaceAll("1", "I");
		hexString = hexString.replaceAll("0", "O");

		return hexString;
	}

	public String hexpeakString(String s) {
		long number = Long.parseLong(s);

		StringBuilder result = new StringBuilder();

		while (number > 0) {
			int current = (int) (number % 16);
			if (current > 1 && current < 10)
				return "ERROR";
			else {
				if (current == 0)
					result.insert(0, 'O');
				else if (current == 1)
					result.insert(0, 'I');
				else
					result.insert(0, Character.toUpperCase(Integer.toHexString(current).charAt(0)));
			}
			number = number / 16;
		}

		return result.toString();
	}

	// Q5 identical substring

	public int solution5(String S) {
		int sum = 1;

		for (int i = 1; i < S.length(); i++) {
			char character = S.charAt(i);
			sum++;

			for (int j = i - 1; j >= 0; j--) {
				if (S.charAt(j) == character) {
					sum++;
				} else {
					break;
				}
			}
		}

		return sum;
	}

	// identical substring
	public int indenticalSubstring(String s) {
		if (s.length() < 2)
			return s.length();
		int count = 1, result = 0;
		char previous = s.charAt(0);

		for (int i = 1; i < s.length(); i++) {
			char current = s.charAt(i);
			if (current == previous) {
				count++;
			} else {
				previous = current;
				result = result + count * (count + 1) / 2;
				count = 1;
			}
		}
		return result + count * (count + 1) / 2;
	}

	// Q4
	public int[] solution4(int[] A) {
		boolean unstable = true;
		int[] B = new int[A.length];

		while (unstable) {
			boolean change = false;
			for (int i = 1; i < A.length - 1; i++) {
				int mid = A[i] + B[i];
				int left = A[i - 1] + B[i - 1];
				int right = A[i + 1] + B[i + 1];

				if (mid > left && mid > right) {
					change = true;
					B[i]--;
				} else if (mid < left && mid < right) {
					change = true;
					B[i]++;
				}
			}
			unstable = change;
		}

		for (int i = 0; i < A.length; i++) {
			A[i] += B[i];
		}
		return A;
	}

	public int maxApple(int[] A) {
		if (A.length < 2)
			return 0;
		int leftGram = 5000 - A[0];
		Arrays.sort(A, 1, A.length - 1);

		int number = 0, curGrams = 0;

		for (int i = 1; i < A.length; i++) {
			curGrams = curGrams + A[i];
			if (curGrams > leftGram)
				break;
			else {
				number++;
			}
		}
		return number;

	}

	public int largestNumber(int N) {
		if (N < 12)
			return N;
		char[] temp = Integer.toString(N).toCharArray();
		Arrays.sort(temp);
		StringBuilder result = new StringBuilder();
		for (int i = temp.length - 1; i > -1; i--)
			result.append(temp[i]);

		return Integer.parseInt(result.toString());

	}

	// https://github.com/avrahamcohen/Codility-Solutions/blob/master/FibonacciSequence.java
	public static int fib(int n) {
		int[] f = new int[n + 1];
		// Base cases
		if (n == 0)
			return 0;

		if (n == 1 || n == 2)
			return (f[n] = 1);

		// If fib(n) is already computed
		if (f[n] != 0) {
			return f[n];
		}

		int k = (n & 1) == 1 ? (n + 1) / 2 : n / 2;

		// Applyting above formula [Note value
		// n&1 is 1 if n is odd, else 0.
		f[n] = (n & 1) == 1 ? (fib(k) * fib(k) + fib(k - 1) * fib(k - 1)) : (2 * fib(k - 1) + fib(k)) * fib(k);

		if (f[n] > 999999) {
			String temp = Integer.toString(f[n]);
			f[n] = Integer.parseInt(temp.substring(temp.length() - 6, temp.length()));
		}

		return f[n];
	}

	public static String solution(int A, int B, int C, int D, int E, int F) {
		// write your code in Java SE 8
		List<Integer> nums = new ArrayList<Integer>();
		nums.add(A);
		nums.add(B);
		nums.add(C);
		nums.add(D);
		nums.add(E);
		nums.add(F);
		Collections.sort(nums);

		int[] time = new int[6];
		time[0] = nums.get(0);
		time[1] = nums.get(1);
		time[2] = nums.get(2);
		time[4] = nums.get(3);
		time[3] = nums.get(4);
		time[5] = nums.get(5);

		// exceptional cases:
		// 23:35:45 => 23:34:55
		if (time[4] < time[3] && time[3] < 6)
			swap(time, 4, 3);

		// 15:36:87 => 18:36:57
		if (time[4] > 5 && time[1] < 6)
			swap(time, 4, 1);

		// 15:67:58 => 16:57:58
		if (time[2] > 5 && time[1] < 6)
			swap(time, 2, 1);

		// 23:45:35 => 23:35:45
		if (time[2] > time[4])
			swap(time, 2, 4);

		String earlyTime = String.format("%1$d%2$d:%3$d%4$d:%5$d%6$d", time[0], time[1], time[2], time[3], time[4],
				time[5]);
		if (time[0] > 2 || (time[0] == 2 && time[1] > 3) || time[2] > 5 || time[4] > 5)
			// show wrong solution for visual control:
			return "NOT POSSIBLE";
		// ("%1$%2$:%3$%4$:%5$%6$\n", time[0], time[1], time[2], time[3],
		// time[4], time[5]);;
		return earlyTime;
	}

	private static void swap(int[] time, int i, int j) {
		// TODO Auto-generated method stub
		int temp = time[i];
		time[i] = time[j];
		time[j] = temp;

	}

	public static void main(String[] args) {
		int n = Integer.MAX_VALUE - 1;

		System.out.println(solution(2, 3, 3, 5, 4, 5));
		System.out.println(getNthfibo(Integer.MAX_VALUE - 1));

	}

	public static int getNthfibo(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("The fibo value cannot be negative");
		}

		if (n <= 1)
			return n;

		int[][] result = { { 1, 0 }, { 0, 1 } }; // identity matrix.
		int[][] fiboM = { { 1, 1 }, { 1, 0 } };

		while (n > 0) {
			if (n % 2 == 1) {
				multMatrix(result, fiboM);
			}
			n = n / 2;
			multMatrix(fiboM, fiboM);
		}

		return result[1][0];
	}

	private static void multMatrix(int[][] m, int[][] n) {
		int a = m[0][0] * n[0][0] + m[0][1] * n[1][0];
		int b = m[0][0] * n[0][1] + m[0][1] * n[1][1];
		int c = m[1][0] * n[0][0] + m[1][1] * n[0][1];
		int d = m[1][0] * n[0][1] + m[1][1] * n[1][1];

		m[0][0] = a;
		m[0][1] = b;
		m[1][0] = c;
		m[1][1] = d;
	}

	// public int solution(int N) {
	// return (int) fib(N);
	// }
	//
	// public long fib(int k) {
	// if (k == 0)
	// return 0;
	// if (k == 1 || k == 2)
	// return 1;
	//
	// int sub = (k & 1) == 1 ? (k + 1) / 2 : k / 2;
	//
	// long result = (k & 1) == 1 ? (fib(sub) * fib(sub) + fib(sub - 1) *
	// fib(sub - 1))
	// : (2 * fib(sub - 1) + fib(sub)) * fib(sub);
	//
	// if (result > 999999) {
	// String temp = Long.toString(result);
	// return Integer.parseInt(temp.substring(temp.length() - 6,
	// temp.length()));
	// }
	//
	// return result;
	// }

}
