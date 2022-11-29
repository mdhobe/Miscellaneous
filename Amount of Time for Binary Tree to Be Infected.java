class Solution {
    TreeNode startNode = null;
    public int amountOfTime(TreeNode root, int start) {
        //keep track of parent child rel
        HashMap<TreeNode,TreeNode> parentChildRel = new HashMap<>();
        getParentRelation(root, parentChildRel, start);
        //System.out.println(parentChildRel);
        System.out.println(startNode.val);
        
        //bfs level track
        return bfs(startNode,parentChildRel);
    }
    
    public int bfs(TreeNode start, HashMap<TreeNode,TreeNode> parentChildRel){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(start);
        HashMap<TreeNode, Integer> visited = new HashMap<>();
        visited.put(start, 1);
        int max = 0;
        while(!queue.isEmpty()){
            int fl = 0;
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                //System.out.println(node.val);
                if(node.left != null && visited.get(node.left) == null){
                    fl=1;
                    queue.offer(node.left);
                    visited.put(node.left,1);
                }
                if(node.right != null && visited.get(node.right) == null){
                    fl=1;
                    queue.offer(node.right);
                    visited.put(node.right,1);
                }
                if(parentChildRel.containsKey(node) && !visited.containsKey(parentChildRel.get(node))){
                    fl=1;
                    queue.offer(parentChildRel.get(node));
                    visited.put(parentChildRel.get(node),1);
                    //System.out.println(node);
                }
            }
            if(fl == 1) max++;
        }
        return max;
    }
    
    public void getParentRelation(TreeNode root, HashMap<TreeNode,TreeNode> parentChildRel, int start){
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.val == start) startNode = node;
                if(node.left != null){
                    queue.add(node.left);
                    parentChildRel.put(node.left, node);
                }
                if(node.right != null){
                    queue.add(node.right);
                    parentChildRel.put(node.right, node);
                }
            }
        }
    }
}
