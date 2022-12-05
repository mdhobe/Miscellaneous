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
    TreeNode first = null, middle = null, last = null, prev = null;
    public void recoverTree(TreeNode root) {
        prev = new TreeNode(Integer.MIN_VALUE);
        inOrder(root);
        if(first != null && last != null){
            int swap = first.val;
            first.val = last.val;
            last.val = swap;
        } else if(first != null && middle != null){
            int swap = first.val;
            first.val = middle.val;
            middle.val = swap;
        }
    }
    public void inOrder(TreeNode node){
        if(node == null) return;
        inOrder(node.left);
        if(prev != null && node.val < prev.val){
            if(first == null){
                first = prev;
                middle = node;
            } else {
                last = node;
            }
        }
        prev = node;
        inOrder(node.right);
    }
}
