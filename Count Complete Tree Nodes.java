class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int left = getLeftHeight(root);
        int right = getRightHeight(root);
        if(left == right) return ((2<<(left))-1);
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
    public int getLeftHeight(TreeNode root){
        int left = 0;
        while(root.left != null){
            left++;
            root = root.left;
        }
        return left;
    }
    public int getRightHeight(TreeNode root){
        int right = 0;
        while(root.right != null){
            right++;
            root = root.right;
        }
        return right;
    }
}
