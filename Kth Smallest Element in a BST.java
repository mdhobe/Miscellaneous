class Solution {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        inOrder(root,ans);
        return ans.get(k-1);
    }
    public void inOrder(TreeNode root,ArrayList<Integer> ans){
        if(root == null) return;
        inOrder(root.left,ans);
        ans.add(root.val);
        inOrder(root.right,ans);
    }
}
