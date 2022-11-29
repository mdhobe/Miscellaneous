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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inorderhash = new HashMap<>();
        for(int i=0;i<inorder.length;i++) inorderhash.put(inorder[i],i);
        TreeNode node = buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inorderhash);
        return node;
    }
    public TreeNode buildTree(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend, HashMap<Integer, Integer> inorderhash){
        if(prestart > preend || instart > inend) return null;
        TreeNode node = new TreeNode(preorder[prestart]);
        int inroot = inorderhash.get(node.val);
        int numsleft = inroot - instart;
        node.left = buildTree(preorder, prestart+1, prestart+numsleft, inorder, instart, inroot-1, inorderhash);
        node.right = buildTree(preorder, prestart+numsleft+1, preend, inorder, inroot+1, inend, inorderhash);
        return node;
    }
}
