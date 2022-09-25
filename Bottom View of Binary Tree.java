
class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        Queue<Location> queue = new LinkedList<>();
		TreeMap<Integer, Integer> hashmap = new TreeMap<>();

		Location l = new Location(root, 0, 0);
		queue.add(l);

		while (!queue.isEmpty()) {
			int length = queue.size();
			for (int i = 0; i < length; i++) {
				Location location = queue.poll();
				hashmap.put(location.xaxis, location.node.data);
				if (location.node.left != null) {
					Location loc = new Location(location.node.left, location.level + 1, location.xaxis - 1);
					queue.add(loc);
				}
				if (location.node.right != null) {
					Location loc = new Location(location.node.right, location.level + 1, location.xaxis + 1);
					queue.add(loc);
				}
			}
		}

		ArrayList<Integer> ans = new ArrayList<>(hashmap.values());
        return ans;
    }
    
    class Location {
		int level, xaxis;
		Node node;
		Location(Node node, int level, int xaxis) {
			this.node = node;
			this.level = level;
			this.xaxis = xaxis;
		}
	}
}
