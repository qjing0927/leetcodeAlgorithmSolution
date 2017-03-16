package practiseAlgrothim;

import java.util.Stack;

public class BST {

	// die dai solution
	public boolean isValidBST(TreeNode root) {

		Stack<TreeNode> stack = new Stack<>();

		stack.push(root);

		TreeNode current;

		while (!stack.isEmpty()) {

			current = stack.pop();

			if (current.left != null) {
				if (current.left.val >= current.val)
					return false;
				else
					stack.push(current);
			}

			if (current.right != null) {
				if (current.right.val <= current.val)
					return false;
				else
					stack.push(current);
			}
		}

		return true;

	}

	/*
	 * public boolean isValidBST(TreeNode root) { return isValidBST(root,
	 * Long.MIN_VALUE, Long.MAX_VALUE); }
	 * 
	 * public boolean isValidBST(TreeNode root, long minVal, long maxVal) { if
	 * (root == null) return true; if (root.val >= maxVal || root.val <= minVal)
	 * return false; return isValidBST(root.left, minVal, root.val) &&
	 * isValidBST(root.right, root.val, maxVal); }
	 */
}

// definition of tree node
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
