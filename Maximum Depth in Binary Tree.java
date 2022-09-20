/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int height = 1;
    
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
		inOrder(root, 1);
		return height;
	}

	public void inOrder(TreeNode node, int currentHeight) {
		if (node.left == null && node.right == null) {
			height = Math.max(height, currentHeight);
			return;
		}
		if (node.left != null) inOrder(node.left, currentHeight + 1);
		if (node.right != null) inOrder(node.right, currentHeight + 1);
	}
}
