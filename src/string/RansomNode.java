package string;

import java.util.Stack;

public class RansomNode {

	/****
	 * Given an arbitrary ransom note string and another string containing
	 * letters from all the magazines, write a function that will return true if
	 * the ransom note can be constructed from the magazines ; otherwise, it
	 * will return false.
	 * 
	 * Each letter in the magazine string can only be used once in your ransom
	 * note.
	 * 
	 * @param ransomNode
	 * @param magazine
	 * @return
	 */
	public boolean canConstruct(String ransomNode, String magazine) {

		int len = ransomNode.length();
		String reading;
		String newStr = magazine;

		if (len == 0)
			return true;

		for (int i = 0; i < len; i++) {

			if (newStr.length() == 0)
				return false;

			reading = ransomNode.substring(i, i + 1);

			if (newStr.contains(reading))
				newStr = newStr.replaceFirst(reading, "");
			else
				return false;
		}

		return true;
	}

	/**
	 * Example: Given "bcabc" Return "abc"
	 * 
	 * Given "cbacdcbc" Return "acdb"
	 * 
	 * @param s
	 * @return
	 */
	// does not meet smallest in lexicographical order
	public String removeDuplicateLetters(String s) {

		// char array to store if a-z appears
		boolean[] chars = new boolean[26];

		for (int i = 0; i < s.length(); i++) {

			if (chars[s.charAt(i) - 'a'] == false)
				chars[s.charAt(i) - 'a'] = true;
			else {
				Character temp = s.charAt(i);
				s = s.replaceFirst(temp.toString(), "");
				i--;
			}
		}
		return s;
	}

	public String removeDuplicateLettersInOrder(String s) {
		Stack<Character> stack = new Stack<>();
		int[] count = new int[26];
		char[] arr = s.toCharArray();
		for (char c : arr) {
			count[c - 'a']++;
		}
		boolean[] visited = new boolean[26];
		for (char c : arr) {
			count[c - 'a']--;
			if (visited[c - 'a']) {
				continue;
			}
			while (!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0) {
				visited[stack.peek() - 'a'] = false;
				stack.pop();
			}
			stack.push(c);
			visited[c - 'a'] = true;
		}
		StringBuilder sb = new StringBuilder();
		for (char c : stack) {
			sb.append(c);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RansomNode test = new RansomNode();
		// test.canConstruct("a", "b");
		test.removeDuplicateLettersInOrder("cbacdcbc");

	}

}
