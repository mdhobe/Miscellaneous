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
class Pair{
    int index;
    TreeNode node;
    Pair(TreeNode n, int i){
        index = i;
        node = n;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        if(root == null) return ans;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while(!queue.isEmpty()){
            int size = queue.size();
            int min = queue.peek().index;
            int first = 0, last = 0;
            for(int i=0;i<size;i++){
                Pair p = queue.poll();
                TreeNode node = p.node;
                int index = p.index;
                if(i == 0) first = index;
                if(i == size-1) last = index;
                if(node.left != null) queue.add(new Pair(node.left, 2*(index-min)+1));
                if(node.right != null) queue.add(new Pair(node.right, 2*(index-min)+2));
            }
            ans = Math.max(ans, last - first + 1);
            System.out.println(last - first + 1);
        }
        return ans;
    }
}
