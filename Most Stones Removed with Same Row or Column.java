class DisjointSet {
	List<Integer> rank, parent, size;

	public DisjointSet(int n){
		rank = new ArrayList<>();
		parent = new ArrayList<>();
		size = new ArrayList<>();
		for(int i=0;i<=n;i++){
			rank.add(0);
			parent.add(i);
			size.add(1);
		}
	}

	public int findUltimateParent(int node){
		if(node == parent.get(node)) return node;
		int pnode = findUltimateParent(parent.get(node));
		parent.set(node, pnode);
		return parent.get(node);
	}

	public void unionByRank(int u, int v){
		int pu = findUltimateParent(u);
		int pv = findUltimateParent(v);
		if(pu == pv) return;

		if(rank.get(pu) < rank.get(pv)){
			parent.set(pu, pv);
		} else if(rank.get(pu) > rank.get(pv)){
			parent.set(pv, pu);
		} else {
			parent.set(pu, pv);
			int r = rank.get(pv);
			rank.set(pv, r+1);
		}
	}

	public void unionBySize(int u, int v){
		int pu = findUltimateParent(u);	
		int pv = findUltimateParent(v);
		if(pu == pv) return;

		if(size.get(pu) < size.get(pv)){
			parent.set(pu, pv);
			size.set(pv, size.get(pu)+size.get(pu));
		} else {
			parent.set(pv, pu);
			size.set(pu, size.get(pu)+size.get(pu));
		}
	}
}
class Solution {
    public int removeStones(int[][] stones) {
        int rows = 0, cols = 0, n = stones.length;

        //count of rows ans cols
        for(int[] s : stones){
            rows = Math.max(s[0], rows);
            cols = Math.max(s[1], cols);
        }

        //init disjoint set
        DisjointSet ds = new DisjointSet(rows+cols+1);
        HashMap<Integer, Integer> stonesNode = new HashMap<>();
        for(int i=0;i<stones.length;i++){
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + rows + 1;

            ds.unionBySize(nodeRow, nodeCol);
            stonesNode.put(nodeRow,1);
            stonesNode.put(nodeCol,1);
        }
        int count = 0;
        for(Map.Entry<Integer, Integer> it : stonesNode.entrySet()){
            if(ds.findUltimateParent(it.getKey()) == it.getKey())count++;
        }
        return n - count;
    }
}
