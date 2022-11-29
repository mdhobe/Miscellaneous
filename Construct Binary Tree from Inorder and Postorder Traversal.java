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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> inorderhash = new HashMap<>();
        for(int i=0;i<inorder.length;i++) inorderhash.put(inorder[i],i);
        TreeNode node = buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, inorderhash);
        return node;
    }
    public TreeNode buildTree(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend, HashMap<Integer,Integer> inorderhash){
        if(instart > inend || poststart > postend) return null;
        TreeNode node = new TreeNode(postorder[postend]);
        int inroot = inorderhash.get(node.val);
        int numsleft = inroot-instart;
        node.left = buildTree(inorder, instart, inroot-1, postorder, poststart, poststart+numsleft-1, inorderhash);
        node.right = buildTree(inorder, inroot+1, inend, postorder, poststart+numsleft, postend-1, inorderhash);
        return node;
    }
}
