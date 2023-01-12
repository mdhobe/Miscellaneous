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
    
    public boolean isValid(int ar, int ac, int rows, int cols){
        return ar >= 0 && ac >=0 && ar < rows && ac < cols;
    }
    
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        //Your code here
        int total = rows*cols;
        DisjointSet ds = new DisjointSet(total);
        int[][] visited = new int[rows][cols];
        List<Integer> islands = new ArrayList<>();
        int count = 0;
        for(int i=0;i<operators.length;i++){
            int r = operators[i][0];
            int c = operators[i][1];
            
            if(visited[r][c] == 1){
                islands.add(count);
                continue;
            }
            visited[r][c] = 1;
            count++;
            
            int[] dr = {-1, 0, 1, 0};
            int[] dc = {0, 1, 0, -1};
            for(int j=0;j<4;j++){
                int ar = r + dr[j];
                int ac = c + dc[j];
                
                if(isValid(ar,ac,rows,cols)){
                    if(visited[ar][ac] == 1){
                        int noden = r * cols + c;
                        int anoden = ar * cols + ac;
                        
                        if(ds.findUltimateParent(noden) != ds.findUltimateParent(anoden)){
                            count--;
                            ds.unionByRank(noden, anoden);
                        }
                    }
                }
            }
            islands.add(count);
        }
        return islands;
    }
    
}
