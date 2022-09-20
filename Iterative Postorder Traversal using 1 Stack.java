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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
		if (root == null) return ans;
		TreeNode node = root;
		Stack<TreeNode> stack = new Stack<>();
		while (node != null || !stack.isEmpty()) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			} else {
				TreeNode temp = stack.peek().right;
				if (temp == null) {
					temp = stack.pop();
					ans.add(temp.val);
					while (!stack.isEmpty() && temp == stack.peek().right) {
						temp = stack.pop();
						ans.add(temp.val);
					}
				} else {
					node = temp;
				}
			}
		}
		return ans;
    }
}
