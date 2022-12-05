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
class NodeValue {
    int sumNodes, maxNode, minNode;
    NodeValue(int sumNodes, int minNode, int maxNode){
        this.sumNodes = sumNodes;
        this.maxNode = maxNode;
        this.minNode = minNode;
    }
}
class Solution {
    int max = 0;
    public int maxSumBST(TreeNode root) {
        postOrder(root);
        return max;
    }
    public NodeValue postOrder(TreeNode node){
        if(node == null) return new NodeValue(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        NodeValue left = postOrder(node.left);
        NodeValue right = postOrder(node.right);
        if(left.maxNode < node.val && node.val < right.minNode){
            max = Math.max(max,node.val+left.sumNodes+right.sumNodes);
            return new NodeValue(node.val+left.sumNodes+right.sumNodes, Math.min(node.val, left.minNode), Math.max(node.val, right.maxNode));
        }
        return new NodeValue(Math.max(left.sumNodes, right.sumNodes), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
