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

	// Given a binary tree, you need to compute the length of the diameter of
	// the tree.
	// The diameter of a binary tree is the length of the longest path between
	// any two nodes in a tree.
	// This path may or may not pass through the root.

	int max = 0;

	public int diameterOfBinaryTree(TreeNode root) {

		// basic idea is finding max level of left and right sub tree

		levelofBinaryTree(root);
		return max;
	}

	public int levelofBinaryTree(TreeNode root) {

		if (root == null)
			return 0;

		int lmax = levelofBinaryTree(root.left);
		int rmax = levelofBinaryTree(root.right);

		max = Math.max(max, lmax + rmax);

		return Math.max(lmax, rmax) + 1;

	}

	// Given a binary tree, determine if it is height-balanced.
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		int differ = Math.abs((lengthofTree(root.left) - lengthofTree(root.right)));
		if (differ > 1)
			return false;
		return isBalanced(root.left) && isBalanced(root.right);

	}

	public int lengthofTree(TreeNode root) {
		if (root == null)
			return 0;

		return (Math.max(lengthofTree(root.left), lengthofTree(root.right)) + 1);
	}

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
