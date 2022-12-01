class Solution {
    int floor = -1;
    
    public TreeNode searchBST(TreeNode root, int val) {
        searchTree(root,val);
        System.out.println(floor);
        return null;
    }
    
    public void searchTree(TreeNode root, int val){
        if(root == null) return;
        if(val == root.val){
            floor = root.val;
            return;
        }
        else if(val < root.val) searchTree(root.left, val);
        else if(val > root.val){
            floor = root.val;
            searchTree(root.right, val);
        }
    }
}
