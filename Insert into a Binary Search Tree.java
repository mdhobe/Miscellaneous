class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            root = new TreeNode(val);
            return root;
        }
        TreeNode node = root;
        insert(node,val);
        return root;
    }
    public void insert(TreeNode node, int val){
        if(node == null){
            return;
        }
        if(val < node.val){
            if(node.left == null) node.left = new TreeNode(val);
            insert(node.left, val);
        }
        if(val > node.val){
            if(node.right == null) node.right = new TreeNode(val);
            insert(node.right,val);
        }
    }
}
