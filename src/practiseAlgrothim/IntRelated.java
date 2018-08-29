package practiseAlgrothim;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntRelated {

	// N [0, 10000] digits in N to have the largest number
	public int largetestSibling(int N) {
		if (N <= 10)
			return N;

		char[] charArrayN = Integer.toString(N).toCharArray();
		Arrays.sort(charArrayN);

		String largest = "";

		for (int i = charArrayN.length - 1; i >= 0; i--) {
			largest += charArrayN[i];
		}

		return Integer.parseInt(largest);
	}

	public int solution1(int N) {
		char[] digits = String.valueOf(N).toCharArray();

		if (digits.length <= 1) {
			return N;
		}

		Arrays.sort(digits);

		String result = "";
		for (int i = digits.length - 1; i >= 0; i--) {
			result += digits[i];
		}

		return Integer.parseInt(result);
	}

	public int solution(int N) {
		if (N <= 1) {
			return N;
		}

		if (N == 2)
			return 1;

		if (N == 2)
			return 1;

		return (int) fib(N);
	}

	Map<Integer, Long> f = new HashMap<>();

	public long fib(int n) {
		if (n <= 1)
			return n;

		if (n == 2)
			return 1;

		if (f.containsKey(n))
			return f.get(n);

		int k = 0;
		long value = 0;

		if (n % 2 == 0) {
			k = n / 2;
			value = (2 * fib(k - 1) + fib(k)) * fib(k);
		} else {
			k = (n + 1) / 2;
			value = (fib(k) * fib(k) + fib(k - 1) * fib(k - 1));
		}

		value = value % 1000000;

		f.put(n, value);
		return value;
	}

	public static void main(String[] args) {
		IntRelated test = new IntRelated();
		System.out.println(test.solution(13));
		System.out.println(test.solution(18911));
		System.out.println(test.solution(5));
		System.out.println(test.solution(1111));
		System.out.println(test.solution(25315688));

	}

}
