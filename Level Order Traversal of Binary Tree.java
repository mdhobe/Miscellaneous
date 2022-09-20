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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans  = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if (root == null) return ans;
        TreeNode node = root;
		queue.add(node);
		ArrayList<Integer> a = new ArrayList<>();
		a.add(node.val);
		ans.add(new ArrayList<>(a));

		while (!queue.isEmpty()) {
			int size = queue.size();
			ArrayList<Integer> as = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode n = queue.poll();
				if (n.left != null) {
					queue.add(n.left);
					as.add(n.left.val);
				}
				if (n.right != null) {
					queue.add(n.right);
					as.add(n.right.val);
				}
			}
			if (as.size() > 0) ans.add(new ArrayList<>(as));
		}

		return ans;
    }
}
