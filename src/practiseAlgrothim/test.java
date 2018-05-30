package practiseAlgrothim;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class test {
	public static void main(String[] args) {
		String s = "00:01:07,400-234-090\n00:05:01,701-080-080\n00:05:00,400-234-090";
		int cost = new test().monthlyBill(s);
		new test().evaluate();

		System.out.println(cost);
	}

	public String earliestValidTime(int A, int B, int C, int D, int E, int F) {
		int[] d = { A, B, C, D, E, F };
		Arrays.sort(d);
		if (d[4] < 6) {
			if (10 * d[0] + d[1] < 24)
				return "" + d[0] + d[1] + ":" + d[2] + d[3] + ":" + d[4] + d[5];
			else
				return "NOT POSSIBLE";
		} else if (d[3] < 6) {
			if (10 * d[0] + d[1] < 24)
				return "" + d[0] + d[1] + ":" + d[2] + d[4] + ":" + d[3] + d[5];
			else
				return "NOT POSSIBLE";
		} else if (d[2] < 6) {
			if (10 * d[0] + d[3] < 24)
				return "" + d[0] + d[3] + ":" + d[1] + d[4] + ":" + d[2] + d[5];
			else
				return "NOT POSSIBLE";
		} else {
			return "NOT POSSIBLE";
		}
	}

	public int monthlyBill(String S) {
		int longestDuration = 0;
		String longestDurationNumber = null;
		Map<String, Integer> numberDuration = new HashMap<>();
		Map<String, Integer> numberCost = new HashMap<>();
		int sumCost = 0;

		char endOfLine = 10;
		String[] lines = S.split(String.valueOf(endOfLine));

		if (lines.length < 2) {
			return 0;
		}

		for (String line : lines) {
			String number = line.split(",")[1];
			String[] duration = line.split(",")[0].split(":");

			int durationInSeconds = Integer.valueOf(duration[0]) * 3600 + Integer.valueOf(duration[1]) * 60
					+ Integer.valueOf(duration[2]);

			int cost;

			if (durationInSeconds < 300) {
				cost = durationInSeconds * 3;
			} else {
				if (durationInSeconds % 60 == 0) {
					cost = durationInSeconds / 60 * 150;
				} else {
					cost = durationInSeconds / 60 * 150 + 150;
				}
			}

			if (numberDuration.containsKey(number)) {
				int newDuration = numberDuration.get(number) + durationInSeconds;
				numberDuration.replace(number, newDuration);

				int newCost = numberCost.get(number) + cost;
				numberCost.replace(number, newCost);
			} else {
				numberDuration.put(number, durationInSeconds);
				numberCost.put(number, cost);
			}

			durationInSeconds = numberDuration.get(number);

			if (durationInSeconds > longestDuration) {
				longestDuration = durationInSeconds;
				longestDurationNumber = number;
			}
			// if there is a tie
			if (durationInSeconds == longestDuration && number.compareTo(longestDurationNumber) < 0) {
				longestDuration = durationInSeconds;
				longestDurationNumber = number;
			}

		}

		numberCost.remove(longestDurationNumber);

		for (int cost : numberCost.values()) {
			sumCost += cost;
		}

		return sumCost;
	}

	public void evaluate() {
		Integer first = new Integer(10); // new java.lang.Integer object
		MyClass second = new MyClass(10); // new custom MyClass object
		System.out.println("Before First = " + (first));
		System.out.println("Before Second = " + (second.Value));
		changeValue(first);
		changeValue(second);
		System.out.println("After First = " + (first));
		System.out.println("After Second = " + (second.Value));
	}

	public void changeValue(Integer oldValue) {
		oldValue += 1;
	}

	public void changeValue(MyClass oldValue) {
		oldValue.Value += 1;
	}

	public class MyClass {
		Integer Value;

		public MyClass(Integer initValue) {
			Value = initValue;
		}
	}

}
