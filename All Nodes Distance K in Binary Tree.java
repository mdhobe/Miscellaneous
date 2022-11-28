/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode targetNode = null;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parentChild = new HashMap<>();
        fillParentChildRel(root, parentChild);
        System.out.println(parentChild);
        getTargetNode(root, target);
        System.out.println(targetNode);
        ArrayList<TreeNode> visitedNodes = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        inOrderTraversal(targetNode, 0, visitedNodes, ans, k);
        TreeNode copytargetNode = targetNode;
        int loopIndex = 0;
        while(parentChild.containsKey(copytargetNode)){
            copytargetNode = parentChild.get(copytargetNode);
            inOrderTraversal(copytargetNode, ++loopIndex, visitedNodes, ans, k);
        }
        return ans;
    }
    
    public void inOrderTraversal(TreeNode node, int dist, ArrayList<TreeNode> visitedNodes, ArrayList<Integer> ans, int targetDist){
        if(node == null || visitedNodes.contains(node)) return;
        inOrderTraversal(node.left, dist + 1, visitedNodes, ans, targetDist);
        visitedNodes.add(node);
        if(dist == targetDist) ans.add(node.val);
        inOrderTraversal(node.right, dist + 1, visitedNodes, ans, targetDist);
    }
    
    public void getTargetNode(TreeNode root, TreeNode target){
        if(root == null) return;
        if(root == target) targetNode = root;
        
        getTargetNode(root.left, target);
        getTargetNode(root.right, target);
    }
    
    public void fillParentChildRel(TreeNode root, HashMap<TreeNode, TreeNode> parentChild){
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                    parentChild.put(node.left, node);
                }
                if(node.right != null){
                    queue.add(node.right);
                    parentChild.put(node.right, node);
                }
            }
        }
    }
}
