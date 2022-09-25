class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
        if (root == null) return new ArrayList<>();
	    TreeMap<Integer, Integer> myhash = new TreeMap<>();
	    traversal(root, 0, myhash);
	    return new ArrayList<>(myhash.values());
    }
    
    public void traversal(Node node, int level, TreeMap<Integer, Integer> myhash) {
		if (node == null) return;
		if (!myhash.containsKey(level)) myhash.put(level, node.data);
		traversal(node.right, level + 1, myhash);
		traversal(node.left, level + 1, myhash);
	}
}
