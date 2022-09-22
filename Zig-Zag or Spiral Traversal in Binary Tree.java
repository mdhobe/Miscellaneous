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
    public boolean flip = true;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        bfs(root, ans);
        return ans;
    }
    public void bfs(TreeNode node, List<List<Integer>> ans){
        if(node == null) return;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        
        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> a = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            for(int i=0;i<len;i++){
                stack.push(queue.poll());
            }
            for(int i=0;i<len;i++){
                TreeNode n = stack.pop();
                a.add(n.val);
                if(flip){
                    if(n.left != null) queue.add(n.left);
                    if(n.right != null) queue.add(n.right);
                } else {
                    if(n.right != null) queue.add(n.right);
                    if(n.left != null) queue.add(n.left);
                }
            }
            ans.add(new ArrayList(a));
            flip = !flip;
        }
    }
}
