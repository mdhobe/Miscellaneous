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
    public List<Integer> inorderTraversal(TreeNode root) {
         List<Integer> ans = new ArrayList<Integer>();
        inOrder(root, ans);
        return ans;
    }
    
    public void inOrder(TreeNode node, List<Integer> ans) {
		if (node == null) return;
		inOrder(node.left, ans);
		ans.add(node.val);
		inOrder(node.right, ans);
	}
}
