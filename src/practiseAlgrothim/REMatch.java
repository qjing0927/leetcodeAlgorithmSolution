package practiseAlgrothim;

import java.util.LinkedList;
import java.util.Queue;

public class REMatch {

	// Implement regular expression matching with support for '.' and '*'>0.
	public static boolean isMatch(String s, String p) {
		// if contains .* match any string
		if (p.contains(".*") || s.length() == 0)
			return true;

		Queue<Integer> indexes = findFirstAlphabetInPattern(s.charAt(0), p);
		if (indexes.isEmpty() || p.length() == 0)
			return false;

		int pIs = 0;
		int pIp = 0;

		while (pIs < s.length() && pIp < p.length()) {
			if (s.charAt(pIs) == p.charAt(pIp) || p.charAt(pIp) == '.') {
				pIs++;
				pIp++;
			} else if (p.charAt(pIp) == '*') {
				// anyhow move pIp to last * considering * appears in a sequence
				pIp = movePointerToLastDuplicate(p, pIp, '*');
				// check and move pointer to last duplicate character
				if (pIs - 1 > -1)
					pIs = movePointerToLastDuplicate(s, pIs, s.charAt(pIs - 1));

			} else {

				if (indexes.isEmpty())
					return false;
				pIs = 0;
				pIp = indexes.poll();
			}

		}

		if (pIs == s.length())
			return true;
		return false;
	}

	private static int movePointerToLastDuplicate(String s, int currentPosition, char c) {

		while (currentPosition < s.length() && s.charAt(currentPosition) == c) {
			currentPosition++;
		}
		return currentPosition;

	}

	private static Queue<Integer> findFirstAlphabetInPattern(char c, String p) {

		Queue<Integer> result = new LinkedList<>();

		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == c)
				result.add(i);
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(isMatch("aab", "aaab"));
	}
}
