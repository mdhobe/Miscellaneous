/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(right == null) return left;
        else if(left == null) return right;
        else return root;
    }
    
    public ArrayList<TreeNode> getPath(TreeNode root, TreeNode node){
        ArrayList<TreeNode> path = new ArrayList<>();
        if(root == null) return path;
        trackPath(root, node, path);
        return path;
    }
    
    public boolean trackPath(TreeNode root, TreeNode node, ArrayList<TreeNode> path){
       if(root == null) return false;
        path.add(root);
        if(root == node) return true;
        if(trackPath(root.left, node, path) || trackPath(root.right, node, path)) return true;
        path.remove(path.size()-1);
        return false;
    }
}
