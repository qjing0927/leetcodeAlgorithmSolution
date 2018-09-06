package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class StringRelated {

	// Given a string, find the length of the longest substring without
	// repeating characters.
	public int lengthOfLongestSubstring(String s) {

		if (s.length() < 2)
			return s.length();

		// substring
		int[] substring = new int[256];
		Arrays.fill(substring, -1);

		int sum = 0;
		int result = 0;
		char cur;
		int start = 0;

		for (int i = 0; i < s.length(); i++) {

			cur = s.charAt(i);
			// check if temp char has been in sub string, then store current its
			// index
			if (substring[cur] < start) {
				substring[cur] = i;
				sum++;
			} else {
				// if go to it again
				// go back to the last place it shows up plus one step

				int lastIndex = substring[cur];
				start = lastIndex + 1;
				sum = i - start + 1;
				substring[cur] = i;
			}

			result = Math.max(result, sum);

		}
		return result;

	}

	public int lengthOfLongestSubstring1(String s) {
		int i = 0, j = 0, max = 0;
		Set<Character> set = new HashSet<>();

		set.add('a');
		set.add('a');

		while (j < s.length()) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				max = Math.max(max, set.size());
			} else {
				set.remove(s.charAt(i++));
			}
		}

		return max;
	}

	public int lengthOfLongestSubstring3(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		} else if (s.length() < 2) {
			return 1;
		}

		char[] bytes = s.toCharArray();

		String tempString = "";
		int maxLength = 0;

		for (int i = 0; i < bytes.length;) {
			int repeatIndex = tempString.indexOf(bytes[i]);
			if (repeatIndex != -1) {
				maxLength = maxLength > tempString.length() ? maxLength : tempString.length();
				tempString = tempString.substring(repeatIndex + 1, tempString.length());
			} else {
				tempString += bytes[i];
				i++;
			}
		}
		maxLength = maxLength > tempString.length() ? maxLength : tempString.length();
		return maxLength;
	}

	// find first non repeat character in a string

	public Character firstNonRepeatChar(String string) {

		Character result = null;
		Map<Character, Integer> chars = new HashMap<Character, Integer>();
		// iterate this string and put char as key into a map.
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);

			if (chars.containsKey(c)) {
				int value = chars.get(c);
				chars.put(c, value + 1);
			} else
				chars.put(c, 1);
		}

		// iterate the map, first value is 0, that's it
		for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
			if (entry.getValue() == 1)
				result = entry.getKey();
			return result;
		}
		return result;
	}

	// Given a string containing just the characters '(', ')', '{', '}', '[' and
	// ']', determine if the input string is valid.
	//
	// The brackets must close in the correct order, "()" and "()[]{}" are all
	// valid but "(]" and "([)]" are not.
	public boolean isValid(String s) {

		Stack<Character> stack = new Stack<Character>();

		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			if (c == '[')
				stack.push(']');
			if (c == '{')
				stack.push('}');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {

		StringRelated test = new StringRelated();

		String s = "pwwkew";
		String s1 = "dvdf";

		int[] ints = new int[256];
		ints['a'] = 5;

		test.lengthOfLongestSubstring(s1);
		test.lengthOfLongestSubstring1(s);
		test.isValid("([)]");

		System.out.println(test.lengthOfLongestSubstring3(s1));

	}

}
