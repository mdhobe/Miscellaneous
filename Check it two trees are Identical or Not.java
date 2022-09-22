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
    boolean ans = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        else if(p == null || q == null) return false;
        inOrder(p,q);
        return ans;
    }
    
    public void inOrder(TreeNode p, TreeNode q) {
        if((p != null && q == null) || (p == null && q != null)){
            ans = false;
            return;
        } else if (p == null && q == null){
            return;
        } else if (p.val != q.val){
            ans = false;
        }   
        inOrder(p.left, q.left);
        inOrder(p.right, q.right);
    }
}
