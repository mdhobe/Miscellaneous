/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void inOrder(TreeNode node, PriorityQueue<NodeLocation> pq, int level, int xaxis) {
		if (node == null) return;
		pq.add(new NodeLocation(node, level, xaxis));
		inOrder(node.left, pq, level + 1, xaxis - 1);
		inOrder(node.right, pq, level + 1, xaxis + 1);
	}

	class NodeLocation {
		TreeNode node;
		int level, xaxis;
		NodeLocation(TreeNode node, int level, int xaxis) {
			this.node = node;
			this.level = level;
			this.xaxis = xaxis;
		}
	}
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        PriorityQueue<NodeLocation> pq = new PriorityQueue<>((NodeLocation a, NodeLocation b) -> {
			if (a.xaxis == b.xaxis){
                if(a.level == b.level) return a.node.val - b.node.val;
                else return a.level - b.level;
            }
			else return a.xaxis - b.xaxis;
		});
		inOrder(root, pq, 0, 0);
		TreeMap<Integer, List<Integer>> hashmap = new TreeMap<>();
		while (pq.size() != 0) {
			NodeLocation node =  pq.remove();
			if (hashmap.containsKey(node.xaxis)) {
				List<Integer> a = hashmap.get(node.xaxis);
				a.add(node.node.val);
				hashmap.put(node.xaxis, a);
			} else {
				ArrayList<Integer> a = new ArrayList<>();
				a.add(node.node.val);
				hashmap.put(node.xaxis, a);
			}
		}

		List<List<Integer>> ans = new ArrayList<>(hashmap.values());
        return ans;
    }
}
