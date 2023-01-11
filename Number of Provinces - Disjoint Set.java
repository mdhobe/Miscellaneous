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
    public int findCircleNum(int[][] isConnected) {
        int row = isConnected.length;
        DisjointSet ds = new DisjointSet(row);

        //create graph
        for(int i=0;i<row;i++){
            for(int j=0;j<row;j++){
                if(i != j && isConnected[i][j] == 1){
                    ds.unionByRank(i, j);
                }
            }
        }

        //finding individual graph
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<row;i++) set.add(ds.findUltimateParent(i));
        return set.size();
    }
}
