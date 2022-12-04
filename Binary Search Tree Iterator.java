class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        addLeft(root);
    }
    
    public void addLeft(TreeNode node){
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }
    
    public int next() {
        TreeNode node = stack.pop();
        int ans = node.val;
        addLeft(node.right);
        return ans;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
