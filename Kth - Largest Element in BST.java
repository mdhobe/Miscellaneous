class Solution
{
    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root,int K)
    {
        //Your code here
        ArrayList<Integer> ans = new ArrayList<>();
        inOrder(root,ans);
        return ans.get(ans.size()-K);
    }
    public void inOrder(Node root,ArrayList<Integer> ans){
        if(root == null) return;
        inOrder(root.left,ans);
        ans.add(root.data);
        inOrder(root.right,ans);
    }
}
