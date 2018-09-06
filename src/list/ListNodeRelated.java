package list;

public class ListNodeRelated {

	public ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode result = new ListNode(0);
		result.next = head;

		ListNode fast = result, slow = result;

		for (int count = n; fast.next != null; count--) {
			if (count <= 0)
				slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return result.next;
	}

	public ListNode mergeSortedTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode result = new ListNode(0);
		ListNode current = result;

		while (p1 != null && p2 != null) {
			if (p1.val > p2.val) {
				current.next = p2;
				p2 = p2.next;
			} else {
				current.next = p1;
				p1 = p1.next;
			}
			current = current.next;
		}
		if (p1 == null) {
			current.next = p2;
		}
		if (p2 == null) {
			current.next = p1;
		}
		return result.next;

	}

}
