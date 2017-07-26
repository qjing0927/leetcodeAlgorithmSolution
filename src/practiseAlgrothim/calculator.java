package practiseAlgrothim;

import java.util.Stack;

public class calculator {

	public int calculate(String s) {

		int len = s.length(), sign = 1, result = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < len; i++) {
			if (Character.isDigit(s.charAt(i))) {
				int sum = s.charAt(i) - '0';
				while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
					sum = sum * 10 + s.charAt(i + 1) - '0';
					i++;
				}
				result += sum * sign;
			} else if (s.charAt(i) == '+')
				sign = 1;
			else if (s.charAt(i) == '-')
				sign = -1;
			else if (s.charAt(i) == '(') {
				stack.push(result);
				stack.push(sign);
				result = 0;
				sign = 1;
			} else if (s.charAt(i) == ')') {
				result = result * stack.pop() + stack.pop();
			}

		}
		return result;

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode temp1 = l1;
		ListNode temp2 = l2;
		ListNode temp = null;
		int addOne = 0;

		while (temp1 != null || temp2 != null) {

			if (temp1 == null) {
				temp.next = temp2;
				break;
			}
			if (temp2 == null) {

				break;
			}

			temp1.val = temp1.val + temp2.val + addOne;
			if (temp1.val > 9) {
				addOne = 1;
				temp1.val = temp1.val - 10;
			} else
				addOne = 0;

			temp = temp1;
			temp1 = temp1.next;
			temp2 = temp2.next;

		}

		while (temp.next != null && addOne == 1) {

			temp = temp.next;
			temp.val = temp.val + 1;
			if (temp.val > 9) {
				addOne = 1;
				temp.val = temp.val - 10;
			} else
				addOne = 0;

		}

		if (addOne == 1 && temp.next == null) {

			ListNode last = new ListNode(1);
			last.next = null;
			temp.next = last;

		}

		return l1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		calculator test = new calculator();
		// test.canConstruct("a", "b");
		// test.calculate("(1+(4+5+2)-3)+(6+8)");
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(9);

		test.addTwoNumbers(l1, l2);

		int i = 5;
		System.out.println(5 % 10);

	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}