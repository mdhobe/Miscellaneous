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
    Stack<TreeNode> stackNext;
    Stack<TreeNode> stackBefore;
    
    public boolean findTarget(TreeNode root, int k) {
        stackNext = new Stack<>();
        addLeft(root);
        stackBefore = new Stack<>();
        addRight(root);
        int small = nextLeft();
        int large = nextRight();
        while(hasNext() && hasBefore() && small != large){
            if(small + large == k) return true;
            else if (small + large < k) small = nextLeft();
            else if (small + large > k) large = nextRight();
        }
        return false;
    }
    
    public void addLeft(TreeNode node){
         while(node != null){
             stackNext.push(node);
             node = node.left;
         }
     }
    
    public void addRight(TreeNode node){
         while(node != null){
             stackBefore.push(node);
             node = node.right;
         }
     }

     public int nextLeft() {
         TreeNode node = stackNext.pop();
         int ans = node.val;
         addLeft(node.right);
         return ans;
     }
    
    public int nextRight() {
         TreeNode node = stackBefore.pop();
         int ans = node.val;
         addRight(node.left);
         return ans;
     }

     public boolean hasNext() {
         return !stackNext.isEmpty();
     }
    
    public boolean hasBefore() {
         return !stackBefore.isEmpty();
     }
}
