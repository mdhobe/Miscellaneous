class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key) return helper(root);
        TreeNode head = root;
        while(root != null){
            if(key < root.val){
                if(root.left != null && root.left.val == key){
                    root.left = helper(root.left);
                    break;
                } else root = root.left;
            } else {
                if(root.right != null && root.right.val == key){
                    root.right = helper(root.right);
                    break;
                } else root = root.right;
            }
        }
        return head;
    }
    public TreeNode helper(TreeNode root){
        if(root.right == null) return root.left;
        else if(root.left == null) return root.right;
        else{
            TreeNode rightChild = root.right;
            TreeNode lastRightChild = lastRightChild(root.left);
            lastRightChild.right = rightChild;
            return root.left;
        }
    }
    public TreeNode lastRightChild(TreeNode node){
        if(node.right == null) return node;
        return lastRightChild(node.right);
    }
}
