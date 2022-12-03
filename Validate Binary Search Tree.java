// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         if(root == null) return true;
//         ArrayList<Integer> ans = new ArrayList<>();
//         inOrder(root,ans);
//         System.out.println(ans);
//         for(int i=1;i<ans.size();i++) if(ans.get(i-1) >= ans.get(i)) return false;
//         return true;
//     }
//     public void inOrder(TreeNode node, ArrayList<Integer> ans){
//         if(node == null) return;
//         inOrder(node.left,ans);
//         ans.add(node.val);
//         inOrder(node.right,ans);
//     }
// }
class Solution {
    boolean ans = true;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return ans;
        inOrder(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return ans;
    }
    public void inOrder(TreeNode root, long min, long max){
        if(!ans || root == null) return;
        inOrder(root.left, min, root.val);
        if(min >= root.val || root.val >= max) ans = false;
        inOrder(root.right, root.val, max);
    }
}
