class Tree {
    int ceil = -1;
    
    // Function to return the ceil of given number in BST.
    int findCeil(Node root, int key) {
        if (root == null) return -1;
        // Code here
        searchTree(root,key);
        return ceil;
    }
    
    public void searchTree(Node root, int val){
        if(root == null) return;
        if(val == root.data){
            ceil = root.data;
            return;
        }
        else if(val < root.data){
            ceil = root.data;
            searchTree(root.left, val);
        }
        else if(val > root.data) searchTree(root.right, val);
    }
}
