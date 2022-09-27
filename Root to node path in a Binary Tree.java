public class Solution {
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> ans = new ArrayList<>();
		if (A == null) return ans;
		search(A, B, ans);
		return ans;
    }
    public boolean search(TreeNode node, int x, ArrayList<Integer> ans) {
		if (node == null) return false;
		ans.add(node.val);
		if (node.val == x) return true;
		if (search(node.left, x, ans) || search(node.right, x, ans)) return true;
		ans.remove(ans.size() - 1);
		return false;
	}
}
