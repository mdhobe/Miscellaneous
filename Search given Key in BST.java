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
    TreeNode ans = null;
    public TreeNode searchBST(TreeNode root, int val) {
        searchTree(root,val);
        return ans;
    }
    
    public void searchTree(TreeNode root, int val){
        if(root == null) return;
        if(root.val == val){
            ans = root;
            return;
        }else if(val < root.val) searchTree(root.left, val);
        else if(val > root.val) searchTree(root.right, val);
    }
}
