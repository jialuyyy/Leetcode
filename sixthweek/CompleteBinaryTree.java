//count the nodes number
//if the index of the current node is larger than or equal to the totoal number, return false; else, return true

public class CompleteBinaryTree {
	public boolean isComplete (TreeNode root) {
		int count = countNodes(root);

		if (count == 0) {
			return true;
		}

		return helper(root, 0, count);
	}

	private int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return (1 + countNodes(root.left) + countNodes(root.right));
	}

	private boolean helper (TreeNode root, int index, int number) {
		if (root == null) {
			return true;
		}

		if (index >= number) {
			return false;
		}

		return (helper(root.left, 2 * index + 1, number) && helper(root.right, 2 * index + 2, number));
	}

}
