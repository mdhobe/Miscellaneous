public class DisjointSet {
	List<Integer> parent, size;

	public DisjointSet(int n){
		parent = new ArrayList<>();
		size = new ArrayList<>();
		for(int i=0;i<=n;i++){
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
        return ar >= 0 && ac >= 0 && ar < rows && ac < cols; 
    }
    public int largestIsland(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        //if no zero is present
        int countofzero = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == 0){
                    countofzero++;
                }
            }
        }
        if(countofzero == 0) return rows*cols;

        DisjointSet ds = new DisjointSet(rows*cols);
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == 1){
                    for(int k=0;k<4;k++){
                        int ar = i + dr[k];
                        int ac = j + dc[k];

                        int noden = i*cols+j;
                        int anoden = ar*cols+ac;

                        if(isValid(ar,ac,rows,cols) && grid[ar][ac] == 1 && ds.findUltimateParent(noden) != ds.findUltimateParent(anoden)){
                            ds.unionBySize(noden, anoden);
                        }
                    }
                }
            }
        }

        HashMap<Integer, Integer> counthash = new HashMap<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == 1){
                    int noden = i*cols+j;
                    int parent = ds.findUltimateParent(noden);
                    if(counthash.containsKey(parent)){
                        int score = counthash.get(parent);
                        counthash.put(parent, ++score);
                    } else counthash.put(parent, 1);
                }
            }
        }

        System.out.println(counthash);

        int ans = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == 0){
                    int tempnodeans = 0;
                    HashSet<Integer> parents = new HashSet<>();
                    for(int k=0;k<4;k++){
                        int ar = i + dr[k];
                        int ac = j + dc[k];

                        if(isValid(ar,ac,rows,cols)){
                            int anode = ar*cols+ac;
                            int p = ds.findUltimateParent(anode);
                            if(!parents.contains(p) && grid[ar][ac]==1){
                                tempnodeans += counthash.get(p);
                                parents.add(p);
                            }
                        }
                    }
                    ans = Math.max(ans, tempnodeans + 1);
                }
            }
        }
        return ans;
    }
}
