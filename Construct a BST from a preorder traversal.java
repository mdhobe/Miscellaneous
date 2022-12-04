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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for(int i=1;i<preorder.length;i++){
            TreeNode code = root;
            insert(code, preorder[i]);   
        }
        return root;
    }
    public void insert(TreeNode node, int val){
        if(node == null) return;
        if(val < node.val){
            if(node.left == null) node.left = new TreeNode(val);
            insert(node.left,val);
        } else if(val > node.val){
            if(node.right == null) node.right = new TreeNode(val);
            insert(node.right,val);
        }
    }
}
