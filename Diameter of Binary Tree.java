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
// class Solution {
//     public int diameterOfBinaryTree(TreeNode root) {
//         int height = 0;
//         ArrayList<TreeNode> nodes = new ArrayList<>();
//         inOrder(root, nodes);
//         for (TreeNode n : nodes) height = Math.max(height, maxDepth(n.left) + maxDepth(n.right));
//         return height;
//     }
    
//     public void inOrder(TreeNode node, ArrayList<TreeNode> nodes) {
//         if (node == null) return;
//         inOrder(node.left, nodes);
//         nodes.add(node);
//         inOrder(node.right, nodes);
// 	}

// 	public int maxDepth(TreeNode root) {
//         if (root == null) return 0;
//         int left = maxDepth(root.left);
//         int right = maxDepth(root.right);
//         return 1 + Math.max(left, right);
// 	}
// }
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] a = new int[1];
        findMax(root, a);
        return a[0];
    }
    
    public int findMax(TreeNode root, int[] max){
        if(root == null) return 0;
        int left = findMax(root.left, max);
        int right = findMax(root.right, max);
        max[0] = Math.max(max[0], left+right);
        return 1 + Math.max(left, right);
    }
}
