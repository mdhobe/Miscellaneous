class Tree
{
    //Function to check whether all nodes of a tree have the value 
    //equal to the sum of their child nodes.
    public static int isSumProperty(Node root)
    {
        // add your code here
        if(root == null) return 0;
        ArrayList<Node> nodes = new ArrayList<>();
        inOrder(root, nodes);
        for(int i=0;i<nodes.size();i++){
            if(nodes.get(i).left != null && nodes.get(i).right != null){
                if(nodes.get(i).left.data + nodes.get(i).right.data != nodes.get(i).data) return 0;
            } else if(nodes.get(i).left != null){
                if(nodes.get(i).left.data != nodes.get(i).data) return 0;
            } else if(nodes.get(i).right != null){
                if(nodes.get(i).right.data != nodes.get(i).data) return 0;
            }
        }
        return 1;
    }
    
    public static void inOrder(Node root, ArrayList<Node> nodes){
        if(root == null) return;
        inOrder(root.left, nodes);
        nodes.add(root);
        inOrder(root.right, nodes);
    }
}
